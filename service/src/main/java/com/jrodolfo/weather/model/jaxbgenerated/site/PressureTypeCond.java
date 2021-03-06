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
 * <p>Java class for pressureTypeCond complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pressureTypeCond">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>validPressures">
 *       &lt;attribute name="units" type="{}validPressureUnits" />
 *       &lt;attribute name="unitType" type="{}validUnitTypes" />
 *       &lt;attribute name="change" type="{}validPressures" />
 *       &lt;attribute name="tendency" type="{}validPressureTendencies" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pressureTypeCond", propOrder = {
    "value"
})
public class PressureTypeCond {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "units")
    protected ValidPressureUnits units;
    @XmlAttribute(name = "unitType")
    protected String unitType;
    @XmlAttribute(name = "change")
    protected String change;
    @XmlAttribute(name = "tendency")
    protected String tendency;

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
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link ValidPressureUnits }
     *     
     */
    public ValidPressureUnits getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link ValidPressureUnits }
     *     
     */
    public void setUnits(ValidPressureUnits value) {
        this.units = value;
    }

    /**
     * Gets the value of the unitType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * Sets the value of the unitType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnitType(String value) {
        this.unitType = value;
    }

    /**
     * Gets the value of the change property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChange() {
        return change;
    }

    /**
     * Sets the value of the change property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChange(String value) {
        this.change = value;
    }

    /**
     * Gets the value of the tendency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTendency() {
        return tendency;
    }

    /**
     * Sets the value of the tendency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTendency(String value) {
        this.tendency = value;
    }

}
