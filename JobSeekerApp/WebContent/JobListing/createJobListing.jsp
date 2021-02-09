<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create new listing</title>
</head>
<body>
	
	<form action="/JobSeekerApp/CreateJobListingServlet">
		<label>Job Title: </label>
		<input type="text" name="jobtitle"> 
		
		</br></br>
		
		<label>Description: (Enter at most 200 characters.)</label>
		</br>
		<textarea name="jobdescription" rows="4" cols="50"></textarea>
		<!--<input type="text" name="jobdescription"> -->
		
		</br></br>
		
		<label>Address: </label>
		</br>
		<textarea name="jobaddress" rows="3" cols="40"></textarea>
		<!-- <input type="text" name="jobaddress"> -->
		
		</br></br>
		
		<label for="reportingDateTime">Date and Time: </label>
		<input type="datetime-local" name="jobdatetime">
		
		</br></br>
		
		<label for="pay">Pay (in SGD$): </label>
		<input type="number" name="jobpay">
		
		</br></br>
		
		<input type="submit" name="submitlisting">
		
	</form>

</body>
</html>