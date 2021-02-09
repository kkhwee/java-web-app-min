package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class JobPostingModel {
	private int jobID;
	private String title;
	private String description;
	private String company;
	private String companyAddress;
	private String reportingDateTime;
	private String pay;
	private String status;
	private HashMap<String,JobPostingRequestModel> jobRequestList;
	Connection con;
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			this.con = DriverManager.getConnection("jdbc:MySQL://localhost/jobseekproject", "root", "root");
			System.out.println("Connection to DB establised");
			jobRequestList = new HashMap<String,JobPostingRequestModel>();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet getAllJobPosting() {
		try
		{
			String sql = "SELECT * FROM jobposting";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs;
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public HashMap<String,JobPostingRequestModel> getRelatedJobRequest(String username) {
		try
		{
			// String sql = "SELECT * FROM jobrequest where jobID = ? and username = ?";
			// This became a 1 to 1 relationship because one user can only make 1 job request to a single posting.
			String tempsql = "Select * from jobposting INNER JOIN jobrequest On jobposting.jobID=jobrequest.jobID WHERE username=?";
			
			PreparedStatement pstmt = con.prepareStatement(tempsql);
//			pstmt.setInt(1, this.jobID);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				JobPostingRequestModel jr = new JobPostingRequestModel();
				String jobID = rs.getString("jobID");
				jr.setJobID(jobID);
				jr.setTitle(rs.getString("title"));
				jr.setDescription(rs.getString("description"));
				jr.setCompany(rs.getString("Employer"));
				jr.setCompanyAddress(rs.getString("employerAddress"));
				jr.setReportingDateTime(rs.getString("reportingDateTime"));
				jr.setPay(rs.getString("pay"));
				jr.setStatus(rs.getString("status"));
				jr.setJobReqID(rs.getString("jobReqID"));
				jr.setJobSeekerID(rs.getString("username"));
				jr.setJobReqStatus(rs.getString("jobReqStatus"));
				jobRequestList.put(jobID, jr);
			}
			return jobRequestList;
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public ArrayList<JobPostingRequestModel> getJobRequestByJobID() {
		try
		{
			String tempsql = "Select * from jobposting INNER JOIN jobrequest On jobposting.jobID=jobrequest.jobID WHERE jobrequest.jobID=?";
			
			PreparedStatement pstmt = con.prepareStatement(tempsql);
//			pstmt.setInt(1, this.jobID);
//			String strJobID = Integer.toString(jobID);
			pstmt.setInt(1, jobID);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<JobPostingRequestModel> returnList = new ArrayList<JobPostingRequestModel>();
			while(rs.next()) {

				JobPostingRequestModel jr = new JobPostingRequestModel();
				String jobID = rs.getString("jobID");
				jr.setJobID(jobID);
				jr.setTitle(rs.getString("title"));
				jr.setDescription(rs.getString("description"));
				jr.setCompany(rs.getString("Employer"));
				jr.setCompanyAddress(rs.getString("employerAddress"));
				jr.setReportingDateTime(rs.getString("reportingDateTime"));
				jr.setPay(rs.getString("pay"));
				jr.setStatus(rs.getString("status"));
				jr.setJobReqID(rs.getString("jobReqID"));
				jr.setJobSeekerID(rs.getString("username"));
				jr.setJobReqStatus(rs.getString("jobReqStatus"));
				returnList.add(jr);
			}
			return returnList;
			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getReportingDateTime() {
		return reportingDateTime;
	}
	public void setReportingDateTime(String reportingDateTime) {
		this.reportingDateTime = reportingDateTime;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public HashMap<String,JobPostingRequestModel> getJobRequestList() {
		return jobRequestList;
	}
	public void setStatus(HashMap<String,JobPostingRequestModel> jobRequestList) {
		this.jobRequestList = jobRequestList;
	}

}
