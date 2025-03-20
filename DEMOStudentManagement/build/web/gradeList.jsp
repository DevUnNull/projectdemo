<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh Sách Điểm</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Sinh Viên</th>
        <th>Môn Học</th>
        <th>Điểm</th>
    </tr>
    <c:forEach var="grade" items="${gradeList}">
        <tr>
            <td>${grade.id}</td>
            <td>${grade.studentId}</td>
            <td>${grade.subjectId}</td>
            <td>${grade.score}</td>
        </tr>
    </c:forEach>
</table>