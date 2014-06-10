<%@page import="com.ifli.mbcp.domain.KindOfLead"%>
<%@page import="com.ifli.mbcp.util.MBCPConstants.PageType"%>
<script>
$(document).ready(function(){
	
	var pageType = $('#leadSearchBean input[name="pageType"]');
	console.log("got page type")
	if(pageType){
		console.log("Setting  page type")
		$(pageType).val("<%=PageType.LEAD%>");
	}
	
	var leadType = $('#leadSearchBean input[name="leadType"]');
	console.log("got leadType")
	if(leadType){
		console.log("Setting  leadType ")
		$(leadType).val("<%=KindOfLead.GROUP%>");
	}
});
</script>