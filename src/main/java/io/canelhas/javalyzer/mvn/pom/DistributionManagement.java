package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This elements describes all that pertains to distribution for a project. It is primarily used for deployment of artifacts and the site produced by the build.
 *
 * <p>Classe Java de DistributionManagement complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="DistributionManagement">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="repository" type="{http://maven.apache.org/POM/4.0.0}DeploymentRepository" minOccurs="0"/>
 *         &lt;element name="snapshotRepository" type="{http://maven.apache.org/POM/4.0.0}DeploymentRepository" minOccurs="0"/>
 *         &lt;element name="site" type="{http://maven.apache.org/POM/4.0.0}Site" minOccurs="0"/>
 *         &lt;element name="downloadUrl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relocation" type="{http://maven.apache.org/POM/4.0.0}Relocation" minOccurs="0"/>
 *         &lt;element name="exitCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "DistributionManagement", propOrder = {

} )
public class DistributionManagement {

    @XmlElement()
    private DeploymentRepository repository;
    @XmlElement()
    private DeploymentRepository snapshotRepository;
    @XmlElement()
    private Site                 site;
    @XmlElement()
    private String               downloadUrl;
    @XmlElement()
    private Relocation           relocation;
    @XmlElement()
    private String               status;

    /**
     * Obtém o valor da propriedade repository.
     *
     * @return possible object is {@link DeploymentRepository }
     */
    public DeploymentRepository getRepository( ) {
        return repository;
    }

    /**
     * Define o valor da propriedade repository.
     *
     * @param value allowed object is {@link DeploymentRepository }
     */
    public void setRepository( DeploymentRepository value ) {
        this.repository = value;
    }

    /**
     * Obtém o valor da propriedade snapshotRepository.
     *
     * @return possible object is {@link DeploymentRepository }
     */
    public DeploymentRepository getSnapshotRepository( ) {
        return snapshotRepository;
    }

    /**
     * Define o valor da propriedade snapshotRepository.
     *
     * @param value allowed object is {@link DeploymentRepository }
     */
    public void setSnapshotRepository( DeploymentRepository value ) {
        this.snapshotRepository = value;
    }

    /**
     * Obtém o valor da propriedade site.
     *
     * @return possible object is {@link Site }
     */
    public Site getSite( ) {
        return site;
    }

    /**
     * Define o valor da propriedade site.
     *
     * @param value allowed object is {@link Site }
     */
    public void setSite( Site value ) {
        this.site = value;
    }

    /**
     * Obtém o valor da propriedade downloadUrl.
     *
     * @return possible object is {@link String }
     */
    public String getDownloadUrl( ) {
        return downloadUrl;
    }

    /**
     * Define o valor da propriedade downloadUrl.
     *
     * @param value allowed object is {@link String }
     */
    public void setDownloadUrl( String value ) {
        this.downloadUrl = value;
    }

    /**
     * Obtém o valor da propriedade relocation.
     *
     * @return possible object is {@link Relocation }
     */
    public Relocation getRelocation( ) {
        return relocation;
    }

    /**
     * Define o valor da propriedade relocation.
     *
     * @param value allowed object is {@link Relocation }
     */
    public void setRelocation( Relocation value ) {
        this.relocation = value;
    }

    /**
     * Obtém o valor da propriedade exitCode.
     *
     * @return possible object is {@link String }
     */
    public String getStatus( ) {
        return status;
    }

    /**
     * Define o valor da propriedade exitCode.
     *
     * @param value allowed object is {@link String }
     */
    public void setStatus( String value ) {
        this.status = value;
    }

}
