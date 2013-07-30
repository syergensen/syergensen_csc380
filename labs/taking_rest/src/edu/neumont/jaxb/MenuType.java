
package edu.neumont.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for menuType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="menuType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BREAKFAST"/>
 *     &lt;enumeration value="LUNCH"/>
 *     &lt;enumeration value="DINNER"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "menuType")
@XmlEnum
public enum MenuType {

    BREAKFAST,
    LUNCH,
    DINNER;

    public String value() {
        return name();
    }

    public static MenuType fromValue(String v) {
        return valueOf(v);
    }

}
