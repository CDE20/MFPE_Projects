<%@page import="com.pensionManagementSystem.model.PensionDetail"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<title>Pension Management</title>
<style>
.box-design {
	width: 350px;
	background-color: transparent;
	margin: 20px;
	padding: 20px;
	box-shadow: 5px 10px 8px 10px #888888;
	padding: 30px;
	border-radius: 5mm;
}

.transparent {
	background-color: transparent; /*whichever you want*/
	opacity: 0.7; /*0.5 determines transparency value*/
	filter: (opacity=70);
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	color: #4d0000;
	text-align: center;
	display: inline-block;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body    
	style="background-image: url(https://www.incimages.com/uploaded_files/image/1920x1080/getty_505872010_373934.jpg); background-size: auto; background-repeat: no-repeat; background-position: inherit;">
	<header>
		<nav class="navbar bg-light transparent">
			<h3 class=" text-center display-5 text-uppercase font-bold"
				style="margin-top: 5px; font-family: sans-serif; color: #4d0000">
				<i class="fab fa-google-wallet"> </i>&nbsp; Pension Management
				Portal
			</h3>
			<a href="/logout" style="align: right;">Logout</a>
		</nav>
	</header>
	<section>
		<div class="container">
			<p class="lead text-center" style="color: RED" id="errorMessage">${status}</p>

			<%
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				PensionDetail pd = (PensionDetail) request.getAttribute("pensionDetail");	
				String dob = sdf.format(pd.getDateOfBirth().getTime()+(1000*3600*24));	
			%>

			<div class="col float-right box-design" style="margin-left: 80px; background-color: rgba(255, 255, 255, 0.5);">
				<div class="form-group">
					<label>Pensioner Name:</label>
					<p class="form-control is-valid">${pensionDetail.name}</p>
				</div>

				<div class="form-group">
					<label>Pensioner PAN:</label>
					<p class="form-control is-valid">${pensionDetail.pan}</p>
				</div>
				<div class="form-group">
					<label>Pension Type:</label>
					<p class="form-control is-valid">${pensionDetail.pensionType}</p>
				</div>
				<div class="form-group">
					<label>Pensioner DOB:</label>
					<p class="form-control is-valid"><%=dob%></p>
				</div>
				<div class="form-group">
					<label>Pension Amount:</label>
					<p class="form-control">${pensionDetail.pensionAmount}</p>
				</div>
				<div class="form-group float-right">
					<form:form method="GET" action="/disbursement">
						<input id="verifyBtn" name="verify" class="btn btn-dark"
							style="cursor: pointer;" type="submit" value="Disburse Pension" />
					</form:form>
				</div>
			</div>
		</div>
	</section>
	<div class="navbar bg-light footer transparent ">
		&copy; Copyright 2021
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i
			class="fab fa-facebook"> </i> <i class="fab fa-twitter"> </i> <i
			class="fab fa-google"> </i> <i class="fab fa-instagram"> </i> <i
			class="fab fa-youtube"> </i>


	</div>

</body>
</html>
