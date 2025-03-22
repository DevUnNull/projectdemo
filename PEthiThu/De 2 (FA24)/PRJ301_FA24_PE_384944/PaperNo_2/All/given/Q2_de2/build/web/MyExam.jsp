<%-- 
    Document   : MyExam
    Created on : Mar 7, 2025, 11:05:05 PM
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
        <form action="exe" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter a string (str):</td>
                        <td><input type="text" name="str" value="${param.str}"></td>
                    </tr>
                    <tr>
                        <td>Choose an option:</td>
                        <td><select name="opt" >
                                <option value="Consonant characters" <c:if test="${param.opt eq 'Consonant characters'}">selected=""</c:if> >Consonant characters</option>
                                <option value="Length of string" <c:if test="${param.opt eq 'Length of string'}">selected=""</c:if>>Length of string</option>

                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Result:</td>
                            <td><input type="text" name="res" value="${res}"></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="EXECUTE"></td>
                        <td style="font-weight: bold">${msg}</td>
                    </tr>
                </tbody>
            </table>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th>String str</th>
                    <th>Option</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td>${o.str}</td>
                        <td>${o.opt}</td>
                        <td>${o.res}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
