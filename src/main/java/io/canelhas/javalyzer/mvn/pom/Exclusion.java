package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The <code>&lt;exclusion&gt;</code> element contains informations required to exclude an artifact to the project.
 *
 *
 *
 * <p>Classe Java de Exclusion complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Exclusion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Exclusion", propOrder = {

} )
public class Exclusion {

    @XmlElement()
    private String artifactId;
    @XmlElement()
    private String groupId;

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

}
