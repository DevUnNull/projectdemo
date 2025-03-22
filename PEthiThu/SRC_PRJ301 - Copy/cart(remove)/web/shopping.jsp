<%-- 
    Document   : index
    Created on : Feb 28, 2023, 9:01:26 PM
    Author     : Hoadnt
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
        <style>
            a {
                text-decoration: none;
                color: #000
            }
            
            table, td, th {
                border: 1px solid #000
            }
        </style>
    </head>
    <body>
        <c:set value="${requestScope.products}" var="products"></c:set>
            <h1>Welcome to Thinh's shop</h1>
            <!--your code here-->
            <button><a href="/PE_PRJ301_SPRING23/MainController?action=get_products">Get All</a></button>
            <button><a href="/PE_PRJ301_SPRING23/MainController?action=get_cart">View Cart</a></button>
            <table>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>Add</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach begin="1" end="${products.size()}" var="i">
                    <tr>
                        <td>${i}</td>
                        <td>${products.get(i - 1).getProductId()}</td>
                        <td>${products.get(i - 1).getProductName()}</td>
                        <td>${products.get(i - 1).getDescription()}</td>
                        <td>${products.get(i - 1).getPrice()}</td>
                        <td><button><a href="/PE_PRJ301_SPRING23/MainController?action=add_cart&id=${products.get(i - 1).getProductId()} ">Add</a></button></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
