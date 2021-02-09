package com.avensys.controller;

import java.io.IOException;import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.JobPostingModel;
import com.avensys.model.JobPostingRequestModel;
import com.avensys.model.JobRequestModel;

/**
 * Servlet implementation class ViewJobRequestList
 */
public class ViewJobRequestList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String jobID = req.getParameter("jobID");

		HttpSession session = req.getSession();

		session.setAttribute("jobID", jobID);
		res.sendRedirect("/JobSeekerApp/JobRequestList.jsp");

	}

}
