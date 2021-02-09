package com.avensys.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {
	private String username;
	private String email;
	private String password;
	private String accountType;
	Connection con;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");	
			System.out.println("Driver was loaded");
			
			con = DriverManager.getConnection("jdbc:MySQL://localhost:3306/jobseekproject","root","root");
			System.out.println("Connection to DB is established");
		}
		catch(Exception ex) {ex.printStackTrace();}
	}
	
	public ResultSet login() 
	{
		ResultSet rs= null;
		try {
			String loginQuery = "SELECT * FROM user WHERE username=? AND password=?";

			PreparedStatement loginStmt = con.prepareStatement(loginQuery);

			loginStmt.setString(1, this.username);
			loginStmt.setString(2, this.password);
			
			rs = loginStmt.executeQuery();
			while(rs.next())
			{
				return rs;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		
		return rs;
	}
	
	public int register() 
	{
		try {
			String registerQuery = "INSERT INTO user VALUES (?,?,?,?)";

			PreparedStatement registerStmt = con.prepareStatement(registerQuery);
			registerStmt.setString(1, this.username);
			registerStmt.setString(2, this.email);
			registerStmt.setString(3, this.password);
			registerStmt.setString(4, this.accountType);
			int rs = registerStmt.executeUpdate();
			if(rs != 0)
			{
				return 1;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		
		return 0;
	}
	
	public int getUserByUsername() 
	{
		ResultSet rs = null;
		try {
			String getUserByUsernameQuery = "SELECT * FROM USER WHERE username=?";

			PreparedStatement getStmt = con.prepareStatement(getUserByUsernameQuery);
			getStmt.setString(1, this.username);
			rs = getStmt.executeQuery();
			while(rs.next())
			{
				this.password = rs.getString("password");
				this.email = rs.getString("email");
				this.accountType = rs.getString("accountType");
				return 1;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		
		return 0;
	}
	
	public int changePassword() 
	{
		try {
			String changePwdQuery = "UPDATE user SET password = ? where username = ?";

			PreparedStatement changePwStmt = con.prepareStatement(changePwdQuery);
			changePwStmt.setString(1, this.password);
			changePwStmt.setString(2, this.username);
			int rs = changePwStmt.executeUpdate();
			if(rs != 0)
			{
				return 1;
			}
		}catch(Exception ex) {ex.printStackTrace();}
		
		return 0;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
}
