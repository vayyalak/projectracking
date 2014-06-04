
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
 *         &lt;element name="MeterYear" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MeterMonth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="MeterDay" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "ptsSystemID",
    "meterYear",
    "meterMonth",
    "meterDay"
})
@XmlRootElement(name = "GetMeterValue")
public class GetMeterValue {

    @XmlElement(name = "PTSSystemID")
    protected String ptsSystemID;
    @XmlElement(name = "MeterYear")
    protected int meterYear;
    @XmlElement(name = "MeterMonth")
    protected int meterMonth;
    @XmlElement(name = "MeterDay")
    protected int meterDay;

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

    /**
     * Gets the value of the meterYear property.
     * 
     */
    public int getMeterYear() {
        return meterYear;
    }

    /**
     * Sets the value of the meterYear property.
     * 
     */
    public void setMeterYear(int value) {
        this.meterYear = value;
    }

    /**
     * Gets the value of the meterMonth property.
     * 
     */
    public int getMeterMonth() {
        return meterMonth;
    }

    /**
     * Sets the value of the meterMonth property.
     * 
     */
    public void setMeterMonth(int value) {
        this.meterMonth = value;
    }

    /**
     * Gets the value of the meterDay property.
     * 
     */
    public int getMeterDay() {
        return meterDay;
    }

    /**
     * Sets the value of the meterDay property.
     * 
     */
    public void setMeterDay(int value) {
        this.meterDay = value;
    }

}
