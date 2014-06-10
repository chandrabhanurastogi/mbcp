
package com.ifli.mbcp.service.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CreateServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CreateServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CustType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="PolicyNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="ApplicationNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Channel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Source" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Severity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sub_Type" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="OmniURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CaseDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Attachment" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreateServiceRequest", propOrder = {
    "custType",
    "custId",
    "policyNumber",
    "applicationNumber",
    "channel",
    "source",
    "severity",
    "subType",
    "omniURL",
    "caseDetails",
    "attachment"
})
public class CreateServiceRequest2 {

    @XmlElement(name = "CustType")
    protected String custType;
    @XmlElement(name = "CustId")
    protected long custId;
    @XmlElement(name = "PolicyNumber")
    protected long policyNumber;
    @XmlElement(name = "ApplicationNumber")
    protected long applicationNumber;
    @XmlElement(name = "Channel")
    protected String channel;
    @XmlElement(name = "Source")
    protected String source;
    @XmlElement(name = "Severity")
    protected String severity;
    @XmlElement(name = "Sub_Type")
    protected long subType;
    @XmlElement(name = "OmniURL")
    protected String omniURL;
    @XmlElement(name = "CaseDetails")
    protected String caseDetails;
    @XmlElement(name = "Attachment")
    protected boolean attachment;

    /**
     * Gets the value of the custType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustType() {
        return custType;
    }

    /**
     * Sets the value of the custType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustType(String value) {
        this.custType = value;
    }

    /**
     * Gets the value of the custId property.
     * 
     */
    public long getCustId() {
        return custId;
    }

    /**
     * Sets the value of the custId property.
     * 
     */
    public void setCustId(long value) {
        this.custId = value;
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
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSource(String value) {
        this.source = value;
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
     * Gets the value of the subType property.
     * 
     */
    public long getSubType() {
        return subType;
    }

    /**
     * Sets the value of the subType property.
     * 
     */
    public void setSubType(long value) {
        this.subType = value;
    }

    /**
     * Gets the value of the omniURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOmniURL() {
        return omniURL;
    }

    /**
     * Sets the value of the omniURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOmniURL(String value) {
        this.omniURL = value;
    }

    /**
     * Gets the value of the caseDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCaseDetails() {
        return caseDetails;
    }

    /**
     * Sets the value of the caseDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCaseDetails(String value) {
        this.caseDetails = value;
    }

    /**
     * Gets the value of the attachment property.
     * 
     */
    public boolean isAttachment() {
        return attachment;
    }

    /**
     * Sets the value of the attachment property.
     * 
     */
    public void setAttachment(boolean value) {
        this.attachment = value;
    }

}
