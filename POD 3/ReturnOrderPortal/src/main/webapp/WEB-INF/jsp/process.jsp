<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<style>

body, table, td, a {
	-webkit-text-size-adjust: 100%;
	-ms-text-size-adjust: 100%;
}

table, td {
	mso-table-lspace: 0pt;
	mso-table-rspace: 0pt;
}

img {
	-ms-interpolation-mode: bicubic;
}

img {
	border: 0;
	height: auto;
	line-height: 100%;
	outline: none;
	text-decoration: none;
}

table {
	border-collapse: collapse !important;
}

body {
	height: 100% !important;
	margin: 0 !important;
	padding: 0 !important;
	width: 100% !important;
}

a[x-apple-data-detectors] {
	color: inherit !important;
	text-decoration: none !important;
	font-size: inherit !important;
	font-family: inherit !important;
	font-weight: inherit !important;
	line-height: inherit !important;
}

@media screen and (max-width: 480px) {
	.mobile-hide {
		display: none !important;
	}
	.mobile-center {
		text-align: center !important;
	}
}

div[style*="margin: 16px 0;"] {
	margin: 0 !important;
}
.text-secondary{
	text-align: right;
}
span {
	color: red;
	font-size: 20px;
}

.register {
	background: -webkit-linear-gradient(left, #3931af, #00c6ff);
	margin-top: 3%;
	padding: 3%;
}

.register-left {
	text-align: center;
	color: #fff;
	margin-top: 4%;
}

.register-left input {
	border: none;
	border-radius: 1.5rem;
	padding: 2%;
	width: 60%;
	background: #f8f9fa;
	font-weight: bold;
	color: #383d41;
	margin-top: 30%;
	margin-bottom: 3%;
	cursor: pointer;
}

.register-right {
	background: #f8f9fa;
	border-top-left-radius: 10% 50%;
	border-bottom-left-radius: 10% 50%;
}

.register-left img {
	margin-top: 15%;
	margin-bottom: 5%;
	width: 25%;
	-webkit-animation: mover 2s infinite alternate;
	animation: mover 1s infinite alternate;
}

@
-webkit-keyframes mover { 0% {
	transform: translateY(0);
}

100


%
{
transform


:


translateY
(


-20px


)
;


}
}
@
keyframes mover { 0% {
	transform: translateY(0);
}

100


%
{
transform


:


translateY
(


-20px


)
;


}
}
.register-left p {
	font-weight: lighter;
	padding: 12%;
	margin-top: -9%;
}

.register .register-form {
	padding: 10%;
	margin-top: 10%;
}

.btnRegister {
	float: right;
	margin-top: 10%;
	border: none;
	border-radius: 1.5rem;
	padding: 2%;
	background: #0062cc;
	color: #fff;
	font-weight: 600;
	width: 50%;
	cursor: pointer;
}

.register .nav-tabs {
	margin-top: 3%;
	border: none;
	background: #0062cc;
	border-radius: 1.5rem;
	width: 28%;
	float: right;
}

.register .nav-tabs .nav-link {
	padding: 2%;
	height: 34px;
	font-weight: 600;
	color: #fff;
	border-top-right-radius: 1.5rem;
	border-bottom-right-radius: 1.5rem;
}

.register .nav-tabs .nav-link:hover {
	border: none;
}

.register .nav-tabs .nav-link.active {
	width: 100px;
	color: #0062cc;
	border: 2px solid #0062cc;
	border-top-left-radius: 1.5rem;
	border-bottom-left-radius: 1.5rem;
}

.register-heading {
	text-align: center;
	margin-top: 3%;
	margin-bottom: -15%;
	color: #495057;
}

label {
	font-weight: bold;
}
</style>
<body>
	<div class="container register">
		<div class="row">
			<div class="col-md-3 register-left">
				<img src="https://image.flaticon.com/icons/png/512/1440/1440524.png" alt="" width="62.5" height="60"/>
				<h3>Return Order Portal</h3>
				<p>You are few seconds away from returning your product!</p>
				
			</div>
			<div class="col-md-9 register-right">

				<div class="tab-content" id="myTabContent">
							
						
					
							<table align="center" border="0" cellpadding="0" cellspacing="0"
								width="100%" style="max-width: 600px;">
								<tr>
									<td align="center"
										style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;">
										<img
										src="https://img.icons8.com/color/48/000000/grocery-store.png"
										width="62.5" height="60" style="display: block; border: 0px;" /><br>
										<h2
											style="font-size: 30px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;">
											Confirm Your Order Return!</h2>
									</td>
								</tr>
								<tr>
									<td align="left"
										style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;">
										<p
											style="font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;">
											<center>
											The Processing Details of Your Return Order are as follows.</center></p>
									</td>
								</tr>
								<tr>
									<td align="left" style="padding-top: 20px;">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td width="75%" align="left" bgcolor="#eeeeee"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;">
													Order Request ID#</td>
												<td width="25%" align="left" bgcolor="#eeeeee"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px;">
													${requestId}</td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;">User
													ID#</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 15px 10px 5px 10px;">
													${userID}</td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													Packaging and Delivery Charge</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													${packagingAndDeliveryCharge}</td>
											</tr>
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													Processing charge</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding: 5px 10px;">
													${processingCharge}</td>
											</tr>

										</table>
									</td>
								</tr>

								<tr>
									<td align="left" style="padding-top: 20px;">
										<table cellspacing="0" cellpadding="0" border="0" width="100%">
											<tr>
												<td width="75%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													Total charge</td>
												<td width="25%" align="left"
													style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px; padding: 10px; border-top: 3px solid #eeeeee; border-bottom: 3px solid #eeeeee;">
													${processingCharge + packagingAndDeliveryCharge}</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="100%" valign="top" width="100%"
							style="padding: 0 35px 35px 35px; background-color: #ffffff;"
							bgcolor="#ffffff">
							<table border="0" cellpadding="0" cellspacing="0"
								width="100%" style="max-width: 660px;">
								<tr>
									<td align="center" valign="top" style="font-size: 0;">
										<div
											style="display: inline-block; max-width: 50%; min-width: 240px; vertical-align: top; width: 100%;">
											<table align="left" border="0" cellpadding="0"
												cellspacing="0" width="100%" style="max-width: 300px;">
												<tr><p></p></tr>
												<tr>
													<td align="left" valign="top"
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 800; line-height: 24px;">
														Estimated Delivery Date</td>
													<td align="left" valign="top"
														style="font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px;">
														${dateOfDelivery}</td>
												</tr>
											</table>
										</div>
										<div>
											<br>
											<br><br><br>
											
											<a href="/cardDetails" class="btn btn-success" style="margin-top: 50px;">Proceed for
												Payment</a>
											<p></p>
										</div>
										<div
											style="display: inline-block; max-width: 50%; min-width: 240px; vertical-align: top; width: 100%;">

										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>


				
					</div>

				</div>
</body>
</html>