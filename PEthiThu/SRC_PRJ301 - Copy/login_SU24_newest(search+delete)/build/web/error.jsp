<%-- 
    Document   : error
    Created on : Mar 1, 2022, 8:33:55 PM
    Author     : hd
--%>

<%@page import="pe.models.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <%
        UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
        if (user == null || !user.getRoleID().equals("user")) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>
</html>
