package com.avensys.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.User;

/**
 * Servlet implementation class ChangePassword
 */
public class ChangePassword extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		User user = new User();	
		HttpSession session = req.getSession(true);
		String username = (String)session.getAttribute("username");
		user.setUsername(username);
		String clientOldPassword = req.getParameter("oldpassword");
		System.out.println(clientOldPassword);

		
		user.connect();
		int status = user.getUserByUsername();
		if(status != 0) {
			if(clientOldPassword.equals(user.getPassword())) 
			{
				user.setPassword(req.getParameter("newpassword"));
				status = user.changePassword();
				if(status == 0) 
				{
					res.sendRedirect("/JobSeekerApp/common-page/errorPage.jsp");
				}
				else 
				{
					session.setAttribute("username", username);
					session.setAttribute("email", user.getEmail());
					session.setAttribute("accountType", user.getAccountType());
					session.setAttribute("prevAction","changePw");
					res.sendRedirect("/JobSeekerApp/jobSeekerHome.jsp");
				}
			}
		}
	}

}
