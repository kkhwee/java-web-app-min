package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobPostingModel {
	private int jobID;
	private String title;
	private String description;
	private String company;
	private String companyAddress;
	private String reportingDateTime;
	private String pay;
	private String status;
	Connection con;
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			this.con = DriverManager.getConnection("jdbc:MySQL://localhost/jobseekproject", "root", "root");
			System.out.println("Connection to DB establised");
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

}
