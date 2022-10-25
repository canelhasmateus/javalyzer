package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Describes where an artifact has moved to. If any of the values are omitted, it is assumed to be the same as it was before.
 *
 * <p>Classe Java de Relocation complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Relocation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="groupId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="artifactId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Relocation", propOrder = {

} )
public class Relocation {

    @XmlElement()
    private String groupId;
    @XmlElement()
    private String artifactId;
    @XmlElement()
    private String version;
    @XmlElement()
    private String message;

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
     * Obtém o valor da propriedade message.
     *
     * @return possible object is {@link String }
     */
    public String getMessage( ) {
        return message;
    }

    /**
     * Define o valor da propriedade message.
     *
     * @param value allowed object is {@link String }
     */
    public void setMessage( String value ) {
        this.message = value;
    }

}
