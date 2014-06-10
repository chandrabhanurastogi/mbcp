package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Represents the type of document uploaded by a user to the MBCP system. 
 * Document Types include proof of age, proof of address, proof of id, 
 * PAN Card, etc.
 * 
 * @author FL867
 * @since 21 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_document_type")
public class DocumentType extends GenericLookup implements Serializable
{
	private static final long	serialVersionUID	= -6616479667238737697L;
	
	private Set<DocumentProof>	documentProof;

	@Override
	@Id
	@Column(name = "documentTypeId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "documentName", length = 128, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "documentDescription", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "documentTypeId")
	public Set<DocumentProof> getDocumentProof() {
		return documentProof;
	}

	public void setDocumentProof(Set<DocumentProof> documentProof) {
		this.documentProof = documentProof;
	}
}
