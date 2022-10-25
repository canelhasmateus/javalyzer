package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * The <code>&lt;plugin&gt;</code> element contains informations required for a report plugin.
 *
 *
 *
 * <p>Classe Java de ReportPlugin complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="ReportPlugin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportSets" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="reportSet" type="{http://maven.apache.org/POM/4.0.0}ReportSet" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="inherited" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType( name = "ReportPlugin", propOrder = {

} )
public class ReportPlugin {

    @XmlElement( defaultValue = "org.apache.maven.plugins" )
    private String                     groupId;
    @XmlElement()
    private String                     artifactId;
    @XmlElement()
    private String                     version;
    @XmlElement()
    private ReportPlugin.ReportSets    reportSets;
    @XmlElement()
    private String                     inherited;
    @XmlElement()
    private ReportPlugin.Configuration configuration;

    /**
     * Obtém o valor da propriedade groupId.
     *
     * @return possible object is {@link String }
     */
    public String getGroupId( ) {
        return groupId;
    }

    /**
     * Define o valor da propriedade groupId.
     *
     * @param value allowed object is {@link String }
     */
    public void setGroupId( String value ) {
        this.groupId = value;
    }

    /**
     * Obtém o valor da propriedade artifactId.
     *
     * @return possible object is {@link String }
     */
    public String getArtifactId( ) {
        return artifactId;
    }

    /**
     * Define o valor da propriedade artifactId.
     *
     * @param value allowed object is {@link String }
     */
    public void setArtifactId( String value ) {
        this.artifactId = value;
    }

    /**
     * Obtém o valor da propriedade version.
     *
     * @return possible object is {@link String }
     */
    public String getVersion( ) {
        return version;
    }

    /**
     * Define o valor da propriedade version.
     *
     * @param value allowed object is {@link String }
     */
    public void setVersion( String value ) {
        this.version = value;
    }

    /**
     * Obtém o valor da propriedade reportSets.
     *
     * @return possible object is {@link ReportPlugin.ReportSets }
     */
    public ReportPlugin.ReportSets getReportSets( ) {
        return reportSets;
    }

    /**
     * Define o valor da propriedade reportSets.
     *
     * @param value allowed object is {@link ReportPlugin.ReportSets }
     */
    public void setReportSets( ReportPlugin.ReportSets value ) {
        this.reportSets = value;
    }

    /**
     * Obtém o valor da propriedade inherited.
     *
     * @return possible object is {@link String }
     */
    public String getInherited( ) {
        return inherited;
    }

    /**
     * Define o valor da propriedade inherited.
     *
     * @param value allowed object is {@link String }
     */
    public void setInherited( String value ) {
        this.inherited = value;
    }

    /**
     * Obtém o valor da propriedade configuration.
     *
     * @return possible object is {@link ReportPlugin.Configuration }
     */
    public ReportPlugin.Configuration getConfiguration( ) {
        return configuration;
    }

    /**
     * Define o valor da propriedade configuration.
     *
     * @param value allowed object is {@link ReportPlugin.Configuration }
     */
    public void setConfiguration( ReportPlugin.Configuration value ) {
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
     *         &lt;element name="reportSet" type="{http://maven.apache.org/POM/4.0.0}ReportSet" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "reportSet"
    } )
    public static class ReportSets {

        @XmlElement()
        private List< ReportSet > reportSet;

        /**
         * Gets the value of the reportSet property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the reportSet property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getReportSet().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ReportSet }
         */
        public List< ReportSet > getReportSet( ) {
            if ( reportSet == null ) {
                reportSet = new ArrayList< ReportSet >();
            }
            return this.reportSet;
        }

    }

}
