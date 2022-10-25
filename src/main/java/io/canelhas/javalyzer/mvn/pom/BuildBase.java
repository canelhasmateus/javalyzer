package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * Generic informations for a build.
 *
 * <p>Classe Java de BuildBase complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="BuildBase">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="defaultGoal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="resources" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="resource" type="{http://maven.apache.org/POM/4.0.0}Resource" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="testResources" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="testResource" type="{http://maven.apache.org/POM/4.0.0}Resource" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="directory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="finalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="filters" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="filter" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pluginManagement" type="{http://maven.apache.org/POM/4.0.0}PluginManagement" minOccurs="0"/>
 *         &lt;element name="plugins" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="plugin" type="{http://maven.apache.org/POM/4.0.0}Plugin" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType( name = "BuildBase", propOrder = {

} )
public class BuildBase {

    @XmlElement()
    private String                  defaultGoal;
    @XmlElement()
    private BuildBase.Resources     resources;
    @XmlElement()
    private BuildBase.TestResources testResources;
    @XmlElement()
    private String                  directory;
    @XmlElement()
    private String                  finalName;
    @XmlElement()
    private BuildBase.Filters       filters;
    @XmlElement()
    private PluginManagement        pluginManagement;
    @XmlElement()
    private BuildBase.Plugins       plugins;

    /**
     * Obtém o valor da propriedade defaultGoal.
     *
     * @return possible object is {@link String }
     */
    public String getDefaultGoal( ) {
        return defaultGoal;
    }

    /**
     * Define o valor da propriedade defaultGoal.
     *
     * @param value allowed object is {@link String }
     */
    public void setDefaultGoal( String value ) {
        this.defaultGoal = value;
    }

    /**
     * Obtém o valor da propriedade resources.
     *
     * @return possible object is {@link BuildBase.Resources }
     */
    public BuildBase.Resources getResources( ) {
        return resources;
    }

    /**
     * Define o valor da propriedade resources.
     *
     * @param value allowed object is {@link BuildBase.Resources }
     */
    public void setResources( BuildBase.Resources value ) {
        this.resources = value;
    }

    /**
     * Obtém o valor da propriedade testResources.
     *
     * @return possible object is {@link BuildBase.TestResources }
     */
    public BuildBase.TestResources getTestResources( ) {
        return testResources;
    }

    /**
     * Define o valor da propriedade testResources.
     *
     * @param value allowed object is {@link BuildBase.TestResources }
     */
    public void setTestResources( BuildBase.TestResources value ) {
        this.testResources = value;
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
     * Obtém o valor da propriedade finalName.
     *
     * @return possible object is {@link String }
     */
    public String getFinalName( ) {
        return finalName;
    }

    /**
     * Define o valor da propriedade finalName.
     *
     * @param value allowed object is {@link String }
     */
    public void setFinalName( String value ) {
        this.finalName = value;
    }

    /**
     * Obtém o valor da propriedade filters.
     *
     * @return possible object is {@link BuildBase.Filters }
     */
    public BuildBase.Filters getFilters( ) {
        return filters;
    }

    /**
     * Define o valor da propriedade filters.
     *
     * @param value allowed object is {@link BuildBase.Filters }
     */
    public void setFilters( BuildBase.Filters value ) {
        this.filters = value;
    }

    /**
     * Obtém o valor da propriedade pluginManagement.
     *
     * @return possible object is {@link PluginManagement }
     */
    public PluginManagement getPluginManagement( ) {
        return pluginManagement;
    }

    /**
     * Define o valor da propriedade pluginManagement.
     *
     * @param value allowed object is {@link PluginManagement }
     */
    public void setPluginManagement( PluginManagement value ) {
        this.pluginManagement = value;
    }

    /**
     * Obtém o valor da propriedade plugins.
     *
     * @return possible object is {@link BuildBase.Plugins }
     */
    public BuildBase.Plugins getPlugins( ) {
        return plugins;
    }

    /**
     * Define o valor da propriedade plugins.
     *
     * @param value allowed object is {@link BuildBase.Plugins }
     */
    public void setPlugins( BuildBase.Plugins value ) {
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
     *         &lt;element name="filter" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "filter"
    } )
    public static class Filters {

        @XmlElement()
        private List< String > filter;

        /**
         * Gets the value of the filter property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the filter property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getFilter().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getFilter( ) {
            if ( filter == null ) {
                filter = new ArrayList< String >();
            }
            return this.filter;
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
     *         &lt;element name="plugin" type="{http://maven.apache.org/POM/4.0.0}Plugin" maxOccurs="unbounded" minOccurs="0"/>
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
        private List< Plugin > plugin;

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
         * Objects of the following type(s) are allowed in the list {@link Plugin }
         */
        public List< Plugin > getPlugin( ) {
            if ( plugin == null ) {
                plugin = new ArrayList< Plugin >();
            }
            return this.plugin;
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
     *         &lt;element name="resource" type="{http://maven.apache.org/POM/4.0.0}Resource" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "resource"
    } )
    public static class Resources {

        @XmlElement()
        private List< Resource > resource;

        /**
         * Gets the value of the resource property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the resource property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getResource().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Resource }
         */
        public List< Resource > getResource( ) {
            if ( resource == null ) {
                resource = new ArrayList< Resource >();
            }
            return this.resource;
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
     *         &lt;element name="testResource" type="{http://maven.apache.org/POM/4.0.0}Resource" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "testResource"
    } )
    public static class TestResources {

        @XmlElement()
        private List< Resource > testResource;

        /**
         * Gets the value of the testResource property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the testResource property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTestResource().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Resource }
         */
        public List< Resource > getTestResource( ) {
            if ( testResource == null ) {
                testResource = new ArrayList< Resource >();
            }
            return this.testResource;
        }

    }

}
