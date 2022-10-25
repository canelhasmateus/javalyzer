package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * Section for management of reports and their configuration.
 *
 * <p>Classe Java de Reporting complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Reporting">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="excludeDefaults" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outputDirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plugins" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="plugin" type="{http://maven.apache.org/POM/4.0.0}ReportPlugin" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType( name = "Reporting", propOrder = {

} )
public class Reporting {

    @XmlElement()
    private String            excludeDefaults;
    @XmlElement()
    private String            outputDirectory;
    @XmlElement()
    private Reporting.Plugins plugins;

    /**
     * Obtém o valor da propriedade excludeDefaults.
     *
     * @return possible object is {@link String }
     */
    public String getExcludeDefaults( ) {
        return excludeDefaults;
    }

    /**
     * Define o valor da propriedade excludeDefaults.
     *
     * @param value allowed object is {@link String }
     */
    public void setExcludeDefaults( String value ) {
        this.excludeDefaults = value;
    }

    /**
     * Obtém o valor da propriedade outputDirectory.
     *
     * @return possible object is {@link String }
     */
    public String getOutputDirectory( ) {
        return outputDirectory;
    }

    /**
     * Define o valor da propriedade outputDirectory.
     *
     * @param value allowed object is {@link String }
     */
    public void setOutputDirectory( String value ) {
        this.outputDirectory = value;
    }

    /**
     * Obtém o valor da propriedade plugins.
     *
     * @return possible object is {@link Reporting.Plugins }
     */
    public Reporting.Plugins getPlugins( ) {
        return plugins;
    }

    /**
     * Define o valor da propriedade plugins.
     *
     * @param value allowed object is {@link Reporting.Plugins }
     */
    public void setPlugins( Reporting.Plugins value ) {
        this.plugins = value;
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
     *         &lt;element name="plugin" type="{http://maven.apache.org/POM/4.0.0}ReportPlugin" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "plugin"
    } )
    public static class Plugins {

        @XmlElement()
        private List< ReportPlugin > plugin;

        /**
         * Gets the value of the plugin property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the plugin property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPlugin().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link ReportPlugin }
         */
        public List< ReportPlugin > getPlugin( ) {
            if ( plugin == null ) {
                plugin = new ArrayList< ReportPlugin >();
            }
            return this.plugin;
        }

    }

}
