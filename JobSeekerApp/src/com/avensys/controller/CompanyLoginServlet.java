package com.avensys.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			String userName;
			String email;
			String password;
			//String accountType;
	
			email = req.getParameter("email");
			password = req.getParameter("password");
			
			CompanyLoginModel m = new CompanyLoginModel();
			
			// connect to database
			m.connect();
			
			//m.setUserName(userName);
			m.setEmail(email);
			m.setPassword(password);
			
			HttpSession session = req.getSession(true);
			
			if(m.loginCompany() == 1)
			{
				// success
				//userName = m.getUserName();
				//accountType = m.getAccountType();
				email = m.getEmail();
				//password = m.getPassword();
				
				
				//session.setAttribute("userName", userName);
				session.setAttribute("email", email);
				session.setAttribute("password", password);
				//session.setAttribute("accountType", accountType); // have to get data from log in file
				
				// change this to home page later
				res.sendRedirect("/JobSeekerApp/Homepage/companyHomePage.jsp");
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
