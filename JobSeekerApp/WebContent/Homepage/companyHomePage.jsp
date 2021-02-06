<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
</body>
</html>