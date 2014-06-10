<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.ifli.mbcp.util.MBCPConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>


<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
<script type="text/javascript"	src="http://keith-wood.name/js/jquery.datepick.js"></script>
<link href="http://keith-wood.name/css/jquery.datepick.css"	type="text/css" rel="stylesheet" />
<link rel="stylesheet"	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script type="text/javascript"
	src="http://tablesorter.com/__jquery.tablesorter.min.js"></script>
<link href="http://tablesorter.com/themes/blue/style.css"
	type="text/css" rel="stylesheet" />
<portlet:defineObjects />
<liferay-theme:defineObjects />


<style>
.form-register td {
	padding: 2px;
}

.error_message {
	color: red;
}

#leadSearchResultsTable td {
	border: 1px gray solid;
}

#leadSearchResultsTable th {
	border: 1px gray solid;
}
</style>

<script>

function setGetParameter(url, params)
{
	$.each(params, function(paramName, paramValue) {
	    //display the key and value pair
	    alert(paramName + ' is ' + paramValue);
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
	});
  
    window.location.href = url;
}
</script>