
package com.ifli.mbcp.service.remote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Attachment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Attachment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="File_Attachment" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;element name="File_Description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="File_Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="File_Extension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="File_Size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="File_Modified_Date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="File_Modified_Time" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Attachment", propOrder = {
    "fileAttachment",
    "fileDescription",
    "fileName",
    "fileExtension",
    "fileSize",
    "fileModifiedDate",
    "fileModifiedTime"
})
public class Attachment {

    @XmlElement(name = "File_Attachment")
    protected byte[] fileAttachment;
    @XmlElement(name = "File_Description")
    protected String fileDescription;
    @XmlElement(name = "File_Name")
    protected String fileName;
    @XmlElement(name = "File_Extension")
    protected String fileExtension;
    @XmlElement(name = "File_Size")
    protected int fileSize;
    @XmlElement(name = "File_Modified_Date", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fileModifiedDate;
    @XmlElement(name = "File_Modified_Time", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fileModifiedTime;

    /**
     * Gets the value of the fileAttachment property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileAttachment() {
        return fileAttachment;
    }

    /**
     * Sets the value of the fileAttachment property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileAttachment(byte[] value) {
        this.fileAttachment = value;
    }

    /**
     * Gets the value of the fileDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileDescription() {
        return fileDescription;
    }

    /**
     * Sets the value of the fileDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileDescription(String value) {
        this.fileDescription = value;
    }

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileName(String value) {
        this.fileName = value;
    }

    /**
     * Gets the value of the fileExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileExtension() {
        return fileExtension;
    }

    /**
     * Sets the value of the fileExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileExtension(String value) {
        this.fileExtension = value;
    }

    /**
     * Gets the value of the fileSize property.
     * 
     */
    public int getFileSize() {
        return fileSize;
    }

    /**
     * Sets the value of the fileSize property.
     * 
     */
    public void setFileSize(int value) {
        this.fileSize = value;
    }

    /**
     * Gets the value of the fileModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFileModifiedDate() {
        return fileModifiedDate;
    }

    /**
     * Sets the value of the fileModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFileModifiedDate(XMLGregorianCalendar value) {
        this.fileModifiedDate = value;
    }

    /**
     * Gets the value of the fileModifiedTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFileModifiedTime() {
        return fileModifiedTime;
    }

    /**
     * Sets the value of the fileModifiedTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFileModifiedTime(XMLGregorianCalendar value) {
        this.fileModifiedTime = value;
    }

}
