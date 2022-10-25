package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * The <code>&lt;project&gt;</code> element is the root of the descriptor. The following table lists all of the possible child elements.
 *
 *
 *
 * <p>Classe Java de Model complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Model">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="modelVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="parent" type="{http://maven.apache.org/POM/4.0.0}Parent" minOccurs="0"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="packaging" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inceptionYear" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="organization" type="{http://maven.apache.org/POM/4.0.0}Organization" minOccurs="0"/>
 *         &lt;element name="licenses" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="license" type="{http://maven.apache.org/POM/4.0.0}License" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="developers" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="developer" type="{http://maven.apache.org/POM/4.0.0}Developer" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="contributors" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="contributor" type="{http://maven.apache.org/POM/4.0.0}Contributor" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="mailingLists" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="mailingList" type="{http://maven.apache.org/POM/4.0.0}MailingList" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="prerequisites" type="{http://maven.apache.org/POM/4.0.0}Prerequisites" minOccurs="0"/>
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
 *         &lt;element name="scm" type="{http://maven.apache.org/POM/4.0.0}Scm" minOccurs="0"/>
 *         &lt;element name="issueManagement" type="{http://maven.apache.org/POM/4.0.0}IssueManagement" minOccurs="0"/>
 *         &lt;element name="ciManagement" type="{http://maven.apache.org/POM/4.0.0}CiManagement" minOccurs="0"/>
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
 *         &lt;element name="build" type="{http://maven.apache.org/POM/4.0.0}Build" minOccurs="0"/>
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
 *         &lt;element name="profiles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="profile" type="{http://maven.apache.org/POM/4.0.0}Profile" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *       &lt;attribute name="child.project.url.inherit.append.path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "model", namespace = "http://maven.apache.org/POM/4.0.0", propOrder = {

} )
public class Model {

    @XmlElement()
    private String modelVersion;

    @XmlElement()
    private String                   schemaLocation;
    @XmlElement()
    private Parent                   parent;
    @XmlElement()
    private String                   groupId;
    @XmlElement()
    private String                   artifactId;
    @XmlElement()
    private String                   version;
    @XmlElement( defaultValue = "jar" )
    private String                   packaging;
    @XmlElement()
    private String                   name;
    @XmlElement()
    private String                   description;
    @XmlElement()
    private String                   url;
    @XmlElement()
    private String                   inceptionYear;
    @XmlElement()
    private Organization             organization;
    @XmlElement()
    private Model.Licenses           licenses;
    @XmlElement()
    private Model.Developers         developers;
    @XmlElement()
    private Model.Contributors       contributors;
    @XmlElement()
    private Model.MailingLists       mailingLists;
    @XmlElement()
    private Prerequisites            prerequisites;
    @XmlElement()
    private Model.Modules            modules;
    @XmlElement()
    private Scm                      scm;
    @XmlElement()
    private IssueManagement          issueManagement;
    @XmlElement()
    private CiManagement             ciManagement;
    @XmlElement()
    private DistributionManagement   distributionManagement;
    @XmlElement()
    private Model.Properties         properties;
    @XmlElement()
    private DependencyManagement     dependencyManagement;
    @XmlElement()
    private Model.Dependencies       dependencies;
    @XmlElement()
    private Model.Repositories       repositories;
    @XmlElement()
    private Model.PluginRepositories pluginRepositories;
    @XmlElement()
    private Build                    build;
    @XmlElement()
    private Model.Reports            reports;
    @XmlElement()
    private Reporting                reporting;
    @XmlElement()
    private Model.Profiles           profiles;
    @XmlAttribute( name = "child.project.url.inherit.append.path" )
    private String                   childProjectUrlInheritAppendPath;

    /**
     * Obtém o valor da propriedade modelVersion.
     *
     * @return possible object is {@link String }
     */
    public String getModelVersion( ) {
        return modelVersion;
    }

    /**
     * Define o valor da propriedade modelVersion.
     *
     * @param value allowed object is {@link String }
     */
    public void setModelVersion( String value ) {
        this.modelVersion = value;
    }

    /**
     * Obtém o valor da propriedade parent.
     *
     * @return possible object is {@link Parent }
     */
    public Parent getParent( ) {
        return parent;
    }

    /**
     * Define o valor da propriedade parent.
     *
     * @param value allowed object is {@link Parent }
     */
    public void setParent( Parent value ) {
        this.parent = value;
    }

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
     * Obtém o valor da propriedade packaging.
     *
     * @return possible object is {@link String }
     */
    public String getPackaging( ) {
        return packaging;
    }

    /**
     * Define o valor da propriedade packaging.
     *
     * @param value allowed object is {@link String }
     */
    public void setPackaging( String value ) {
        this.packaging = value;
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
     * Obtém o valor da propriedade description.
     *
     * @return possible object is {@link String }
     */
    public String getDescription( ) {
        return description;
    }

    /**
     * Define o valor da propriedade description.
     *
     * @param value allowed object is {@link String }
     */
    public void setDescription( String value ) {
        this.description = value;
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
     * Obtém o valor da propriedade inceptionYear.
     *
     * @return possible object is {@link String }
     */
    public String getInceptionYear( ) {
        return inceptionYear;
    }

    /**
     * Define o valor da propriedade inceptionYear.
     *
     * @param value allowed object is {@link String }
     */
    public void setInceptionYear( String value ) {
        this.inceptionYear = value;
    }

    /**
     * Obtém o valor da propriedade organization.
     *
     * @return possible object is {@link Organization }
     */
    public Organization getOrganization( ) {
        return organization;
    }

    /**
     * Define o valor da propriedade organization.
     *
     * @param value allowed object is {@link Organization }
     */
    public void setOrganization( Organization value ) {
        this.organization = value;
    }

    /**
     * Obtém o valor da propriedade licenses.
     *
     * @return possible object is {@link Model.Licenses }
     */
    public Model.Licenses getLicenses( ) {
        return licenses;
    }

    /**
     * Define o valor da propriedade licenses.
     *
     * @param value allowed object is {@link Model.Licenses }
     */
    public void setLicenses( Model.Licenses value ) {
        this.licenses = value;
    }

    /**
     * Obtém o valor da propriedade developers.
     *
     * @return possible object is {@link Model.Developers }
     */
    public Model.Developers getDevelopers( ) {
        return developers;
    }

    /**
     * Define o valor da propriedade developers.
     *
     * @param value allowed object is {@link Model.Developers }
     */
    public void setDevelopers( Model.Developers value ) {
        this.developers = value;
    }

    /**
     * Obtém o valor da propriedade contributors.
     *
     * @return possible object is {@link Model.Contributors }
     */
    public Model.Contributors getContributors( ) {
        return contributors;
    }

    /**
     * Define o valor da propriedade contributors.
     *
     * @param value allowed object is {@link Model.Contributors }
     */
    public void setContributors( Model.Contributors value ) {
        this.contributors = value;
    }

    /**
     * Obtém o valor da propriedade mailingLists.
     *
     * @return possible object is {@link Model.MailingLists }
     */
    public Model.MailingLists getMailingLists( ) {
        return mailingLists;
    }

    /**
     * Define o valor da propriedade mailingLists.
     *
     * @param value allowed object is {@link Model.MailingLists }
     */
    public void setMailingLists( Model.MailingLists value ) {
        this.mailingLists = value;
    }

    /**
     * Obtém o valor da propriedade prerequisites.
     *
     * @return possible object is {@link Prerequisites }
     */
    public Prerequisites getPrerequisites( ) {
        return prerequisites;
    }

    /**
     * Define o valor da propriedade prerequisites.
     *
     * @param value allowed object is {@link Prerequisites }
     */
    public void setPrerequisites( Prerequisites value ) {
        this.prerequisites = value;
    }

    /**
     * Obtém o valor da propriedade modules.
     *
     * @return possible object is {@link Model.Modules }
     */
    public Model.Modules getModules( ) {
        return modules;
    }

    /**
     * Define o valor da propriedade modules.
     *
     * @param value allowed object is {@link Model.Modules }
     */
    public void setModules( Model.Modules value ) {
        this.modules = value;
    }

    /**
     * Obtém o valor da propriedade scm.
     *
     * @return possible object is {@link Scm }
     */
    public Scm getScm( ) {
        return scm;
    }

    /**
     * Define o valor da propriedade scm.
     *
     * @param value allowed object is {@link Scm }
     */
    public void setScm( Scm value ) {
        this.scm = value;
    }

    /**
     * Obtém o valor da propriedade issueManagement.
     *
     * @return possible object is {@link IssueManagement }
     */
    public IssueManagement getIssueManagement( ) {
        return issueManagement;
    }

    /**
     * Define o valor da propriedade issueManagement.
     *
     * @param value allowed object is {@link IssueManagement }
     */
    public void setIssueManagement( IssueManagement value ) {
        this.issueManagement = value;
    }

    /**
     * Obtém o valor da propriedade ciManagement.
     *
     * @return possible object is {@link CiManagement }
     */
    public CiManagement getCiManagement( ) {
        return ciManagement;
    }

    /**
     * Define o valor da propriedade ciManagement.
     *
     * @param value allowed object is {@link CiManagement }
     */
    public void setCiManagement( CiManagement value ) {
        this.ciManagement = value;
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
     * @return possible object is {@link Model.Properties }
     */
    public Model.Properties getProperties( ) {
        return properties;
    }

    /**
     * Define o valor da propriedade properties.
     *
     * @param value allowed object is {@link Model.Properties }
     */
    public void setProperties( Model.Properties value ) {
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
     * @return possible object is {@link Model.Dependencies }
     */
    public Model.Dependencies getDependencies( ) {
        return dependencies;
    }

    /**
     * Define o valor da propriedade dependencies.
     *
     * @param value allowed object is {@link Model.Dependencies }
     */
    public void setDependencies( Model.Dependencies value ) {
        this.dependencies = value;
    }

    /**
     * Obtém o valor da propriedade repositories.
     *
     * @return possible object is {@link Model.Repositories }
     */
    public Model.Repositories getRepositories( ) {
        return repositories;
    }

    /**
     * Define o valor da propriedade repositories.
     *
     * @param value allowed object is {@link Model.Repositories }
     */
    public void setRepositories( Model.Repositories value ) {
        this.repositories = value;
    }

    /**
     * Obtém o valor da propriedade pluginRepositories.
     *
     * @return possible object is {@link Model.PluginRepositories }
     */
    public Model.PluginRepositories getPluginRepositories( ) {
        return pluginRepositories;
    }

    /**
     * Define o valor da propriedade pluginRepositories.
     *
     * @param value allowed object is {@link Model.PluginRepositories }
     */
    public void setPluginRepositories( Model.PluginRepositories value ) {
        this.pluginRepositories = value;
    }

    /**
     * Obtém o valor da propriedade build.
     *
     * @return possible object is {@link Build }
     */
    public Build getBuild( ) {
        return build;
    }

    /**
     * Define o valor da propriedade build.
     *
     * @param value allowed object is {@link Build }
     */
    public void setBuild( Build value ) {
        this.build = value;
    }

    /**
     * Obtém o valor da propriedade reports.
     *
     * @return possible object is {@link Model.Reports }
     */
    public Model.Reports getReports( ) {
        return reports;
    }

    /**
     * Define o valor da propriedade reports.
     *
     * @param value allowed object is {@link Model.Reports }
     */
    public void setReports( Model.Reports value ) {
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
     * Obtém o valor da propriedade profiles.
     *
     * @return possible object is {@link Model.Profiles }
     */
    public Model.Profiles getProfiles( ) {
        return profiles;
    }

    /**
     * Define o valor da propriedade profiles.
     *
     * @param value allowed object is {@link Model.Profiles }
     */
    public void setProfiles( Model.Profiles value ) {
        this.profiles = value;
    }

    /**
     * Obtém o valor da propriedade childProjectUrlInheritAppendPath.
     *
     * @return possible object is {@link String }
     */
    public String getChildProjectUrlInheritAppendPath( ) {
        return childProjectUrlInheritAppendPath;
    }

    /**
     * Define o valor da propriedade childProjectUrlInheritAppendPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setChildProjectUrlInheritAppendPath( String value ) {
        this.childProjectUrlInheritAppendPath = value;
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
     *         &lt;element name="contributor" type="{http://maven.apache.org/POM/4.0.0}Contributor" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "contributor"
    } )
    public static class Contributors {

        @XmlElement()
        private List< Contributor > contributor;

        /**
         * Gets the value of the contributor property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the contributor property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getContributor().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Contributor }
         */
        public List< Contributor > getContributor( ) {
            if ( contributor == null ) {
                contributor = new ArrayList< Contributor >();
            }
            return this.contributor;
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
     *         &lt;element name="developer" type="{http://maven.apache.org/POM/4.0.0}Developer" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "developer"
    } )
    public static class Developers {

        @XmlElement()
        private List< Developer > developer;

        /**
         * Gets the value of the developer property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the developer property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDeveloper().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Developer }
         */
        public List< Developer > getDeveloper( ) {
            if ( developer == null ) {
                developer = new ArrayList< Developer >();
            }
            return this.developer;
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
     *         &lt;element name="license" type="{http://maven.apache.org/POM/4.0.0}License" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "license"
    } )
    public static class Licenses {

        @XmlElement()
        private List< License > license;

        /**
         * Gets the value of the license property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the license property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLicense().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link License }
         */
        public List< License > getLicense( ) {
            if ( license == null ) {
                license = new ArrayList< License >();
            }
            return this.license;
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
     *         &lt;element name="mailingList" type="{http://maven.apache.org/POM/4.0.0}MailingList" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "mailingList"
    } )
    public static class MailingLists {

        @XmlElement()
        private List< MailingList > mailingList;

        /**
         * Gets the value of the mailingList property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the mailingList property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMailingList().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link MailingList }
         */
        public List< MailingList > getMailingList( ) {
            if ( mailingList == null ) {
                mailingList = new ArrayList< MailingList >();
            }
            return this.mailingList;
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
     *         &lt;element name="profile" type="{http://maven.apache.org/POM/4.0.0}Profile" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "profile"
    } )
    public static class Profiles {

        @XmlElement()
        private List< Profile > profile;

        /**
         * Gets the value of the profile property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the profile property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProfile().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Profile }
         */
        public List< Profile > getProfile( ) {
            if ( profile == null ) {
                profile = new ArrayList< Profile >();
            }
            return this.profile;
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
