package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * This is the file specification used to activate the profile. The <code>missing</code> value is the location of a file that needs to exist, and if it doesn't, the profile will be activated. On the
 * other hand, <code>exists</code> will test for the existence of the file and if it is there, the profile will be activated.<br> Variable interpolation for these file specifications is limited to
 * <code>${basedir}</code>, System properties and request properties.
 *
 * <p>Classe Java de ActivationFile complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="ActivationFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="missing" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="exists" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "ActivationFile", propOrder = {

} )
public class ActivationFile {

    @XmlElement()
    private String missing;
    @XmlElement()
    private String exists;

    /**
     * Obtém o valor da propriedade missing.
     *
     * @return possible object is {@link String }
     */
    public String getMissing( ) {
        return missing;
    }

    /**
     * Define o valor da propriedade missing.
     *
     * @param value allowed object is {@link String }
     */
    public void setMissing( String value ) {
        this.missing = value;
    }

    /**
     * Obtém o valor da propriedade exists.
     *
     * @return possible object is {@link String }
     */
    public String getExists( ) {
        return exists;
    }

    /**
     * Define o valor da propriedade exists.
     *
     * @param value allowed object is {@link String }
     */
    public void setExists( String value ) {
        this.exists = value;
    }

}
