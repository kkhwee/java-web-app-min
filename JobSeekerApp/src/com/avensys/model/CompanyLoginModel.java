package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CompanyLoginModel {
	
	private String userName;
	private String password;
	private String email;
	private final String accountType = "Company";
	
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
//				userName = rs.getString(1);
//				email = rs.getString(2);
//				password = rs.getString(3);
//				accountType = rs.getString(4);
				return 1;
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccountType() {
		return accountType;
	}

}
