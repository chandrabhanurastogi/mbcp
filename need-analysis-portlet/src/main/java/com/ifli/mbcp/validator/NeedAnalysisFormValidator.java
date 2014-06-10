package com.ifli.mbcp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ifli.mbcp.util.IFLIValidationUtils;
import com.ifli.mbcp.vo.LeadVO;


@Component("needAnalysisFormValidator")
public class NeedAnalysisFormValidator implements Validator {
	private static final Logger _log = LoggerFactory.getLogger(NeedAnalysisFormValidator.class);

	public boolean supports(Class<?> clazz) {
		return LeadVO.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		
		LeadVO lead = (LeadVO) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.firstName", "NotBlank.customerFirstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.lastName", "NotBlank.customerLastName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.middleName", "NotBlank.customerMiddleName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.gender", "NotBlank.customerGender");
		IFLIValidationUtils.checkPhoneNumber("leadCustomerDetails.mobileNumber", lead.getLeadCustomerDetails().getMobileNumber(), errors, "Invalid.mobileNumber");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.customerAddress[0].addressLine1", "NotBlank.address");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.dateOfBirth", "NotBlank.dateOfBirth");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.annualIncome", "NotBlank.annualIncome");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "leadCustomerDetails.numberOfChildren" , "NotBlank.numberOfChildren");
		
		/*Set<CustomerAddressVO> ca = needs.getOwningLead().getLeadCustomerDetails().getCustomerAddress();
		ca.iterator().next().getAddressLine1();
		//IFLIValidationUtils.addressValidation(ca.iterator().next().getAddressLine1());
		System.out.println("Address1 form value "+ca.iterator().next().getAddressLine1());
		
		if(IFLIValidationUtils.addressValidation(ca.iterator().next().getAddressLine1())){
			System.out.println(IFLIValidationUtils.addressValidation(ca.iterator().next().getAddressLine1()));
			System.out.println("Validation paas in .......................");
		}else{
			System.out.println("Validation fail in .......................");
		}*/
		
		//IFLIValidationUtils.checkDob( "owningLead.leadCustomerDetails.dateOfBirth", "NotBlank.dateOfBirth", errors);
		
		_log.info("inside need analysis form Validator");
	}
}
