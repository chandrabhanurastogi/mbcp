<%@include file="init.jsp"%>

<portlet:actionURL var="submitAndRenderTabURL">
	<%-- <portlet:param name="tabs1" value="Current Annual Contribution"/> --%>
	<portlet:param name="action" value="setMyNeeds"/>
</portlet:actionURL>

<style>
.error_message {
	color: red;
}
.star {
color: red;
}
</style>

<div>
<form:form class="form-register" method="post" commandName="leadModelBean" action="${submitAndRenderTabURL}" modelAttribute="leadModelBean">
<%--  <c:forEach items="${leadModelBean.needsAnalysis}" var="nAnalysis" varStatus="loop">
 --%> 	<div style="margin-top: 15px;">
		<div class="td1"><label style="float: left;">Annual Affordable Contribution</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].annualAffordableContribution" />
			<div class="error_message">	<form:errors path="needsAnalysis[0].annualAffordableContribution" /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label style="float: left;">Your Desired Years of Contribution</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].yearsOfContribtion" />
			<div class="error_message">	<form:errors path="needsAnalysis[0].yearsOfContribtion" /></div>
		</div>
	</div>
	
	<div style="margin-top: 15px;">
		<div class="td1"><label style="float: left;">Incremental Contribution of Every Year (%)</label><div class="star">*</div></div>
		<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].annualContributionIncrement" />
			<div class="error_message">	<form:errors path="needsAnalysis[0].annualContributionIncrement" /></div>
		</div>
	</div>

 
 <%-- </c:forEach>	 --%>
 
 
	<%-- <div style="margin-top: 15px;">
		<div class="td1"><label for="annualAffordableContribution" style="float: left;">Annual Affordable Contribution</label></div>
		<div style="margin-left: 460px;"><form:input path="annualAffordableContribution" />
			<div class="error_message">	<form:errors path="annualAffordableContribution" /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="yearsOfContribtion" style="float: left;">Your Desired Years of Contribution</label></div>
		<div style="margin-left: 460px;"><form:input path="yearsOfContribtion"/>
			<div class="error_message">	<form:errors path="yearsOfContribtion" /></div>
		</div>
	</div>	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="annualContributionIncrement" style="float: left;">Incremental Contribution of Every Year (%)</label></div>
		<div style="margin-left: 460px;"><form:input path="annualContributionIncrement" />
			<div class="error_message">	<form:errors path="annualContributionIncrement" /></div>
		</div>
	</div>	 --%>
	<Div style="margin-top: 15px;">
		<input type="submit" value="Next">
	</Div>
</form:form>
</div>