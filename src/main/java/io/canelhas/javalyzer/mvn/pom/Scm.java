package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;


/**
 * The <code>&lt;scm&gt;</code> element contains informations required to the SCM (Source Control Management) of the project.
 *
 *
 *
 * <p>Classe Java de Scm complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="Scm">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="connection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="developerConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="child.scm.connection.inherit.append.path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="child.scm.developerConnection.inherit.append.path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="child.scm.url.inherit.append.path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "Scm", propOrder = {

} )
public class Scm {

    @XmlElement()
    private String connection;
    @XmlElement()
    private String developerConnection;
    @XmlElement( defaultValue = "HEAD" )
    private String tag;
    @XmlElement()
    private String url;
    @XmlAttribute( name = "child.scm.connection.inherit.append.path" )
    private String childScmConnectionInheritAppendPath;
    @XmlAttribute( name = "child.scm.developerConnection.inherit.append.path" )
    private String childScmDeveloperConnectionInheritAppendPath;
    @XmlAttribute( name = "child.scm.url.inherit.append.path" )
    private String childScmUrlInheritAppendPath;

    /**
     * Obtém o valor da propriedade connection.
     *
     * @return possible object is {@link String }
     */
    public String getConnection( ) {
        return connection;
    }

    /**
     * Define o valor da propriedade connection.
     *
     * @param value allowed object is {@link String }
     */
    public void setConnection( String value ) {
        this.connection = value;
    }

    /**
     * Obtém o valor da propriedade developerConnection.
     *
     * @return possible object is {@link String }
     */
    public String getDeveloperConnection( ) {
        return developerConnection;
    }

    /**
     * Define o valor da propriedade developerConnection.
     *
     * @param value allowed object is {@link String }
     */
    public void setDeveloperConnection( String value ) {
        this.developerConnection = value;
    }

    /**
     * Obtém o valor da propriedade tag.
     *
     * @return possible object is {@link String }
     */
    public String getTag( ) {
        return tag;
    }

    /**
     * Define o valor da propriedade tag.
     *
     * @param value allowed object is {@link String }
     */
    public void setTag( String value ) {
        this.tag = value;
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
     * Obtém o valor da propriedade childScmConnectionInheritAppendPath.
     *
     * @return possible object is {@link String }
     */
    public String getChildScmConnectionInheritAppendPath( ) {
        return childScmConnectionInheritAppendPath;
    }

    /**
     * Define o valor da propriedade childScmConnectionInheritAppendPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setChildScmConnectionInheritAppendPath( String value ) {
        this.childScmConnectionInheritAppendPath = value;
    }

    /**
     * Obtém o valor da propriedade childScmDeveloperConnectionInheritAppendPath.
     *
     * @return possible object is {@link String }
     */
    public String getChildScmDeveloperConnectionInheritAppendPath( ) {
        return childScmDeveloperConnectionInheritAppendPath;
    }

    /**
     * Define o valor da propriedade childScmDeveloperConnectionInheritAppendPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setChildScmDeveloperConnectionInheritAppendPath( String value ) {
        this.childScmDeveloperConnectionInheritAppendPath = value;
    }

    /**
     * Obtém o valor da propriedade childScmUrlInheritAppendPath.
     *
     * @return possible object is {@link String }
     */
    public String getChildScmUrlInheritAppendPath( ) {
        return childScmUrlInheritAppendPath;
    }

    /**
     * Define o valor da propriedade childScmUrlInheritAppendPath.
     *
     * @param value allowed object is {@link String }
     */
    public void setChildScmUrlInheritAppendPath( String value ) {
        this.childScmUrlInheritAppendPath = value;
    }

}
