package com.example.passman;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PasswordDao {
	
	
	
	public int setPassword(String username, String passwordtitle, String titlepassword) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312");
		PreparedStatement st = con.prepareStatement("insert into passwordinfo values(?,?,?);");
		st.setString(1,username);
		st.setString(2, passwordtitle);
		st.setString(3, titlepassword);
		int r = st.executeUpdate();
		con.close();
		return r;
	}
	
	public int deletePassword(String username, String passwordtitle) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312");
		PreparedStatement st = 
				con.prepareStatement("delete from passwordinfo where username = ? and passwordtitle = ?");
		st.setString(1, username);
		st.setString(2, passwordtitle);
		int r = st.executeUpdate();
		con.close();
		return r;
	}
	
	public int updatePassword(String username, String passwordtitle, String newtitlepass) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312");
		PreparedStatement st = 
				con.prepareStatement("update passwordinfo set titlepassword = ? where username = ? and passwordtitle = ?;");
		st.setString(1, newtitlepass);
		st.setString(2, username);
		st.setString(3, passwordtitle);
		int r = st.executeUpdate();
		con.close();
		return r;
	}
}
