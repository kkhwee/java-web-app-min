package com.avensys.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.avensys.model.JobRequestModel;

/**
 * Servlet implementation class CreateJobRequestServlet
 */
public class CreateJobRequestServlet extends HttpServlet {
	
//	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		System.out.println("Here we go");
//	}
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public CreateJobRequestServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JobRequestModel jr = new JobRequestModel();
		jr.connect();
		jr.setJobID(request.getParameter("jobID"));
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		jr.setJobSeekerID(username);
		jr.setJobReqStatus("1");
		int i = (int) (new Date().getTime()/1000);
		String jobReqID = username.substring(0,5) + i;
		jr.setJobReqID(jobReqID);
		jr.submitJobRequest();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
