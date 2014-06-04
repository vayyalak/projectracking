package com.gridpoint.energy.util.xml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.JAXBException;
import javax.xml.validation.SchemaFactory;

import org.apache.log4j.Logger;

import org.xml.sax.SAXException;

public class JaxbUtil {

    private static final Logger log = Logger.getLogger(JaxbUtil.class);

	public static <T> T getObject(Class<T> clazz, String resource)
			throws IOException, JAXBException {
		InputStream in = null;

		try {
			in = clazz.getResourceAsStream(resource);

			return getObject(clazz, in);
		} finally {
			if (in != null) {
				try {
					in.close();
				} finally {
					in = null;
				}
			}
		}
	}

	public static <T> T getObject(Class<T> type, URL url) throws IOException,
			JAXBException {
		InputStream in = null;

		try {
			in = url.openStream();
			return getObject(type, in);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				} finally {
					in = null;
				}
			}
		}
	}

    public static <T> T getObject(Class<T> type, byte[] buffer) 
        throws IOException, JAXBException {

        ByteArrayInputStream in = new ByteArrayInputStream(buffer);
        return getObject(type, in);
    }

	@SuppressWarnings( { "unchecked" })
	public static <T> T getObject(Class<T> clazz, InputStream in)
			throws IOException, JAXBException {

		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (T) unmarshaller.unmarshal(in);
	}

	public static <T> T getObject(Class<T> clazz, File file)
			throws IOException, JAXBException {

            InputStream in = null;
            try {
                in = new FileInputStream(file);
                return getObject(clazz, in);
            } finally {
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        log.warn(ex);
                    } finally {
                        in = null;
                    }
                }
            }
	}

	@SuppressWarnings( { "unchecked" })
	public static <T> T getObject(Class<T> clazz, InputStream in,
			String schemaLocation) throws IOException, JAXBException {

		JAXBContext context = JAXBContext.newInstance(clazz);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		URL schemaUrl = Thread.currentThread().getContextClassLoader()
				.getResource(schemaLocation);
		try {
			unmarshaller.setSchema(SchemaFactory.newInstance(
					"http://www.w3.org/2001/XMLSchema").newSchema(schemaUrl));
		} catch (SAXException sx) {
			throw new JAXBException(sx.getMessage());
		}
		return (T) unmarshaller.unmarshal(in);
	}

	public static void printXml(Object obj, OutputStream outStream)
			throws JAXBException {
		JAXBContext jc = JAXBContext.newInstance(obj.getClass());
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(obj, outStream);
	}

    public static byte[] marshal(Object data) throws JAXBException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JAXBContext context = JAXBContext.newInstance(data.getClass());
        Marshaller marshaller = context.createMarshaller();
        //        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(data, out);

        return out.toByteArray();
    }
}