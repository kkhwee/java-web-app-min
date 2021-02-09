package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avensys.model.CompanyModel;
import com.avensys.model.CompanyRegistrationModel;

/**
 * Servlet implementation class CompanyRegistrationServlet
 */
public class CompanyRegistrationServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{	
		String user;
		String email;
		String password;
		final String account = "Company";
		
		user = req.getParameter("user");
		email = req.getParameter("email");
		password = req.getParameter("password");
		
		CompanyModel m = new CompanyModel();
		
		// connect to database
		m.connect();
		
		m.setUserName(user);
		m.setEmail(email);
		m.setPassword(password);
		
		int insertStatus = m.registerNewCompany();
		
		if(insertStatus == 1)
		{
			// success
			res.sendRedirect("/JobSeekerApp/Registration/companyRegistrationSuccessPage.html");
		} else
		{
			// fail
			res.sendRedirect("/JobSeekerApp/Registration/companyRegistrationFailurePage.html");
		}
	}

}
