
package com.gridpoint.energy.domainmodel.masscec.wsclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "PTS_ARSoap", targetNamespace = "http://ar.masstech-pts.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PTSARSoap {


    /**
     * 
     * @param ptsSystemID
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "GetLastMeterDate", action = "http://ar.masstech-pts.org/GetLastMeterDate")
    @WebResult(name = "GetLastMeterDateResult", targetNamespace = "http://ar.masstech-pts.org/")
    @RequestWrapper(localName = "GetLastMeterDate", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.GetLastMeterDate")
    @ResponseWrapper(localName = "GetLastMeterDateResponse", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.GetLastMeterDateResponse")
    public String getLastMeterDate(
        @WebParam(name = "PTSSystemID", targetNamespace = "http://ar.masstech-pts.org/")
        String ptsSystemID);

    /**
     * 
     * @param meterYear
     * @param meterDay
     * @param meterMonth
     * @param ptsSystemID
     * @return
     *     returns double
     */
    @WebMethod(operationName = "GetMeterValue", action = "http://ar.masstech-pts.org/GetMeterValue")
    @WebResult(name = "GetMeterValueResult", targetNamespace = "http://ar.masstech-pts.org/")
    @RequestWrapper(localName = "GetMeterValue", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.GetMeterValue")
    @ResponseWrapper(localName = "GetMeterValueResponse", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.GetMeterValueResponse")
    public double getMeterValue(
        @WebParam(name = "PTSSystemID", targetNamespace = "http://ar.masstech-pts.org/")
        String ptsSystemID,
        @WebParam(name = "MeterYear", targetNamespace = "http://ar.masstech-pts.org/")
        int meterYear,
        @WebParam(name = "MeterMonth", targetNamespace = "http://ar.masstech-pts.org/")
        int meterMonth,
        @WebParam(name = "MeterDay", targetNamespace = "http://ar.masstech-pts.org/")
        int meterDay);

    /**
     * 
     * @param xmldata
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://ar.masstech-pts.org/postdata")
    @WebResult(name = "postdataResult", targetNamespace = "http://ar.masstech-pts.org/")
    @RequestWrapper(localName = "postdata", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.Postdata")
    @ResponseWrapper(localName = "postdataResponse", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.PostdataResponse")
    public String postdata(
        @WebParam(name = "xmldata", targetNamespace = "http://ar.masstech-pts.org/")
        String xmldata);

    /**
     * 
     * @param xmldata
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://ar.masstech-pts.org/testpostdata")
    @WebResult(name = "testpostdataResult", targetNamespace = "http://ar.masstech-pts.org/")
    @RequestWrapper(localName = "testpostdata", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.Testpostdata")
    @ResponseWrapper(localName = "testpostdataResponse", targetNamespace = "http://ar.masstech-pts.org/", className = "org.masstech_pts.ar.TestpostdataResponse")
    public String testpostdata(
        @WebParam(name = "xmldata", targetNamespace = "http://ar.masstech-pts.org/")
        String xmldata);

}
