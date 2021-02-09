<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password Page</title>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<style>
html,body { 
	height: 100%;
	background-image: url('/JobSeekerApp/assets/homebg.jpg');
}

.innercolumn {
	width: 700px;
	height:500px;
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
            <a class="nav-link" href="/JobSeekerApp/JobSeekerLogout">Log Out</a>
          </li>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  
	<div class="container">
      <div class="d-flex align-items-center justify-content-center" style="height: 100%">
		  <div class="innercolumn p-2 bd-highlight col-example">
			<form action="/JobSeekerApp/ChangePassword">
			<h3>Registration</h3>
			  <div class="mb-3 form-input-container ">
			    <label for="labelUsername" class="form-label">Old Password</label>
			    <input name="oldpassword" class="form-control" type="password" id="oldpassword" aria-describedby="usernameHelp">
			  </div>
			  <div class="mb-3">
			    <label for="inputPassword" class="form-label">Password</label>
			    <input name="newpassword" type="password" class="form-control" id="inputPassword">
			  </div>
		  	  <div class="mb-3">
			    <label for="confirmPassword1" class="form-label">Confirm Password</label>
			    <input name="confirmpassword" type="password" class="form-control" id="confirmPassword1">
			  </div>
			  <input type="hidden" value="JobSeeker" name="accountType"></input>
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

<script src="/JobSeekerApp/js/jquery.js"></script>
<script src="/JobSeekerApp/js/bootstrap.js"></script>
</body>
</html>