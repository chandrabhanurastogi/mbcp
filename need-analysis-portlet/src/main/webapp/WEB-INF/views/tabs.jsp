<%@page import="com.ifli.mbcp.vo.LeadVO"%>
<%@ include file="init.jsp" %>

<%
	String tabs1 = ParamUtil.getString(request, "tabs1", "Home");

	String tabNames = "Home,Current Annual Contribution,My Needs,Signature";
	
	//LeadVO leadModelBean = (LeadVO)request.getAttribute("leadModelBean");
%>

<portlet:renderURL var="portletURL" windowState="normal">
	<portlet:param name="tabs1" value="${tabs1}"/>
	<portlet:param name="action" value="renderTabs"/>
	<%-- <portlet:param name="leadModelBean" value="${leadModelBean}"></portlet:param> --%>
</portlet:renderURL>

<liferay-ui:tabs names="<%= tabNames %>" url="<%= portletURL.toString() %>" >
</liferay-ui:tabs>

<%-- <form:form id="submitAndRenderTabs"  method="post" commandName="needAnalysisModelBean" action="${submitAndRenderTabURL}"> --%>
	
	<c:if test='<%= tabs1.equals("Home") %>'>
	  	<liferay-util:include servletContext="<%= this.getServletContext() %>" page="/WEB-INF/views/add_EditNeeds.jsp" />
	</c:if>
	
	<c:if test='<%= tabs1.equals("Current Annual Contribution") %>'>
	  	<liferay-util:include servletContext="<%= this.getServletContext() %>" page="/WEB-INF/views/currentAnnualContribution.jsp" />
	</c:if>
	
	<c:if test='<%= tabs1.equals("My Needs") %>'>
	  	<liferay-util:include servletContext="<%= this.getServletContext() %>" page="/WEB-INF/views/myNeeds.jsp" />
	</c:if>
	
	<c:if test='<%= tabs1.equals("Signature") %>'>
		<liferay-util:include servletContext="<%= this.getServletContext() %>" page="/WEB-INF/views/signature.jsp" >
			<liferay-util:param name="leadId" value="[get lead id from lead object]" />
		</liferay-util:include>
	</c:if>
<%-- </form:form> --%>
