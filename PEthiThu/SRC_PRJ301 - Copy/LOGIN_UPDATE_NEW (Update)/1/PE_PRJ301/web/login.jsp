<%-- 
    Document   : login
    Created on : 113
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
         <h1 style="color: red">${requestScope.MESSAGE}</h1>
        <form action="MainController" method="POST">
            Username:<input type="text" name="username"><br>
            Password:<input type="password" name="password"><br>
            <input type="submit" name="action" value="Login">
        </form>
    </body>
    
</html>

