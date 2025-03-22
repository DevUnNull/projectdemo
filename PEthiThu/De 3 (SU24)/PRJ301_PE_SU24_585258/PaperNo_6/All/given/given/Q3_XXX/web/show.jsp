<%-- 
    Document   : show
    Created on : Mar 13, 2025, 7:41:18 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        List of Executions:
        <table border="1">
            <thead>
                <tr>
                    <th>ExecutionID</th>
                    <th>Array</th>
                    <th>Result</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listE}" var="o">
                    <tr>
                        <td> <a href="show?eid=${o.executionID}">${o.executionID}</a>  </td>
                        <td>
                            <c:forEach items="${o.arr}" var="i">     
                                ${i.arrayItem} 
                            </c:forEach>

                        </td>
                        <td>${o.result}</td>
                        <td><a href="delete?eid=${o.executionID}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        
        <table border="0">
            <tbody>
                <tr>
                    <td>ExecutionID:</td>
                    <td><input type="text" name="id" value="${exe.executionID}"></td>
                </tr>
                <tr>
                    <td>Array:</td>
                    <td><input type="text" name="arr" value="${arr}"></td>
                </tr>
                <tr>
                    <td>Result:</td>
                    <td><input type="text" name="res" value="${exe.result}"></td>
                </tr>
            </tbody>
        </table>


    </body>
</html>
