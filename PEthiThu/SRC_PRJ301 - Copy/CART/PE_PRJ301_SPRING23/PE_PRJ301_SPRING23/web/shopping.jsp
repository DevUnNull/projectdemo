<%-- 
    Document   : index
    Created on : Feb 28, 2023, 9:01:26 PM
    Author     : Hoadnt
--%>

<%@page import="pe.spring23.shopping.Product"%>
<%@page import="java.util.List"%>
<%@page import="pe.spring23.shopping.DAO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <h1>Welcome to Thinh's shop</h1>
        <!--your code here-->
        <form action="MainController">
            <button name="action" value="getAll">getAll</button>
        </form>
        <a href="viewCart.jsp"><button>ViewCart</button></a>

        <%
            List<Product> a = (List) session.getAttribute("LIST");
            if (a != null) {
                if (a.size() > 0) {
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (Product i : a) {
                        if (i.getStatus() == 1) {
                %>
            <form action="MainController">
                <tr>
                    <td><%=count++%></td>
                    <td><input type="text" name="productID" value="<%= i.getProductID()%>"></td>
                    <td><input type="text" name="productName" value="<%= i.getProductName()%>"></td>
                    <td><input type="text" name="description" value="<%= i.getDescription()%>"></td>
                    <td><input type="text" name="price" value="<%= i.getPrice()%>"></td>
                    <td><button name="action" value="add">Add</button></td>
                </tr>
            </form>
            <%
                    }
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
