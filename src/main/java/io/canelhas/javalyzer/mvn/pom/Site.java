package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;


/**
 * Contains the information needed for deploying websites.
 *
 * <p>Classe Java de Site complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Site">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="child.site.url.inherit.append.path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Site", propOrder = {

} )
public class Site {

    @XmlElement()
    private String id;
    @XmlElement()
    private String name;
    @XmlElement()
    private String url;
    @XmlAttribute( name = "child.site.url.inherit.append.path" )
    private String childSiteUrlInheritAppendPath;

    /**
     * Obtém o valor da propriedade id.
     *
     * @return possible object is {@link String }
     */
    public String getId( ) {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     *
     * @param value allowed object is {@link String }
     */
    public void setId( String value ) {
        this.id = value;
    }

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
     * Obtém o valor da propriedade childSiteUrlInheritAppendPath.
     *
     * @return possible object is {@link String }
     */
    public String getChildSiteUrlInheritAppendPath( ) {
        return childSiteUrlInheritAppendPath;
    }

    /**
     * Define o valor da propriedade childSiteUrlInheritAppendPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setChildSiteUrlInheritAppendPath( String value ) {
        this.childSiteUrlInheritAppendPath = value;
    }

}
