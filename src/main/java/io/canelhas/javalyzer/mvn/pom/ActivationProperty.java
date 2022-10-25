package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the property specification used to activate a profile. If the value field is empty, then the existence of the named property will activate the profile, otherwise it does a case-sensitive
 * match against the property value as well.
 *
 * <p>Classe Java de ActivationProperty complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="ActivationProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ActivationProperty", propOrder = {

} )
public class ActivationProperty {

    @XmlElement()
    private String name;
    @XmlElement()
    private String value;

    /**
     * Obtém o valor da propriedade name.
     *
     * @return possible object is {@link String }
     */
    public String getName( ) {
        return name;
    }

    /**
     * Define o valor da propriedade name.
     *
     * @param value allowed object is {@link String }
     */
    public void setName( String value ) {
        this.name = value;
    }

    /**
     * Obtém o valor da propriedade value.
     *
     * @return possible object is {@link String }
     */
    public String getValue( ) {
        return value;
    }

    /**
     * Define o valor da propriedade value.
     *
     * @param value allowed object is {@link String }
     */
    public void setValue( String value ) {
        this.value = value;
    }

}
