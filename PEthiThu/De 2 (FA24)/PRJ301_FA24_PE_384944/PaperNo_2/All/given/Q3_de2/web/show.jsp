<%-- 
    Document   : show
    Created on : Mar 8, 2025, 2:25:37 PM
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
        <form action="search" method="post" style="margin-bottom: 20px">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Choose an option:</td>
                        <td><select name="opt">
                                <option value="all" <c:if test="${param.opt eq 'all'}">selected=""</c:if> >All types</option>
                                <c:forEach items="${listT}" var="o">
                                <option value="${o.typeID}" <c:if test="${param.opt != 'all' && param.opt eq o.typeID}">selected=""</c:if> >${o.typeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input type="submit" name="submit" value="FILTER"></td>
                    </tr>
                    <tr>
                        <td>Enter a result:</td>
                        <td><input type="text" name="res" value="${param.res}"></td>
                        <td><input type="submit" name="submit" value="SEARCH"></td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        Result of Filter/Search
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>String str</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${listE}" var="o">
                <tr>
                    <td>${o.executionID}</td>
                    <td>${o.inputString}</td>
                    <td>${o.result}</td>
                    <td>${o.type.typeName}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
