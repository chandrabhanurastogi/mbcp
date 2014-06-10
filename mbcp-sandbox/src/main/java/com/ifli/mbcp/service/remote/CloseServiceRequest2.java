
package com.ifli.mbcp.service.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CloseServiceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CloseServiceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Service_Request_Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Closed_By" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closed_DateTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="Delay_Reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Closure_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CloseServiceRequest", propOrder = {
    "serviceRequestId",
    "closedBy",
    "closedDateTime",
    "delayReason",
    "closureDescription",
    "notes"
})
public class CloseServiceRequest2 {

    @XmlElement(name = "Service_Request_Id")
    protected long serviceRequestId;
    @XmlElement(name = "Closed_By")
    protected String closedBy;
    @XmlElement(name = "Closed_DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar closedDateTime;
    @XmlElement(name = "Delay_Reason")
    protected String delayReason;
    @XmlElement(name = "Closure_Description")
    protected String closureDescription;
    @XmlElement(name = "Notes")
    protected String notes;

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
     * Gets the value of the closedDateTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getClosedDateTime() {
        return closedDateTime;
    }

    /**
     * Sets the value of the closedDateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setClosedDateTime(XMLGregorianCalendar value) {
        this.closedDateTime = value;
    }

    /**
     * Gets the value of the delayReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelayReason() {
        return delayReason;
    }

    /**
     * Sets the value of the delayReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelayReason(String value) {
        this.delayReason = value;
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

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotes(String value) {
        this.notes = value;
    }

}
