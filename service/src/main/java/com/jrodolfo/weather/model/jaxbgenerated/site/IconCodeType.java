//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.15 at 12:39:23 PM ADT 
//


package com.jrodolfo.weather.model.jaxbgenerated.site;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for iconCodeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iconCodeType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>validIconCodes">
 *       &lt;attribute name="format" use="required" type="{}validIconCodesUnits" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iconCodeType", propOrder = {
    "value"
})
public class IconCodeType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "format", required = true)
    protected ValidIconCodesUnits format;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link ValidIconCodesUnits }
     *     
     */
    public ValidIconCodesUnits getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidIconCodesUnits }
     *     
     */
    public void setFormat(ValidIconCodesUnits value) {
        this.format = value;
    }

}
