package com.ifli.mbcp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents a multimedia pitch entity. Typically this is the URL to a video
 * file stored elsewhere, and is streamed to the users.
 * 
 * @author FL867
 * @version 1.0
 * @since 22 May 2013
 */
@Entity
@Table(name = "tbl_audiovideo")
public class AudioVideo implements Serializable
{
	private static final long	serialVersionUID	= -3402607299165611507L;

	/**
	 * Unique Identifier of a Audio/Video instance
	 */
	private Long				audioVideoId;

	/**
	 * Audio/Video URL pointing to an external system (Absolute URL)
	 */
	private String				url;

	/**
	 * Language associated to this instance of Audio/Video
	 * 
	 * @see Language
	 */
	private Language			language;

	/**
	 * InsurancePlan associated to this instance of Audio/Video
	 * 
	 * @see InsurancePlan
	 */
	private InsurancePlan		tblInsurance;

	
	private Integer type;
	
	private String urlType;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getAudioVideoId()
	{
		return audioVideoId;
	}

	public void setAudioVideoId(Long audioVideoId)
	{
		this.audioVideoId = audioVideoId;
	}

	@Column(nullable = false, length = 300)
	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	@ManyToOne
	@JoinColumn(name = "languageId")
	public Language getLanguage()
	{
		return language;
	}

	public void setLanguage(Language language)
	{
		this.language = language;
	}

	@ManyToOne
	@JoinColumn(name = "planId", insertable = false, updatable = false, nullable = false)
	public InsurancePlan getTblInsurance()
	{
		return tblInsurance;
	}

	public void setTblInsurance(InsurancePlan tblInsurance)
	{
		this.tblInsurance = tblInsurance;
	}

	@Column(name="urlType",nullable=false)
	public String getUrlType() {
		return urlType;
	}

	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}

	@Column(name="type",nullable=false)
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
