<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Seeker Home</title>
</head>
<body>
	<button type="button" class="btn btn-light" onClick=window.location.href="/JobSeekerApp/ChangePassword.jsp">Change Password</button>
	<%
	final String register = "register";
	final String login = "login";
	final String changepw = "changePw";

	if(session.getAttribute("prevAction").equals("changePw"))
	{
		out.println("Password Successfully Changed");
	}


	%>
</body>
</html>