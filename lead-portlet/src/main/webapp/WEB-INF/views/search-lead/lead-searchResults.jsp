<table id="leadSearchResultsTable" class="tablesorter">
	<thead>
		<tr>
			<th>Ref. Id</th>
			<th>First / Last Name</th>
			<th>Lead Status</th>
			<th>Mobile Number</th>
			<th>BDM Code</th>
			<th>BM/RM Code</th>
			<th>Lead Gen. / Advisor Code</th>
			<th>Date Lead Created</th>
			<th>Pending Stage</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchResultList}" var="lead" varStatus="status">
			<tr>
				<%-- <td align="center">${status.count}</td> --%>
				<td><input class="leadIdCB" type="checkbox" id="${lead.leadId}"
					onclick="<portlet:namespace/>selectLead(this, ${lead.leadId}, ${lead.lifecycleState})">${lead.paddedLeadId}</td>
				<td>${lead.leadCustomerDetails.fullName}</td>
				<td>${lead.leadStatus.name}</td>
				<td>${lead.leadCustomerDetails.mobileNumber}</td>
				<td>${lead.bdmCode.name}</td>
				<td>${lead.bmRmCode.name}</td>
				<td>${lead.leadGeneratorCode.name}</td>
				<td>${lead.createdDate}</td>
				<td>${f:getLifecycleDisplayValue(lead.lifecycleState)}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	