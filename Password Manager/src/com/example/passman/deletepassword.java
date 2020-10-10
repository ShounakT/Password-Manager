package com.example.passman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "deletepassword",urlPatterns = {"/deletepassword"})
public class deletepassword extends HttpServlet {
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String passtitle = request.getParameter("passtitle");
		
		
		PasswordDao pd = new PasswordDao();
		try {
			int i = pd.deletePassword(username, passtitle);
			if(i != 0) {
				request.setAttribute("Message","Password Deleted Successfully!");
				request.setAttribute("username1", username);
				request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			}else {
				request.setAttribute("PMessage","An Error Occurred!");
				request.getRequestDispatcher("Welcome.jsp").forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e.getMessage());
		} 
	}
}


