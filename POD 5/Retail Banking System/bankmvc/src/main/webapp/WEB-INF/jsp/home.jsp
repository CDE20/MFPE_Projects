<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>ADFC Bank</title>
  </head>

<body>
    
    <div class="container">
      
      <div class="row">
       
          <div class="col-md-6">
              <div class="card">
               
                  <div class="box">
                    
                      <h2 style="color: aliceblue;">Welcome to ADFC Bank</h2>
                      <p class="text-muted"> We believe that creating an inclusive and supportive culture is not only right thing to do,
                        but also what is best for our business.
                        it makes us better at understanding the needs of our customers and clients, and it creates a sense of belonging 
                        and values that enable our colleagues to perform at their best.
                      </p> 
                       <!-- Button trigger modal -->
                       <form  action="/customerlogin" method="get">
                    <input type="submit"  value="Customer Login" >
                    </form>
                    <form action="/employeelogin" method="get">
                    <input type="submit"  value="Employee Login" >
                    
                   
                  </form>
              </div>
          </div>
      </div>
  </div>
  

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

  </body>
</html>