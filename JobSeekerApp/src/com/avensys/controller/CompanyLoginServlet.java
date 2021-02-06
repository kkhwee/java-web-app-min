package com.avensys.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.avensys.model.CompanyLoginModel;
import com.avensys.model.CompanyRegistrationModel;

/**
 * Servlet implementation class CompanyLoginServlet
 */
public class CompanyLoginServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{	
		
		try
		{
			String email;
			String password;
	
			email = req.getParameter("email");
			password = req.getParameter("password");
			
			CompanyLoginModel m = new CompanyLoginModel();
			
			// connect to database
			m.connect();
			
			m.setEmail(email);
			m.setPassword(password);
			
			if(m.loginCompany() == 1)
			{
				// success
				// change this to home page later
				res.sendRedirect("/JobSeekerApp/Login/companyLoginSuccessPage.html");
			} else
			{
				// fail
				res.sendRedirect("/JobSeekerApp/Login/companyLoginFailurePage.html");
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}
