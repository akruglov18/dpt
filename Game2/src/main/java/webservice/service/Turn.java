
package webservice.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for turn complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="turn"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="edge" type="{http://Server/}edge" minOccurs="0"/&gt;
 *         &lt;element name="clientServerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "turn", propOrder = {
    "edge",
    "clientServerName"
})
public class Turn {

    protected Edge edge;
    protected String clientServerName;

    /**
     * Gets the value of the edge property.
     * 
     * @return
     *     possible object is
     *     {@link Edge }
     *     
     */
    public Edge getEdge() {
        return edge;
    }

    /**
     * Sets the value of the edge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Edge }
     *     
     */
    public void setEdge(Edge value) {
        this.edge = value;
    }

    /**
     * Gets the value of the clientServerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientServerName() {
        return clientServerName;
    }

    /**
     * Sets the value of the clientServerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientServerName(String value) {
        this.clientServerName = value;
    }

}
