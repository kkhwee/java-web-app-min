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
<meta charset="ISO-8859-1">
<title>Edit Job Listing</title>
</head>
<body>

<form action="/JobSeekerApp/UpdateListingServlet">

<button type="button" onClick=window.location.href="/JobSeekerApp/Homepage/companyHomePage.jsp">Go Back</button>
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
</body>
</html>