package io.canelhas.javalyzer.mvn.pom;

import jakarta.xml.bind.annotation.*;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;


/**
 * The <code>&lt;execution&gt;</code> element contains informations required for the execution of a plugin.
 *
 *
 *
 * <p>Classe Java de PluginExecution complex type.
 *
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 *
 * <pre>
 * &lt;complexType name="PluginExecution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="phase" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="goals" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="goal" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="inherited" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="configuration" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType( XmlAccessType.FIELD )
@XmlType( name = "PluginExecution", propOrder = {

} )
public class PluginExecution {

    @XmlElement( defaultValue = "default" )
    private String                        id;
    @XmlElement()
    private String                        phase;
    @XmlElement()
    private PluginExecution.Goals         goals;
    @XmlElement()
    private String                        inherited;
    @XmlElement()
    private PluginExecution.Configuration configuration;

    /**
     * Obtém o valor da propriedade id.
     *
     * @return possible object is {@link String }
     */
    public String getId( ) {
        return id;
    }

    /**
     * Define o valor da propriedade id.
     *
     * @param value allowed object is {@link String }
     */
    public void setId( String value ) {
        this.id = value;
    }

    /**
     * Obtém o valor da propriedade phase.
     *
     * @return possible object is {@link String }
     */
    public String getPhase( ) {
        return phase;
    }

    /**
     * Define o valor da propriedade phase.
     *
     * @param value allowed object is {@link String }
     */
    public void setPhase( String value ) {
        this.phase = value;
    }

    /**
     * Obtém o valor da propriedade goals.
     *
     * @return possible object is {@link PluginExecution.Goals }
     */
    public PluginExecution.Goals getGoals( ) {
        return goals;
    }

    /**
     * Define o valor da propriedade goals.
     *
     * @param value allowed object is {@link PluginExecution.Goals }
     */
    public void setGoals( PluginExecution.Goals value ) {
        this.goals = value;
    }

    /**
     * Obtém o valor da propriedade inherited.
     *
     * @return possible object is {@link String }
     */
    public String getInherited( ) {
        return inherited;
    }

    /**
     * Define o valor da propriedade inherited.
     *
     * @param value allowed object is {@link String }
     */
    public void setInherited( String value ) {
        this.inherited = value;
    }

    /**
     * Obtém o valor da propriedade configuration.
     *
     * @return possible object is {@link PluginExecution.Configuration }
     */
    public PluginExecution.Configuration getConfiguration( ) {
        return configuration;
    }

    /**
     * Define o valor da propriedade configuration.
     *
     * @param value allowed object is {@link PluginExecution.Configuration }
     */
    public void setConfiguration( PluginExecution.Configuration value ) {
        this.configuration = value;
    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any processContents='skip' maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "any"
    } )
    public static class Configuration {

        @XmlAnyElement
        private List< Element > any;

        /**
         * Gets the value of the any property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the any property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link Element }
         */
        public List< Element > getAny( ) {
            if ( any == null ) {
                any = new ArrayList< Element >();
            }
            return this.any;
        }

    }


    /**
     * <p>Classe Java de anonymous complex type.
     *
     * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="goal" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType( XmlAccessType.FIELD )
    @XmlType( name = "", propOrder = {
            "goal"
    } )
    public static class Goals {

        @XmlElement()
        private List< String > goal;

        /**
         * Gets the value of the goal property.
         *
         * <p>
         * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification you make to the returned list will be present inside the JAXB object. This is why there
         * is not a <CODE>set</CODE> method for the goal property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getGoal().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list {@link String }
         */
        public List< String > getGoal( ) {
            if ( goal == null ) {
                goal = new ArrayList< String >();
            }
            return this.goal;
        }

    }

}
