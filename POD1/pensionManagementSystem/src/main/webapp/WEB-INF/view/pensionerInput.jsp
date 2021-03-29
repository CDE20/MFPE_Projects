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
	style="background-image: url(https://thumbs.dreamstime.com/b/retirement-concept-survivor-s-pension-wife-concept-retirement-concept-survivor-s-pension-wife-190136843.jpg); background-size:100%;background-repeat: no-repeat; background-position: inherit;">
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
			<p class="lead text-center" style="color: RED; font-weight: bold;" id="errorMessage">${status}</p>

			<div class="row">
				<div class="col float-left box-design" style="margin-right: 80px; background-color: rgba(255, 255, 255, 0.5);">
					<form:form name="form" action="getPensionerDetail" method="post"
						modelAttribute="pensionerInput">
						<div class="form-group">
							<input id="name" name="name" path="name" type="text"
								class="form-control" placeholder="Name" required="required" />
						</div>
						<div class="form-group">
							<input name="dateOfBirth" path="dateOfBirth" type="date"
								class="form-control" placeholder="Date of Birth"
								required="required" />
						</div>
						<div class="form-group">
							<input name="pan" path="pan" type="text" class="form-control"
								placeholder="PAN Number" required="required" />
						</div>
						<div class="form-group">
							<input placeholder="Aadhar" name="aadharNumber"
								path="aadharNumber" type="text" class="form-control"
								required="required" /> <small class="form-text text-muted">Your
								Aadhar Number will not ever be shared</small>
						</div>

						<h6 class="test-dark">Pension Type:</h6>
						<div class="form-check form-check-inline">
							<form:label class="form-check-label" path="pensionType"
								for="self">Self
<form:radiobutton path="pensionType" name="type" id="self"
									class="form-check-input" value="self" required="required"/>
							</form:label>
						</div>
						<div class="form-check form-check-inline">
							<form:label class="form-check-label" path="pensionType"
								for="family">Family
<form:radiobutton path="pensionType" name="type" id="family"
									class="form-check-input" value="family" />
							</form:label>
						</div>
						<br>
						<br>
						<div class="form-group float-left">
							<input id="submitBtn" name="submit" class="btn btn-dark"
								style="cursor: pointer;" type="submit" value="Fetch Details"
								formmethod="post" />
						</div>
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
