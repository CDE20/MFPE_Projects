<%@ include file="common/header.jspf"%>


<article>
	<div class="container">
		<h1 class="article-heading text-center m-4">Schedule</h1>
		<table class="table table-striped table-bordered bg-light rounded">
			<tr class="text-center bg-secondary text-white"
				style="font-size: 1.3em;">
				<th>Id</th>
				<th>Representative Name</th>
				<th>Doctor name</th>
				<th>Treating Ailment</th>
				<th>Medicine</th>
				<th>Meeting Slot</th>
				<th>Date Of Meeting</th>
				<th>Doctor Contact No</th>
			</tr>
			<c:forEach items="${repScheduleList}" var="repSchedule">
				<tr>
					<td>${repSchedule.id}</td>
					<td>${repSchedule.repName}</td>
					<td>${repSchedule.doctorName}</td>
					<td>${repSchedule.treatingAilment}</td>
					<td>${repSchedule.medicines}</td>
					<td>${repSchedule.meetingSlot}</td>
					<td>${repSchedule.meetingDate}</td>
					<td>${repSchedule.doctorContactNumber}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</article>


<%@ include file="common/footer.jspf"%>