<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h2>Danh Sách Tài Khoản</h2>
<table>
    <tr>
        <th>ID</th>
        <th>Tên Đăng Nhập</th>
        <th>Vai Trò</th>
    </tr>
    <c:forEach var="account" items="${accountList}">
        <tr>
            <td>${account.id}</td>
            <td>${account.username}</td>
            <td>${account.role}</td>
        </tr>
    </c:forEach>
</table>