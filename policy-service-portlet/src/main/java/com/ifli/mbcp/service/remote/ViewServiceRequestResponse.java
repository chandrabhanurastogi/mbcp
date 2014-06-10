
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
 *         &lt;element name="ViewServiceRequestResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ErrorDetails" type="{http://www.CDCCRM.com/webservices/}ArrayOfError" minOccurs="0"/>
 *         &lt;element name="ServiceRequestDetails" type="{http://www.CDCCRM.com/webservices/}ArrayOfServiceRequest" minOccurs="0"/>
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
    "viewServiceRequestResult",
    "errorDetails",
    "serviceRequestDetails"
})
@XmlRootElement(name = "ViewServiceRequestResponse")
public class ViewServiceRequestResponse {

    @XmlElement(name = "ViewServiceRequestResult")
    protected boolean viewServiceRequestResult;
    @XmlElement(name = "ErrorDetails")
    protected ArrayOfError errorDetails;
    @XmlElement(name = "ServiceRequestDetails")
    protected ArrayOfServiceRequest serviceRequestDetails;

    /**
     * Gets the value of the viewServiceRequestResult property.
     * 
     */
    public boolean isViewServiceRequestResult() {
        return viewServiceRequestResult;
    }

    /**
     * Sets the value of the viewServiceRequestResult property.
     * 
     */
    public void setViewServiceRequestResult(boolean value) {
        this.viewServiceRequestResult = value;
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
     * Gets the value of the serviceRequestDetails property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfServiceRequest }
     *     
     */
    public ArrayOfServiceRequest getServiceRequestDetails() {
        return serviceRequestDetails;
    }

    /**
     * Sets the value of the serviceRequestDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfServiceRequest }
     *     
     */
    public void setServiceRequestDetails(ArrayOfServiceRequest value) {
        this.serviceRequestDetails = value;
    }

}
