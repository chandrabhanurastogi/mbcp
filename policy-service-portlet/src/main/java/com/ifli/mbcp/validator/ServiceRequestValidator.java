package com.ifli.mbcp.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("serviceRequestValidator")
public class ServiceRequestValidator implements Validator
{

	public boolean supports(Class<?> clazz)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors)
	{
		// TODO Auto-generated method stub
		
	}

}
