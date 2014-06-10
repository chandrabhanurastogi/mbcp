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

<%@include file="./searchLead.jsp"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="selectedLead">
	<portlet:param name="action" value="selectedLead" />
</portlet:actionURL>

<script type="text/javascript"
	src="http://tablesorter.com/__jquery.tablesorter.min.js"></script>
<link href="http://tablesorter.com/themes/blue/style.css"
	type="text/css" rel="stylesheet" />

<style>
#leadSearchResultsTable td {
	border: 1px gray solid;
}

#leadSearchResultsTable th {
	border: 1px gray solid;
}
</style>

<script>

function <portlet:namespace/>selectLead(currentCB, leadId) {
	if($(currentCB).is(':checked')){
		<portlet:namespace/>resetCheckBoxes();
		<portlet:namespace/>redirect(leadId);
	}
}
	
function <portlet:namespace/>resetCheckBoxes(){
		$(".leadIdCB").each(function()
		        {
		          $(this).click(function()
		            {
		             $(".leadIdCB").attr('checked',false);
		             $(this).attr('checked',true);
		            });
		  }); 
}

function <portlet:namespace/>redirect(selectedLeadId){
	
		setGetParameter('${selectedLead}', "selectedLeadId", selectedLeadId);
	/*  var request =  $.ajax({
	      type: "POST",
	      url: "${selectedLead}",
	      data: {
		  	  	<portlet:namespace/>selectedLeadId: selectedLeadId
			  	}
	     // dataType : "json"
			});
	 	 request.done(function( mydata ) {
				$('#updateLead').html(mydata);
			});
		request.fail(function(jqXHR, textStatus) {
		  		alert( "Request failed: " + textStatus );
		}); */
}


function setGetParameter(url, paramName, paramValue)
{
    if (url.indexOf(paramName + "=") >= 0)
    {
        var prefix = url.substring(0, url.indexOf(paramName));
        var suffix = url.substring(url.indexOf(paramName)).substring(url.indexOf("=") + 1);
        suffix = (suffix.indexOf("&") >= 0) ? suffix.substring(suffix.indexOf("&")) : "";
        url = prefix + paramName + "=" + paramValue + suffix;
    }
    else
    {
    if (url.indexOf("?") < 0)
        url += "?" + paramName + "=" + paramValue;
    else
        url += "&" + paramName + "=" + paramValue;
    }
    window.location.href = url;
}
/* function <portlet:namespace/>updateLead() {
	$("input").removeAttr("disabled", "disabled");
	
	 var str = $("#leadModelBean").serialize();
	 var request =  $.ajax({
	      type: "POST",
	      url: "${updateLeadURL}",
	      data: str
	     // dataType : "json"
			});
	 	 request.done(function( mydata ) {
				$('#updateLead').html(mydata);
			});
		request.fail(function(jqXHR, textStatus) {
		  		alert( "Request failed: " + textStatus );
		});
}
 */
</script>

<c:if test="${not empty searchResultList}">
	<!--display collection using c:foreach -->

	<div id="searchResults">

		<table id="leadSearchResultsTable" class="tablesorter">
			<thead>
				<tr>
					<th>Lead Id</th>
					<th>Application Number</th>
					<th>First / Last Name</th>
					<th>Product</th>
					<th>Lead status</th>
					<th>Mobile Number</th>
					<!-- <th>Date Lead Created</th> -->
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${searchResultList}" var="lead" varStatus="status">
					<tr>
						<%-- <td align="center">${status.count}</td> --%>
						<td><input class="leadIdCB" type="checkbox"
							id="${lead.leadId}"
							onclick="<portlet:namespace/>selectLead(this, ${lead.leadId})">${lead.leadId}</td>
						<td>${lead.applicationNumber}</td>
						<td>${lead.leadCustomerDetails.customerFirstName}</td>
						<td>${lead.insuranceProduct.name}</td>
						<td>${lead.leadStatus.name}</td>
						<td>${lead.leadCustomerDetails.mobileNumber}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<script>
		$("#leadSearchResultsTable").tablesorter({
			debug : true
		});
		$("#leadSearchResultsTable").trigger("update");
		</script>
	</div>
</c:if>

<c:if test="${empty searchResultList}">
	<div>${message}</div>
</c:if>
<div id="updateLead"></div>