<%@ include file="init.jsp"%>

<portlet:actionURL var="addServiceRequestURL">
	<portlet:param name="action" value="addServiceRequest"/>
</portlet:actionURL>

<liferay-ui:success key="got-parameters" message="Got Paramters" />
<liferay-ui:error key="error-getting-parameters" message="Error Getting Parameters" />


<form:form class="form-register" method="post" action="${addServiceRequestURL}">
	
	Policy Number : <input type="text" name="policyNo" /><br />
	Client Id : <input type="text" name="clientId" /><br />
	Life Assured Name : <input type="text" name="assuredName" /><br />
	Product Name : <input type="text" name="productName" /><br />
	Type of Service : <input type="text" name="typeOfService" /><br />
	Comments : <input type="text" name="comments" /><br />
	<input type="checkbox" name="disclaimer" >Disclaimer<br />
</form:form>