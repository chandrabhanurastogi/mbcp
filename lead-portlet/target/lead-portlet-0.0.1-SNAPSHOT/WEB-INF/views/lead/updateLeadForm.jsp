<%@ include file="../init.jsp" %>
<%@ include file="empty.jsp" %>
<portlet:actionURL var="updateLeadURL">
	<portlet:param name="action" value="updateLead"></portlet:param>
</portlet:actionURL>

<script>

 function <portlet:namespace/>updateLead() {
		$("#leadModelBean").find("input").removeAttr("disabled", "disabled");
 		$("#leadModelBean").submit();
}

 $(document).ready(function(){
	 
	 $("#appointmentScheduled").datepick();
	 
	 $( "#historyDialog" ).dialog({
		 autoOpen: false,
	        title: "History",
	        modal: true,
	        height: 230,
	        width: 500,
	        buttons: {
	            "Ok": function () {
	                $(this).dialog("close");
	            }
	        },
		/*  show: {
	        effect: "blind",
	        duration: 1000
	      },
	      hide: {
	        effect: "explode",
	        duration: 1000
	      } */
	    });
	 
	 $("#historyButton").click(function(){
		 $( "#historyDialog" ).dialog( "open" );
	 });
	 
	 
 });
</script>
<div>
	<form:form class="form-register" method="post"
		commandName="leadModelBean" action="${updateLeadURL}">
		<c:if test="${leadModelBean.success == true}">

			<div class="success_message">
				<div style="margin: 12px 0 0px 18px;">Lead Updated
					Successfully</div>
			</div>
		</c:if>

		<table width="100%" class="registertable">
			<tbody>

				<tr>
					<td class="td1"><label for="leadId">Ref. Id</label></td>
					<td><form:input path="paddedLeadId" readonly="true" />
						<div class="error_message">
							<form:errors path="paddedLeadId" />
						</div></td>
				</tr>
				<%--Hidden field --%>
				<form:hidden path="leadId" />
				<tr>
					<td class="td1"><label for="leadCustomerDetails.salutation.salutationId">Salutation</label></td>
					<td><form:select path="leadCustomerDetails.salutation.salutationId">
							<form:options items="${leadSalutationList}"
								itemLabel="salutationText" itemValue="salutationId" />
						</form:select>
						<div class="error_message">
							<form:errors path="leadCustomerDetails.salutation.salutationId" />
						</div></td>
				</tr>
				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.firstName">First Name</label></td>
					<td><form:input path="leadCustomerDetails.firstName" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.firstName" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.middleName">Middle Name</label></td>
					<td><form:input path="leadCustomerDetails.middleName" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.middleName" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.lastName">Last Name</label></td>
					<td><form:input path="leadCustomerDetails.lastName" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.lastName" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.gender">Gender</label></td>
					<td><form:radiobutton
							path="leadCustomerDetails.gender"
							value="<%=MBCPConstants.MALE%>" label="Male" /> <form:radiobutton
							path="leadCustomerDetails.gender"
							value="<%=MBCPConstants.FEMALE%>" label="Female" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.gender" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="leadCustomerDetails.mobileNumber">Mobile
							Number</label></td>
					<td><form:input path="leadCustomerDetails.mobileNumber" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.mobileNumber" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].addressLine1">Address</label></td>
					<td><form:input
							path="leadCustomerDetails.customerAddress[0].addressLine1" />
						<div class="error_message">
							<form:errors
								path="leadCustomerDetails.customerAddress[0].addressLine1" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].addressLine2">Address
							1</label></td>
					<td><form:input
							path="leadCustomerDetails.customerAddress[0].addressLine2" />
						<div class="error_message">
							<form:errors
								path="leadCustomerDetails.customerAddress[0].addressLine2" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].addressLine3">Address
							2</label></td>
					<td><form:input
							path="leadCustomerDetails.customerAddress[0].addressLine3" />
						<div class="error_message">
							<form:errors
								path="leadCustomerDetails.customerAddress[0].addressLine3" />
						</div></td>
				</tr>


				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].state.stateId">State
					</label></td>
					<td><form:select
							path="leadCustomerDetails.customerAddress[0].state.stateId">
							<form:options items="${stateList}" itemLabel="stateName"
								itemValue="stateId" />
						</form:select>
						<div class="error_message">
							<form:errors
								path="leadCustomerDetails.customerAddress[0].state.stateId" />
						</div></td>
				</tr>


				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].city.cityId">City
					</label></td>
					<td><form:select
							path="leadCustomerDetails.customerAddress[0].city.cityId">
							<form:options items="${cityList}" itemLabel="cityName"
								itemValue="cityId" />
						</form:select>
						<div class="error_message">
							<form:errors
								path="leadCustomerDetails.customerAddress[0].city.cityId" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label
						for="leadCustomerDetails.customerAddress[0].pinCode">Pin Code</label></td>
					<td><form:input
							path="leadCustomerDetails.customerAddress[0].pinCode" />
						<div class="error_message">
							<form:errors path="leadCustomerDetails.customerAddress[0].pinCode" />
						</div></td>
				</tr>
				<%--Hidden field --%>
				<input type="hidden" id="leadCustomerDetails.customerAddress[0].addressType.id" name="leadCustomerDetails.customerAddress[0].addressType.id" value="1" />
				<form:hidden path="leadCustomerDetails.customerAddress[0].customerAddressId" />
				<form:hidden path="proposalsMade[0].proposalId" />
				<tr>
					<td class="td1"><label for="channelSelection.id">Channel
							Selection</label></td>
					<td><form:select path="channelSelection.id">
							<form:options items="${channelSelectionList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="channelSelection.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="branchCode.id">Branch Code</label></td>
					<td><form:input path="branchCode.id" />
						<div class="error_message">
							<form:errors path="branchCode.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="bmRmCode.id">BM / RM Code</label></td>
					<td><form:input path="bmRmCode.id" />
						<div class="error_message">
							<form:errors path="bmRmCode.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="leadGeneratorCode.id">Lead
							Gene/Advisor Code</label></td>
					<td><form:input path="leadGeneratorCode.id" />
						<div class="error_message">
							<form:errors path="leadGeneratorCode.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="bdmCode.id">BDM Code</label></td>
					<td><form:input path="bdmCode.id" />
						<div class="error_message">
							<form:errors path="bdmCode.id" />
						</div></td>
				</tr>
			<tr>
					<td class="td1"><label for="assignApplicationNumber">Assign
							Application Number</label></td>
					<td><form:checkbox path="assignApplicationNumber" />
						<div class="error_message">
							<form:errors path="assignApplicationNumber" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="proposalsMade[0].paddedProposalId">Application
							Number</label></td>
					<td><form:input path="proposalsMade[0].paddedProposalId" />
						<div class="error_message">
							<form:errors path="proposalsMade[0].paddedProposalId" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="proposalsMade[0].insuranceProduct.id">Product
							Name</label></td>
					<td><form:select path="proposalsMade[0].insuranceProduct.id">
							<form:options items="${insuranceProductList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="proposalsMade[0].insuranceProduct.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="proposalsMade[0].premiumAmount">Premium
							Amount</label></td>
					<td><form:input path="proposalsMade[0].premiumAmount" />
						<div class="error_message">
							<form:errors path="proposalsMade[0].premiumAmount" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="proposalsMade[0].premiumFrequency.id">Premium
							Frequency</label></td>
					<td><form:select path="proposalsMade[0].premiumFrequency.id">
							<form:options items="${premiumFrequencyList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="proposalsMade[0].premiumFrequency.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="appointmentScheduled">Appointment
							Scheduled </label></td>
					<td><form:input path="appointmentScheduled" />
						<div class="error_message">
							<form:errors path="appointmentScheduled" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="leadCategory.id">Lead
							Category </label></td>
					<td><form:select path="leadCategory.id">
							<form:options items="${leadCategoryList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="leadCategory.id" />
						</div></td>
				</tr>
				<tr>
					<td class="td1"><label for="leadType.id">Lead Type</label></td>
					<td><form:select path="leadType.id">
							<form:options items="${leadTypeList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="leadType.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="leadStatus.id">Lead Status</label></td>
					<td><form:select path="leadStatus.id">
							<form:options items="${leadStatusList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="leadStatus.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="taskType.id">Lead Status</label></td>
					<td><form:select path="taskType.id">
							<form:options items="${taskTypeList}" itemLabel="name"
								itemValue="id" />
						</form:select>
						<div class="error_message">
							<form:errors path="taskType.id" />
						</div></td>
				</tr>

				<tr>
					<td class="td1"><label for="comments">Comments </label></td>
					<td><form:textarea path="comments" maxlength="5000"/>
						<div class="error_message">
							<form:errors path="comments" />
						</div></td>
				</tr>
				<tr>
					<td class="td1"></td>
					<td><input type="button" value="Save"
						onclick="<portlet:namespace/>updateLead()" /> <input type="reset"
						value="Cancel"> <input type="button" value="Next"
						<c:if test="${leadModelBean.success == false}">
							 disabled="disabled"	
						</c:if>
						onClick="location.href='${nextPageURL}'" /> <input
						id="historyButton" type="button" value="History" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>

</div>


<div id="historyDialog">

		<table>
			<thead>
				<tr>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Created Date : </td>
					<td>${leadModelBean.createdDate}</td>
				</tr>
				<tr>
					<td>Modified Date : </td>
					<td>${leadModelBean.modifiedDate}</td>
				</tr>
				<tr>
					<td>Comments : </td>
					<td>${leadModelBean.comments}</td>
				</tr>
			</tbody>
		</table>

</div>