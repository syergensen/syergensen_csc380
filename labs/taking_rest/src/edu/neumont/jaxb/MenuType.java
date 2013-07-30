
package edu.neumont.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for menuType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="menuType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="breakfast"/>
 *     &lt;enumeration value="lunch"/>
 *     &lt;enumeration value="dinner"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "menuType")
@XmlEnum
public enum MenuType {

    @XmlEnumValue("breakfast")
    BREAKFAST("breakfast"),
    @XmlEnumValue("lunch")
    LUNCH("lunch"),
    @XmlEnumValue("dinner")
    DINNER("dinner");
    private final String value;

    MenuType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MenuType fromValue(String v) {
        for (MenuType c: MenuType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
