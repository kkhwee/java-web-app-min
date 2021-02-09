package com.avensys.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.JobRequestModel;

/**
 * Servlet implementation class RejectJobRequest
 */
public class RejectJobRequest extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String jobReqID = req.getParameter("jobReqID");
		JobRequestModel jr = new JobRequestModel();
		jr.connect();
		jr.setJobReqID(jobReqID);
		jr.setJobReqStatus("3");
		int success = jr.updateJobStatus();
		HttpSession session = req.getSession();
		if(success == 1) {
			res.sendRedirect("/JobSeekerApp/JobRequestList.jsp");
		}
		else {
			res.sendRedirect("/JobSeekerApp/common-page/errorPage.jsp");
		}
	}
}
