package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.CompanyModel;

/**
 * Servlet implementation class DeleteListingServlet
 */
public class DeleteListingServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			HttpSession session = req.getSession();
			CompanyModel m = (CompanyModel)session.getAttribute("model");
			
			String jobID = req.getParameter("deleteJobID");
			
			if(m.checkJobID(Integer.parseInt(jobID)) != 1)
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListingErrorPage.jsp");
				return;
			}
			
			int status = m.deleteListing(jobID);
			
			if(status == 1)
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListing.jsp");
			} else
			{
				res.sendRedirect("/JobSeekerApp/JobListing/editJobListingErrorPage.jsp");
				return;
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
