<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Password</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body style="background-color:antiquewhite">
<%

	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	HttpSession session1 = request.getSession();
if(session1.getAttribute("UserName") == null){
	response.sendRedirect("SignIn.jsp");


}
%>
    <form action="addpassword" method="post">
        <div class="wrapper fadeInDown" style="display: flex;
              align-items: center;
              flex-direction: column; 
              justify-content: center;
              width: 100%;
              min-height: 100%;
              padding: 20px;">
            <div align="center" class="formContent" style="
              -webkit-border-radius: 10px 10px 10px 10px;
              border-radius: 10px 10px 10px 10px;
              background: #fff;
              padding: 30px;
              width: 90%; 
              background-color:cornsilk;
              max-width: 450px;
              position: relative;
              padding: 0px;
              -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
              box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
              text-align: center;"><br>
                <label for="uname"><b>Username: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
                <input class="fadeIn second" type="text" placeholder="Enter Username" name="username" required><br><br>

                <label for="psw"><b>Password Title: &nbsp;</b></label>
                <input type="text" placeholder="Enter Password" name="passtitle" required><br><br>
                
                <label for="psw"><b>Password: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b></label>
                <input type="password" placeholder="Enter Password" name="titlepass" required><br><br>

                <button  class="btn btn-primary" 	type="submit" name="add">Add</button><br><br>
                
            </div>
        </div>
    </form>
</body>
</html>