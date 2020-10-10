package com.example.passman;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/updatePassword")
public class updatePassword extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String passtitle = request.getParameter("passtitle");
		String titlepass = request.getParameter("newtitlepass");
		
		PasswordDao pd = new PasswordDao();
		try {
			int i = pd.updatePassword(username, passtitle, titlepass);
			if(i != 0) {
				request.setAttribute("Message","Password Updated Successfully!");
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
