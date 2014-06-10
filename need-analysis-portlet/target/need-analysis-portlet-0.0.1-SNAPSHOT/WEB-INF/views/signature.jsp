<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="init.jsp"%>


<%
	long leadId = ParamUtil.getLong(request, "leadId");
%>

<portlet:resourceURL var="PDFActionURL">
	<portlet:param name="leadId" value="pdf" />
	<%-- <portlet:param name="pdfNumber" value="${pdfNumber}" /> --%> --%>
</portlet:resourceURL>

<portlet:actionURL var="submitAndRenderTabURL">
	<portlet:param name="action" value="submitSignature" />
</portlet:actionURL>



<portlet:renderURL var="historyURL"   windowState="<%= LiferayWindowState.POP_UP.toString() %>">
			<portlet:param name="action" value="history"/> 
</portlet:renderURL>
<style>
.error_message {
	color: red;
}
.star {
color: red;
}
</style>

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>


<script>
function showTagDialogBox() {
     $('#tagDialogBox').dialog({
        autoOpen: true,
        title: "History",
        modal: true,
        height: 250,
        width: 400,
        buttons: {
            "Ok": function () {
                $(this).dialog("close");
            }
        }
    }); 
     $('#tagDialogBox').load('${historyURL}');
    return false;
}

function clear_form_elements(ele) {

    $(ele).find(':input').each(function() {
        switch(this.type) {
            case 'text':
            case 'textarea':
                $(this).val('');
                break;
        }
    });
}

</script>

<div style="display: none">
	<div id="tagDialogBox" title="History">
		
	</div>
</div>

<div class="formOuter">
	<form:form class="form-register" method="post" commandName="leadModelBean" action="${submitAndRenderTabURL}" modelAttribute="leadModelBean">
		<%-- <c:forEach items="${leadModelBean.needsAnalysis}" var="nAnalysis" varStatus="loop"> --%>
			<div style="margin-top: 15px;">
				<div class="td1"><label style="float: left;">Customer</label><div class="star">*</div></div>
				<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].linkToCustomerSignature" />
					<div class="error_message">	<form:errors path="needsAnalysis[0].linkToCustomerSignature" /></div>
				</div>
			</div>
			
				<div style="margin-top: 15px;">
			<div class="td1"><label style="float: left;">BDM</label><div class="star">*</div></div>
				<div style="margin-left: 460px;"><form:input path="needsAnalysis[0].linkToBDMSignature" />
					<div class="error_message">	<form:errors path="needsAnalysis[0].linkToBDMSignature" /></div>
				</div>
			</div>
		
		
		<%-- </c:forEach> --%>
<%-- 		
		
		
		
		<div style="margin-top: 15px;">
			<div class="td1">
				<label for="linkToCustomerSignature" style="float: left;">Customer</label>
			</div>
			<div style="margin-left: 460px;">
				<form:input path="linkToCustomerSignature" />
				<div class="error_message">
					<form:errors path="linkToCustomerSignature" />
				</div>
			</div>
		</div>
 --%>

		<Div style="margin-top: 15px; float: left;">
			<input type="submit" value="Save">
		</Div>

		<div class="historyBtn"
			style="margin-top: 15px; float: left; margin-left: 25px;">
			<input type="button" name="historyBtn" value="History"
				onclick="showTagDialogBox();">
		</div>
		<div style="margin-top: 15px; float: left; margin-left: 25px;">
			<input type="button" name="cancelBtn" value="Cancel"
				class="cancelBtn" onclick="clear_form_elements(this.form)">
		</div>
		<div style="margin-top: 15px; margin-left: 25px; float: left;">
			<input type="button" name="generateNeedAnalysisBtn"
				value="Generate Need Analysis"
				onClick="self.location = '${PDFActionURL}';" ">
		</div>
	</form:form>

</div>
