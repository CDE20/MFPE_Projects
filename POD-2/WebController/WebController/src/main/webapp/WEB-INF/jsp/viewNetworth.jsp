<%@ page language="java" contentType="text/html;  charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/viewNetworth-style.css">
<title>View Networth</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#" style="margin-left: 20px;"> <img
			src="https://images.vexels.com/media/users/3/136559/isolated/preview/624dd0a951a1e8a118215b1b24a0da59-pharmacy-logo-by-vexels.png"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Portfolio Manager
		</a>
		<form action="/Home">
			<button type="button float-right" style="margin-right: 20px;"
				class="btn btn-outline-light">Home</button>
		</form>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6 ">
				<div class="card text-center shadow-lg">
					<img class="card-img-top img-fluid"
						src="https://cdn.govexec.com/media/img/upload/2020/10/14/shutterstock_1517792294/860x394.jpg"
						style="width: 600x; height: 300px;" alt="Card image cap">
					<div class="card-block">
						<h4 class="card-title">Calculate Networth</h4>
						
						<p class="card-text">Your Networth is : ${networth}</p>
						<br> 
						<c:if test="${assetMap != null}" >
						<br>
						<div class="container">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Asset</th>
										<th>Units Sold</th>
									</tr>
								</thead>
								<tbody>
										<%-- <c:forEach items="${sold}" var="asset">
								</c:forEach>
								<td><c:out value="{}" </td> --%>


										<c:forEach items="${assetMap}" var="temp">
										<tr>
											<td>${temp.key}</td>
											<td>${temp.value}</td>
										</tr>
										</c:forEach>
								</tbody>
							</table>
							
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>