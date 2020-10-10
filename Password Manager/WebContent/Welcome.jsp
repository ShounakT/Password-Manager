<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Welcome Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body style="background-color:antiquewhite">
    
<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
/* HttpSession session1 = request.getSession();
if(!request.isRequestedSessionIdValid()){
	response.sendRedirect("SignIn.jsp"); */
	HttpSession session1 = request.getSession(false);
	if(session1 == null || !request.isRequestedSessionIdValid()){
		response.sendRedirect("SignIn.jsp");
	}
%>

    <form action="logout" method="post">
        <div class="container-fluid">
            <h2 style="display: inline-block; margin-right: 600px; margin-top: 30px">Welcome, ${UserName}!</h2>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

            <button style="display: inline-block;" class="btn btn-primary" type="submit" name="logout">LogOut</button>
        </div>

        <div class="container jumbotron">
            <center>${Message}</center>
            <a href="AddPassword.jsp"> <button class="btn btn-primary" name="add" type="button">Add Password</button></a>
            <a href="DeletePassword.jsp"> <button class="btn btn-primary" name="delete" type="button">Delete Password</button></a>
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                  
                    <tr>
                        <td>
                                <h5><strong>Password Title</strong></h5>
                            </td>
                        <td>
                                <h5><strong>Password</strong></h5>
                            </td>
                    </tr>
                </thead><tbody>
                <%

    String cname = request.getParameter("username");
    try {
        Class.forName("com.mysql.jdbc.Driver"); 

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/passwordmanager","root","Sshounak@47312"); 

        PreparedStatement st = con.prepareStatement("select * from passwordinfo where username = ?;");

        st.setString(1, cname); 

        ResultSet rs = st.executeQuery();


        while (rs.next()) {
%>
                	<tr>
					<td><%= rs.getString(2) %></td>
					
					<td><%= rs.getString(3) %></td>
					<td><a href="UpdatePassword.jsp"><button class="btn btn-primary"name="edit" type="button">Edit</button></a></td>
					</tr>
					<%}
con.close();
    } catch (Exception ex) {

        System.out.println(ex);

    }

%>
                </tbody>
            </table>

        </div>
    </form>
</body>

</html>