<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>

<%@page import="java.util.List"%>
<%@page import="pe.models.CapstonesDTO"%>
<%@page import="pe.models.UserDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Capstone list</title>
    </head>
    <body>
        <!--your code here-->
        <h1>Hello world</h1> 

        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !user.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
                return;
            }
            List<CapstonesDTO> list = (List<CapstonesDTO>) request.getAttribute("LIST_PRODUCT");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Welcome <%=user.getFullName()%></h1>       
       <form action="MainController" method="POST">
    Search furniture by name: <input type="text" name="search"/>
    <input type="submit" name="action" value="Search"/>
    <input type="submit" name="action" value="Logout"/>            
</form>

<table border="1">
    <thead>
        <tr>
            <th>No</th>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>UserID</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <% if (list != null) {
                int count = 0;
                for (CapstonesDTO p : list) {
                    count++;
        %>
        <form action="MainController" method="POST">
            <tr>
                <td><%=count%></td>
                <td>
                    <input type="text" name="ID" value="<%=p.getId()%>" readonly>
                </td>
                <td>
                    <input type="text" name="name" value="<%=p.getName()%>"> 
                </td>
                <td>
                    <input type="text" name="description" value="<%=p.getDescription()%>">
                </td>
                <td>
                    <input type="text" name="userID" value="<%=p.getUserID()%>">
                </td>
                <td>
                    <button name="action" value="Update">Update</button>
                    <input type="hidden" name="search" value="<%=search%>">
                </td> 
            </tr>
        </form>
        <% }
            } %>
    </tbody>
</table>
 
    </body>

</html>
