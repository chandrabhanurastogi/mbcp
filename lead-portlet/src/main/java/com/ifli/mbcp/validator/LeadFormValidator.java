package com.ifli.mbcp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.LeadGeneratorCode;
import com.ifli.mbcp.service.LookupService;
import com.ifli.mbcp.vo.LeadVO;


@Component("leadFormValidator")
public class LeadFormValidator implements Validator {
	private static final Logger logger = LoggerFactory.getLogger(LeadFormValidator.class);
	
	@Autowired
	@Qualifier("lookupService")
	private LookupService lookupService;

	public boolean supports(Class<?> clazz) {
		return LeadVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		logger.info("Validating Lead.");
		LeadVO lead = (LeadVO)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.firstName", "NotBlank.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.lastName", "NotBlank.lastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.gender", "NotBlank.gender");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.customerAddress[0].addressLine1", "NotBlank.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "branchCode.id", "NotBlank.branchCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bmRmCode.id", "NotBlank.bmRmCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bdmCode.id", "NotBlank.bdmCode");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadGeneratorCode.id", "NotBlank.leadGeneratorCode");

		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "applicationNumber", "NotBlank.applicationNumber");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "premiumAmount", "NotBlank.premiumAmount");
		//IFLIValidationUtils.checkPhoneNumber("leadCustomerDetails.mobileNumber", lead.getLeadCustomerDetails().getMobileNumber(), errors, "Invalid.mobileNumber");
		
		
		if(lead.getBranchCode().getId() != null && !lookupService.exists(BranchCode.class, lead.getBranchCode().getId())){
			errors.rejectValue("branchCode.id", "Invalid.branchCode");
		}
		

		if(lead.getBmRmCode().getId() != null && !lookupService.exists(BMRMCode.class, lead.getBmRmCode().getId())){
			errors.rejectValue("bmRmCode.id", "Invalid.bmRmCode");
		}
		

		if(lead.getBdmCode().getId() != null && !lookupService.exists(BDMCode.class, lead.getBdmCode().getId())){
			errors.rejectValue("bdmCode.id", "Invalid.bdmCode");
		}
		

		if(lead.getLeadGeneratorCode().getId() != null && !lookupService.exists(LeadGeneratorCode.class, lead.getLeadGeneratorCode().getId())){
			errors.rejectValue("leadGeneratorCode.id", "Invalid.leadGeneratorCode");
		}
		logger.info("Validation Completed.");
	}

        
}
