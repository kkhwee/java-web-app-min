package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.CompanyModel;

/**
 * Servlet implementation class UpdateListingServlet
 */
public class UpdateListingServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			String jobID = req.getParameter("jobID");
			String title = req.getParameter("jobtitle");
			String desc = req.getParameter("jobdescription");
			String address = req.getParameter("jobaddress");
			String dateTime = req.getParameter("jobdatetime");
			String pay = req.getParameter("jobpay");
			
			HttpSession session = req.getSession();
			
			CompanyModel m = (CompanyModel)session.getAttribute("model");
			
			// check if jobID belongs to current user
			if(m.checkJobID(Integer.parseInt(jobID)) != 1)
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListingErrorPage.jsp");
				return;
			}
			
			int result = m.updateListing(jobID, title, desc, address, dateTime, pay);
			
			if(result == 1)
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListing.jsp");
			} else
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListingErrorPage.jsp");
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
