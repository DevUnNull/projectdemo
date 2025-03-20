<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh Sách Giáo Viên</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Giáo Viên</th>
        <th>Ngày Sinh</th>
    </tr>
    <c:forEach var="teacher" items="${teacherList}">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.name}</td>
            <td>${teacher.dob}</td>
        </tr>
    </c:forEach>
</table>