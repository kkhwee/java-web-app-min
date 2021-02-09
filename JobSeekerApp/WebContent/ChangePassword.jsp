<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password Page</title>
</head>
<body>
<form action="/JobSeekerApp/ChangePassword">
	old password: <input type="text" name="oldpassword"></input>
	new password: <input type="text" name="newpassword"></input>
	confirm password: <input type="text" name="confirmpassword"></input>
<input type="submit" name="Login User"></input>
</body>
</html>