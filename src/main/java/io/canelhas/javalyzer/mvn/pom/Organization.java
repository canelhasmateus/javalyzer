package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Specifies the organization that produces this project.
 *
 * <p>Classe Java de Organization complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Organization">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Organization", propOrder = {

} )
public class Organization {

    @XmlElement()
    private String name;
    @XmlElement()
    private String url;

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
     * Obtém o valor da propriedade url.
     *
     * @return possible object is {@link String }
     */
    public String getUrl( ) {
        return url;
    }

    /**
     * Define o valor da propriedade url.
     *
     * @param value allowed object is {@link String }
     */
    public void setUrl( String value ) {
        this.url = value;
    }

}
