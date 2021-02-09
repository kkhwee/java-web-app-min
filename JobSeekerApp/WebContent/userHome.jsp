<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.avensys.model.JobPostingModel" %>
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

<link rel="stylesheet" href="/JobSeekerApp/style.css"/>
<meta charset="ISO-8859-1">
<title>Job Seeker Home</title>
</head>
<body>
	<%
	JobPostingModel jobPosting = new JobPostingModel();
	jobPosting.connect();
	%>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Job Seeker Home Page</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
        <%
        if(session.getAttribute("username")==null)
        {
        %>
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/userLogin.html">Login</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/userRegister.html">Register</a>
          </li>
        <%
        }
        else{
        %>
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/ChangePassword.jsp">Change Password</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/JobSeekerApp/userRegister.html">Log Out</a>
          </li>
        <%
        }
        %>
         <!-- <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Blog
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
              <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
              <a class="dropdown-item" href="blog-post.html">Blog Post</a>
            </div>
          </li>-->
        </ul>
      </div>
    </div>
  </nav>

  <header>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
        <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">
        <!-- Slide One - Set the background image for this slide in the line below -->
        <div class="carousel-item active" style="background-image: url('/JobSeekerApp/assets/banner1.jpg')">
         <!--  <div class="carousel-caption d-none d-md-block">
            <h3>First Slide</h3>
            <p>This is a description for the first slide.</p>
          </div> -->
        </div>
      </div>
      <!-- <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>-->
    </div>
  </header>

  <!-- Page Content -->
  <div class="container">
	<%
	if(session.getAttribute("prevAction") != null)
	{
		if(session.getAttribute("prevAction").equals("changePw"))
		{
	%>	
	    	<h1 class="my-4">Password successfully changed</h1>
		<%
		}
		else{
		%>
		<h1 class="my-4">Welcome, <%out.println(session.getAttribute("username")); %></h1>
	<%
		}
	}
	else
	{
	%>
		<h1 class="my-4">Welcome to Job Seeker Home</h1>
	<%
	} 
	%>
    <!-- Marketing Icons Section -->
    <!-- <div class="row">
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h4 class="card-header">Card Title</h4>
          <div class="card-body">
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Learn More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h4 class="card-header">Card Title</h4>
          <div class="card-body">
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis ipsam eos, nam perspiciatis natus commodi similique totam consectetur praesentium molestiae atque exercitationem ut consequuntur, sed eveniet, magni nostrum sint fuga.</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Learn More</a>
          </div>
        </div>
      </div>
      <div class="col-lg-4 mb-4">
        <div class="card h-100">
          <h4 class="card-header">Card Title</h4>
          <div class="card-body">
            <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
          </div>
          <div class="card-footer">
            <a href="#" class="btn btn-primary">Learn More</a>
          </div>
        </div>
      </div>
    </div>-->
    <!-- /.row -->

    <!-- Portfolio Section -->
    <h2>Job Listing</h2>

    <div class="row">
    <%
	ResultSet rs = jobPosting.getAllJobPosting();
    while(rs.next())
    {
   		if(rs.getString("status").equals("1"))
   		{
    %>
	      <div class="col-lg-4 col-sm-6 portfolio-item">
	        <div class="card h-100">
	          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
	          <div class="card-body">
	            <h4 class="card-title">
	              <input type="hidden" name="jobID" value="<% out.println(rs.getString("jobID"));%>"/>
	              <a href="#"><% out.println(rs.getString("title"));%></a>
	            </h4>
	            <p class="card-text"><%out.println(rs.getString("description")); %></p>
	          </div>
	          <%
	          	if(!(session.getAttribute("username") == null))
	          	{
	          %>
		          <div class="card-footer">
		            <a href="/JobSeekerApp/CreateJobRequestServlet?jobID=<%out.println(rs.getString("jobID"));%>" class="btn btn-primary">Apply Now</a>
		          </div>
	          <%
	        	}
	          %>
	        </div>
	      </div>
    <%
    	}
    }
    %>
    </div>
    <!-- /.row -->

    <!-- Features Section -->
    <!-- <div class="row">
      <div class="col-lg-6">
        <h2>Modern Business Features</h2>
        <p>The Modern Business template by Start Bootstrap includes:</p>
        <ul>
          <li>
            <strong>Bootstrap v4</strong>
          </li>
          <li>jQuery</li>
          <li>Font Awesome</li>
          <li>Working contact form with validation</li>
          <li>Unstyled page elements for easy customization</li>
        </ul>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p>
      </div>
      <div class="col-lg-6">
        <img class="img-fluid rounded" src="http://placehold.it/700x450" alt="">
      </div>
    </div>
    <!-- /.row -->

    <hr>

    <!-- Call to Action Section -->
    <div class="row mb-4">
      <div class="col-md-8">
        <p>Tired of sending thousands of resumes and not getting any response? <br/>
        Let us find the best suited job for you. Register with us now! </p>
      </div>
      <div class="col-md-4">
        <a class="btn btn-lg btn-secondary btn-block" href="/JobSeekerApp/userRegister.html">Register</a>
      </div>
    </div>

  </div>
  <!-- /.container -->
  <!--
	<button type="button" class="btn btn-link" onClick=window.location.href="/JobSeekerApp/userRegister.html">Register</button>
	<button type="button" class="btn btn-primary" onClick=window.location.href="/JobSeekerApp/userLogin.html">Login</button>
  -->
  <!-- Footer -->
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