
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
 *         &lt;element name="CustomerID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ApplicationNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ServiceRequestId" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "customerID",
    "policyNumber",
    "applicationNumber",
    "serviceRequestId"
})
@XmlRootElement(name = "ViewServiceRequest")
public class ViewServiceRequest {

    @XmlElement(name = "User")
    protected User user;
    @XmlElement(name = "Channel")
    protected String channel;
    @XmlElement(name = "CustomerID")
    protected long customerID;
    @XmlElement(name = "PolicyNumber")
    protected long policyNumber;
    @XmlElement(name = "ApplicationNumber")
    protected long applicationNumber;
    @XmlElement(name = "ServiceRequestId")
    protected long serviceRequestId;

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
     * Gets the value of the customerID property.
     * 
     */
    public long getCustomerID() {
        return customerID;
    }

    /**
     * Sets the value of the customerID property.
     * 
     */
    public void setCustomerID(long value) {
        this.customerID = value;
    }

    /**
     * Gets the value of the policyNumber property.
     * 
     */
    public long getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Sets the value of the policyNumber property.
     * 
     */
    public void setPolicyNumber(long value) {
        this.policyNumber = value;
    }

    /**
     * Gets the value of the applicationNumber property.
     * 
     */
    public long getApplicationNumber() {
        return applicationNumber;
    }

    /**
     * Sets the value of the applicationNumber property.
     * 
     */
    public void setApplicationNumber(long value) {
        this.applicationNumber = value;
    }

    /**
     * Gets the value of the serviceRequestId property.
     * 
     */
    public long getServiceRequestId() {
        return serviceRequestId;
    }

    /**
     * Sets the value of the serviceRequestId property.
     * 
     */
    public void setServiceRequestId(long value) {
        this.serviceRequestId = value;
    }

}
