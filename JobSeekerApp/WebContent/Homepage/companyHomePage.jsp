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
<title>Company Portal</title>

<style>
html,body { 
	background-image: url('/JobSeekerApp/assets/sgcity.jpg');
	height: 100%;
}

.innercolumn {
	width: 1500px;
	height:1000px;
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
	<% //scriplet tag
		//out.println(session.getAttribute("email") + " " + 
		//			session.getAttribute("accountType"));
	%>
	
	<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="/JobSeekerApp/Homepage/companyHomePage.jsp">Job Seeker App</a>
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
			
			<ul class="navbar-nav ml-auto">
			
				<li class="nav-item">
					<a class="nav-link" href="/JobSeekerApp/Homepage/changePasswordPage.jsp">Change Password</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="/JobSeekerApp/JobListing/createJobListing.jsp"> Create Job Listing</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="/JobSeekerApp/JobListing/editJobListing.jsp">Edit Listing</a>
				</li>
				
				<li class="nav-item">
					<a class="nav-link" href="/JobSeekerApp/Homepage/companyLogout.jsp">Log Out</a>
				</li>
			</ul>
			</div>
		</div>
	</nav>

	
	</br></br>
	
	<%
		CompanyModel m = (CompanyModel)session.getAttribute("model");//new CompanyModel();
		//m.connect();
		ResultSet rs = m.displayJobListing();
	%>
	

	<div class="d-flex align-items-center justify-content-center" style="height: 100%">
		<div class="innercolumn p-2 bd-highlight col-example">
			<div style="overflow: auto; max-height: 500px; background: ivory">
				<table border=1 cellpadding=30>
				<tr>
					<th>Job ID</th>
					<th>Title</th>
					<th>Description</th>
					<th>Employer</th>
					<th>Address</th>
					<th>Report Date Time</th>
					<th>Pay</th>
					<th>Status</th>
				</tr>
				
				<%
					while(rs.next())
					{
				%>
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
					}
				%>
				</table>
			</div>
		</div>
	</div>

</body>
</html>