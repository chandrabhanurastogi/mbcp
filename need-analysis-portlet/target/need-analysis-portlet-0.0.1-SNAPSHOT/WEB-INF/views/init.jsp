<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>

<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="liferay-theme" uri="http://liferay.com/tld/theme"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="liferay-util" uri="http://liferay.com/tld/util"%>

<%@page import="com.ifli.mbcp.util.MBCPConstants"%>
<%@page import="com.ifli.mbcp.vo.NeedsAnalysisVO"%>
<%@page import="com.ifli.mbcp.domain.NeedsAnalysis"%>
<%@page import="com.ifli.mbcp.domain.Lead"%>
<%@page import="org.springframework.ui.Model"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>


<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.CalendarFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@ page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer"%>
<%@ page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.log.Log" %>
<%@ page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.dao.search.SearchEntry" %>
<%@ page import="com.liferay.portal.kernel.dao.search.ResultRow" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortalPermissionUtil" %>
<%@ page import="com.liferay.portal.service.permission.PortletPermissionUtil" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.model.*" %>


<%@ page import="javax.portlet.PortletURL" %>

<script type='text/javascript' src='http://code.jquery.com/jquery-latest.min.js'></script>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%@page import="com.ifli.mbcp.domain.KindOfLead"%>
<%@page import="com.ifli.mbcp.util.MBCPConstants.PageType"%>
<script>
$(document).ready(function(){
	
	var pageType = $('#leadSearchBean input[name="pageType"]');
	console.log("got page type")
	if(pageType){
		console.log("Setting  page type")
		$(pageType).val("<%=PageType.NA%>");
	}
	
	var leadType = $('#leadSearchBean input[name="leadType"]');
	console.log("got leadType")
	if(leadType){
		console.log("Setting  leadType ")
		$(leadType).val("<%=KindOfLead.INDIVIDUAL%>");
	}
});
</script>