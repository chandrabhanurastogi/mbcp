package com.ifli.mbcp.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents a Premium of an insurance policy at IFLI.
 * 
 * @author FL867
 * @version 1.0
 * @since 23 May 2013
 */
@Entity
@Table(name = "tbl_premium")
public class Premium implements Serializable
{
	/**
	 * Unique Identifier of a Premium
	 */

	private Long		premiumId;

	/**
	 * Cutoff date for making Premium payment
	 */

	private Date		premiumPaymentDate;

	/**
	 * Premium amount to be paid
	 */

	private BigDecimal	premiumAmount;

	/**
	 * Mode of Payment
	 * 
	 * @see PaymentType
	 */

	private PaymentType	paymentType;

	/**
	 * Additional information about the Payment done.<br>
	 * Transaction Id, for an Online Transaction or Cheque Details, if payment
	 * made through Cheque etc.
	 */
	private String		paymentNotes;

	/**
	 * Takes care of Currency Formatting
	 * 
	 * @return the Premium Amount in Standard Currency Format
	 */
	@Transient
	public String getPremiumAmountAsText()
	{
		// TODO: Implement a numbers - to - text here
		// TODO: Get a requirement confirmation whether this should be the
		// Indian system or the American system (lakhs/crores/arabs vs hundreds
		// of thousands/millions/billions)
		return ("Billions Of Blue Boiled And Blistering Barnacles");
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getPremiumId()
	{
		return premiumId;
	}

	public void setPremiumId(Long premiumId)
	{
		this.premiumId = premiumId;
	}

	@Column(nullable = false)
	public Date getPremiumPaymentDate()
	{
		return premiumPaymentDate;
	}

	public void setPremiumPaymentDate(Date premiumPaymentDate)
	{
		this.premiumPaymentDate = premiumPaymentDate;
	}

	@Column(nullable = false)
	public BigDecimal getPremiumAmount()
	{
		return premiumAmount;
	}

	public void setPremiumAmount(BigDecimal premiumAmount)
	{
		this.premiumAmount = premiumAmount;
	}

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "paymentTypeId", nullable = false)
	public PaymentType getPaymentType()
	{
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType)
	{
		this.paymentType = paymentType;
	}

	@Column(nullable = false)
	public String getPaymentNotes()
	{
		return paymentNotes;
	}

	public void setPaymentNotes(String paymentNotes)
	{
		this.paymentNotes = paymentNotes;
	}

	private static final long	serialVersionUID	= -7178729729314092130L;
}
