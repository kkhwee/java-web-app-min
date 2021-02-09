<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log Out</title>


<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<link href="/JobSeekerApp/css/modern-business.css" rel="stylesheet">

<link rel="stylesheet" href="/JobSeekerApp/style.css"/>

<style>
html,body { 
	background-image: url('/JobSeekerApp/assets/sgriver.jpg');
	height: 100%;
}

.innercolumn {
	width: 500px;
	height:300px;
	background: rgba(204, 204, 204, 0.5);
	justify-content: center;
	align-items:center;
	display:flex;
	text-align:center;
	border-radius: 25px;
}

table, th, td {
  color:black;
  background-color: ivory;
}
</style>

</head>
<body>

<div class="container">

	<div class="d-flex align-items-center justify-content-center" style="height: 100%">
		<div class="innercolumn p-2 bd-highlight col-example">
			
			<form action="/JobSeekerApp/CompanyLogoutServlet">
				<h3>Are you sure you want to Log out?</h3> <br><br>
				
				<button type="submit" class="btn btn-dark">Yes</button>
				<button type="button" class="btn btn-dark" onClick=window.location.href="/JobSeekerApp/Homepage/companyHomePage.jsp">No</button>
			</form>

		</div>
	</div>
</div>

</body>
</html>