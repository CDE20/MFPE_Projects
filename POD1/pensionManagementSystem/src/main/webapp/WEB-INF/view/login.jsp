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
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<title>Pension Management Login</title>
<style>
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
	style="background-image: url(https://c1.wallpaperflare.com/preview/970/579/821/pension-third-age-enjoy-rest.jpg); background-size: cover; background-repeat: no-repeat; background-position: center;">
	<header>
		<nav class="navbar bg-light transparent">
			<h3 class=" text-center display-5 text-uppercase font-bold"
				style="margin-top: 5px; font-family: sans-serif; color: #4d0000">
				<i class="fab fa-google-wallet"> </i>&nbsp; Pension Management
				Portal
			</h3>


		</nav>
	</header>
	<section>
		<div class="container">

			<div class="float-right"
				style="margin-top: 100px; background-color: rgba(255, 255, 255, 0.5);  width: 400px; box-shadow: 5px 10px 8px 10px #888888; padding: 30px; border-radius: 5mm;">
				<div class="text-center text-dark font-italic"
					style="margin-bottom: 25px;">
					<h2>Login</h2>
				</div>
				<form action="login" method="POST" modelAttribute="user">
					<%
						if(request.getAttribute("status") != null) {
							
							out.print("<h5 style='color:red;'>"+request.getAttribute("status")+"</h5>");
						}
					%>			<div class="form-group">
						<input name="username" type="text" class="form-control"
							placeholder="Username" required="required" autofocus="autofocus">
					</div>
					<div class="form-group">
						<input name="password" type="password" class="form-control"
							placeholder="Password" required="required">
					</div>
					<div class="form-group float-right"
						style="margin-top: 25px; margin-bottom: 100px;">
						<input id="submitBtn" name="submit"
							class="btn btn-success btn-outline-white"
							style="cursor: pointer;" type="submit" value="Login"
							formmethod="post">
					</div>
					<div class="clearfix"></div>
				</form>
				<p style="color: RED" id="errorMessage">${msg}</p>
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
