
package com.gridpoint.energy.domainmodel.masscec.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="PTSSystemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "ptsSystemID"
})
@XmlRootElement(name = "GetLastMeterDate")
public class GetLastMeterDate {

    @XmlElement(name = "PTSSystemID")
    protected String ptsSystemID;

    /**
     * Gets the value of the ptsSystemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPTSSystemID() {
        return ptsSystemID;
    }

    /**
     * Sets the value of the ptsSystemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPTSSystemID(String value) {
        this.ptsSystemID = value;
    }

}
