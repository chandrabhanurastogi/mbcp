<%@ include file="./searchLead.jsp"%>
<%@ taglib prefix="f" uri="http://ifli.com/tld/functions"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:actionURL var="selectedLeadURL">
	<portlet:param name="action" value="selectedLead" />
</portlet:actionURL>
<script>

function <portlet:namespace/>selectLead(currentCB, leadId, lifecycleState) {
	if($(currentCB).is(':checked')){
		<portlet:namespace/>resetCheckBoxes();
		setGetParameter('${selectedLeadURL}', {
			selectedLeadId: leadId,
			lifecycleState:	lifecycleState,
			pageType: ${leadSearchBean.pageType}
		});
	}
}
	
function <portlet:namespace/>resetCheckBoxes(){
		$(".leadIdCB").each(function()
		        {
		          $(this).click(function()
		            {
		             $(".leadIdCB").attr('checked',false);
		             $(this).attr('checked',true);
		            });
		  }); 
}

</script>

<c:if test="${not empty searchResultList}">


	<div id="searchResults">
	<c:if test="${leadSearchBean.pageType == 1}">
	<%@ include file="lead-searchResults.jsp"%>
	</c:if>
	
	<c:if test="${leadSearchBean.pageType == 2}">
	<%@ include file="na-searchResults.jsp"%>
	</c:if>
	
	</div>
		<script>
		$("#leadSearchResultsTable").tablesorter({
			debug : true
		});
		$("#leadSearchResultsTable").trigger("update");
		</script>
</c:if>

<c:if test="${empty searchResultList}">
	<div>${message}</div>
</c:if>