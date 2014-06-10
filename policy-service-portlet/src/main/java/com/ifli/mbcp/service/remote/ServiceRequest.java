
package com.ifli.mbcp.service.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service_Request_Id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Create_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contact_Email" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closed_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Category" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Call_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sub_Type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Owner_Team" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assigned_Team" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Assigned_To" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contact" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Policy" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Severity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closed_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Close_Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ServiceRequest", propOrder = {
    "serviceRequestId",
    "createDate",
    "status",
    "contactEmail",
    "closedDate",
    "category",
    "callType",
    "subType",
    "ownerTeam",
    "assignedTeam",
    "assignedTo",
    "contact",
    "policy",
    "channel",
    "severity",
    "closedBy",
    "closeStatus",
    "closureDescription"
})
public class ServiceRequest {

    @XmlElement(name = "Service_Request_Id")
    protected String serviceRequestId;
    @XmlElement(name = "Create_Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createDate;
    @XmlElement(name = "Status")
    protected String status;
    @XmlElement(name = "Contact_Email")
    protected String contactEmail;
    @XmlElement(name = "Closed_Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closedDate;
    @XmlElement(name = "Category")
    protected String category;
    @XmlElement(name = "Call_Type")
    protected String callType;
    @XmlElement(name = "Sub_Type")
    protected String subType;
    @XmlElement(name = "Owner_Team")
    protected String ownerTeam;
    @XmlElement(name = "Assigned_Team")
    protected String assignedTeam;
    @XmlElement(name = "Assigned_To")
    protected String assignedTo;
    @XmlElement(name = "Contact")
    protected long contact;
    @XmlElement(name = "Policy")
    protected long policy;
    @XmlElement(name = "Channel")
    protected String channel;
    @XmlElement(name = "Severity")
    protected String severity;
    @XmlElement(name = "Closed_By")
    protected String closedBy;
    @XmlElement(name = "Close_Status")
    protected String closeStatus;
    @XmlElement(name = "Closure_Description")
    protected String closureDescription;

    /**
     * Gets the value of the serviceRequestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceRequestId() {
        return serviceRequestId;
    }

    /**
     * Sets the value of the serviceRequestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceRequestId(String value) {
        this.serviceRequestId = value;
    }

    /**
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreateDate(XMLGregorianCalendar value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the contactEmail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * Sets the value of the contactEmail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactEmail(String value) {
        this.contactEmail = value;
    }

    /**
     * Gets the value of the closedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosedDate() {
        return closedDate;
    }

    /**
     * Sets the value of the closedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosedDate(XMLGregorianCalendar value) {
        this.closedDate = value;
    }

    /**
     * Gets the value of the category property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the value of the category property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategory(String value) {
        this.category = value;
    }

    /**
     * Gets the value of the callType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallType() {
        return callType;
    }

    /**
     * Sets the value of the callType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallType(String value) {
        this.callType = value;
    }

    /**
     * Gets the value of the subType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubType(String value) {
        this.subType = value;
    }

    /**
     * Gets the value of the ownerTeam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerTeam() {
        return ownerTeam;
    }

    /**
     * Sets the value of the ownerTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerTeam(String value) {
        this.ownerTeam = value;
    }

    /**
     * Gets the value of the assignedTeam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignedTeam() {
        return assignedTeam;
    }

    /**
     * Sets the value of the assignedTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignedTeam(String value) {
        this.assignedTeam = value;
    }

    /**
     * Gets the value of the assignedTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssignedTo() {
        return assignedTo;
    }

    /**
     * Sets the value of the assignedTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssignedTo(String value) {
        this.assignedTo = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     */
    public long getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     */
    public void setContact(long value) {
        this.contact = value;
    }

    /**
     * Gets the value of the policy property.
     * 
     */
    public long getPolicy() {
        return policy;
    }

    /**
     * Sets the value of the policy property.
     * 
     */
    public void setPolicy(long value) {
        this.policy = value;
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
     * Gets the value of the severity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeverity(String value) {
        this.severity = value;
    }

    /**
     * Gets the value of the closedBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosedBy() {
        return closedBy;
    }

    /**
     * Sets the value of the closedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosedBy(String value) {
        this.closedBy = value;
    }

    /**
     * Gets the value of the closeStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCloseStatus() {
        return closeStatus;
    }

    /**
     * Sets the value of the closeStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCloseStatus(String value) {
        this.closeStatus = value;
    }

    /**
     * Gets the value of the closureDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClosureDescription() {
        return closureDescription;
    }

    /**
     * Sets the value of the closureDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClosureDescription(String value) {
        this.closureDescription = value;
    }

}
