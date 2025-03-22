<%-- 
    Document   : show2
    Created on : Mar 6, 2025, 7:49:57 PM
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
        List of Instructors:
        <table border="1"style="margin-bottom: 20px">
            <tbody>
                <tr>
                    <td>Code</td>
                    <td>Name</td>
                    <td>Date of birth</td>
                    <td>Gender</td>
                    <td>Subject</td>
                </tr>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td>${o.instructorID}</td>
                        <td>${o.instructorName}</td>
                        <td>${o.birthDate}</td>
                        <td>${o.gender ? 'Male':'Female'}</td>
                        <td>${o.subject.subjectName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
