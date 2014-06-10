<%@page import="com.ifli.mbcp.domain.KindOfLead"%>
<%@page import="com.ifli.mbcp.util.MBCPConstants.PageType"%>
<%@ include file="../init.jsp" %>

<portlet:actionURL var="searchLeadURL">
	<portlet:param name="action" value="searchLead" />
</portlet:actionURL>

<div>
	<form:form class="form" method="POST"
		commandName="leadSearchBean" action="${searchLeadURL}">

		<table width="100%">
			<tbody>

				<tr>
					<td class="td1"><label for="searchById">Search By</label></td>
					<td><form:select path="searchById">
							<form:options items="${searchByList}" itemLabel="searchByName"
								itemValue="searchById" />
						</form:select>
						</td>
					<td class="td1"><form:input path="searchText" class="searchText"/>
						<div class="error_message">
							<form:errors path="searchText" />
						</div></td>
						<input type="hidden" name="pageType" value="<%= PageType.LEAD%>"/>
						<input type="hidden" name="leadType" value="<%= KindOfLead.INDIVIDUAL%>"/>
					<td class="td1"><input type="submit" value="Search"></td>
				</tr>

			</tbody>
		</table>
	</form:form>
</div>
