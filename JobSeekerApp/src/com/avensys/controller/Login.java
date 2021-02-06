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
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		User user = new User();		
		String username = req.getParameter("username");
		user.setUsername(username);
		user.setPassword(req.getParameter("password"));

		
		user.connect();
		ResultSet rs = user.login();
		if(rs == null) 
		{
			res.sendRedirect("/JobSeekerApp/common-page/errorPage.jsp");
		}
		else 
		{
			HttpSession session = req.getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("prevAction", "login");
			res.sendRedirect("/JobSeekerApp/jobSeekerHome.jsp");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public Login() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
