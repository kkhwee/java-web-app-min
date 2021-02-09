<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<link href="/JobSeekerApp/css/modern-business.css" rel="stylesheet">

<link rel="stylesheet" href="/JobSeekerApp/style.css"/>

<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
html,body { 
	background-image: url('/JobSeekerApp/assets/spotlight.jpg');
	height: 100%;
}

.innercolumn {
	width: 1500px;
	height:1200px;
	/*background: rgba(204, 204, 204, 0.5);*/
	justify-content: center;
	align-items:center;
	display:flex;
	text-align:center;
	border-radius: 25px;
}

</style>

</head>
<body>

<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/JobSeekerApp/Homepage/companyHomePage.jsp">Job Seeker App</a>
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
			
			<ul class="navbar-nav ml-auto">
			
				<li class="nav-item">
					<a class="navbar-brand" href="/JobSeekerApp/Homepage/companyHomePage.jsp">Home</a>
				</li>
			
				<li class="nav-item">
					<a class="nav-link" href="/JobSeekerApp/Homepage/companyLogout.jsp">Log Out</a>
				</li>
			</ul>
			</div>
		</div>
	</nav>
	
	
	<div class="d-flex align-items-center justify-content-center" style="height: 100%" >
		<div class="innercolumn p-2 bd-highlight col-example">
		

		<form action="/JobSeekerApp/CompanyChangePasswordServlet">
			<label for="oldPasswordLabel">Enter old password: </label>
			<input type="password" name="oldpwd">
			
			</br></br>
			
			<label for="newPasswordLabel">Enter new password: </label>
			<input type="password" name="newpwd">
			
			</br></br>
			
			<label for="confirmPasswordLabel">Confirm new Password: </label>
			<input type="password" name="conpwd">
			
			</br></br>
			
			<input type="submit" name="changepwd"/>
		</form>
	</div>
</div>
	
</body>
</html>