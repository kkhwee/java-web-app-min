package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CompanyRegistrationModel {
	
	private String user;
	private String password;
	private String email;
	private final String account = "Company";
	
	Connection con;
	PreparedStatement pstmt;
	
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
	
	public int registerNewCompany()
	{
		try
		{	

			String sql = "INSERT INTO user VALUES(?,?,?,?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, account);
			
			return pstmt.executeUpdate();
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void setUser(String user)
	{
		this.user = user;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}
