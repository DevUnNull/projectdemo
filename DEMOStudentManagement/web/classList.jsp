<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh Sách Lớp Học</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Lớp</th>
    </tr>
    <c:forEach var="class" items="${classList}">
        <tr>
            <td>${class.id}</td>
            <td>${class.name}</td>
        </tr>
    </c:forEach>
</table>