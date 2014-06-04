
package com.gridpoint.energy.domainmodel.masscec.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.masstech_pts.ar package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CAuthentication_QNAME = new QName("http://ar.masstech-pts.org/", "cAuthentication");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.masstech_pts.ar
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TestpostdataResponse }
     * 
     */
    public TestpostdataResponse createTestpostdataResponse() {
        return new TestpostdataResponse();
    }

    /**
     * Create an instance of {@link CAuthentication }
     * 
     */
    public CAuthentication createCAuthentication() {
        return new CAuthentication();
    }

    /**
     * Create an instance of {@link GetMeterValueResponse }
     * 
     */
    public GetMeterValueResponse createGetMeterValueResponse() {
        return new GetMeterValueResponse();
    }

    /**
     * Create an instance of {@link GetMeterValue }
     * 
     */
    public GetMeterValue createGetMeterValue() {
        return new GetMeterValue();
    }

    /**
     * Create an instance of {@link Testpostdata }
     * 
     */
    public Testpostdata createTestpostdata() {
        return new Testpostdata();
    }

    /**
     * Create an instance of {@link PostdataResponse }
     * 
     */
    public PostdataResponse createPostdataResponse() {
        return new PostdataResponse();
    }

    /**
     * Create an instance of {@link GetLastMeterDateResponse }
     * 
     */
    public GetLastMeterDateResponse createGetLastMeterDateResponse() {
        return new GetLastMeterDateResponse();
    }

    /**
     * Create an instance of {@link GetLastMeterDate }
     * 
     */
    public GetLastMeterDate createGetLastMeterDate() {
        return new GetLastMeterDate();
    }

    /**
     * Create an instance of {@link Postdata }
     * 
     */
    public Postdata createPostdata() {
        return new Postdata();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CAuthentication }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ar.masstech-pts.org/", name = "cAuthentication")
    public JAXBElement<CAuthentication> createCAuthentication(CAuthentication value) {
        return new JAXBElement<CAuthentication>(_CAuthentication_QNAME, CAuthentication.class, null, value);
    }

}
