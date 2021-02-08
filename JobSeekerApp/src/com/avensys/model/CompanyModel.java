package com.avensys.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class CompanyModel {

	private String userName;
	private String email;
	private String password;
	private final String accountType = "Company";
	
	Connection con;
	
	public void connect()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			this.con = DriverManager.getConnection("jdbc:MySQL://localhost/JOBSEEKPROJECT", "root", "root");
			System.out.println("Connection to DB establised");
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int loginCompany()
	{
		try
		{	
			String sql = "SELECT * FROM user WHERE email=? AND password=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next() == true)
			{
				userName = rs.getString(1);
				email = rs.getString(2);
				password = rs.getString(3);
				
				return 1;
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int registerNewCompany()
	{
		try
		{	

			String sql = "INSERT INTO user VALUES(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, accountType);
			
			System.out.println("Registration: " + userName);
			System.out.println("Registration: " + email);
			System.out.println("Registration: " + password);
			
			int result = pstmt.executeUpdate();
			
			System.out.println("Result Registration: " + result);
			return result;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int changeCompanyPassword(String newPassword)
	{
		try
		{
//			if(oldPassword != .getAttribute("password"));
			
			String sql = "UPDATE user SET password=? WHERE username=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, userName);
			
			System.out.println(newPassword);
			System.out.println(userName);
			
			if( pstmt.executeUpdate() == 1)
			{
				setPassword(newPassword);
				return 1;
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int createNewListing(String title, String desc, String username, String address, String datetime, String pay) throws Exception
	{
		
		try {
			String sql = "INSERT INTO jobposting VALUES(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			int jobId = getJobCount() + 1;
			String formattedDatetime = formatDateTime(datetime);
			
			pstmt.setInt(1, jobId);
			pstmt.setString(2, title);
			pstmt.setString(3,  desc);
			pstmt.setString(4, username);
			pstmt.setString(5, address);
			pstmt.setTimestamp(6, java.sql.Timestamp.valueOf(formattedDatetime)); // 2021-02-07T17:30
			pstmt.setDouble(7, Double.parseDouble(pay));
			pstmt.setInt(8, 1);
			
			int result = pstmt.executeUpdate();
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ResultSet displayJobListing()
	{
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
	
//	// display all job listing created by current user
	public ResultSet displayUserJobListing()
	{
		try
		{
			String sql = "SELECT * FROM jobposting WHERE Employer=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			return rs;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int updateListing(String jobID, String title, String desc, String address, String dateTime, String pay)
	{
		try
		{
			String sql = "UPDATE jobposting SET title=?, description=?, employerAddress=?, reportingDateTime=?, pay=? WHERE jobID=?";
//			
//			System.out.println("Update Listing: " + jobID);
//			System.out.println("Update Listing: " + title);
//			System.out.println("Update Listing: " + desc);
//			System.out.println("Update Listing: " + address);
//			System.out.println("Update Listing: " + dateTime);
//			System.out.println("Update Listing: " + pay);
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, desc);
			pstmt.setString(3, address);
			pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(formatDateTime(dateTime)));
			pstmt.setDouble(5, Double.parseDouble(pay));
			pstmt.setInt(6, Integer.parseInt(jobID));
			
			int result = pstmt.executeUpdate();
			
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int deleteListing(String jobID)
	{
		try
		{
			String sql = "DELETE FROM jobposting WHERE jobID=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(jobID));
			
			int result = pstmt.executeUpdate();
			
			return result;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	// This function assumes the jobID is correct.
	public int changeJobStatus(String jobID)
	{
		try
		{
			String sql = "UPDATE jobposting SET status=? WHERE jobID=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			System.out.println("Inside changJobStatus, jobID is " + jobID);
			
			int jobStatus = getJobStatus(jobID);
			
			// if available, close vacancy vice versa
			if(jobStatus == 1)
			{
				pstmt.setInt(1, 0);
			} else
			{
				pstmt.setInt(1, 1);
			}
			
			pstmt.setInt(2, Integer.parseInt(jobID));
			
			int result = pstmt.executeUpdate();
			
			return result;
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		// dummy int
		return 0;
	}
	
	public int getJobStatus(String jobID)
	{
		try
		{
			String sql = "SELECT status FROM jobposting WHERE jobID=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(jobID));
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Status Obtained: " + rs.getInt("status"));
				if(rs.getInt("status") == 1)
				{
					return 1;
				}
			}

		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	// check if the job id belongs to current user in session
	public int checkJobID(int id)
	{
		try
		{
			String sql = "SELECT * FROM jobposting WHERE jobID=? AND Employer=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, userName);
			
			ResultSet rs = pstmt.executeQuery();
			
			System.out.println("Job ID: " + id);
			
			if(rs.next())
			{
				//System.out.println("Item found");
				return 1;
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	/*
	 * Format the date time string into yyyy-mm-dd hh:mm:ss
	 * so it can be inserted into the DB
	 * */
	public String formatDateTime(String datetime)
	{
		StringBuilder formattedDatetime = new StringBuilder(datetime);
		
		formattedDatetime.setCharAt(10, ' ');
		
		// Original date time does not comes with ss, so have to concat to the end
		return formattedDatetime.toString().concat(":00");
	}
	
	public int getJobCount()
	{
		try
		{
			String sql = "SELECT COUNT(*) FROM jobposting";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				System.out.println("Job Count: " + rs.getString(1));
				return Integer.parseInt(rs.getString(1));
			}
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String obtainUserName()
	{
		
		try {
			String sql = "SELECT username FROM user WHERE email=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getAccountType() {
		return accountType;
	}
}
