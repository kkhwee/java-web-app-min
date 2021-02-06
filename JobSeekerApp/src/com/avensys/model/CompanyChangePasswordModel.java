package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CompanyChangePasswordModel {

	private String email;
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	
	Connection con;
	//PreparedStatement pstmt;
	
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
	
	public int changeCompanyPassword()
	{
		try
		{
//			if(oldPassword != .getAttribute("password"));
			
			String sql = "UPDATE user SET password=? WHERE email=?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, email);
			
			return pstmt.executeUpdate();
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setNewPassword(String pw)
	{
		this.newPassword = pw;
	}
	
	public void setOldPassword(String pw)
	{
		this.oldPassword = pw;
	}
	
	public void setConfirmPassword(String pw)
	{
		this.confirmPassword = pw;
	}
}
