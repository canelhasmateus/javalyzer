package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * This element describes all of the classpath resources associated with a project or unit tests.
 *
 * <p>Classe Java de Resource complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Resource">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="targetPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filtering" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="directory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="includes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="include" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="excludes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="exclude" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType( name = "Resource", propOrder = {

} )
public class Resource {

    @XmlElement()
    private String            targetPath;
    @XmlElement()
    private String            filtering;
    @XmlElement()
    private String            directory;
    @XmlElement()
    private Resource.Includes includes;
    @XmlElement()
    private Resource.Excludes excludes;

    /**
     * Obtém o valor da propriedade targetPath.
     *
     * @return possible object is {@link String }
     */
    public String getTargetPath( ) {
        return targetPath;
    }

    /**
     * Define o valor da propriedade targetPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setTargetPath( String value ) {
        this.targetPath = value;
    }

    /**
     * Obtém o valor da propriedade filtering.
     *
     * @return possible object is {@link String }
     */
    public String getFiltering( ) {
        return filtering;
    }

    /**
     * Define o valor da propriedade filtering.
     *
     * @param value allowed object is {@link String }
     */
    public void setFiltering( String value ) {
        this.filtering = value;
    }

    /**
     * Obtém o valor da propriedade directory.
     *
     * @return possible object is {@link String }
     */
    public String getDirectory( ) {
        return directory;
    }

    /**
     * Define o valor da propriedade directory.
     *
     * @param value allowed object is {@link String }
     */
    public void setDirectory( String value ) {
        this.directory = value;
    }

    /**
     * Obtém o valor da propriedade includes.
     *
     * @return possible object is {@link Resource.Includes }
     */
    public Resource.Includes getIncludes( ) {
        return includes;
    }

    /**
     * Define o valor da propriedade includes.
     *
     * @param value allowed object is {@link Resource.Includes }
     */
    public void setIncludes( Resource.Includes value ) {
        this.includes = value;
    }

    /**
     * Obtém o valor da propriedade excludes.
     *
     * @return possible object is {@link Resource.Excludes }
     */
    public Resource.Excludes getExcludes( ) {
        return excludes;
    }

    /**
     * Define o valor da propriedade excludes.
     *
     * @param value allowed object is {@link Resource.Excludes }
     */
    public void setExcludes( Resource.Excludes value ) {
        this.excludes = value;
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
     *         &lt;element name="exclude" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "exclude"
    } )
    public static class Excludes {

        @XmlElement()
        private List< String > exclude;

        /**
         * Gets the value of the exclude property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the exclude property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getExclude().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getExclude( ) {
            if ( exclude == null ) {
                exclude = new ArrayList< String >();
            }
            return this.exclude;
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
     *         &lt;element name="include" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "include"
    } )
    public static class Includes {

        @XmlElement()
        private List< String > include;

        /**
         * Gets the value of the include property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the include property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInclude().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getInclude( ) {
            if ( include == null ) {
                include = new ArrayList< String >();
            }
            return this.include;
        }

    }

}
