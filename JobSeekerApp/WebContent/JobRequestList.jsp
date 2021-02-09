<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.avensys.model.JobPostingModel" %>
<%@page import="com.avensys.model.JobPostingRequestModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
  
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap.min.css"/>
<link rel="stylesheet" href="/JobSeekerApp/css/bootstrap-theme.min.css"/>
<link href="/JobSeekerApp/css/modern-business.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Job Request For A Job Post Page</title>
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
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Job Seeker Home Page</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/userLogin.html">Login</a>
          </li>
          </li>
        </ul>
      </div>
    </div>
  </nav>
<%
	String jobID = (String)session.getAttribute("jobID");
	JobPostingModel jp = new JobPostingModel();
	jp.connect();
	jp.setJobID(Integer.parseInt(jobID));
	ArrayList<JobPostingRequestModel> result = jp.getJobRequestByJobID();
%>

	<div class="d-flex align-items-center justify-content-center" style="height: 100%">
		<div class="innercolumn p-2 bd-highlight col-example">
			<div style="overflow: auto; max-height: 500px; background: ivory">
				<table border=1 cellpadding=30>
				<tr>
					<th>Job Request ID</th>
					<th>Job Requester Name</th>
					<th>Job Request Status</th>
					<th>Actions</th>
				</tr>
				
				<%
					for(JobPostingRequestModel rs : result)
					{
				%>
					<tr>
						<td><%out.println(rs.getJobReqID()); %></td>
						<td><%out.println(rs.getJobSeekerID()); %></td>
						<%
							if(rs.getJobReqStatus().equals("1"))
							{
							// Pending Approval
							%>
								<td><%String pend = "Pending";out.println(pend); %></td>
								<td>
									<a href="/JobSeekerApp/ApproveJobRequest?jobReqID=<%out.println(rs.getJobReqID());%>" class="btn btn-primary">Accept</a>
									<a href="/JobSeekerApp/RejectJobRequest?jobReqID=<%out.println(rs.getJobReqID());%>" class="btn btn-primary">Reject</a>
								</td>
							<%
							}
							else if(rs.getJobReqStatus().equals("2"))
							{
							// Accepted
							%>
								<td><%String acc = "Accepted";out.println(acc); %></td>
								<td>
								</td>
							<%	
							}
							else
							{
							// Rejected
							%>
								<td><%String rej = "Rejected";out.println(rej); %></td>
								<td>

								</td>
							<%
							}
						%>
					</tr>
				<%
					}
				%>
				</table>
			</div>
		</div>
	</div>


  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Job Seeker SG 2021</p>
    </div>
    <!-- /.container -->
  </footer>

<script src="/JobSeekerApp/js/jquery.js"></script>
<script src="/JobSeekerApp/js/bootstrap.js"></script>
</body>
</html>