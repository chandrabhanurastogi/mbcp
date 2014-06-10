<%@ include file="init.jsp" %>


<portlet:renderURL var="addNeedsURL">
	<portlet:param name="action" value="renderTabs"/> 
</portlet:renderURL>

<input type="button" name="addNeedBtn" value="Add Needs" onclick="window.location.href='${addNeedsURL}'">
