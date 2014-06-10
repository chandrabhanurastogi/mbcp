package com.ifli.mbcp.service.remote;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.Holder;

import junit.framework.TestCase;

import org.junit.Test;

import com.ifli.mbcp.service.util.XMLGregorianCalendarConversionUtil;

public class CreateServiceTest extends TestCase {
	private Service testService;
	private ObjectFactory objectFactory;

	@Test
	public void testWebServiceConnection() throws JAXBException, MalformedURLException {
		Date currentDate = new Date();
		XMLGregorianCalendar xmlGC = XMLGregorianCalendarConversionUtil
				.asXMLGregorianCalendar(currentDate);
		
		URL url = new URL("http://220.226.102.236/PivotalCSMSSDK/Service.asmx?WSDL");

		QName SERVICE_QNAME = new QName("http://www.CDCCRM.com/webservices/", "Service");
			    
		testService = new Service(url,SERVICE_QNAME);
		objectFactory = new ObjectFactory();

		// Check that we have a non-null web service handle
		assertNotNull(testService);

		// Create the test request that will be sent to the web service
		CreateServiceRequest testRequest = objectFactory
				.createCreateServiceRequest();
		
		CreateServiceRequestResponse  response = objectFactory.createCreateServiceRequestResponse();

		// Start creating the Java beans that will populate the test request
		// before it is sent to the web service.
		User testUser = objectFactory.createUser();
		testUser.setUserName("IFL");
		testUser.setPassword("pass@123");
		testRequest.setUser(testUser);
		testRequest.setChannel("web");

		CreateServiceRequest2 t2 = objectFactory.createCreateServiceRequest2();
		ArrayOfAttachment testAttachment = objectFactory
				.createArrayOfAttachment();
		Attachment attachements = new Attachment();
		attachements.setFileDescription("adding image");
		attachements.setFileExtension(".jpg");
		attachements.setFileSize(169);
		attachements.setFileModifiedDate(xmlGC);
		attachements.setFileModifiedTime(xmlGC);
		testAttachment.getAttachment().add(attachements);

		Holder<Boolean> isBoolean = null;
		 Holder<String> id = new  Holder<String>();
		Holder<ArrayOfError> testErrors = null;
		
		// Set values into t2
		t2.setCustId(50000002);
		t2.setPolicyNumber(10000001);
		t2.setCustType("Active");
		t2.setApplicationNumber(200412482);
		t2.setSource("Customer");
		t2.setSeverity("Normal");
		t2.setSubType(849);
		t2.setAttachment(false);
		t2.setCaseDetails("NA");
		
		
		// Fire the web service
		try {
			ServiceSoap serviceSoap = testService.getServiceSoap();
			serviceSoap.createServiceRequest(testUser,"Web Chat", t2, testAttachment, isBoolean, testErrors, id);
			response.setCreateServiceRequestResult(true);
			} catch (ExceptionInInitializerError er) {
			// Do nothing
		}
		JAXBContext ctx = JAXBContext.newInstance(CreateServiceRequestResponse.class);
		Unmarshaller u = ctx.createUnmarshaller();
        //System.out.println("UnMarshaller" + u.toString());
		
		Marshaller m = ctx.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		m.marshal(response, System.out);
      
		System.out.println("The Value of Service Request:" + id.value);
	}
}
