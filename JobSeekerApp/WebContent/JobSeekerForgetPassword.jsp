<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<style>
html,body { 
	height: 100%;
	background-image: url('/JobSeekerApp/assets/homebg.jpg');
}

.innercolumn {
	width: 500px;
	height:350px;
	background: lightgrey;
	justify-content: center;
	align-items:center;
	display:flex;
	text-align:center;
}
.container {
	height: 100%;
    display: table;
}
.titleclass{
    margin-bottom: 5rem !important;
	text-align:center;
}
.form-input-container{
	width: 350px;
}
</style>
</head>
<body>

  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Job Seeker Home Page</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/userRegister.html">Register</a>
          </li>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  

	<div class="container">
      <div class="d-flex align-items-center justify-content-center" style="height: 100%">
		  <div class="innercolumn p-2 bd-highlight col-example">
			<form action="/JobSeekerApp/JobSeekerForgetPassword">
			<h3>Reset Password</h3>
			  <div class="mb-3 form-input-container ">
			    <input name="email" type="email" class="form-control" id="username" placeholder="Email Address" aria-describedby="emailHelp">
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		  </div>
      </div>
	</div>
	
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Job Seeker SG 2021</p>
    </div>
    <!-- /.container -->
  </footer>	
</body>
</html>