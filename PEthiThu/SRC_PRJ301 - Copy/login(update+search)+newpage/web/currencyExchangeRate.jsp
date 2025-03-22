<%@page import="java.util.List"%>
<%@page import="pe.models.CurrencyDTO"%>
<%@page import="pe.models.CurrencyDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Exchange</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        header {
            background-color: #333;
            padding: 10px;
            color: #fff;
            text-align: center;
        }

        nav {
            margin-bottom: 20px;
        }

        nav a {
            text-decoration: none;
            color: #333;
            padding: 10px;
            margin-right: 10px;
            border-radius: 5px;
            background-color: #eee;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>

<body>
    <header>
        <h1>Currency Exchange Rates</h1>
    </header>

    <nav>
        <a href="#">Currency List</a>
        <a href="#">Hello ${sessionScope.LOGIN_USER.name}</a>
        <a href="MainController?action=Logout">Logout</a>
    </nav>
    
    <form action="MainController" id="searchForm">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code">

        <label for="name">Name:</label>
        <input type="text" id="name" name="name">

        <input type="submit" name="action" value="Search" >
    </form>

    <table>
        <thead>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Description</th>
                <th>Rate</th>
                <th>Action</th>
            </tr>
        </thead>
<tbody>
    <% 
        List<CurrencyDTO> list = (List<CurrencyDTO>) request.getAttribute("LIST_Currency");
        if (list != null) {
            for (CurrencyDTO p : list) { 
    %>
                <tr>
                    <td><%= p.getCode() %></td>
                    <td><%= p.getName() %></td>
                    <td><%= p.getDescription() %></td>
                    <td><%= p.getRate() %></td>
                    <td>
                        <a href="editCurrencyRate.jsp?code=<%= p.getCode() %>"><button>Update</button> </a>
                    </td> 
                </tr>
    <% 
            }
        } 
    %>
</tbody>

    </table>
</body>

</html>