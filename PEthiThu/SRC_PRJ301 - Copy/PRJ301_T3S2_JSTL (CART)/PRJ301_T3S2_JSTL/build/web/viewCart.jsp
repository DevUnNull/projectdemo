

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.shopping.Comestics"%>
<%@page import="sample.shopping.Cart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
            />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>ViewCart Page</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
            rel="stylesheet"
            />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-w
                     hite">
                    <h1 class="display-4 fw-bolder" style="color: white">Your shopping Cart</h1>
                    <p class="lead fw-normal text-white-50 mb-0">
                    </p>
                </div>
            </div>
        </header>
        <h1>These are the products you want: </h1>
    <body>
        <c:if test="${sessionScope.CART != null}">
            <c:if test="${not empty sessionScope.CART}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Edit</th>
                            <th>Remove</th>
                            <th>Total</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set value="0.0" var="sum" scope="page"/>
                        <c:forEach var="comestics" varStatus="counter" items="${sessionScope.CART.cart}">   
                        <form action="MainController" method="POST">
                            <tr> 
                                <td> ${counter.count} </td>
                                <td>
                                    <input type="text" name="id" value="${comestics.value.id}" readonly=""/>
                                </td>
                                <td>
                                    <input type="text" name="name" value="${comestics.value.name}"/>
                                </td>
                                <td>
                                    <input type="number" name="quantity" value="${comestics.value.quantity}" required="" min="1"/>
                                </td>
                                <td>${comestics.value.price}</td>
                                <th>
                                    <input type="submit" name="action" value="Edit"/>
                                    <input type="hidden" name="id" value="${comestics.value.id}"/>
                                    <input type="hidden" name="name" value="${comestics.value.name}"/>
                                </th>
                                <td>
                                    <a href="MainController?action=Remove&id=${comestics.value.id}">Remove</a>
                                </td>
                                <td>${comestics.value.quantity*comestics.value.price}$</td> 
                                <c:set value="${sum + (comestics.value.quantity*comestics.value.price)}" var="sum" scope="page"/>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>
            ${sessionScope.ERROR}
            <h1>Total : <c:out value="${sum}"/></h1>
            <a href="MainController?action=Shopping_Page">Add more</a>
        </c:if>
    </c:if>
    <a href="MainController?action=Shopping_Page">Add more</a>
</body>
<%@include file="components/footerComponent.jsp" %>
</html>
