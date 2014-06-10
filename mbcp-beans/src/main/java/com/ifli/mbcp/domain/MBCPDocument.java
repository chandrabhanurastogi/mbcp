package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Represents a document uploaded into MBCP.
 * @author FL867
 * @version 1.0
 * @since 22 May 2013
 */
@Entity
@Table(name = "tbl_documents")
public class MBCPDocument implements Serializable
{
	private Long			documentId;
	private DocumentType	documentType;
	private String			documentName;
	private String			documentFileName;
	private String			documentURL;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getDocumentId()
	{
		return documentId;
	}

	public void setDocumentId(Long documentId)
	{
		this.documentId = documentId;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "documentTypeId")
	public DocumentType getDocumentType()
	{
		return documentType;
	}

	public void setDocumentType(DocumentType documentType)
	{
		this.documentType = documentType;
	}

	@Column
	public String getDocumentName()
	{
		return documentName;
	}

	public void setDocumentName(String documentName)
	{
		this.documentName = documentName;
	}

	@Column
	public String getDocumentFileName()
	{
		return documentFileName;
	}

	public void setDocumentFileName(String documentFileName)
	{
		this.documentFileName = documentFileName;
	}

	@Column
	public String getDocumentURL()
	{
		return documentURL;
	}

	public void setDocumentURL(String documentURL)
	{
		this.documentURL = documentURL;
	}

	private static final long	serialVersionUID	= -6780874122022091302L;
}
