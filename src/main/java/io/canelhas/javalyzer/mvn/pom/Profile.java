package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * Modifications to the build process which is activated based on environmental parameters or command line arguments.
 *
 * <p>Classe Java de Profile complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Profile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="activation" type="{http://maven.apache.org/POM/4.0.0}Activation" minOccurs="0"/>
 *         &lt;element name="build" type="{http://maven.apache.org/POM/4.0.0}BuildBase" minOccurs="0"/>
 *         &lt;element name="modules" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="module" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="distributionManagement" type="{http://maven.apache.org/POM/4.0.0}DistributionManagement" minOccurs="0"/>
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
 *         &lt;element name="dependencyManagement" type="{http://maven.apache.org/POM/4.0.0}DependencyManagement" minOccurs="0"/>
 *         &lt;element name="dependencies" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="dependency" type="{http://maven.apache.org/POM/4.0.0}Dependency" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="repositories" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="repository" type="{http://maven.apache.org/POM/4.0.0}Repository" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="pluginRepositories" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="pluginRepository" type="{http://maven.apache.org/POM/4.0.0}Repository" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="reports" minOccurs="0">
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
 *         &lt;element name="reporting" type="{http://maven.apache.org/POM/4.0.0}Reporting" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Profile", propOrder = {

} )
public class Profile {

    @XmlElement( defaultValue = "default" )
    private String                     id;
    @XmlElement()
    private Activation                 activation;
    @XmlElement()
    private BuildBase                  build;
    @XmlElement()
    private Profile.Modules            modules;
    @XmlElement()
    private DistributionManagement     distributionManagement;
    @XmlElement()
    private Profile.Properties         properties;
    @XmlElement()
    private DependencyManagement       dependencyManagement;
    @XmlElement()
    private Profile.Dependencies       dependencies;
    @XmlElement()
    private Profile.Repositories       repositories;
    @XmlElement()
    private Profile.PluginRepositories pluginRepositories;
    @XmlElement()
    private Profile.Reports            reports;
    @XmlElement()
    private Reporting                  reporting;

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
     * Obtém o valor da propriedade activation.
     *
     * @return possible object is {@link Activation }
     */
    public Activation getActivation( ) {
        return activation;
    }

    /**
     * Define o valor da propriedade activation.
     *
     * @param value allowed object is {@link Activation }
     */
    public void setActivation( Activation value ) {
        this.activation = value;
    }

    /**
     * Obtém o valor da propriedade build.
     *
     * @return possible object is {@link BuildBase }
     */
    public BuildBase getBuild( ) {
        return build;
    }

    /**
     * Define o valor da propriedade build.
     *
     * @param value allowed object is {@link BuildBase }
     */
    public void setBuild( BuildBase value ) {
        this.build = value;
    }

    /**
     * Obtém o valor da propriedade modules.
     *
     * @return possible object is {@link Profile.Modules }
     */
    public Profile.Modules getModules( ) {
        return modules;
    }

    /**
     * Define o valor da propriedade modules.
     *
     * @param value allowed object is {@link Profile.Modules }
     */
    public void setModules( Profile.Modules value ) {
        this.modules = value;
    }

    /**
     * Obtém o valor da propriedade distributionManagement.
     *
     * @return possible object is {@link DistributionManagement }
     */
    public DistributionManagement getDistributionManagement( ) {
        return distributionManagement;
    }

    /**
     * Define o valor da propriedade distributionManagement.
     *
     * @param value allowed object is {@link DistributionManagement }
     */
    public void setDistributionManagement( DistributionManagement value ) {
        this.distributionManagement = value;
    }

    /**
     * Obtém o valor da propriedade properties.
     *
     * @return possible object is {@link Profile.Properties }
     */
    public Profile.Properties getProperties( ) {
        return properties;
    }

    /**
     * Define o valor da propriedade properties.
     *
     * @param value allowed object is {@link Profile.Properties }
     */
    public void setProperties( Profile.Properties value ) {
        this.properties = value;
    }

    /**
     * Obtém o valor da propriedade dependencyManagement.
     *
     * @return possible object is {@link DependencyManagement }
     */
    public DependencyManagement getDependencyManagement( ) {
        return dependencyManagement;
    }

    /**
     * Define o valor da propriedade dependencyManagement.
     *
     * @param value allowed object is {@link DependencyManagement }
     */
    public void setDependencyManagement( DependencyManagement value ) {
        this.dependencyManagement = value;
    }

    /**
     * Obtém o valor da propriedade dependencies.
     *
     * @return possible object is {@link Profile.Dependencies }
     */
    public Profile.Dependencies getDependencies( ) {
        return dependencies;
    }

    /**
     * Define o valor da propriedade dependencies.
     *
     * @param value allowed object is {@link Profile.Dependencies }
     */
    public void setDependencies( Profile.Dependencies value ) {
        this.dependencies = value;
    }

    /**
     * Obtém o valor da propriedade repositories.
     *
     * @return possible object is {@link Profile.Repositories }
     */
    public Profile.Repositories getRepositories( ) {
        return repositories;
    }

    /**
     * Define o valor da propriedade repositories.
     *
     * @param value allowed object is {@link Profile.Repositories }
     */
    public void setRepositories( Profile.Repositories value ) {
        this.repositories = value;
    }

    /**
     * Obtém o valor da propriedade pluginRepositories.
     *
     * @return possible object is {@link Profile.PluginRepositories }
     */
    public Profile.PluginRepositories getPluginRepositories( ) {
        return pluginRepositories;
    }

    /**
     * Define o valor da propriedade pluginRepositories.
     *
     * @param value allowed object is {@link Profile.PluginRepositories }
     */
    public void setPluginRepositories( Profile.PluginRepositories value ) {
        this.pluginRepositories = value;
    }

    /**
     * Obtém o valor da propriedade reports.
     *
     * @return possible object is {@link Profile.Reports }
     */
    public Profile.Reports getReports( ) {
        return reports;
    }

    /**
     * Define o valor da propriedade reports.
     *
     * @param value allowed object is {@link Profile.Reports }
     */
    public void setReports( Profile.Reports value ) {
        this.reports = value;
    }

    /**
     * Obtém o valor da propriedade reporting.
     *
     * @return possible object is {@link Reporting }
     */
    public Reporting getReporting( ) {
        return reporting;
    }

    /**
     * Define o valor da propriedade reporting.
     *
     * @param value allowed object is {@link Reporting }
     */
    public void setReporting( Reporting value ) {
        this.reporting = value;
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
     *         &lt;element name="dependency" type="{http://maven.apache.org/POM/4.0.0}Dependency" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "dependency"
    } )
    public static class Dependencies {

        @XmlElement()
        private List< Dependency > dependency;

        /**
         * Gets the value of the dependency property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the dependency property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDependency().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Dependency }
         */
        public List< Dependency > getDependency( ) {
            if ( dependency == null ) {
                dependency = new ArrayList< Dependency >();
            }
            return this.dependency;
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
     *         &lt;element name="module" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "module"
    } )
    public static class Modules {

        @XmlElement()
        private List< String > module;

        /**
         * Gets the value of the module property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the module property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getModule().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getModule( ) {
            if ( module == null ) {
                module = new ArrayList< String >();
            }
            return this.module;
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
     *         &lt;element name="pluginRepository" type="{http://maven.apache.org/POM/4.0.0}Repository" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "pluginRepository"
    } )
    public static class PluginRepositories {

        @XmlElement()
        private List< Repository > pluginRepository;

        /**
         * Gets the value of the pluginRepository property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the pluginRepository property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPluginRepository().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Repository }
         */
        public List< Repository > getPluginRepository( ) {
            if ( pluginRepository == null ) {
                pluginRepository = new ArrayList< Repository >();
            }
            return this.pluginRepository;
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
    public static class Reports {

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
     *         &lt;element name="repository" type="{http://maven.apache.org/POM/4.0.0}Repository" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "repository"
    } )
    public static class Repositories {

        @XmlElement()
        private List< Repository > repository;

        /**
         * Gets the value of the repository property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the repository property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRepository().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Repository }
         */
        public List< Repository > getRepository( ) {
            if ( repository == null ) {
                repository = new ArrayList< Repository >();
            }
            return this.repository;
        }

    }

}
