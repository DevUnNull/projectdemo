<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        Login information:
        <!--your code here-->
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" value="" /> <br>
            Password <input type="password" name="password" value="" /> <br>
            <input type="submit" name="action" value="Login" />
        </form>
        <%
            String error = (String) request.getAttribute("MESSAGE");
            if (error == null) {
                error = "";
            }
        %>
        <div> <%= error%> </div>
    </body>

</html>

