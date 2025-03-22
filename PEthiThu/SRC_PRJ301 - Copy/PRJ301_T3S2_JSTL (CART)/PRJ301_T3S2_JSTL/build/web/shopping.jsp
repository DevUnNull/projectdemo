

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.ProductDAO"%>
<%@page import="java.util.List"%>
<%@page import="sample.shopping.Comestics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Comestics Store</title>
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
                    <h1 class="display-4 fw-bolder" style="color: white">Comestics Store</h1>
                    <p class="lead fw-normal text-white-50 mb-0">
                        Good to the last drop!
                    </p>
                </div>
            </div>
        </header>
        <div>Welcome to my store</div>

        Select your clothes:

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity Left</th>
                    <th>Quantity</th>
                    <th>Add</th>
                    <th>View</th>
                </tr>
            </thead>  
            <tbody>
                <c:forEach var="item" varStatus="counter" items="${requestScope.LIST_COMES}">
                <form action="MainController" method="POST">
                    <tr>
                        <td>${counter.count}</td>
                        <td>
                            <input type="text" name="id" value="${item.id}" readonly="">
                        </td>
                        <td>
                            <input type="text" name="name" value="${item.name}" readonly="">
                        </td>
                        <td>
                            <input type="text" name="price" value="${item.price}" readonly="">
                        </td>
                        <td>
                            <input type="text" name="quantity" value="${item.quantity}" readonly="">
                        </td>
                        <td><input name="cmbQuantity" type="number" min="1"></td>
                        <td><input type="submit" name="action" value="Add"/></td>
                        <td><input type="submit" name="action" value="View"/></td>
                    </tr>

                </form>
            </c:forEach>


        </tbody>
    </table>   


    ${requestScope.MESSAGE}
</body>
<%@include file="components/footerComponent.jsp" %>

</html>
