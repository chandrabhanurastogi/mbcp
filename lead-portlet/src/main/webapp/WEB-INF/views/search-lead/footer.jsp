
		<script>
		$("#leadSearchResultsTable").tablesorter({
			debug : true
		});
		$("#leadSearchResultsTable").trigger("update");
		</script>
	</div>
</c:if>

<c:if test="${empty searchResultList}">
	<div>${message}</div>
</c:if>