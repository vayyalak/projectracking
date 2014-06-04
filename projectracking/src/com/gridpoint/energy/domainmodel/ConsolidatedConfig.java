package com.gridpoint.energy.domainmodel;

import com.gridpoint.energy.domainmodel.exception.FirmwareBinaryIsNotGzippedException;
import com.gridpoint.energy.domainmodel.exception.FirmwareBinaryIsNotTarredException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.io.IOUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/**
 * Consolidates configuration from all the config files used by an endpoint controller, as well as
 * the corresponding document schema.
 *
 * Includes methods for extracting consolidated configuration from firmware binary archives.
 *
 * @author dhorlick
 */
public class ConsolidatedConfig
{
    private Document config;
    private Document configSchema;

    final String GRIDPOINT_EMS_NS = "https://ems.gridpoint.com";

    public ConsolidatedConfig()
    {
    }

    public ConsolidatedConfig(final Document designatedConfig, final Document designatedConfigSchema)
    {
        setConfig(designatedConfig);
        setConfigSchema(designatedConfigSchema);
    }

    public Document getConfig()
    {
        return config;
    }

    public void setConfig(final Document designatedConfig)
    {
        config = designatedConfig;
    }

    public Document getConfigSchema()
    {
        return configSchema;
    }

    public void setConfigSchema(final Document designatedConfigSchema)
    {
        configSchema = designatedConfigSchema;
    }

    /**
     * Builds a directory from annotations in the associated configuration document schema that can be used
     * to subdivide consolidated a configuration XML document into the appropriate individually-named entries
     * in an archive.
     *
     * File names will <em>not</em> be prefixed with a parent directory to form a complete path. They will
     * be returned exactly as they appear in the schema's documents gpup:filename attribute.
     */
    public Map<String, String> buildConfigElementNameToEntryNameMap()
    {
        assertInitialed();
        final Map<String, String> configElementNameToEntryNameMap = new LinkedHashMap<String, String>();

        final Element documentElement = configSchema.getDocumentElement();

        for (int i=0; i<documentElement.getChildNodes().getLength(); i++)
        {
            final Node node = documentElement.getChildNodes().item(i);
            if (node.hasAttributes() && node instanceof Element && "element".equals(node.getLocalName()))
            {
                final Element elementElement = (Element) node;

                if (elementElement.hasAttribute("name") && elementElement.hasAttributeNS(GRIDPOINT_EMS_NS, "filename"))
                    configElementNameToEntryNameMap.put(elementElement.getAttribute("name"), elementElement.getAttributeNS(GRIDPOINT_EMS_NS, "filename"));
            }
        }

        return configElementNameToEntryNameMap;
    }

    public void bind(final Map<String, String> requestedBindings)
    {
        assertInitialed();

        final Element documentElement = configSchema.getDocumentElement();

        final NodeList nodes = documentElement.getChildNodes();

        // Let's copy the bindings map so we can safely remove entries from it, without affecting the outside world.

        final Map<String, String> bindings = new LinkedHashMap<String, String> ();
        bindings.putAll(requestedBindings);

        bindRecurse(bindings, nodes);

        if (bindings.size()>0)
        {
            throw new IllegalStateException("Could not bind the following bindings: "+bindings);
        }
    }

    private void bindRecurse(final Map<String,String> bindings, final NodeList schemaNodes)
    {
        for (int i=0; i< schemaNodes.getLength(); i++)
        {
            final Node node = schemaNodes.item(i);
            if (node.hasAttributes() && node instanceof Element && "element".equals(node.getLocalName()))
            {
                final Element elementElement = (Element) node;

                if (elementElement.hasAttribute("name") && elementElement.hasAttributeNS(GRIDPOINT_EMS_NS, "bind"))
                {
                    final String bindVariableName = elementElement.getAttributeNS(GRIDPOINT_EMS_NS, "bind");

                    if (!bindings.containsKey(bindVariableName) || bindings.get(bindVariableName)==null)
                    {
                        throw new IllegalStateException("Could not find binding "+bindVariableName+" in "+bindings);
                    }

                    final String replacement = bindings.get(bindVariableName);
                    final boolean replaced = replaceConfigValueAttributeValue(elementElement.getAttribute("name"), replacement);

                    int bindingsSize = bindings.size();

                    if (replaced)
                    {
                        bindings.remove(bindVariableName);
                    }
                }
            }

            bindRecurse(bindings, node.getChildNodes());
        }
    }

    /**
     * @return The old value, or null if no replacement took place.
     */
    public boolean replaceConfigValueAttributeValue(final String elementName, final String newValue)
    {
        return replaceConfigValueAttributeValueRecurse(elementName, newValue, config.getDocumentElement().getChildNodes());
    }

    /**
     * will find the node on itself that corresponds to the input DOM, and replace (or insert, if not found)
     *
     * This is intended to mirror what the controllers do when they receive individual files (here, stanzas).
     */
    public void overlayConfig(final Node node)
    {
        if (node==null)
            return;
            
        if (config==null)
        {
            // degenerate case
            
            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            
            try
            {
				final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				config = documentBuilder.newDocument();
				
				final Element configurationElement = config.createElement("Configuration");
				config.appendChild(configurationElement);
            }
            catch (ParserConfigurationException e)
            {
                 throw new IllegalStateException(e); // misconfiguration
            }
        }
        
        final Element configurationElement = config.getDocumentElement();
        assert("Configuration".equals(configurationElement.getNodeName()));
        
        // Deal with the multi-stanza import case.

        if (node.getNodeType()==Node.DOCUMENT_NODE)
        {
            final Document docToOverlay = (Document) node;
            overlayConfig(docToOverlay.getDocumentElement());

            return;
        }
        else if ("Configuration".equals(node.getNodeName()))
        {
            for (int i=0; i<=node.getChildNodes().getLength(); i++)
            {
                Node stanzaToOverlay = node.getChildNodes().item(i);
                overlayConfig(stanzaToOverlay);
            }

            return;
        }

        final Node stanzaNode = node;

        // Has this stanza been added previously?

        final String stanzaName = stanzaNode.getNodeName();
        assert(stanzaName!=null);
        
        for (int i=0; i<configurationElement.getChildNodes().getLength(); i++)
        {
             final Node subNode = configurationElement.getChildNodes().item(i);
             if (subNode.getNodeType()==Node.ELEMENT_NODE && stanzaName.equals(subNode.getNodeName()))
             {
                  // replace
                  
                  configurationElement.replaceChild(config.importNode(stanzaNode, true), subNode);
                  
                  // done
                  
                  return;
             }
        }
        
        // isn't already here... add to end
        
        configurationElement.appendChild(config.importNode(stanzaNode, true));
    }

    private boolean replaceConfigValueAttributeValueRecurse(final String targetElementName, final String newValue, final NodeList configNodes)
    {
        for (int i=0; i< configNodes.getLength(); i++)
        {
            final Node configNode = configNodes.item(i);

            if (configNode instanceof Element)
            {
                final Element configElement = (Element) configNode;

                if (targetElementName.equals(configElement.getLocalName()) || targetElementName.equals(configElement.getNodeName()))
                {
                    configElement.setAttribute("value", newValue);
                    return true;
                }

                final boolean replaced = replaceConfigValueAttributeValueRecurse(targetElementName, newValue, configElement.getChildNodes());

                if (replaced)
                    return true;
            }
        }

        return false;
    }

    private void assertInitialed()
    {
        assert(config!=null);
        assert(configSchema!=null);
    }

    /**
     * Generates an unbound ConsolidatedConfig from a firmware binary archive.
     */
    public static ConsolidatedConfig buildFrom(final byte [] tarGzContent, final Document schemaDocument)
            throws FirmwareBinaryIsNotTarredException, FirmwareBinaryIsNotGzippedException
    {
        final Map<String, Document> configMap = obtainConfigMap(tarGzContent);
        final Document configDoc = configMapToDocument(configMap);
        return new ConsolidatedConfig(configDoc, schemaDocument);
    }

    /**
     * @throws java.io.IOException if the content is not a GZipped Tar archive.
     */
    public static Map<String, Document> obtainConfigMap(final byte [] tarGzContent) throws FirmwareBinaryIsNotGzippedException, FirmwareBinaryIsNotTarredException
    {
        final ByteArrayInputStream archiveByteInputStream = new ByteArrayInputStream(tarGzContent);

        TarArchiveInputStream tarInputStream = null;

        try
        {
            final GZIPInputStream gzInputStream;

            try
            {
                gzInputStream = new GZIPInputStream(archiveByteInputStream);
            }
            catch (IOException e)
            {
                throw new FirmwareBinaryIsNotGzippedException(e);
            }

            tarInputStream = new TarArchiveInputStream(gzInputStream);

            TarArchiveEntry entry = null;

            final Map<String, Document> docs = new LinkedHashMap<String, Document>();

            final DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

            try
            {
                while ((entry = tarInputStream.getNextTarEntry()) != null)
                {
                    if (entry.getName().endsWith(".xml") && entry.getName().startsWith("configs/") && entry.getName().indexOf('/')==entry.getName().lastIndexOf('/'))
                    {
                        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        IOUtils.copy(tarInputStream, byteArrayOutputStream);
                        final ByteArrayInputStream entryByteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        docs.put(stripFileExtension(entry.getName()), documentBuilder.parse(entryByteArrayInputStream));
                    }
                }
            }
            catch (IOException e)
            {
                throw new FirmwareBinaryIsNotTarredException(e);
            }

            return docs;
        }
        catch (ParserConfigurationException e)
        {
           throw new IllegalStateException(e); // misconfiguration
        }
        catch (SAXException e)
        {
            throw new IllegalStateException(e); // bad data in database
        }
        finally
        {
            try
            {
                if (tarInputStream!=null)
                    tarInputStream.close();
            }
            catch (IOException e)
            {
                throw new IllegalStateException(e); // misconfiguration
            }
        }
    }

    public static String stripFileExtension(final String fileName)
    {
        if (fileName==null)
            return null;

        final int dotPosition = fileName.lastIndexOf('.');
        if (dotPosition==-1)
            return fileName;

        return fileName.substring(0, dotPosition);
    }

    /**
     * converts a config map to single, unbound, document.
     */
    public static Document configMapToDocument(final Map<String, Document> docs)
    {
        return configCollectionToDocument(docs.values());
    }

    /**
     * converts a Collection of XML configuration documents to a single, unbound, document.
     */
    public static Document configCollectionToDocument(final Collection<Document> docs)
    {
        try
        {
            // consolidate into a single XML Document

            final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setNamespaceAware(true);
            final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            final Document configDoc = documentBuilder.newDocument();
            final Element configurationElement = configDoc.createElement("Configuration");

            configDoc.appendChild(configurationElement);

            for (final Document doc : docs)
            {
                configurationElement.appendChild(configDoc.adoptNode(doc.getDocumentElement())); // TODO use importNode, instead?
            }

            return configDoc;
        }
        catch (ParserConfigurationException e)
        {
            throw new IllegalStateException(e); // misconfiguration
        }
    }

    public static Document wrapWithConsolidatedConfigDocIfNotAlreadyDone(final Document doc)
    {
        if (doc.getDocumentElement().getNodeName().equals("Configuration"))
            return doc;

        final List<Document> list = new ArrayList<Document> ();
        list.add(doc);
        return configCollectionToDocument(list);
    }
}
