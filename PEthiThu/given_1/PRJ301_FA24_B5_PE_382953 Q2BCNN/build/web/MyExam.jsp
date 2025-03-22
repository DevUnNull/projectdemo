<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>LCM Calculator</title>
</head>
<body>
    <h2>Enter three integers:</h2>
    <form action="bcnn" method="post">
        Enter integer number 1: <input type="text" name="number1"><br>
        Enter integer number 2: <input type="text" name="number2"><br>
        Enter integer number 3: <input type="text" name="number3"><br>
        <input type="submit" value="EXECUTE LCM">
    </form>
    Result: <input type="text" ${message}>
    
    <table border="1">
        <tr>
            <th>Number 1</th>
            <th>Number 2</th>
            <th>Number 3</th>
            <th>Result</th>
        </tr>
        <c:forEach var="record" items="${history}">
            <tr>
                <td>${record.num1}</td>
                <td>${record.num2}</td>
                <td>${record.num3}</td>
                <td>${record.result}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
