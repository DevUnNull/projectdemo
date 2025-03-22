<%@page import="item.ItemDTO"%>
<%@page import="java.util.List"%>
<%@page import="user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null) {
                response.sendRedirect("login.jsp");
            }
            String fromValue = request.getParameter("fromValue");
            if (fromValue == null) {
                fromValue = "";
            }
            String toValue = request.getParameter("toValue");
            if (toValue == null) {
                toValue = "";
            }
        %>
        <h1>Welcome <%= loginUser.getFullName()%> </h1>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Logout" />
        </form>
        <form action="MainController" method="POST">
            From value:<input type="text" name="fromValue" value="<%= fromValue%>" />
            To value:<input type="text" name="toValue" value="<%= toValue%>" />
            <input type="submit" name="action" value="Search" />
        </form>

        <%
            List<ItemDTO> list_item = (List<ItemDTO>) session.getAttribute("LIST_ITEM");
            if (list_item != null) {
                if (!list_item.isEmpty()) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Subtotal</th>
                    <th>Remove</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 0;
                    for (ItemDTO item : list_item) {
                        count++;
                %>
            <form action="MainController" method="POST">
                <tr>
                    <td> <%= count%> </td>
                    <td> <%= item.getId()%> </td>
                    <td> <%= item.getName()%> </td>
                    <td> <%= item.getPrice()%> </td>
                    <td> <%= item.getQuantity()%> </td>
                    <td> <%= item.getQuantity() * item.getPrice()%> </td>
                    <td>
                        <input type="hidden" name="fromValue" value="<%= fromValue%>" />
                        <input type="hidden" name="toValue" value="<%= toValue%>" />
                        <input type="hidden" name="itemID" value="<%= item.getId() %>" />
                        <input type="submit" name="action" value="Remove" />
                    </td>
                </tr>
            </form>
            <%
                }
            %>

        </tbody>
    </table>
    <%
            }
        }

    %>


</body>
</html>
