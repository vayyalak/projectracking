
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
 *         &lt;element name="postdataResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "postdataResult"
})
@XmlRootElement(name = "postdataResponse")
public class PostdataResponse {

    protected String postdataResult;

    /**
     * Gets the value of the postdataResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostdataResult() {
        return postdataResult;
    }

    /**
     * Sets the value of the postdataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostdataResult(String value) {
        this.postdataResult = value;
    }

}
