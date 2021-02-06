package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.CompanyChangePasswordModel;

/**
 * Servlet implementation class CompanyChangePasswordServlet
 */
public class CompanyChangePasswordServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String email;
		String oldPassword;
		String newPassword;
		String confirmPassword;
		
		HttpSession session = req.getSession();
	
		oldPassword = req.getParameter("oldpwd");
		newPassword = req.getParameter("newpwd");
		confirmPassword = req.getParameter("conpwd");
		
		email = (String) session.getAttribute("email");
		
		System.out.println("Session user: " + email);
		
		//userName = (String) session.getAttribute("userName");

//		if(oldPassword != (String) session.getAttribute("password"))
//		{
//			System.out.println("Password different");
//			// User verification failed
//			res.sendRedirect("/JobSeekerApp/companyChangePasswordError.jsp");
//		}
//		
		CompanyChangePasswordModel m = new CompanyChangePasswordModel();
		
		m.connect();
		
		m.setOldPassword(oldPassword);
		m.setNewPassword(newPassword);
		m.setConfirmPassword(confirmPassword);
		
		int result = m.changeCompanyPassword(email);
		
		if(result == 1)
		{
			// change password success
			res.sendRedirect("/JobSeekerApp/Homepage/companyHomePage.jsp");
		}
		else
		{
			res.sendRedirect("/JobSeekerApp/Homepage/companyChangePasswordErrorPage.jsp");
		}
	}

}
