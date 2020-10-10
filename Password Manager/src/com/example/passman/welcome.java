package com.example.passman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "welcome",urlPatterns = {"/welcome"})
public class welcome extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String UserName = request.getParameter("username");
		String UserPass = request.getParameter("userpass");
		
		if(UserName.equals("") || UserPass.equals("")) {
			
					request.setAttribute("Message","No data entered.");
					request.getRequestDispatcher("SignIn.jsp").forward(request,response);
		}
		
		try {
			
				UserDao ud = new UserDao();
				User u = ud.getUser(UserName, UserPass);
				System.out.println(u);
				String UserName1 =u.getUsername();
				 if(!ud.checkUser(UserName1)){
					 
					  request.setAttribute("Message","Data not found! Please Register.");
					  request.getRequestDispatcher("SignIn.jsp").forward(request,response);
					   
				} else
						  { 
							   HttpSession session = request.getSession();
							   session.setAttribute("UserName", UserName1);
							  request.setAttribute("UserName",UserName1);
							  request.getRequestDispatcher("Welcome.jsp").forward(request,response);
						  }
			 
			} catch (ClassNotFoundException | SQLException e) {
		
				e.printStackTrace();
		}
	}
}
