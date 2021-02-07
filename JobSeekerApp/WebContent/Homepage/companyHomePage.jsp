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
<title>Company Portal</title>
</head>
<body>
	<% //scriplet tag
		out.println(session.getAttribute("email") + " " + 
					session.getAttribute("accountType"));
	%>
	
	</br>
	
	<button type="button" onClick=window.location.href="/JobSeekerApp/Homepage/changePasswordPage.jsp">Change Password</button>
	<button type="button" onClick=window.location.href="/JobSeekerApp/JobListing/createJobListing.jsp">Create Listing</button>
	
	</br></br></br>
	
	<%
		CompanyModel m = new CompanyModel();
		m.connect();
		ResultSet rs = m.displayJobListing();
	%>
	
	<table border=1 cellpadding=50>
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
						{out.println("No vacancies");} %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>