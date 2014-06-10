
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
 *         &lt;element name="CloseServiceRequestResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorDetails" type="{http://www.CDCCRM.com/webservices/}ArrayOfError" minOccurs="0"/>
 *         &lt;element name="ServiceRequestId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "closeServiceRequestResult",
    "errorDetails",
    "serviceRequestId"
})
@XmlRootElement(name = "CloseServiceRequestResponse")
public class CloseServiceRequestResponse {

    @XmlElement(name = "CloseServiceRequestResult")
    protected boolean closeServiceRequestResult;
    @XmlElement(name = "ErrorDetails")
    protected ArrayOfError errorDetails;
    @XmlElement(name = "ServiceRequestId")
    protected String serviceRequestId;

    /**
     * Gets the value of the closeServiceRequestResult property.
     * 
     */
    public boolean isCloseServiceRequestResult() {
        return closeServiceRequestResult;
    }

    /**
     * Sets the value of the closeServiceRequestResult property.
     * 
     */
    public void setCloseServiceRequestResult(boolean value) {
        this.closeServiceRequestResult = value;
    }

    /**
     * Gets the value of the errorDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfError }
     *     
     */
    public ArrayOfError getErrorDetails() {
        return errorDetails;
    }

    /**
     * Sets the value of the errorDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfError }
     *     
     */
    public void setErrorDetails(ArrayOfError value) {
        this.errorDetails = value;
    }

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

}
