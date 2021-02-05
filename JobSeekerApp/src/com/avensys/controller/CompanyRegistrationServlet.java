package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avensys.model.CompanyRegistrationModel;

/**
 * Servlet implementation class CompanyRegistrationServlet
 */
public class CompanyRegistrationServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		
		System.out.println("Insert Data Servlet");
		
		String user;
		String email;
		String password;
		final String account = "Company";
		
		user = req.getParameter("user");
		email = req.getParameter("email");
		password = req.getParameter("password");
		
		CompanyRegistrationModel m = new CompanyRegistrationModel();
		
		// connect to database
		m.connect();
		
		m.setUser(user);
		m.setEmail(email);
		m.setPassword(password);
		
		int insertStatus = m.registerNewCompany();
		
		if(insertStatus == 1)
		{
			// success
			res.sendRedirect("/RegistrationEx/companyRegistrationSuccessPage");
		} else
		{
			// fail
			res.sendRedirect("/RegistrationEx/companyRegistrationFailurePage");
		}
	}

}
