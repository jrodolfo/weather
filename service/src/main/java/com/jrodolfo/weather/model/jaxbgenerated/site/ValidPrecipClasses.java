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
 * <p>Java class for validPrecipClasses.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="validPrecipClasses">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="extremeRainfall"/>
 *     &lt;enumeration value="extremeSnowfall"/>
 *     &lt;enumeration value="extremePrecipitation"/>
 *     &lt;enumeration value="extremeSnowOnGround"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "validPrecipClasses")
@XmlEnum
public enum ValidPrecipClasses {

    @XmlEnumValue("extremeRainfall")
    EXTREME_RAINFALL("extremeRainfall"),
    @XmlEnumValue("extremeSnowfall")
    EXTREME_SNOWFALL("extremeSnowfall"),
    @XmlEnumValue("extremePrecipitation")
    EXTREME_PRECIPITATION("extremePrecipitation"),
    @XmlEnumValue("extremeSnowOnGround")
    EXTREME_SNOW_ON_GROUND("extremeSnowOnGround");
    private final String value;

    ValidPrecipClasses(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ValidPrecipClasses fromValue(String v) {
        for (ValidPrecipClasses c: ValidPrecipClasses.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
