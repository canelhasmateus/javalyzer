package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is an activator which will detect an operating system's attributes in order to activate its profile.
 *
 * <p>Classe Java de ActivationOS complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="ActivationOS">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="family" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="arch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ActivationOS", propOrder = {

} )
public class ActivationOS {

    @XmlElement()
    private String name;
    @XmlElement()
    private String family;
    @XmlElement()
    private String arch;
    @XmlElement()
    private String version;

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
     * Obtém o valor da propriedade family.
     *
     * @return possible object is {@link String }
     */
    public String getFamily( ) {
        return family;
    }

    /**
     * Define o valor da propriedade family.
     *
     * @param value allowed object is {@link String }
     */
    public void setFamily( String value ) {
        this.family = value;
    }

    /**
     * Obtém o valor da propriedade arch.
     *
     * @return possible object is {@link String }
     */
    public String getArch( ) {
        return arch;
    }

    /**
     * Define o valor da propriedade arch.
     *
     * @param value allowed object is {@link String }
     */
    public void setArch( String value ) {
        this.arch = value;
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

}
