<%--  
    Document   : MyExam
    Created on : Mar 3, 2025, 8:23:17 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Import thư viện JSTL Core để sử dụng các thẻ lặp, điều kiện, ... --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%> <%-- Cấu hình mã hóa UTF-8 để hiển thị đúng tiếng Việt --%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> <%-- Định dạng charset UTF-8 cho trang web --%>
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Form nhập ba số nguyên để tính toán LCM --%>
        <form action="bcnn" method="post"> <%-- Gửi dữ liệu đến servlet hoặc controller có URL mapping là "bcnn" --%>
            <table border="0">
                <tbody>
                    <tr>
                        <td>Enter integer number 1:</td>
                        <td><input type="text" name="a" value="${param.a}"></td> <%-- Ô nhập số nguyên thứ nhất, hiển thị lại giá trị nếu có --%>
                    </tr>
                    <tr>
                        <td>Enter integer number 2:</td>
                        <td><input type="text" name="b" value="${param.b}"></td> <%-- Ô nhập số nguyên thứ hai --%>
                    </tr>
                    <tr>
                        <td>Enter integer number 3:</td>
                        <td><input type="text" name="c" value="${param.c}"></td> <%-- Ô nhập số nguyên thứ ba --%>
                    </tr>
                    <tr>
                        <td><input type="submit" value="EXECUTE LCM"></td> <%-- Nút thực thi tính toán LCM --%>
                        <td style="font-weight: bold">${msg}</td> <%-- Hiển thị thông báo lỗi hoặc trạng thái nếu có --%>
                    </tr>
                    <tr>
                        <td>Result:</td>
                        <td><input type="text" value="${res}" name="result"></td> <%-- Hiển thị kết quả LCM sau khi tính --%>
                    </tr>
                </tbody>
            </table>
        </form>

        <%-- Bảng hiển thị lịch sử tính toán LCM --%>
        <table border="1" style="margin-top: 20px">
            <thead>
                <tr>
                    <th>Number 1</th>
                    <th>Number 2</th>
                    <th>Number 3</th>
                    <th>Result</th>
                </tr>
            </thead>
            <tbody>
                <%-- Duyệt danh sách kết quả lịch sử từ biến "list" và hiển thị từng dòng --%>
                <c:forEach items="${list}" var="o">
                    <tr>
                        <td>${o.a}</td> <%-- Hiển thị số nguyên thứ nhất --%>
                        <td>${o.b}</td> <%-- Hiển thị số nguyên thứ hai --%>
                        <td>${o.c}</td> <%-- Hiển thị số nguyên thứ ba --%>
                        <td>${o.result}</td> <%-- Hiển thị kết quả LCM --%>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
