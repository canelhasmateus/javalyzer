package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * Configures one method for notifying users/developers when a build breaks.
 *
 * <p>Classe Java de Notifier complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Notifier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sendOnError" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sendOnFailure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sendOnSuccess" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="sendOnWarning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configuration" minOccurs="0">
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
@XmlType( name = "Notifier", propOrder = {

} )
public class Notifier {

    @XmlElement( defaultValue = "mail" )
    private String                 type;
    @XmlElement( defaultValue = "true" )
    private Boolean                sendOnError;
    @XmlElement( defaultValue = "true" )
    private Boolean                sendOnFailure;
    @XmlElement( defaultValue = "true" )
    private Boolean                sendOnSuccess;
    @XmlElement( defaultValue = "true" )
    private Boolean                sendOnWarning;
    @XmlElement()
    private String                 address;
    @XmlElement()
    private Notifier.Configuration configuration;

    /**
     * Obtém o valor da propriedade type.
     *
     * @return possible object is {@link String }
     */
    public String getType( ) {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     *
     * @param value allowed object is {@link String }
     */
    public void setType( String value ) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade sendOnError.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isSendOnError( ) {
        return sendOnError;
    }

    /**
     * Define o valor da propriedade sendOnError.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setSendOnError( Boolean value ) {
        this.sendOnError = value;
    }

    /**
     * Obtém o valor da propriedade sendOnFailure.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isSendOnFailure( ) {
        return sendOnFailure;
    }

    /**
     * Define o valor da propriedade sendOnFailure.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setSendOnFailure( Boolean value ) {
        this.sendOnFailure = value;
    }

    /**
     * Obtém o valor da propriedade sendOnSuccess.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isSendOnSuccess( ) {
        return sendOnSuccess;
    }

    /**
     * Define o valor da propriedade sendOnSuccess.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setSendOnSuccess( Boolean value ) {
        this.sendOnSuccess = value;
    }

    /**
     * Obtém o valor da propriedade sendOnWarning.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isSendOnWarning( ) {
        return sendOnWarning;
    }

    /**
     * Define o valor da propriedade sendOnWarning.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setSendOnWarning( Boolean value ) {
        this.sendOnWarning = value;
    }

    /**
     * Obtém o valor da propriedade address.
     *
     * @return possible object is {@link String }
     */
    public String getAddress( ) {
        return address;
    }

    /**
     * Define o valor da propriedade address.
     *
     * @param value allowed object is {@link String }
     */
    public void setAddress( String value ) {
        this.address = value;
    }

    /**
     * Obtém o valor da propriedade configuration.
     *
     * @return possible object is {@link Notifier.Configuration }
     */
    public Notifier.Configuration getConfiguration( ) {
        return configuration;
    }

    /**
     * Define o valor da propriedade configuration.
     *
     * @param value allowed object is {@link Notifier.Configuration }
     */
    public void setConfiguration( Notifier.Configuration value ) {
        this.configuration = value;
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
    public static class Configuration {

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

}
