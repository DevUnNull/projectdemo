<%-- 
    Document   : viewCart
    Created on : Feb 28, 2023, 9:07:46 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
        <style>
            a {
                text-decoration: none;
                color: #000
            }

            table, td, th {
                border: 1px solid #000
            }</style>
    </head>
    <body>
        <c:set var="cart" value="${requestScope.cart}"></c:set>
            <h1>Your Shopping cart</h1>
            <!--your code here-->
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach begin="1" end="${cart.size()}" var="i">
                    <tr>
                        <td>${i}</td>
                        <td>${cart.get(i - 1).getId()}</td>
                        <td>${cart.get(i - 1).getName()}</td>
                        <td>${cart.get(i - 1).getDescription()}</td>
                        <td>${cart.get(i - 1).getPrice()}</td>
                        <td>${cart.get(i - 1).getQuantity()}</td>
                        <td><button><a href="/PE_PRJ301_SPRING23/MainController?action=remove_cart&id=${cart.get(i - 1).getId()}">Remove</a></button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            <a href="/PE_PRJ301_SPRING23/MainController">Back to products</a>
    </body>
</html>
