package com.ifli.mbcp.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifli.mbcp.dao.LeadDAO;
import com.ifli.mbcp.dao.exceptions.DAOException;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.domain.NeedsAnalysis;
import com.ifli.mbcp.service.IReportsService;
import com.ifli.mbcp.vo.NeedAnalysisReportsVO;

/**
 * This class is used for report's generation, report will be generated in PDF file format.
 * 
 * @author Fl703
 * @version 1.0
 * @since 03 June 2013
 * 
 */
@Service(value = "needAnalysisReportsService")
@Transactional
public class ReportsServiceImpl implements IReportsService {

	private static final Logger logger = LoggerFactory.getLogger(LeadServiceImpl.class);

	@Autowired
	@Qualifier("leadDAO")
	private LeadDAO leadDAO;

	public void generateNeedAnalysisReport(ServletResponse servletResponse,
			String documentType, Long leadId) {

		if (documentType != null && documentType.equals("PDF")) {
			servletResponse.setContentType("application/pdf");
		}
		InputStream inputStream = getClass().getResourceAsStream("/report1.jrxml");
		URL image = getClass().getClassLoader().getResource("/IFLI001.gif");
		URL image1 = getClass().getClassLoader().getResource("/IFLI002.jpg");

		try {
			Lead lead = null;
			try {
				lead = leadDAO.findById(Lead.class, leadId);
			} catch (DAOException e) {
				throw new DAOException();
			}
			Set<NeedsAnalysis> naSet = lead.getNeedsAnalysis();
			Iterator<NeedsAnalysis> iter = naSet.iterator();
			NeedsAnalysis needAnalysis = null;
			while (iter.hasNext()) {
				needAnalysis = iter.next();
			}

			NeedAnalysisReportsVO needAnalysisReportsVO = populateBean(lead);
			List<NeedAnalysisReportsVO> needAnalysisReportsList = new ArrayList<NeedAnalysisReportsVO>();
			needAnalysisReportsList.add(needAnalysisReportsVO);

			printPDF(servletResponse, inputStream, image, image1, needAnalysisReportsList);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param lead
	 * @return NeedAnalysisReportsVO
	 */
	private NeedAnalysisReportsVO populateBean(Lead lead) {
		ModelMapper modelMapper = new ModelMapper();
		PropertyMap<Lead, NeedAnalysisReportsVO> personMap = new PropertyMap<Lead, NeedAnalysisReportsVO>() {
			protected void configure() {
				map().setName(source.getLeadCustomerDetails().getFullCustomerName());
				map().setGender(source.getLeadCustomerDetails().getGenderType());
				map().setDateOfBirth(source.getLeadCustomerDetails().getDateOfBirth().toString());
			}
		};
		modelMapper.addMappings(personMap);
		NeedAnalysisReportsVO needAnalysisReportsVO = modelMapper.map(lead,NeedAnalysisReportsVO.class);
		return needAnalysisReportsVO;
	}

	/**
	 * @param servletResponse
	 * @param inputStream
	 * @param image
	 * @param image1
	 * @param needAnalysisReportsList
	 * @throws IOException
	 * @throws JRException
	 */
	private void printPDF(ServletResponse servletResponse,
			InputStream inputStream, URL image, URL image1,
			List<NeedAnalysisReportsVO> needAnalysisReportsList)
			throws IOException, JRException {
		
		ServletOutputStream sops = servletResponse.getOutputStream();
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(needAnalysisReportsList);
		HashMap<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("IFLI_LOGO", image.toString());
		parameters.put("IFLI_LOGO1", image1.toString());
		JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		JasperExportManager.exportReportToPdfStream(jasperPrint, sops);
	}

}
