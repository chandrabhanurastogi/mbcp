package com.ifli.mbcp.service;

import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;

@Component
public interface IReportsService {
	
	/**
	 * @param servletResponse
	 * @param documentType
	 */
	public void generateNeedAnalysisReport(ServletResponse servletResponse, String documentType, Long leadId);

}
