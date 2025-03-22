<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page import="java.util.List"%>
<%@page import="pe.models.FurnitureDTO"%>
<%@page import="pe.models.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !user.getRoleID().equals("admin")) {
                response.sendRedirect("login.jsp");
                return;
            }
            List<FurnitureDTO> list = (List<FurnitureDTO>) request.getAttribute("LIST_FURNITURE");
            String search = request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>
        <h1>Welcome <%=user.getFullName()%></h1>       
        <form action="MainController">
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
                    <th>Price</th>
                    <th>Dimensions</th>
                    <th>Material</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <%if (list != null) {
                        int count = 0;
                        for (FurnitureDTO p : list) {
                            count++;
                %>

                <tr>
                    <td><%=count%></td>
                    <td>
                        <%=p.getId()%>
                    </td>
                    <td>
                        <%=p.getName()%>
                    </td>
                    <td>
                        <%=p.getDescription()%>
                    </td>
                    <td>
                        <%=p.getPrice()%>
                    </td>
                    <td>
                        <%=p.getDimensions()%>
                    </td>
                    <td>
                        <%=p.getMaterial()%>
                    </td>
                    <td>
                        <%=p.isStatus()%>
                    </td>
                    <td>
                        <a href="MainController?action=Delete&search=<%=search%>&id=<%=p.getId()%>">Delete</a>
                    </td>
                </tr>
                <% }
                    }%>
            </tbody>
        </table>   
    </body>
</html>
