package com.example.passman;
import java.sql.*;

public class UserDao {
	
	public User getUser(String user,String password) throws ClassNotFoundException, SQLException {
		
		User u = new User();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312");
		PreparedStatement st = con.prepareStatement("select * from userinfo where uname = ? and "
				+ "upassword = ?;");
		st.setString(1,user);
		st.setString(2,password);
		ResultSet rs = st.executeQuery();
		while(rs.next()) {
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));
		}
		con.close();
		return u;
	}
	
	public int setUser(String user, String pass) throws ClassNotFoundException, SQLException {
		User u = new User();
		String uname=user;
		String upass=pass;
		int status;
		u.setUsername(uname);
		u.setPassword(upass);
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.
				getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312");
		PreparedStatement st = con.prepareStatement("insert into userinfo values(?,?);");
		st.setString(1,uname);
		st.setString(2,upass);
		status = st.executeUpdate();
		con.close();
		return status;
	}
	
	
	  public boolean checkUser(String usernamec) throws SQLException,
	  ClassNotFoundException { 
		  
		  Boolean doExist = false;
		  Class.forName("com.mysql.jdbc.Driver"); 
		  Connection con = DriverManager.
				  getConnection("jdbc:mysql://localhost:3306/passwordmanager","root", "Sshounak@47312"); 
		  PreparedStatement ps = con.prepareStatement("select * from userinfo where uname = ?;"); 
		  ps.setString(1, usernamec);
		  ResultSet rs = ps.executeQuery(); 
		  if(rs.next()) {
		  if(usernamec.equals(rs.getString(1))) { 
			   doExist = true; 
			  }
		  }
		  con.close();
		  return doExist;
	 }
}
