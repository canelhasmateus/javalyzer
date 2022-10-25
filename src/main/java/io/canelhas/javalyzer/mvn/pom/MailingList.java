package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * This element describes all of the mailing lists associated with a project. The auto-generated site references this information.
 *
 * <p>Classe Java de MailingList complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="MailingList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subscribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unsubscribe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="post" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="archive" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="otherArchives" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="otherArchive" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType( name = "MailingList", propOrder = {

} )
public class MailingList {

    @XmlElement()
    private String                    name;
    @XmlElement()
    private String                    subscribe;
    @XmlElement()
    private String                    unsubscribe;
    @XmlElement()
    private String                    post;
    @XmlElement()
    private String                    archive;
    @XmlElement()
    private MailingList.OtherArchives otherArchives;

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
     * Obtém o valor da propriedade subscribe.
     *
     * @return possible object is {@link String }
     */
    public String getSubscribe( ) {
        return subscribe;
    }

    /**
     * Define o valor da propriedade subscribe.
     *
     * @param value allowed object is {@link String }
     */
    public void setSubscribe( String value ) {
        this.subscribe = value;
    }

    /**
     * Obtém o valor da propriedade unsubscribe.
     *
     * @return possible object is {@link String }
     */
    public String getUnsubscribe( ) {
        return unsubscribe;
    }

    /**
     * Define o valor da propriedade unsubscribe.
     *
     * @param value allowed object is {@link String }
     */
    public void setUnsubscribe( String value ) {
        this.unsubscribe = value;
    }

    /**
     * Obtém o valor da propriedade post.
     *
     * @return possible object is {@link String }
     */
    public String getPost( ) {
        return post;
    }

    /**
     * Define o valor da propriedade post.
     *
     * @param value allowed object is {@link String }
     */
    public void setPost( String value ) {
        this.post = value;
    }

    /**
     * Obtém o valor da propriedade archive.
     *
     * @return possible object is {@link String }
     */
    public String getArchive( ) {
        return archive;
    }

    /**
     * Define o valor da propriedade archive.
     *
     * @param value allowed object is {@link String }
     */
    public void setArchive( String value ) {
        this.archive = value;
    }

    /**
     * Obtém o valor da propriedade otherArchives.
     *
     * @return possible object is {@link MailingList.OtherArchives }
     */
    public MailingList.OtherArchives getOtherArchives( ) {
        return otherArchives;
    }

    /**
     * Define o valor da propriedade otherArchives.
     *
     * @param value allowed object is {@link MailingList.OtherArchives }
     */
    public void setOtherArchives( MailingList.OtherArchives value ) {
        this.otherArchives = value;
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
     *         &lt;element name="otherArchive" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "otherArchive"
    } )
    public static class OtherArchives {

        @XmlElement()
        private List< String > otherArchive;

        /**
         * Gets the value of the otherArchive property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the otherArchive property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOtherArchive().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getOtherArchive( ) {
            if ( otherArchive == null ) {
                otherArchive = new ArrayList< String >();
            }
            return this.otherArchive;
        }

    }

}
