<%@include file="init.jsp" %>
<%-- <jsp:useBean id="needAnalysis" class="com.ifli.mbcp.vo.NeedsAnalysisVO"></jsp:useBean> --%>

<div>

<portlet:actionURL var="submitAndRenderTabURL">
	<%-- <portlet:param name="tabs1" value="Current Annual Contribution"/> --%>
	<portlet:param name="action" value="setSignature"/>
</portlet:actionURL>
<style>
.error_message {
	color: red;
}
.star {
color: red;
}
</style>

<form:form class="form-register" method="post" commandName="leadModelBean" action="${submitAndRenderTabURL}" modelAttribute="leadModelBean">
	<%-- <c:forEach items="${leadModelBean.needsAnalysis}" var="nAnalysis" varStatus="loop" > --%>
		<div style="margin-top: 15px;">
			<div class="td1"><label style="float: left;">Desirable Life Cover</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].desirableLifeCover" />
				<div class="error_message">	<form:errors path="needsAnalysis[0].desirableLifeCover" /></div>
			</div>
		</div>
		
		<div style="margin-top: 15px;">
			<div class="td1"><label style="float: left;">Desirable Health Cover</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].desirableHealthCover" />
				<div class="error_message">	<form:errors path="needsAnalysis[0].desirableHealthCover" /></div>
			</div>
		</div>
		
		<div style="margin-top: 15px;">
			<div class="td1"><label style="float: left;">Desirable returns on saving / Investments (%)</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].returnOnInvestments" />
				<div class="error_message">	<form:errors path="needsAnalysis[0].returnOnInvestments" /></div>
			</div>
		</div>
	
		<div style="margin-top: 15px;">
			<div class="td1"><label style="float: left;">Desirable Annual Pension Post Retirement (%)</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].desirableAnnualPension" />
				<div class="error_message">	<form:errors path="needsAnalysis[0].desirableAnnualPension" /></div>
			</div>
		</div>		
		
			
	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Life Stage</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="needsAnalysis[0].lifeStage" readonly="true"/>
				<div class="error_message">	<form:errors path="needsAnalysis[0].lifeStage"/></div>
	 	</div>
	</div>

	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Protection Needs</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="needsAnalysis[0].protectionNeeds" readonly="true"/>
				<div class="error_message">	<form:errors path="needsAnalysis[0].protectionNeeds"/></div>
	 	</div>
	</div>
	
	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Appetite</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="needsAnalysis[0].appetite" readonly="true"/>
				<div class="error_message">	<form:errors path="needsAnalysis[0].appetite"/></div>
	 	</div>
	</div>
	
	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Details of Commitment for Current & Future Years</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="needsAnalysis[0].commitmentDetails" readonly="true"/>
				<div class="error_message">	<form:errors path="needsAnalysis[0].commitmentDetails"/></div>
	 	</div>
	</div>
	
	<div style="margin-top: 15px;">
	 	<div class="td1"><label style="float: left;">Risk Element Explanation</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="needsAnalysis[0].riskElementExplanation" readonly="true"/>
				<div class="error_message">	<form:errors path="needsAnalysis[0].riskElementExplanation"/></div>
	 	</div>
	</div>
	
	<div style="margin-top: 15px;">
			<div class="td1"><label for="recommendedPlans.id" style="float: left;">Recommended Products</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:select path="needsAnalysis[0].recommendedPlans.id">
							<form:options items="${insuranceProductList}" itemLabel="name" itemValue="id" />
						</form:select>
			<div class="error_message">	<form:errors path="needsAnalysis[0].recommendedPlans.id" /></div>
		</div>
	</div> 
	
	
	<%-- </c:forEach>
 --%>	<%--  <c:forEach items="${leadModelBean.leadCustomerDetails.allExistingInsurance}" var="extInsurance" begin="0" end="0"> --%>
		 <div style="margin-top: 15px;">
		 	<div class="td1"><label style="float: left;">Annual Premium</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="leadCustomerDetails.allExistingInsurance[0].annualPremium" />
				<div class="error_message">	<form:errors path="leadCustomerDetails.allExistingInsurance[0].annualPremium"/></div>
	 		</div>
	 	</div>
	 	
	 	<div style="margin-top: 15px;">
		 	<div class="td1"><label style="float: left;">Sum Assured</label><div class="star">*</div></div>
		 	<div style="margin-left: 460px;">
		 		<form:input path="leadCustomerDetails.allExistingInsurance[0].sumAssured" />
				<div class="error_message">	<form:errors path="leadCustomerDetails.allExistingInsurance[0].sumAssured"/></div>
	 		</div>
	 	</div>
	 		
	 	<div style="margin-top: 15px;">
			<div class="td1"><label for="planRecommendation.id" style="float: left;">Plan /Product name</label><div class="star">*</div></div>
			<div style="margin-left: 460px;"><form:select path="leadCustomerDetails.allExistingInsurance[0].insurancePlan.id">
							<form:options items="${insuranceProductList}" itemLabel="name" itemValue="id" />
						</form:select>
			<div class="error_message">	<form:errors path="leadCustomerDetails.allExistingInsurance[0].insurancePlan.id" /></div>
		</div>
	</div> 

	
	
	<%-- </c:forEach> --%>
	
	<Div style="margin-top: 15px;">
		<input type="submit" value="Next">
	</Div>
</form:form>	
	 <!-- System Populate Fields -->
	
	<%--	
	
	<div style="margin-top: 15px;">
		<div class="td1"><label for="planRecommendation.id" style="float: left;">Recommended Products</label></div>
		<div style="margin-left: 460px;"><form:select path="planRecommendation.id">
							<form:options items="${insuranceProductList}" itemLabel="name"
								itemValue="id" />
						</form:select>
			<div class="error_message">	<form:errors path="planRecommendation.id"  /></div>
		</div>
	</div> 

	
	<Div style="margin-top: 15px;">
		<input type="submit" value="Next">
	</Div>
	--%>

	
	 
	

</div>
