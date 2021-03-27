<%@page import="java.net.http.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

	<head>
	<!-- Required meta tags -->
		<meta charset="ISO-8859-1">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<link rel="stylesheet" href="/style/table.css">
		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
			integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
			crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
			integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
			crossorigin="anonymous"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
			integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
			crossorigin="anonymous"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
			integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
			crossorigin="anonymous"></script>
		<link rel="stylesheet" href="style.css">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script
			src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
		<style>
			html {
				height: 100%;
			}

			input::-webkit-outer-spin-button,
			input::-webkit-inner-spin-button {
			-webkit-appearance: none;
			margin: 0;
			}

			/* Firefox */
			input[type=number] {
			-moz-appearance: textfield;
			}

			body {
			margin: 0;
			padding: 0;
			font-family: sans-serif;
			color:white;
			background: linear-gradient(to right, #610354, #053070);
			
			}
			ul {
			list-style-type: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
			background-color: #333;
			}

			li {
			float: left;
			}

			li a {
			display: block;
			color: white;
			text-align: center;
			padding: 14px 16px;
			text-decoration: none;
			}

			li a:hover:not(.active) {
			background-color: #111;
			}
			.center {
 				 margin-left: auto;
 				 margin-right: auto;
				}

			.active {
			background-color: #3c1c92;
			}
		</style>
		</head>



</head>




<body class="doodle">


	<%
		response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("Expires", 0);

	if (session== null) {
	%>
	<c:redirect url="/403" />
	<%
		}
	%>
	<!--------------------- Navigation------------------>


		<ul>
		
		<li><div class="navbar-brand">&nbsp;&nbsp;ADFC Bank</div></li>
		<li style="float:right"><a class="active"  href="/logout">Logout</a></li>
		</ul>

			<!--------------------- Details------------------>
		<center>
			<br><h1 style="font-weight: 400;">Welcome to ADFC Bank</h1>
		</center>
		
				
			<div style="margin: 9em 120em 14em 14em;">
				<div class="card   " style="width: 950px; background: rgb(0, 0, 0); /* Fallback color */
  					background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
  					color: #f1f1f1;">
					<div class="card-body">
						<div align="center">
				<caption style="font-family: Bradley Hand ITC;">
					<h3>Customer Details</h3>
				</caption>
			</div>
					<br><br>
					<div align="center">
						<caption>
							<h5>Personal Details</h5>
							<br>
						</caption>
					</div>
					<table border="2" cellpadding="5" class="center" style="width: 900;">
						<tr >
							<th>CUSTOMER ID</th>
							<th>CUSTOMER NAME</th>
							<th>DOB</th>
							<th>PAN</th>
							<th>ADDRESS</th>
						</tr>
						<tr>
							<td><c:out value="${customer.userid}" /></td>
							<td><c:out value="${customer.username}" /></td>
							<td><c:out value="${customer.dateOfBirth}" /></td>
							<td><c:out value="${customer.pan}" /></td>
							<td><c:out value="${customer.address}" /></td>
						</tr>
					</table>
					<br>
				
					<caption>
						<div align="center">
						<br>
						<h5 style="color: white;">Account Details</h5></div><br>
					</caption>
					<table border="2" cellpadding="5" class="center" style="width: 900;">
						<tr>
							<th>ACCOUNT ID</th>
							<th>CURRENT BALANCE</th>
							<th>ACCOUNT TYPE</th>
							<th>OWNER NAME</th>
						</tr>
						<c:forEach var="acc" items="${customer.accounts}">
						<tr>
								
									<td><c:out value="${acc.accountId}" /></td>
									<td><c:out value="${acc.currentBalance}" /></td>
									<td><c:out value="${acc.accountType}" /></td>
									<td><c:out value="${acc.ownerName}" /></td>
						</tr>
						</c:forEach>
						
					</table>
				<br>
		
			</div>
	</div>
	
	<br>
	<br>
	<br>
	<br>
	
	

	<!--------------------- History------------------>

			<div class="card   " style="width: 950px;  background: rgb(0, 0, 0); /* Fallback color */
				background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
				color: #f1f1f1;">
				<div class="card-body">
					<div align="center">
					<caption>
						<h2>Transaction Details</h2>
					</caption>
					<br><br>
					<form action="/customerdashboard/getTransactionsInCustomerdashboard" method="post">
						<select  style="font-family: serif; font-size: 25;font-weight:bold;" path="accountId" name="accountId">
							<c:forEach var="acc" items="${customer.accounts}">
							<option value="${acc.accountId }">Account No: ${acc.accountId }</option>
							</c:forEach>
						</select>
						<br><br>
						<input  class="btn btn-primary" type="submit" value="Submit"/>
				
					</form>
				<br>
				<c:if test="${!empty transactions}">
					<table border="1" cellpadding="5">

						<tr>
							<th>sourceAccountId</th>
							<th>sourceOwnerName</th>
							<th>targetAccountId</th>
							<th>targetOwnerName</th>
							<th>amount</th>
							<th>initiationDate</th>
							<th>reference</th>
						</tr>
						<c:forEach var="trans" items="${transactions}">
						<tr>
								
									<td><c:out value="${trans.sourceAccountId}" /></td>
									<td><c:out value="${trans.sourceOwnerName}" /></td>
									<td><c:out value="${trans.targetAccountId}" /></td>
									<td><c:out value="${trans.targetOwnerName}" /></td>
									<td><c:out value="${trans.amount}" /></td>
									<td><c:out value="${trans.initiationDate}" /></td>
									<td><c:out value="${trans.reference}" /></td>
						</tr>
						</c:forEach>
					</table> 
		
		
				</c:if>
			</div>
		</div> 
	</div>
<br>
<br>
<br>
<br>		

<!--------------------- WITHDRAW------------------>
				<div class="card   " style="width: 400px; background: rgb(0, 0, 0); /* Fallback color */
  					background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
  					color: #f1f1f1;">
					<div class="card-body">
						<h4 class="card-title">Withdraw Amount</h4>
						<form:form action="/withdraw" method="post" modelAttribute="accountinput">
							<form:select path="accountId" name="accountId">
								<c:forEach var="acc" items="${customer.accounts}">
								<form:option value="${acc.accountId }"></form:option>
								</c:forEach>
							</form:select>
							<br><br>
							<label for="amount">Enter Amount:</label><span class="required" style="color: red;"> *</span><br>
							<input type="number" path="amount" name="amount" placeholder="Enter the amount" required="required"/>
							<input type="hidden" name="reference" value="withdraw" />
							<br><br><h6>Minimum balance of 1000 Rs. should be maintained</h6>
							<br><br> <input type="submit" name="View" value="Withdraw Amount" class="btn btn-success" /><br>
						</form:form>
							<br>
						<p style="font-family: Bradley Hand ITC; color: cornflowerblue;" id="message">${msg}</p>
					</div>
				</div>
		
</div>
<br><br><br>
<!--------------------- TRANSFER------------------>
<div class="row">	

<div class="col-xs-6 col-sm-3 col-md-3">
	<div style="margin: -42.8em 12em 5em 48em;">
					<div class="card   " style=" padding-left: 20;position: relative; width: 400px;height:400px; background: rgb(0, 0, 0); /* Fallback color */
  					background: rgba(0, 0, 0, 0.5); /* Black background with 0.5 opacity */
  					color: #f1f1f1;">
					<div class="card-body">
						<h4 class="card-title">Transfer Amount</h4>
						<form:form action="/transfer" method="post" modelAttribute="accountinput">
						<form:select path="accountId" name="accountId">
								<c:forEach var="acc" items="${customer.accounts}">
								<form:option value="${acc.accountId }"></form:option>
								</c:forEach>
							</form:select>
							<br><br><label for="targetAccount">Enter Account No:</label><span class="required" style="color: red;"> *</span><br>
							<input type="number" name="targetAccount" placeholder="Enter the Target Account ID" required="required"/>
							<br> <br>
							<label for="amount">Enter Amount:</label><span class="required" style="color: red;"> *</span><br>
							<input type="number"  name="amount" placeholder="Enter the amount" /required="required">
							<input type="hidden" name="reference" value="transfer" />
							
							<br><br><h6>Minimum balance of 1000 Rs. should be maintained</h6>
							 <br> <input type="submit" name="View" value="Transfer Amount" class="btn btn-success" /><br>
						</form:form>
						<br>
						<p style="color: cornflowerblue;" id="message">${transfermsg}</p>
					</div>
				</div>
			</div>
		</div>
</div>

</body>
</html>