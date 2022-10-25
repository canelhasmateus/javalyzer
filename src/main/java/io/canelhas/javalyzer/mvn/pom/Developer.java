package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * Information about one of the committers on this project.
 *
 * <p>Classe Java de Developer complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Developer">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organization" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organizationUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="roles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="properties" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Developer", propOrder = {

} )
public class Developer {

    @XmlElement()
    private String               id;
    @XmlElement()
    private String               name;
    @XmlElement()
    private String               email;
    @XmlElement()
    private String               url;
    @XmlElement()
    private String               organization;
    @XmlElement()
    private String               organizationUrl;
    @XmlElement()
    private Developer.Roles      roles;
    @XmlElement()
    private String               timezone;
    @XmlElement()
    private Developer.Properties properties;

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
     * Obtém o valor da propriedade email.
     *
     * @return possible object is {@link String }
     */
    public String getEmail( ) {
        return email;
    }

    /**
     * Define o valor da propriedade email.
     *
     * @param value allowed object is {@link String }
     */
    public void setEmail( String value ) {
        this.email = value;
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
     * Obtém o valor da propriedade organization.
     *
     * @return possible object is {@link String }
     */
    public String getOrganization( ) {
        return organization;
    }

    /**
     * Define o valor da propriedade organization.
     *
     * @param value allowed object is {@link String }
     */
    public void setOrganization( String value ) {
        this.organization = value;
    }

    /**
     * Obtém o valor da propriedade organizationUrl.
     *
     * @return possible object is {@link String }
     */
    public String getOrganizationUrl( ) {
        return organizationUrl;
    }

    /**
     * Define o valor da propriedade organizationUrl.
     *
     * @param value allowed object is {@link String }
     */
    public void setOrganizationUrl( String value ) {
        this.organizationUrl = value;
    }

    /**
     * Obtém o valor da propriedade roles.
     *
     * @return possible object is {@link Developer.Roles }
     */
    public Developer.Roles getRoles( ) {
        return roles;
    }

    /**
     * Define o valor da propriedade roles.
     *
     * @param value allowed object is {@link Developer.Roles }
     */
    public void setRoles( Developer.Roles value ) {
        this.roles = value;
    }

    /**
     * Obtém o valor da propriedade timezone.
     *
     * @return possible object is {@link String }
     */
    public String getTimezone( ) {
        return timezone;
    }

    /**
     * Define o valor da propriedade timezone.
     *
     * @param value allowed object is {@link String }
     */
    public void setTimezone( String value ) {
        this.timezone = value;
    }

    /**
     * Obtém o valor da propriedade properties.
     *
     * @return possible object is {@link Developer.Properties }
     */
    public Developer.Properties getProperties( ) {
        return properties;
    }

    /**
     * Define o valor da propriedade properties.
     *
     * @param value allowed object is {@link Developer.Properties }
     */
    public void setProperties( Developer.Properties value ) {
        this.properties = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "any"
    } )
    public static class Properties {

        @XmlAnyElement
        private List< Element > any;

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Element }
         */
        public List< Element > getAny( ) {
            if ( any == null ) {
                any = new ArrayList< Element >();
            }
            return this.any;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "role"
    } )
    public static class Roles {

        @XmlElement()
        private List< String > role;

        /**
         * Gets the value of the role property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the role property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRole().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getRole( ) {
            if ( role == null ) {
                role = new ArrayList< String >();
            }
            return this.role;
        }

    }

}
