package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JobRequestModel {
	private String jobReqID;
	private String jobSeekerID;
	private String jobID;
	private String jobReqStatus;
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
	
	public int submitJobRequest() {
		try {
			String createReqQuery = "INSERT INTO jobrequest VALUES (?,?,?,?)";

			PreparedStatement createReqStmt = con.prepareStatement(createReqQuery);
			createReqStmt.setString(1, this.jobReqID);
			createReqStmt.setString(2, this.jobSeekerID);
			createReqStmt.setString(3, this.jobID);
			createReqStmt.setString(4, this.jobReqStatus);
			int rs = createReqStmt.executeUpdate();
			if(rs != 0)
			{
				return 1;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		
		return 0;
	}
	
	public ResultSet getMyJobRequest() {
		try
		{
			String sql = "SELECT * FROM jobrequest WHERE username=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, this.jobSeekerID);
			ResultSet rs = pstmt.executeQuery();
			return rs;

			
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	//TODO: UPDATE JOB REQ STATUS
	//TODO: DEL JOB REQ
	
	public String getJobReqID() {
		return jobReqID;
	}
	public void setJobReqID(String jobReqID) {
		this.jobReqID = jobReqID;
	}
	public String getJobSeekerID() {
		return jobSeekerID;
	}
	public void setJobSeekerID(String jobSeekerID) {
		this.jobSeekerID = jobSeekerID;
	}
	public String getJobID() {
		return jobID;
	}
	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	public String getJobReqStatus() {
		return jobReqStatus;
	}
	public void setJobReqStatus(String jobReqStatus) {
		this.jobReqStatus = jobReqStatus;
	}
	
	
	
}
