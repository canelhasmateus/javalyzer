package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Download policy.
 *
 * <p>Classe Java de RepositoryPolicy complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="RepositoryPolicy">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="updatePolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="checksumPolicy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "RepositoryPolicy", propOrder = {

} )
public class RepositoryPolicy {

    @XmlElement()
    private String enabled;
    @XmlElement()
    private String updatePolicy;
    @XmlElement()
    private String checksumPolicy;

    /**
     * Obtém o valor da propriedade enabled.
     *
     * @return possible object is {@link String }
     */
    public String getEnabled( ) {
        return enabled;
    }

    /**
     * Define o valor da propriedade enabled.
     *
     * @param value allowed object is {@link String }
     */
    public void setEnabled( String value ) {
        this.enabled = value;
    }

    /**
     * Obtém o valor da propriedade updatePolicy.
     *
     * @return possible object is {@link String }
     */
    public String getUpdatePolicy( ) {
        return updatePolicy;
    }

    /**
     * Define o valor da propriedade updatePolicy.
     *
     * @param value allowed object is {@link String }
     */
    public void setUpdatePolicy( String value ) {
        this.updatePolicy = value;
    }

    /**
     * Obtém o valor da propriedade checksumPolicy.
     *
     * @return possible object is {@link String }
     */
    public String getChecksumPolicy( ) {
        return checksumPolicy;
    }

    /**
     * Define o valor da propriedade checksumPolicy.
     *
     * @param value allowed object is {@link String }
     */
    public void setChecksumPolicy( String value ) {
        this.checksumPolicy = value;
    }

}
