<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh Sách Sinh Viên</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Sinh Viên</th>
        <th>Ngày Sinh</th>
        <th>Lớp</th>
    </tr>
    <c:forEach var="student" items="${studentList}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dob}</td>
            <td>${student.className}</td>
        </tr>
    </c:forEach>
</table>