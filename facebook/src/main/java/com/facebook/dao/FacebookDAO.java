package com.facebook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.facebook.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fb) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance","root","rajesh");
			PreparedStatement ps=con.prepareStatement("insert into facebookuser values(?,?,?,?)");
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getPassword());
			ps.setString(3, fb.getEmail());
			ps.setString(4, fb.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public boolean loginProfileDAO(FacebookUser fb) {
		boolean i=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? and password=?");
			ps.setString(1, fb.getEmail());
			ps.setString(2, fb.getPassword());
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				i=true;
			}
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser fu=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/revatureadvance","root","rajesh");
			PreparedStatement ps=con.prepareStatement("select * from facebookuser where email=? ");
			ps.setString(1, fb.getEmail());
			
			
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				fu=new FacebookUser();
				fu.setName(res.getString(1));
				fu.setPassword(res.getString(2));
				fu.setEmail(res.getString(3));
				fu.setAddress(res.getString(4));
			}
		}
		catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return fu;
	}

}









