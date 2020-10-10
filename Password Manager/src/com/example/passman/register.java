package com.example.passman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "register",urlPatterns = {"/register"})
public class register extends HttpServlet {
		
       
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao ud = new UserDao();
		String username = request.getParameter("username");
		String userpass = request.getParameter("userpass");
		String userpassc = request.getParameter("userpassc");
		
		if(userpass.equals(userpassc)) {
			
			try {
				
					int status = ud.setUser(username, userpass);
					if(status != 0) {
						
						request.setAttribute("Message","Registered Successfully!");
						request.getRequestDispatcher("SignIn.jsp").forward(request, response);
					}else {
					
					request.setAttribute("Message","Registration Failed!");
					request.getRequestDispatcher("SignIn.jsp").forward(request,response);
					
					}
				} catch(ClassNotFoundException e) {
				
					e.printStackTrace();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}	
		}else {	
			
				request.setAttribute("Message","Registration Failed!");
				request.getRequestDispatcher("SignIn.jsp").forward(request,response);
		}
	}
}
