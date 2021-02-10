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
<title>Error!</title>

<style>
html,body { 
	background-image: url('/JobSeekerApp/assets/sgriver.jpg');
	height: 100%;
}

h3{
	color: tomato;
	font-family: "Times New Roman", Times, serif;
	font-weight: bold;
}

.innercolumn {
	width: 400px;
	height:250px;
	background: rgba(204, 204, 204, 0.5);
	justify-content: center;
	align-items:center;
	display:flex;
	text-align:center;
	border-radius: 25px;
}

.label {
  color: white;
  padding: 8px;
}

.container {
	height: 50%;
    display: table;
}
.titleclass{
    margin-bottom: 5rem !important;
	text-align:center;
}

</style>

</head>
<body>

<div class="container">
	<div class="d-flex align-items-center justify-content-center" style="height: 100%">
		<div class="innercolumn p-2 bd-highlight col-example">
		
		
			<div class="container">
  				<span class="text" id="myPopup">There is an error creating job listing!</span> <br><br>
  				<button type="button" class="btn btn-dark" onClick=window.location.href="/JobSeekerApp/JobListing/createJobListing.jsp">Back</button>
			</div>
			
			
		</div>
	</div>
</div>

</body>
</html>