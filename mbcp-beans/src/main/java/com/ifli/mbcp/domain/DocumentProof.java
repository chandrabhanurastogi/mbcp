package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents the document proof uploaded by a user to the MBCP system. 
 * Document proof include proof of age, proof of address, proof of id, 
 * PAN Card, etc.
 * 
 * @author FL703
 * @since 28 May 2013
 * @version 1.0
 */
@Entity
@Table(name = "tbl_lookup_document_proof")
public class DocumentProof extends GenericLookup implements Serializable{
	
	
	private static final long serialVersionUID = -608188976261659538L;
	
	@Override
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId()
	{
		return super.getId();
	}

	@Override
	@Column(name = "documentProofName", length = 128, nullable = false)
	public String getName()
	{
		return super.getName();
	}

	@Override
	@Column(name = "documentProofDescription", nullable = true)
	public String getDescription()
	{
		return super.getDescription();
	}

}
