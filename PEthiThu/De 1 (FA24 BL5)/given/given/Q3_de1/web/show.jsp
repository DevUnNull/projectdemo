<%-- 
    Document   : show
    Created on : Mar 3, 2025, 8:52:08 PM
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

        Detail information:
        <form action="add" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Code:</td>
                        <td><input type="text" name="code"></td>
                        <td>Name:</td>
                        <td><input type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td>Date of birth:</td>
                        <td><input type="text" name="dob"></td>
                        <td>Gender:</td>
                        <td><input type="radio" name="gender" value="1" checked="">Male
                            <input type="radio" name="gender" value="0">Female
                        </td>
                    </tr>
                    <tr>
                        <td>Subject:</td>
                        <td><select name="subject">
                                <c:forEach items="${listS}" var="o">
                                    <option value="${o.subjectID}">${o.subjectName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input type="submit" value="CREATE"></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
        </form>


    </body>
</html>
