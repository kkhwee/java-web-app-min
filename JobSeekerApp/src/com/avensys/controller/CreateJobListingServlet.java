package com.avensys.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.CompanyModel;

/**
 * Servlet implementation class CreateJobListingServlet
 */
public class CreateJobListingServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{	
		try
		{
			System.out.println("CREATE JOB LISTING SERVLET");
			String title;
			String userName;
			String email;
			String jobDescription;
			String address;
			String reportingDateTime;
			String pay;
			int status;
			
			HttpSession session = req.getSession();
			
			
			title = req.getParameter("jobtitle");
			jobDescription = req.getParameter("jobdescription");
			userName = (String)session.getAttribute("userName");
			address = req.getParameter("jobaddress");
			
			reportingDateTime = req.getParameter("jobdatetime");
			pay = req.getParameter("jobpay");
			
			System.out.println("TESTING TESTING");
			System.out.println("Job lisint: " + reportingDateTime);
			System.out.println("Job lisint: " + pay);
			
			status = 1;
			
			email = (String)session.getAttribute("email");
			
			CompanyModel m = new CompanyModel();
			
			m.connect();
			
			int result = m.createNewListing(
					title, 
					jobDescription, 
					(String)session.getAttribute("userName"), 
					address, 
					reportingDateTime, 
					pay);
			
			if(result == 1)
			{
				// success
				res.sendRedirect("/JobSeekerApp/Homepage/companyHomePage.jsp");
			} else
			{
				res.sendRedirect("/JobSeekerApp/JobListing/createJobListingErrorPage.jsp");
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
