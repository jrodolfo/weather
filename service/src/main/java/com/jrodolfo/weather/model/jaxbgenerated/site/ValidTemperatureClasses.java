//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.15 at 12:39:23 PM ADT 
//


package com.jrodolfo.weather.model.jaxbgenerated.site;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validTemperatureClasses.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="validTemperatureClasses">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="high"/>
 *     &lt;enumeration value="low"/>
 *     &lt;enumeration value="max"/>
 *     &lt;enumeration value="min"/>
 *     &lt;enumeration value="extremeMax"/>
 *     &lt;enumeration value="extremeMin"/>
 *     &lt;enumeration value="normalMax"/>
 *     &lt;enumeration value="normalMin"/>
 *     &lt;enumeration value="normalMean"/>
 *     &lt;enumeration value="mean"/>
 *     &lt;enumeration value="current"/>
 *     &lt;enumeration value="dewpoint"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "validTemperatureClasses")
@XmlEnum
public enum ValidTemperatureClasses {

    @XmlEnumValue("high")
    HIGH("high"),
    @XmlEnumValue("low")
    LOW("low"),
    @XmlEnumValue("max")
    MAX("max"),
    @XmlEnumValue("min")
    MIN("min"),
    @XmlEnumValue("extremeMax")
    EXTREME_MAX("extremeMax"),
    @XmlEnumValue("extremeMin")
    EXTREME_MIN("extremeMin"),
    @XmlEnumValue("normalMax")
    NORMAL_MAX("normalMax"),
    @XmlEnumValue("normalMin")
    NORMAL_MIN("normalMin"),
    @XmlEnumValue("normalMean")
    NORMAL_MEAN("normalMean"),
    @XmlEnumValue("mean")
    MEAN("mean"),
    @XmlEnumValue("current")
    CURRENT("current"),
    @XmlEnumValue("dewpoint")
    DEWPOINT("dewpoint");
    private final String value;

    ValidTemperatureClasses(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidTemperatureClasses fromValue(String v) {
        for (ValidTemperatureClasses c: ValidTemperatureClasses.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
