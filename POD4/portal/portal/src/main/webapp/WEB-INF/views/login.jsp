<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>


<link rel="stylesheet" type="text/css" href="login.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #989898;
}

.flip-card {
	background-color: transparent;
	width: 300px;
	height: 300px;
	perspective: 1000px;
	padding: 5px;
}

.flip-card-inner {
	position: relative;
	width: 100%;
	height: 100%;
	text-align: center;
	transition: transform 0.6s;
	transform-style: preserve-3d;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
}

.flip-card:hover .flip-card-inner {
	transform: rotateY(180deg);
}

.flip-card-front, .flip-card-back {
	position: absolute;
	width: 100%;
	height: 100%;
	-webkit-backface-visibility: hidden;
	backface-visibility: hidden;
}

.flip-card-front {
	background-color: #bbb;
	color: black;
}

.flip-card-back {
	background-color: #2980b9;
	color: white;
	transform: rotateY(180deg);
	padding: 5px;
}
</style>

</head>

<!-- <body style="background-image: url('https://morphinewithdrawals.org/wp-content/uploads/2017/05/morphine-withdrawals.jpg');">
 -->
<body style="background-color: #989898;">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark"> <!-- Brand/logo -->
	<!-- Links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="navbar-brand" href="#"> <img
				src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500"
				width="30" height="30" class="d-inline-block align-top" alt="">
				Cognizant Pharmacy
		</a></li>

	</ul>
	</nav>


	<!--                   -->




	<div class="container-fluid">

		<!-- Demo content-->
		<div class="container">
			<div class="row">

				<div class="col-lg-10 col-xl-7 mx-auto">
					<h3 align="center" class="display-4">${loginMessage}</h3>
					<p align="center" class="text-muted mb-4"></p>

					<form:errors path="usercredentials.*" />

					<form:form action="/user/homepage" modelAttribute="usercredentials"
						method="post">
						<div class="form-group mb-3">
							<input id="userid" type="text" name="userid"
								placeholder="Username" required="" autofocus=""
								class="form-control rounded-pill border-0 shadow-sm px-4">
						</div>
						<div class="form-group mb-3">
							<input id="password" type="password" name="password"
								placeholder="Password" required=""
								class="form-control rounded-pill border-0 shadow-sm px-4 text-primary">
						</div>

						<button type="submit" name="submit"
							class="btn btn-warning btn-block text-uppercase mb-2 rounded-pill shadow-sm">Login</button>
						<div class="text-center d-flex justify-content-between mt-4">
							<p>${errormsg}</u>
							</p>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<!-- End -->


	</div>
	<!-- End -->







	<div class="container">
		<div class="row">

			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://epsilon.aeon.co/images/afef287f-dd6f-4a6a-b8a6-4f0a09330657/idea_sized-kendal-l4ikccachoc-unsplash.jpg"
							alt="Avatar" style="width: 400px; height: 400px;">
					</div>
					<div class="flip-card-back">
						<h1>mecidine</h1>


					</div>
				</div>
			</div>


			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://pharmaceutical-journal.com/wp-content/uploads/2021/01/asian-pharmacist-ss-19-1456x967.jpg"
							alt="Avatar" style="width: 400px; height: 400px;">
					</div>
					<div class="flip-card-back">
						<h1>mecidine</h1>

					</div>
				</div>
			</div>


			<div class="flip-card">
				<div class="flip-card-inner">
					<div class="flip-card-front">
						<img
							src="https://images.unsplash.com/photo-1563213126-a4273aed2016?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1350&q=80"
							alt="Avatar" style="width: 400px; height: 400px;">
					</div>
					<div class="flip-card-back">
						<h1>mecidine</h1>
					</div>
				</div>
			</div>


		</div>
	</div>


</body>
</html>