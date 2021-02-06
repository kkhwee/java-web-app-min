package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
