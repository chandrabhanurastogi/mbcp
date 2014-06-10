<%@page import="com.ifli.mbcp.vo.LeadVO"%>
<%@ include file="init.jsp" %>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

  
<script>
$(function() {
    $('.date-picker').datepicker({
    });
});

</script>

<portlet:actionURL var="submitAndRenderTabURL">
	<%-- <portlet:param name="tabs1" value="Current Annual Contribution"/> --%>
	<portlet:param name="action" value="setCurrentAnnualContribution"/>
</portlet:actionURL>

<style>
.error_message {
	color: red;
}
.star {
color: red;
}
#ui-datepicker-div {
		font-size: 70%; /* Without this the datepicker looks huge! */
	}
	.ui-datepicker-trigger {
		vertical-align: middle;
	}

</style>

<div>
<form:form class="form-register" method="post" commandName="leadModelBean"  action="${submitAndRenderTabURL}" modelAttribute="leadModelBean">

	 <div>
		<div class="td1"><label for="leadId" style="float: left;">Lead Id</label></div>
		<div style="margin-left: 460px;"><form:input path="paddedLeadId" readonly="true" />
			<div class="error_message">	<form:errors path="paddedLeadId"/></div>
		</div>
		<%--Hidden field --%>
				<form:hidden path="leadId" />
		
	</div> 
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.salutation.salutationId" style="float: left;">Salutation</label></div>
		<div style="margin-left: 460px;">
			<form:select path="leadCustomerDetails.salutation.salutationId">
				<form:options items="${needAnalysisSalutationList}" itemLabel="salutationText" itemValue="salutationId"/>
			</form:select>
			<div class="error_message">	<form:errors path="leadCustomerDetails.salutation.salutationId"/></div>
		</div>
	</div>
	
	<div style="margin-top: 15px;">
		<div class="td1"><label style="float : left;">First Name</label> <div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.firstName"/>
			<div class="error_message">	<form:errors path="leadCustomerDetails.firstName"/></div>
		</div>
	</div> 
	 
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.middleName" style="float: left;">Middle Name</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.middleName" />
			<div class="error_message">	<form:errors path="leadCustomerDetails.middleName"/></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.lastName" style="float: left;">Last Name</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.lastName" />
			<div class="error_message">	<form:errors path="leadCustomerDetails.lastName" /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.gender" style="float: left;">Gender</label><div class="star">*</div></div>
		<div style="margin-left: 460px;">
			<form:radiobutton path="leadCustomerDetails.gender"
							value="<%=MBCPConstants.MALE%>" label="Male" /> 
			<form:radiobutton path="leadCustomerDetails.gender"
							value="<%=MBCPConstants.FEMALE%>" label="Female" />
			<div class="error_message">	<form:errors path="leadCustomerDetails.gender"  /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.mobileNumber" style="float: left;">Mobile Number</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.mobileNumber" />
			<div class="error_message">	<form:errors path="leadCustomerDetails.mobileNumber"  /></div>
		</div>
	</div>	
	
	<%
	LeadVO leadModelBean = (LeadVO)request.getAttribute("leadModelBean");
	leadModelBean.getLeadCustomerDetails().getCustomerAddress();
	System.out.println("Address size is "+leadModelBean.getLeadCustomerDetails().getCustomerAddress().size());
	%>
	
	 <%-- <c:forEach items="${leadModelBean.leadCustomerDetails.customerAddress}" var="address"> --%>
	 <div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Address</label><div class="star">*</div></div>
	 	<div style="margin-left: 460px;">
	 		<form:input path="leadCustomerDetails.customerAddress[0].addressLine1" />
			<div class="error_message">	<form:errors path="leadCustomerDetails.customerAddress[0].addressLine1"/></div>
	 	</div>
	 </div>
	 <div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Address1</label></div>
	 	<div style="margin-left: 460px;">
			<form:input path="leadCustomerDetails.customerAddress[0].addressLine2" />
		</div>
	</div>
	 
	 <div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Address2</label></div>
	 	<div style="margin-left: 460px;">
			<form:input path="leadCustomerDetails.customerAddress[0].addressLine3" />
		</div>
	 </div>
	 
	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">City</label></div>
	 	<div style="margin-left: 460px;">
	 		<form:select path="leadCustomerDetails.customerAddress[0].city.cityId">
				<form:options items="${cityList}" itemLabel="cityName" itemValue="cityId"/>
			</form:select>
			<div class="error_message">	<form:errors path="leadCustomerDetails.customerAddress[0].city.cityId"/></div>
	 	<%-- 
	 		<select name="city">
	 			<c:forEach items="${cityList}" var="city">
	 				<option value="${city.cityId}">${city.cityName}</option>
	 			</c:forEach>
	 		</select> --%>
		</div>
	 </div>
	 
	 	 <div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">State</label></div>
	 	<div style="margin-left: 460px;">
	 		<form:select path="leadCustomerDetails.customerAddress[0].state.stateId">
				<form:options items="${stateList}" itemLabel="stateName" itemValue="stateId"/>
			</form:select>
			<div class="error_message">	<form:errors path="leadCustomerDetails.customerAddress[0].state.stateId"/></div>
	 		
	 		<%-- <select name="state">
	 			<c:forEach items="${stateList}" var="state">
	 				<option value="${state.stateId}">${state.stateName}</option>
	 			</c:forEach>
	 		</select> --%>
		</div>
	 </div>
	 
	 <div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Pin Code</label></div>
	 	<div style="margin-left: 460px;">
	 		<form:input path="leadCustomerDetails.customerAddress[0].pinCode" />
			<%-- <input type="text" name="pinCode" value="${address.pinCode}"/> --%>
		</div>
	 </div>
	<input type="hidden"	id="leadCustomerDetails.customerAddress[0].addressType.id" name="leadCustomerDetails.customerAddress[0].addressType.id" value="1" />	

	<%-- <div style="margin-top: 15px;">
		<div class="td1"><label for="owningLead.leadCustomerDetails.customerAddress.pinCode" style="float: left;">Pin code</label></div>
		<div style="margin-left: 460px;"><form:input path="owningLead.leadCustomerDetails.customerAddress.pinCode"/>
			<div class="error_message">	<form:errors path="owningLead.leadCustomerDetails.customerAddress.pinCode" /></div>
		</div>
	</div>  --%>
		
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.dateOfBirth" style="float: left;">Date of Birth</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.dateOfBirth" class="date-picker"/>
			<div class="error_message">	<form:errors path="leadCustomerDetails.dateOfBirth"  /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.annualIncome" style="float: left;">Annual Income</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.annualIncome"/>
			<div class="error_message">	<form:errors path="leadCustomerDetails.annualIncome" /></div>
		</div>
	</div>	 
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.maritalStatus.id" style="float: left;">Marital Status</label><div class="star">*</div></div>
		<div style="margin-left: 460px;">
			<form:select path="leadCustomerDetails.maritalStatus.id">
				<form:options items="${maritalStatusList}" itemLabel="name" itemValue="id"/>
			</form:select>
			<div class="error_message">	<form:errors path="leadCustomerDetails.maritalStatus.id"  /></div>
		</div>
	</div>	
	
	 <%-- <div style="margin-top: 15px;">
		<div class="td1"><label for="leadCustomerDetails.numberOfChildren" style="float: left;">Number Of Children</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="leadCustomerDetails.numberOfChildren"  />
			<div class="error_message">	<form:errors path="leadCustomerDetails.numberOfChildren"  /></div>
		</div> 
	</div> --%>
	
	<!-- <div style="margin-top: 15px; float: left;">
		<input type="submit">	
		</div> -->
	<Div style="margin-top: 15px;">
		<input type="submit" value="Next">
	</Div>
</form:form>
</div>