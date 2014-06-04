
package com.gridpoint.energy.domainmodel.masscec.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="xmldata" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "xmldata"
})
@XmlRootElement(name = "testpostdata")
public class Testpostdata {

    protected String xmldata;

    /**
     * Gets the value of the xmldata property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmldata() {
        return xmldata;
    }

    /**
     * Sets the value of the xmldata property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmldata(String value) {
        this.xmldata = value;
    }

}
