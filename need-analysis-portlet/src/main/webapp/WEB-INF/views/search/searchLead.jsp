<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.ifli.mbcp.mbcpbeans.util.MBCPConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="searchLeadURL">
	<portlet:param name="action" value="searchLead" />
</portlet:actionURL>

<style>
.form-register td {
	padding: 2px;
}

.error_message {
	color: red;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>


<div>
	<form:form class="form-register" method="POST"
		commandName="leadSearchBean" action="${searchLeadURL}">

		<table width="100%">
			<tbody>

				<tr>
					<td class="td1"><label for="searchById">Search By</label></td>
					<td><form:select path="searchById">
							<form:options items="${searchByList}" itemLabel="searchByName"
								itemValue="searchById" />
						</form:select>
						<div class="error_message">
							<form:errors path="searchById" />
						</div></td>
					<td class="td1"><form:input path="searchText" /></td>
					<td class="td1"><input type="submit" value="Search"></td>
				</tr>

			</tbody>
		</table>
	</form:form>
</div>