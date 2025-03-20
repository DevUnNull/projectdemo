<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <style>
        body {
            margin: 0;
            font-family: Arial, sans-serif;
            display: flex;
        }
        .sidebar {
            width: 250px;
            background-color: #2c3e50;
            color: white;
            height: 100vh;
            padding-top: 20px;
        }
        .sidebar .profile {
            text-align: center;
            margin-bottom: 30px;
        }
        .sidebar .profile img {
            width: 80px;
            height: 80px;
            border-radius: 50%;
        }
        .sidebar a {
            display: block;
            padding: 15px 20px;
            color: white;
            text-decoration: none;
            font-size: 16px;
        }
        .sidebar a:hover {
            background-color: #34495e;
        }
        .logout {
            background-color: #e74c3c;
            margin: 20px;
            text-align: center;
            border-radius: 5px;
        }
        .content {
            flex: 1;
            padding: 20px;
            background-color: #ecf0f1;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #34495e;
            color: white;
        }
    </style>
</head>
<body>
    <div class="sidebar">
        <div class="profile">
            <img src="https://via.placeholder.com/80" alt="Admin Avatar">
            <h3>Admin</h3>
        </div>
        <a href="AdminController">Quản Lý Tài Khoản</a>
        <a href="ClassController">Quản Lý Lớp Học</a>
        <a href="StudentController">Quản Lý Sinh Viên</a>
        <a href="TeacherController">Quản Lý Giáo Viên</a>
        <a href="GradeController">Quản Lý Điểm</a>
        <a href="LogoutServlet" class="logout">Đăng Xuất</a>
    </div>
    <div class="content">
        <!-- Nội dung sẽ được hiển thị ở đây -->
        <%
            String contentPage = (String) request.getAttribute("contentPage");
            if (contentPage != null) {
                request.getRequestDispatcher(contentPage).include(request, response);
            } else {
        %>
            <h2>Chào mừng đến với trang quản trị</h2>
        <% } %>
    </div>
</body>
</html>