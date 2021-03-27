<%@ include file="common/header.jspf"%>


<article>
	<div class="container">
		<h1 class="article-heading text-center m-4">Medicine Demand</h1>
			<table class="table table-striped table-bordered bg-light rounded">
				<tr class="text-center bg-secondary text-white" style="font-size: 1.3em;">
				
					<th>Medicine</th>
					<th>Demand Count</th>
				</tr>
			</thead>

			<c:forEach items="${medicineDemandList}" var="medicineDemand">
				<tr>
					<td class="col-right">${medicineDemand.medicineName}</td>
					<td class="col-right">${medicineDemand.demandCount}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</article>


<%@ include file="common/footer.jspf"%>