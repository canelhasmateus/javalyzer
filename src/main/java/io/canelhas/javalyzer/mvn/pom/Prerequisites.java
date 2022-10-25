package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * Describes the prerequisites a project can have.
 *
 * <p>Classe Java de Prerequisites complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Prerequisites">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="maven" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Prerequisites", propOrder = {

} )
public class Prerequisites {

    @XmlElement( defaultValue = "2.0" )
    private String maven;

    /**
     * Obtém o valor da propriedade maven.
     *
     * @return possible object is {@link String }
     */
    public String getMaven( ) {
        return maven;
    }

    /**
     * Define o valor da propriedade maven.
     *
     * @param value allowed object is {@link String }
     */
    public void setMaven( String value ) {
        this.maven = value;
    }

}
