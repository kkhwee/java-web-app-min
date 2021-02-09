package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class JobSeekerLogout
 */
public class JobSeekerLogout extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.invalidate();
		res.sendRedirect("/JobSeekerApp/index.html");
	}
}
