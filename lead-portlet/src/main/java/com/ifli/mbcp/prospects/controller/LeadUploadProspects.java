package com.ifli.mbcp.prospects.controller;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.ifli.mbcp.domain.BDMCode;
import com.ifli.mbcp.domain.BMRMCode;
import com.ifli.mbcp.domain.BranchCode;
import com.ifli.mbcp.domain.Channel;
import com.ifli.mbcp.domain.City;
import com.ifli.mbcp.domain.CustomerAddress;
import com.ifli.mbcp.domain.CustomerDetails;
import com.ifli.mbcp.domain.InsurancePlan;
import com.ifli.mbcp.domain.Lead;
import com.ifli.mbcp.domain.LeadCategory;
import com.ifli.mbcp.domain.LeadGeneratorCode;
import com.ifli.mbcp.domain.LeadStatus;
import com.ifli.mbcp.domain.LeadType;
import com.ifli.mbcp.domain.Salutation;
import com.ifli.mbcp.domain.State;
import com.ifli.mbcp.service.LeadService;
import com.liferay.portal.kernel.util.ParamUtil;

@Controller("leadUploadProspects")
@RequestMapping(value = "VIEW")
public class LeadUploadProspects {

	private static final Logger logger = LoggerFactory
			.getLogger(LeadUploadProspects.class);

	private static int leadUpdationStatus = 0;
	List<String> mobileNoList = null;

	@Autowired
	@Qualifier("leadService")
	private LeadService				leadService;

	@RenderMapping
	public String showLeadForm(RenderResponse renderResponse) {

		return "lead/leadForm";
	}

	@ActionMapping(params = "action=uploadLead")
	public void uploadLead(ActionRequest request, ActionResponse response)
			throws Exception {
		logger.info("Lead File Upload");
		String fileName = ParamUtil.get(request, "file", "");
		try {
			leadUploadProspects(fileName, request);
		} catch (Exception e) {
			if (leadUpdationStatus == 1) {
				request.setAttribute("uploadLeadError", true);
			} else if (leadUpdationStatus == 0) {
				request.setAttribute("allUploadLeadError", true);
			}
			request.setAttribute("uploadLead", false);
		}
	}

	public void leadUploadProspects(String fileName, ActionRequest request)
			throws Exception {
		
		saveSheetDataToLeadDB(fileName, request);
	}
	
	
	private void saveSheetDataToLeadDB(String fileName, ActionRequest request)
			throws Exception {

		Long id = null;
		Lead uploadLead = null;
		Salutation uploadSalutation = null;
		CustomerDetails customerDetails = null;
		CustomerAddress customerAddress = null;
		Set<CustomerAddress> customerAddressSet = null;
		City city = null;
		State state = null;
		LeadStatus leadStatus = null;
		Channel channel = null;
		BranchCode branchCode = null;
		BMRMCode bmrmCode = null;
		LeadGeneratorCode leadGeneratorCode = null;
		InsurancePlan insurancePlan = null;
		BDMCode bdmCode = null;
		LeadCategory leadCategory = null;
		LeadType leadType = null;
		
		int counter = 1;
		mobileNoList = new ArrayList<String>();
		StringBuffer recordSaveMessage = new StringBuffer();
		
		try {  
    	    FileInputStream inputStream = new FileInputStream(new File(fileName)); 
    	    XSSFWorkbook workBook = new XSSFWorkbook(inputStream); 
    	    XSSFSheet sheet = workBook.getSheetAt(0); 
    	    Iterator rows = sheet.rowIterator();   
    	    
    	    while (rows.hasNext())
    	    {   
    	    	
    	    	if(counter <= 2) {
    	    		counter++;
    	    		rows.next();
    	    		continue;
    	    	}
    	    
			XSSFRow row = ((XSSFRow) rows.next());   
            int cellTemp = row.getPhysicalNumberOfCells();
            boolean checkRow = isRowEmpty(row);
            if(checkRow == Boolean.TRUE) {
           	   break;
            }
                
            for (int columnIndex = 1; columnIndex < cellTemp; columnIndex++) {
              	XSSFCell cell = row.getCell(columnIndex);
               	//String value = null;
                String stringCellValue = cell.toString().trim();
				
			switch (columnIndex) {
				
				case 1 :
					uploadSalutation = leadService.getUniqueEntityByProperty(Salutation.class, "salutationText" , stringCellValue);
					if(uploadSalutation == null) {
						recordSaveMessage.append("Salutation");
					} else {
						customerDetails.setSalutation(uploadSalutation);
					}
				case 2:
					if(stringCellValue == null) {
						recordSaveMessage.append(" First Name");
					} else {
						customerDetails.setFirstName(stringCellValue);
					}
				case 3:
					customerDetails.setMiddleName(stringCellValue);
				case 4:
					if(stringCellValue == null) {
						recordSaveMessage.append(" Last Name");
					} else {
						customerDetails.setLastName(stringCellValue);
					}
				case 5:
					if (stringCellValue.equalsIgnoreCase("MALE"))
						customerDetails.setGender((short) 1);
					else
						customerDetails.setGender((short) 2);
				case 6:
					if(mobileNoList.contains(stringCellValue)) {
						System.out.println("Dup");
					} else {
						mobileNoList.add(stringCellValue);
						customerDetails.setMobileNumber(stringCellValue);
					}
					
				case 7:
					customerDetails.setLandLineNumber(stringCellValue);
				case 8:
					leadCategory = leadService.getUniqueEntityByProperty(LeadCategory.class, "leadCategoryName" , stringCellValue);
					if(leadCategory == null) {
						recordSaveMessage.append(" LeadCategory");
					} else {
					uploadLead.setLeadCategory(leadCategory);
					}
				case 9:
					leadType = leadService.getUniqueEntityByProperty(LeadType.class, "leadTypeName" , stringCellValue);
					if(leadType == null) {
						recordSaveMessage.append(" LeadType");
					} else {

					uploadLead.setLeadType(leadType);
					}
			
				case 10:
					leadStatus = leadService.getUniqueEntityByProperty(LeadStatus.class, "leadStatusName" , stringCellValue);
					if(leadStatus == null) {
						recordSaveMessage.append(" LeadStatus");
					} else {
					uploadLead.setLeadStatus(leadStatus);
					}
					
				case 11:
					if(stringCellValue == null) {
						recordSaveMessage.append(" Address");
					} else {
					customerAddress.setAddressLine1(stringCellValue);
					}
				case 12:
					customerAddress.setAddressLine2(stringCellValue);
				case 13:
					customerAddress.setAddressLine3(stringCellValue);
				case 14:
					city  = leadService.getUniqueEntityByProperty(City.class, "cityName" , stringCellValue);
					if(city == null) {
						recordSaveMessage.append(" City");
					} else {

					customerAddress.setCity(city);
					}
				case 15:
					state  = leadService.getUniqueEntityByProperty(State.class, "stateName" , stringCellValue);
					if(state == null) {
						recordSaveMessage.append(" State");
					} else {

					customerAddress.setState(state);
					}
				case 16:
					customerAddress.setPinCode(stringCellValue);
				case 17:
					channel  = leadService.getUniqueEntityByProperty(Channel.class, "channelName" , stringCellValue);
					if(channel == null) {
						recordSaveMessage.append(" Channel");
					} else {

					uploadLead.setChannelSelection(channel);
					}
				case 18:
					branchCode = leadService.getUniqueEntityByProperty(BranchCode.class, "branchCodeName" , stringCellValue);
					if(branchCode == null) {
						recordSaveMessage.append(" BranchCode");
					} else {

					uploadLead.setBranchCode(branchCode);
					}
				case 19:
					bmrmCode  = leadService.getUniqueEntityByProperty(BMRMCode.class, "bmRmCodeName" , stringCellValue);
					if(bmrmCode == null) {
						recordSaveMessage.append(" BMRMCode");
					} else {

					uploadLead.setBmRmCode(bmrmCode);
					}
				case 20:
					leadGeneratorCode = leadService.getUniqueEntityByProperty(LeadGeneratorCode.class, "leadGeneratorCodeName" , stringCellValue);
					if(leadGeneratorCode == null) {
						recordSaveMessage.append(" LeadGeneratorCode");
					} else {

					uploadLead.setLeadGeneratorCode(leadGeneratorCode);
					}
				case 21:
					bdmCode  = leadService.getUniqueEntityByProperty(BDMCode.class, "bdmCodeName" , stringCellValue);
					if(bdmCode == null) {
						recordSaveMessage.append(" BDMCode");
					} else {

					uploadLead.setBdmCode(bdmCode);
					}
				default:
			}                	
            
				customerAddressSet.add(customerAddress);
				uploadLead.setLeadCustomerDetails(customerDetails);

            }
			
			Long createdLead = leadService.addLead(uploadLead);
			leadUpdationStatus = 1;
			request.setAttribute("uploadLead", true);
			logger.info("Lead has been Created : " + createdLead);

			uploadLead = null;
			uploadSalutation = null;
			customerDetails = null;
			customerAddress = null;
			customerAddressSet = null;
			city = null;
			state = null;
			leadStatus = null;
			channel = null;
			branchCode = null;
			bmrmCode = null;
			leadGeneratorCode = null;
			insurancePlan = null;
			bdmCode = null;
			leadCategory = null;
			leadType = null;
                
        }
        } catch (IOException e) {   
            e.printStackTrace();   
        }

		
	}

    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c <= row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
                return false;
        }
        return true;
    }

	

}
