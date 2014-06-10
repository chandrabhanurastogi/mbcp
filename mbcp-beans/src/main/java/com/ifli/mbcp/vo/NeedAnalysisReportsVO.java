package com.ifli.mbcp.vo;


public class NeedAnalysisReportsVO {
	
	private CustomerDetailsVO     leadCustomerDetails; 
	private String			      name;
	private String			      dateOfBirth;
	private String			      gender;
	private String 			      maritalStatus;
	
	
	public CustomerDetailsVO getLeadCustomerDetails() {
		return leadCustomerDetails;
	}
	public void setLeadCustomerDetails(CustomerDetailsVO leadCustomerDetails) {
		this.leadCustomerDetails = leadCustomerDetails;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGender() {
		return gender;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	
}
