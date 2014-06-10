package com.ifli.mbcp.validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.ifli.mbcp.util.MBCPConstants.SearchBy;
import com.ifli.mbcp.vo.SearchCriteriaBean;

@Component("leadSearchValidator")
public class LeadSearchValidator implements Validator
{
	private static final Logger	logger	= LoggerFactory.getLogger(LeadSearchValidator.class);

	public boolean supports(Class<?> clazz)
	{
		return SearchCriteriaBean.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors)
	{
		logger.info("Validating Search Parameters.");
		SearchCriteriaBean searchCriteriaBean = (SearchCriteriaBean) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "searchText", "NotBlank.searchText");

		if (errors.hasErrors())
		{
			return;
		}

		if (searchCriteriaBean.getSearchById() == SearchBy.LEAD_ID.getValue())
		{
			try
			{
				Long.parseLong(searchCriteriaBean.getSearchText());
			}
			catch (NumberFormatException e)
			{
				errors.rejectValue("searchText", "Invalid.leadID");
			}
		}
		else if (searchCriteriaBean.getSearchById() == SearchBy.LEAD_ID.getValue())
		{
		}
	}

}
