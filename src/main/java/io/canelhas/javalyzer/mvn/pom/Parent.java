package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The <code>&lt;parent&gt;</code> element contains information required to locate the parent project from which this project will inherit from.
 * <strong>Note:</strong> The children of this element are not interpolated and must be given as literal values.
 *
 *
 *
 * <p>Classe Java de Parent complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Parent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="relativePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Parent", propOrder = {

} )
public class Parent {

    @XmlElement()
    private String groupId;
    @XmlElement()
    private String artifactId;
    @XmlElement()
    private String version;
    @XmlElement( defaultValue = "../pom.xml" )
    private String relativePath;

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
     * Obtém o valor da propriedade relativePath.
     *
     * @return possible object is {@link String }
     */
    public String getRelativePath( ) {
        return relativePath;
    }

    /**
     * Define o valor da propriedade relativePath.
     *
     * @param value allowed object is {@link String }
     */
    public void setRelativePath( String value ) {
        this.relativePath = value;
    }

}
