<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="/css/home.css" rel="stylesheet">
<title>Logout Page</title>
</head>
<body>
	<%
		response.setHeader("cache-control", "no-cache , no-store , must-revalidate");
		response.setHeader("pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		if (session == null) {
		%>
		<c:redirect url="/" />
		<%
		}
		%>

     <div id="login-box" align="center"> 
         <h1 >ABC Bank</h1>
           <form action="/logout" method="get">
             <button class="custom-btn btn-2">Logout</a></button>
           </form>
         
    </div>
</body>
</html>