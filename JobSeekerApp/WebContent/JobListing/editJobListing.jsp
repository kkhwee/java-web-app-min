<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.avensys.model.CompanyModel" %>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<link href="/JobSeekerApp/css/modern-business.css" rel="stylesheet">

<link rel="stylesheet" href="/JobSeekerApp/style.css"/>

<meta charset="ISO-8859-1">
<title>Edit Job Listing</title>

<style>
html,body { 
	background-image: url('/JobSeekerApp/assets/sgcity.jpg');
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

table, th, td {
  color:black;
  background-color: ivory;
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


	<div class="d-flex align-items-center justify-content-center" style="height: 100%">
		<div class="innercolumn p-2 bd-highlight col-example">
<div style="overflow: auto; max-height: 500px; background: rgba(204, 204, 204, 0.5);>
		<form action="/JobSeekerApp/UpdateListingServlet">

		<br><br>
		<h2>Update Listing</h2> <br>
			<label>Job ID: </label>
			<input type="text" name="jobID">
			
			<br><br>
			
			<label>Title: </label>
			<input type="text" name="jobtitle">
			
			<br><br>
			
			<label>Description: (Enter at most 200 characters.)</label>
			<br>
			<textarea name="jobdescription" rows="4" cols="50"></textarea>
			
			<br><br>
			
			<label>Address: </label>
			<br>
			<textarea name="jobaddress" rows="3" cols="40"></textarea>
			
			<br><br>
			
			<label for="reportingDateTime">Date and Time: </label>
			<input type="datetime-local" name="jobdatetime">
				
			<br><br>
				
			<label for="pay">Pay (in SGD$): </label>
			<input type="number" name="jobpay">
				
			<br><br>
				
			<button type="submit" name="submitlisting">Update</button>
			<!-- <button type="button" name="deletelisting" onClick=window.location.href="/JobSeekerApp/DeleteListingServlet">Delete</button> -->
			
			<br><br><br>
		</form>



		<form action="/JobSeekerApp/DeleteListingServlet">
		
			<h2>Delete Listing</h2> <br>
			<label>Job ID: </label>
			<input type="text" name="deleteJobID"> <br><br>
			<button type="submit" name="deletelisting">Delete</button>
		
			<br><br><br>
		</form>
	

		<form action="/JobSeekerApp/UpdateListingStatusServlet">
			
			<h2>Change Status</h2> <br>
			<label>Job ID: </label>
			<input type="text" name="statusJobID"> <br><br>
			<button type="submit" name="statuschange">Change Status</button>
			
			<br><br><br>
		</form>

<%
	CompanyModel m = (CompanyModel)session.getAttribute("model");
	m.connect();
	
	ResultSet rs = m.displayUserJobListing();
	
	%>
	
	<div style="overflow: auto; max-height: 500px">
	<table border=1 cellPadding=30>
	
		<tr>
			<th>Job ID</th>
			<th>Title</th>
			<th>Description</th>
			<th>Employer</th>
			<th>Address</th>
			<th>Reporting Date and Time</th>
			<th>Pay</th>
			<th>Status</th>
		</tr>
	<%
	
	while(rs.next())
	{
%>
		<!--  Table content -->
		<tr>
			<td><%out.println(rs.getString("jobID")); %></td>
			<td><%out.println(rs.getString("title")); %></td>
			<td><%out.println(rs.getString("description")); %></td>
			<td><%out.println(rs.getString("Employer")); %></td>
			<td><%out.println(rs.getString("employerAddress")); %></td>
			<td><%out.println(rs.getString("reportingDateTime")); %></td>
			<td>$<%out.println(rs.getString("pay")); %></td>
			<td><%if(Integer.parseInt(rs.getString("status")) == 1) {
					out.println("Available");
					} else
					{out.println("No vacancies");} 
				%></td>
		</tr>
<%
	} // end while loop
%>

	</table>
	</div>
	</div>
	</div>
	</div>
</body>
</html>