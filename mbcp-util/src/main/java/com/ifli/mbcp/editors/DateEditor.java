package com.ifli.mbcp.editors;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Property editor for Date type properties.
 * 
 */
public class DateEditor extends PropertyEditorSupport {
	private static final Logger		logger	= LoggerFactory.getLogger(DateEditor.class);
	private SimpleDateFormat sdf;

	public DateEditor(SimpleDateFormat simpleDateFormat) {
		this.sdf = simpleDateFormat;
	}
/*
	@Override
	public Object getValue() {
		return super.getValue();
	}
	
	@Override
	public void setValue(Object value) {
		
		super.setValue(value);
	}
	*/
	@Override
	public String getAsText() {
		String returnVal = "";
		if(getValue() != null ) {
			returnVal = sdf.format(getValue());
		}
		
		return returnVal;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		
		try {
			setValue(sdf.parse(text));
		} catch (ParseException e) {
			logger.error("Couldn't parse : " + text);
			setValue(null);
		}
		
	}
	
	
	
	
}
