//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.15 at 12:39:23 PM ADT 
//


package com.jrodolfo.weather.model.jaxbgenerated.site;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cloudPrecipType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cloudPrecipType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="textSummary" type="{}textSummaryType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cloudPrecipType", propOrder = {
    "textSummary"
})
public class CloudPrecipType {

    @XmlElement(required = true)
    protected String textSummary;

    /**
     * Gets the value of the textSummary property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTextSummary() {
        return textSummary;
    }

    /**
     * Sets the value of the textSummary property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTextSummary(String value) {
        this.textSummary = value;
    }

}
