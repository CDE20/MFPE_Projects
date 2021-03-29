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
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<title>Pension Management</title>
<style>
.transparent
{  
     background-color: transparent ;   /*whichever you want*/
    opacity: 0.7;           /*0.5 determines transparency value*/ 
    filter:(opacity=70);       
}
.footer {
   position: fixed;
   left: 0;
   bottom: 0;
   width: 100%;
   color: #4d0000;
   text-align: center;
    display:inline-block;
    font-weight:bold;
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
	style="background-image: url(https://previews.123rf.com/images/belchonock/belchonock1804/belchonock180457480/99357774-composition-with-stationery-on-grey-background-pension-planning.jpg); background-size: cover; background-repeat: no-repeat; background-position: cover;">
	<header>
	<nav class="navbar bg-light transparent">
		<h3 class=" text-center display-5 text-uppercase font-bold"
			style="margin-top: 5px; font-family: sans-serif;color:#4d0000"><i class="fab fa-google-wallet"> </i>&nbsp; Pension
			Management Portal</h3>
			<ul class="navbar-nav ml-auto">
<li class="nav-item text dark font-bold ml-auto"><a href="/logout" style="color:#4d0000;text-decoration: none;" >Logout</a></li>
</ul></nav>
	</header>
	<section>
	<div class="container" style="margin-top: 200px;">

		<h1 class="font-weight-bold" style="color: #336600" id="errorMessage">${msg}</h1>
		<br>
		<h3 class="text-success font-weight-bold" style="color: #145214" id="errorMessage">${info}</h3>
	</div>
	</section>

<div class="navbar bg-light footer transparent ">&copy; Copyright 2021 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<i class="fab fa-facebook"> </i>
<i class="fab fa-twitter"> </i>
<i class="fab fa-google"> </i>
<i class="fab fa-instagram"> </i>
<i class="fab fa-youtube"> </i>


</div>
</body>
</html>
