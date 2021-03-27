
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<head>
<title>logout</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/index-
style.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #989898
}

.button {
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}

.button2 {
	background-color: #008CBA;
} /* Blue */
.container {
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>
</head>
<body>

	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="#"> <img
			src="https://www.graphicsprings.com/filestorage/stencils/62eedfb5818a17fdb9581b1b9324a630.png?width=500&height=500"
			width="30" height="30" class="d-inline-block align-top" alt="">
			Cognizant Pharmacy
		</a>
		<form action="/user/login" method="GET">
			<button type="button float-right" class="btn btn-outline-light">sign
				in</button>
		</form>
	</nav>
	<!-- Demo content-->
	<div class="container">


		<div class="col-lg-10 col-xl-7 mx-auto" style="margin-top: 100px;">
			<center>
				<h3 class="display-4">Logged Out</h3>
			</center>
		</div>

	</div>
	<!-- End -->







</body>
</html>


























<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logout</title>
<link rel="icon" type="image/ico" href="./images/truyum-logo-dark.png" />
<link rel="stylesheet" type="text/css" href="/style/style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-image: url('https://images.unsplash.com/photo-1585830812369-b88fce3bee22?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80');">
	<div class="row" style="background-color: #2ce456;">		<div class="col-2-sm">
			<img src="/images/plogo.png" class="header-logo bg-light"
				alt="pharmacy logo" style="width: 9em; height: 6em;"></img>
		</div>
		<div class="col-sm text-center">
			<span style="color: black; font-size: 3em; font-weight: 800;">Pharmacy
				Medicine Supply</span>
		</div>
		<div class="col-2-sm text-right mx-5 mt-4">
			<a href="/user/login" class="btn btn-primary text-right">Login</a>
		</div>
	</div>
	<div class="container text-center m-5">
		<h1 class="text-warning">Logged out successfully!!</h1>
		<h2>
			<a href="login"><u>Sing in again</u></a>
		</h2>
	</div>
	
</body>
</html>
 -->