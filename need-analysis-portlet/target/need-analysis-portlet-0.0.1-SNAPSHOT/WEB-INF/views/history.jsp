<%@page import="com.ifli.mbcp.domain.Lead"%>
<%@ include file="init.jsp" %>
<jsp:useBean id="leadModelBean" class="com.ifli.mbcp.vo.LeadVO" scope="request" />
<div id="tagDialogBox" title="History">
	</br>  </br>
</div>

<%out.println("Created date : "+leadModelBean.getCreatedDate()); %>
</br>
</br>
 
<% out.println("Modified date : "+leadModelBean.getModifiedDate());%> 
