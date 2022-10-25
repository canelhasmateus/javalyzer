package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Repository contains the information needed for deploying to the remote repository.
 *
 * <p>Classe Java de DeploymentRepository complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="DeploymentRepository">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="uniqueVersion" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="releases" type="{http://maven.apache.org/POM/4.0.0}RepositoryPolicy" minOccurs="0"/>
 *         &lt;element name="snapshots" type="{http://maven.apache.org/POM/4.0.0}RepositoryPolicy" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="layout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "DeploymentRepository", propOrder = {

} )
public class DeploymentRepository {

    @XmlElement( defaultValue = "true" )
    private Boolean          uniqueVersion;
    @XmlElement()
    private RepositoryPolicy releases;
    @XmlElement()
    private RepositoryPolicy snapshots;
    @XmlElement()
    private String           id;
    @XmlElement()
    private String           name;
    @XmlElement()
    private String           url;
    @XmlElement( defaultValue = "default" )
    private String           layout;

    /**
     * Obtém o valor da propriedade uniqueVersion.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isUniqueVersion( ) {
        return uniqueVersion;
    }

    /**
     * Define o valor da propriedade uniqueVersion.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setUniqueVersion( Boolean value ) {
        this.uniqueVersion = value;
    }

    /**
     * Obtém o valor da propriedade releases.
     *
     * @return possible object is {@link RepositoryPolicy }
     */
    public RepositoryPolicy getReleases( ) {
        return releases;
    }

    /**
     * Define o valor da propriedade releases.
     *
     * @param value allowed object is {@link RepositoryPolicy }
     */
    public void setReleases( RepositoryPolicy value ) {
        this.releases = value;
    }

    /**
     * Obtém o valor da propriedade snapshots.
     *
     * @return possible object is {@link RepositoryPolicy }
     */
    public RepositoryPolicy getSnapshots( ) {
        return snapshots;
    }

    /**
     * Define o valor da propriedade snapshots.
     *
     * @param value allowed object is {@link RepositoryPolicy }
     */
    public void setSnapshots( RepositoryPolicy value ) {
        this.snapshots = value;
    }

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
     * Obtém o valor da propriedade layout.
     *
     * @return possible object is {@link String }
     */
    public String getLayout( ) {
        return layout;
    }

    /**
     * Define o valor da propriedade layout.
     *
     * @param value allowed object is {@link String }
     */
    public void setLayout( String value ) {
        this.layout = value;
    }

}
