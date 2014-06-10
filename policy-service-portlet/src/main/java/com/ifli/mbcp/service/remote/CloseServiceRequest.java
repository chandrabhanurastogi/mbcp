
package com.ifli.mbcp.service.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="User" type="{http://www.CDCCRM.com/webservices/}User" minOccurs="0"/>
 *         &lt;element name="Channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AddNotes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="serviceRequest" type="{http://www.CDCCRM.com/webservices/}CloseServiceRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "user",
    "channel",
    "addNotes",
    "serviceRequest"
})
@XmlRootElement(name = "CloseServiceRequest")
public class CloseServiceRequest {

    @XmlElement(name = "User")
    protected User user;
    @XmlElement(name = "Channel")
    protected String channel;
    @XmlElement(name = "AddNotes")
    protected boolean addNotes;
    protected CloseServiceRequest2 serviceRequest;

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setUser(User value) {
        this.user = value;
    }

    /**
     * Gets the value of the channel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannel() {
        return channel;
    }

    /**
     * Sets the value of the channel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannel(String value) {
        this.channel = value;
    }

    /**
     * Gets the value of the addNotes property.
     * 
     */
    public boolean isAddNotes() {
        return addNotes;
    }

    /**
     * Sets the value of the addNotes property.
     * 
     */
    public void setAddNotes(boolean value) {
        this.addNotes = value;
    }

    /**
     * Gets the value of the serviceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CloseServiceRequest2 }
     *     
     */
    public CloseServiceRequest2 getServiceRequest() {
        return serviceRequest;
    }

    /**
     * Sets the value of the serviceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CloseServiceRequest2 }
     *     
     */
    public void setServiceRequest(CloseServiceRequest2 value) {
        this.serviceRequest = value;
    }

}
