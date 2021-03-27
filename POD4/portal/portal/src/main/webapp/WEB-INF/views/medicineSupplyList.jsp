<%@ include file="common/header.jspf"%>


<article>
	<div class="container">
		<h1 class="article-heading text-center m-4">Order Placed</h1>
			<table class="table table-striped table-bordered bg-light rounded">
				<tr class="text-center bg-secondary text-white" style="font-size: 1.3em;">
				
				
					<th>Pharmacy Name</th>
					<th>Medicine Name</th>
					<th>Supply Count</th>
				</tr>
			</thead>
			<c:forEach items="${medicineSupplyList}" var="medicineSupply">
				<tr>
					<td class="col-right">${medicineSupply.pharmacyName}</td>
					<td class="col-right">${medicineSupply.medicineName}</td>
					<td class="col-right">${medicineSupply.supplyCount}</td>
				</tr>

			</c:forEach>

		</table>
	</div>

</article>


<%@ include file="common/footer.jspf"%>