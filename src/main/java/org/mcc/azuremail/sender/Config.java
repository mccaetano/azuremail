//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.7 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2022.05.15 às 07:03:27 PM BRT 
//


package org.mcc.azuremail.sender;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de config complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="config">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="clientSecret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tenantId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="scopes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="callTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="connectTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="readTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="writeTimeout" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "config", propOrder = {
    "clientId",
    "clientSecret",
    "tenantId",
    "scopes",
    "callTimeout",
    "connectTimeout",
    "readTimeout",
    "writeTimeout"
})
public class Config {

    @XmlElement(required = true)
    protected String clientId;
    @XmlElement(required = true)
    protected String clientSecret;
    @XmlElement(required = true)
    protected String tenantId;
    @XmlElement(required = true)
    protected List<String> scopes;
    protected int callTimeout;
    protected int connectTimeout;
    protected int readTimeout;
    protected int writeTimeout;

    /**
     * Obtém o valor da propriedade clientId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Define o valor da propriedade clientId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientId(String value) {
        this.clientId = value;
    }

    /**
     * Obtém o valor da propriedade clientSecret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientSecret() {
        return clientSecret;
    }

    /**
     * Define o valor da propriedade clientSecret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientSecret(String value) {
        this.clientSecret = value;
    }

    /**
     * Obtém o valor da propriedade tenantId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTenantId() {
        return tenantId;
    }

    /**
     * Define o valor da propriedade tenantId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTenantId(String value) {
        this.tenantId = value;
    }

    /**
     * Gets the value of the scopes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the scopes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getScopes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getScopes() {
        if (scopes == null) {
            scopes = new ArrayList<String>();
        }
        return this.scopes;
    }

    /**
     * Obtém o valor da propriedade callTimeout.
     * 
     */
    public int getCallTimeout() {
        return callTimeout;
    }

    /**
     * Define o valor da propriedade callTimeout.
     * 
     */
    public void setCallTimeout(int value) {
        this.callTimeout = value;
    }

    /**
     * Obtém o valor da propriedade connectTimeout.
     * 
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Define o valor da propriedade connectTimeout.
     * 
     */
    public void setConnectTimeout(int value) {
        this.connectTimeout = value;
    }

    /**
     * Obtém o valor da propriedade readTimeout.
     * 
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Define o valor da propriedade readTimeout.
     * 
     */
    public void setReadTimeout(int value) {
        this.readTimeout = value;
    }

    /**
     * Obtém o valor da propriedade writeTimeout.
     * 
     */
    public int getWriteTimeout() {
        return writeTimeout;
    }

    /**
     * Define o valor da propriedade writeTimeout.
     * 
     */
    public void setWriteTimeout(int value) {
        this.writeTimeout = value;
    }

}
