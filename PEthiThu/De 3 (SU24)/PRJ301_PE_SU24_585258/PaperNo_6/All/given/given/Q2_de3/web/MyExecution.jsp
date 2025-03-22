<%-- 
    Document   : MyExecution
    Created on : Mar 8, 2025, 7:53:37 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="sum" method="post" style="margin-bottom: 20px">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter an integer array:</td>
                        <td><input type="text" name="arr" value="${param.arr}"></td>
                    </tr>
                    <tr>
                        <td>Choose an option:</td>
                        <td><input checked="" type="radio" name="opt" value="odd">Odd
                            <input <c:if test="${param.opt == 'even'}">checked=""</c:if> type="radio" name="opt" value="even">Even</td>
                        </tr>
                        <tr>
                            <td>Result:</td>
                            <td><input type="text" name="res" value="${res}"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="COUNT"></td>
                        <td style="font-weight: bold">${msg}</td>
                    </tr>
                </tbody>
            </table>
        </form>

        List of Executions:
        <table border="1">
            <thead>
                <tr>
                    <th>Array</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td>${o.arr}</td>
                        <td>${o.opt}</td>
                        <td>${o.res}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
