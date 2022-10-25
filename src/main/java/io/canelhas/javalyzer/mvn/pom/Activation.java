package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * The conditions within the build runtime environment which will trigger the automatic inclusion of the build profile. Multiple conditions can be defined, which must be all satisfied to activate the
 * profile.
 *
 *
 * <p>Classe Java de Activation complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Activation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="activeByDefault" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="jdk" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="os" type="{http://maven.apache.org/POM/4.0.0}ActivationOS" minOccurs="0"/>
 *         &lt;element name="property" type="{http://maven.apache.org/POM/4.0.0}ActivationProperty" minOccurs="0"/>
 *         &lt;element name="file" type="{http://maven.apache.org/POM/4.0.0}ActivationFile" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Activation", propOrder = {

} )
public class Activation {

    @XmlElement( defaultValue = "false" )
    private Boolean            activeByDefault;
    @XmlElement()
    private String             jdk;
    @XmlElement()
    private ActivationOS       os;
    @XmlElement()
    private ActivationProperty property;
    @XmlElement()
    private ActivationFile     file;

    /**
     * Obtém o valor da propriedade activeByDefault.
     *
     * @return possible object is {@link Boolean }
     */
    public Boolean isActiveByDefault( ) {
        return activeByDefault;
    }

    /**
     * Define o valor da propriedade activeByDefault.
     *
     * @param value allowed object is {@link Boolean }
     */
    public void setActiveByDefault( Boolean value ) {
        this.activeByDefault = value;
    }

    /**
     * Obtém o valor da propriedade jdk.
     *
     * @return possible object is {@link String }
     */
    public String getJdk( ) {
        return jdk;
    }

    /**
     * Define o valor da propriedade jdk.
     *
     * @param value allowed object is {@link String }
     */
    public void setJdk( String value ) {
        this.jdk = value;
    }

    /**
     * Obtém o valor da propriedade os.
     *
     * @return possible object is {@link ActivationOS }
     */
    public ActivationOS getOs( ) {
        return os;
    }

    /**
     * Define o valor da propriedade os.
     *
     * @param value allowed object is {@link ActivationOS }
     */
    public void setOs( ActivationOS value ) {
        this.os = value;
    }

    /**
     * Obtém o valor da propriedade property.
     *
     * @return possible object is {@link ActivationProperty }
     */
    public ActivationProperty getProperty( ) {
        return property;
    }

    /**
     * Define o valor da propriedade property.
     *
     * @param value allowed object is {@link ActivationProperty }
     */
    public void setProperty( ActivationProperty value ) {
        this.property = value;
    }

    /**
     * Obtém o valor da propriedade file.
     *
     * @return possible object is {@link ActivationFile }
     */
    public ActivationFile getFile( ) {
        return file;
    }

    /**
     * Define o valor da propriedade file.
     *
     * @param value allowed object is {@link ActivationFile }
     */
    public void setFile( ActivationFile value ) {
        this.file = value;
    }

}
