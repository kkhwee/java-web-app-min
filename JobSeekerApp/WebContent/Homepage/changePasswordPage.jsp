<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

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
	
</body>
</html>