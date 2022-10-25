package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Describes the licenses for this project. This is used to generate the license page of the project's web site, as well as being taken into consideration in other reporting and validation. The
 * licenses listed for the project are that of the project itself, and not of dependencies.
 *
 * <p>Classe Java de License complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="License">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="distribution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="comments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "License", propOrder = {

} )
public class License {

    @XmlElement()
    private String name;
    @XmlElement()
    private String url;
    @XmlElement()
    private String distribution;
    @XmlElement()
    private String comments;

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

    /**
     * Obtém o valor da propriedade distribution.
     *
     * @return possible object is {@link String }
     */
    public String getDistribution( ) {
        return distribution;
    }

    /**
     * Define o valor da propriedade distribution.
     *
     * @param value allowed object is {@link String }
     */
    public void setDistribution( String value ) {
        this.distribution = value;
    }

    /**
     * Obtém o valor da propriedade comments.
     *
     * @return possible object is {@link String }
     */
    public String getComments( ) {
        return comments;
    }

    /**
     * Define o valor da propriedade comments.
     *
     * @param value allowed object is {@link String }
     */
    public void setComments( String value ) {
        this.comments = value;
    }

}
