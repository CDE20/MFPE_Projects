<!DOCTYPE html> 
<html lang="en"> 
  
<head> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <link rel="stylesheet" href="style/home-style.css">
    <title>Home</title>
</head>
<body>
    <nav class="navbar navbar-dark bg-dark" style="margin-left: 20px;">
        <a class="navbar-brand" href="#">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTjxGDl9hG7JE2Z4YhCgE3D2P4rjn0f0jRiXA&usqp=CAU" width="30" height="30" class="d-inline-block align-top" alt="">
          Portfolio Manager</a>
        <form action="/logout" method="GET"><button type="button float-right" class="btn btn-outline-light">Logout</button></form>
      </nav>
    <br>
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://www.thestreet.com/.image/t_share/MTY5NDYzMzA2MzI1NTk5NzA3/stock-vs-shares.png" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Calculate Portfolio</h4>
                        <p class="card-text">Click to view my portfolio</p>
                        <form action="/viewNetworth" method="GET"><button type="submit" value="submit" class="btn btn-outline-primary">Calculate Portfolio</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="card text-center">
                    <img class="card-img-top img-fluid" src="https://g.foolcdn.com/image/?url=https%3A%2F%2Fg.foolcdn.com%2Feditorial%2Fimages%2F606349%2Finvestor-pressing-sell-button-getty.jpg&w=700&op=resize" style="width:600x;height:300px;" alt="Card image cap">
                    <div class="card-block">
                        <h4 class="card-title">Sell </h4>
                        <p class="card-text">Click to sell a stock</p>
                        <form action="/sellAssets" method="GET"><button type="submit" name="submit" class="btn btn-outline-success">Sell Stock</button></form>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body> 
</html> 

