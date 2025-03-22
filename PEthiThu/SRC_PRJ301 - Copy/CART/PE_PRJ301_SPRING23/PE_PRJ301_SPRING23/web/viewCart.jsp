<%-- 
    Document   : viewCart
    Created on : Feb 28, 2023, 9:07:46 PM
    Author     : hd
--%>

<%@page import="pe.spring23.shopping.Product"%>
<%@page import="pe.spring23.shopping.CART"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>Your Shopping Cart</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total Price</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="cart" value="${sessionScope.cart}" />
                <c:set var="counter" value="0" />
                <c:set var="totalPrice" value="0" />
                <c:forEach items="${cart.items}" var="item">
                    <c:set var="counter" value="${counter + 1}" />
                    <c:set var="itemTotal" value="${item.quantity * item.product.price}" />
                    <c:set var="totalPrice" value="${totalPrice + itemTotal}" />
                    <tr>
                        <td>${counter}</td>
                        <td>${item.product.productID}</td>
                        <td>${item.product.productName}</td>
                        <td>${item.product.description}</td>
                        <td>${item.quantity}</td>
                        <td>${item.product.price}</td>
                        <td>${itemTotal}</td>
                        <td>
                            <form action="MainController" method="get">
                                <input type="hidden" name="productID" value="${item.product.productID}" />
                                <button type="submit" name="action" value="Remove">Remove</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <h2>Total ${totalPrice} Triệu</h2>
        <a href="shopping.jsp" >Add more</a>
    </body>
</html>
