package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * The <code>&lt;CiManagement&gt;</code> element contains informations required to the continuous integration system of the project.
 *
 *
 *
 * <p>Classe Java de CiManagement complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="CiManagement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="system" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="notifiers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="notifier" type="{http://maven.apache.org/POM/4.0.0}Notifier" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType( name = "CiManagement", propOrder = {

} )
public class CiManagement {

    @XmlElement()
    private String                 system;
    @XmlElement()
    private String                 url;
    @XmlElement()
    private CiManagement.Notifiers notifiers;

    /**
     * Obtém o valor da propriedade system.
     *
     * @return possible object is {@link String }
     */
    public String getSystem( ) {
        return system;
    }

    /**
     * Define o valor da propriedade system.
     *
     * @param value allowed object is {@link String }
     */
    public void setSystem( String value ) {
        this.system = value;
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
     * Obtém o valor da propriedade notifiers.
     *
     * @return possible object is {@link CiManagement.Notifiers }
     */
    public CiManagement.Notifiers getNotifiers( ) {
        return notifiers;
    }

    /**
     * Define o valor da propriedade notifiers.
     *
     * @param value allowed object is {@link CiManagement.Notifiers }
     */
    public void setNotifiers( CiManagement.Notifiers value ) {
        this.notifiers = value;
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
     *         &lt;element name="notifier" type="{http://maven.apache.org/POM/4.0.0}Notifier" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "notifier"
    } )
    public static class Notifiers {

        @XmlElement()
        private List< Notifier > notifier;

        /**
         * Gets the value of the notifier property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the notifier property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getNotifier().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Notifier }
         */
        public List< Notifier > getNotifier( ) {
            if ( notifier == null ) {
                notifier = new ArrayList< Notifier >();
            }
            return this.notifier;
        }

    }

}
