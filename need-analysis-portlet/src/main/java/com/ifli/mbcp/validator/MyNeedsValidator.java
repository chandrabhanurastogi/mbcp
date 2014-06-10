package com.ifli.mbcp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ifli.mbcp.vo.LeadVO;
import com.ifli.mbcp.vo.NeedsAnalysisVO;
import com.ifli.mbcp.util.IFLIValidationUtils;


@Component("myNeedsValidator")
public class MyNeedsValidator implements Validator {
	private static final Logger _log = LoggerFactory.getLogger(MyNeedsValidator.class);
	

	public boolean supports(Class<?> clazz) {
		return NeedsAnalysisVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		LeadVO needs = (LeadVO) target;
		/*Validation for Current Annual Contribution*/
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerFirstName", "NotBlank.customerFirstName");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerLastName", "NotBlank.customerLastName");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerMiddleName", "NotBlank.customerMiddleName");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerGender", "NotBlank.customerGender");
		//IFLIValidationUtils.checkPhoneNumber("owningLead.mobileNumber", needs.getOwningLead().getMobileNumber(), errors, "Invalid.mobileNumber");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.addressOne", "NotBlank.address");
		//IFLIValidationUtils.checkDob( "owningLead.leadCustomerDetails.dateOfBirth", "NotBlank.dateOfBirth", errors);
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.dateOfBirth", "NotBlank.dateOfBirth");
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.annualIncome", "NotBlank.annualIncome");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.numberOfChildren" , "NotBlank.numberOfChildren");
		
		
		/*Validation for My Needs Tab*/
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"needsAnalysis[0].desirableLifeCover", "NotBlankDesirableLifeCover");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"needsAnalysis[0].desirableHealthCover", "NotBlankDesirableHealthCover");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"needsAnalysis[0].returnOnInvestments", "NotBlankReturnOnInvestments");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"needsAnalysis[0].desirableAnnualPension", "NotBlankDesirableAnnualPension");
		
		/*System Generated fields*/
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lifeStage", "NotBlankLifeStage");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"protectionNeeds", "NotBlankProtectionNeeds");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"appetite", "NotBlankAppetite");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"planRecommendation", "NotBlankPlanRecommendation");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"commitmentDetails", "NotBlankCommitmentDetails");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors,"riskElementExplanation", "NotBlankRiskElementExplanation");
		
		
		
		
		
		_log.info("inside My Needs Validator");
	}

	

	/*public void validate(Object target, Errors errors) {
		System.out.println("inside validate **************");
		logger.info("Validating Need Analysis.");
		//LeadVO lead = (LeadVO)target;
		NeedsAnalysisVO needs = (NeedsAnalysisVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerFirstName", "NotBlank.customerFirstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerLastName", "NotBlank.customerLastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.leadCustomerDetails.customerGender", "NotBlank.customerGender");
		//IFLIValidationUtils.checkPhoneNumber("mobileNumber", lead.getMobileNumber(), errors, "Invalid.mobileNumber");
		IFLIValidationUtils.checkPhoneNumber("owningLead.mobileNumber", needs.getOwningLead().getMobileNumber(), errors, "Invalid.mobileNumber");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owningLead.addressOne", "NotBlank.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchCode.id", "NotBlank.branchCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bmRmCode.id", "NotBlank.bmRmCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadGeneratorCode.id", "NotBlank.leadGeneratorCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "applicationNumber", "NotBlank.applicationNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "premiumAmount", "NotBlank.premiumAmount");
	}*/

        
}
