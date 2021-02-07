package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.CompanyChangePasswordModel;
import com.avensys.model.CompanyModel;

/**
 * Servlet implementation class CompanyChangePasswordServlet
 */
public class CompanyChangePasswordServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String userName;
		//String email;
		String oldPassword;
		String newPassword;
		String confirmPassword;
		
		HttpSession session = req.getSession();
	
		// Get parameters from user input
		oldPassword = req.getParameter("oldpwd");
		newPassword = req.getParameter("newpwd");
		confirmPassword = req.getParameter("conpwd");
		
		userName = (String) session.getAttribute("userName");

		// old password does not match
		if(!oldPassword.equals((String) session.getAttribute("password")))
		{
			res.sendRedirect("/JobSeekerApp/Homepage/companyChangePasswordErrorPage.jsp");
			return;
		}
		
		// new password does not match confirm password
		if(!newPassword.equals(confirmPassword))
		{
			res.sendRedirect("/JobSeekerApp/Homepage/companyChangePasswordErrorPage.jsp");
			return;
		}

		CompanyModel m = new CompanyModel();
		
		m.connect();
		
		m.setUserName(userName);
		
		int result = m.changeCompanyPassword(newPassword);
		
		if(result == 1)
		{
			// change password success
			session.setAttribute( "password", newPassword);
			res.sendRedirect("/JobSeekerApp/Homepage/companyHomePage.jsp");
		}
		else
		{
			res.sendRedirect("/JobSeekerApp/Homepage/companyChangePasswordErrorPage.jsp");
		}
	}

}
