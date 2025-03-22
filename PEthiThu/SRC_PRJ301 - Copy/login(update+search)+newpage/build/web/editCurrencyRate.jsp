<%@page import="pe.models.CurrencyDTO"%>
<%@page import="pe.DAO.DAO"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Currency Rate</title>
    <style>
        
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
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            box-sizing: border-box;
        }

        button {
            background-color: #333;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
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
    
    <h2>Update Currency Rate</h2>
    <% String code = request.getParameter("code");
    System.out.println(code);
        DAO dao = new DAO();
    CurrencyDTO a = dao.getObject(code); %>
    <form action="MainController" id="updateCurrencyForm">
        <label for="code">Code:</label>
        <input type="text" id="code" name="code" value="<%=code %>" required readonly>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="<%=a.getName()%>" required>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" value="<%=a.getDescription()%>" required>

        <label for="rate">Rate:</label>
        <input type="number" id="rate" name="rate" value="<%=a.getRate()%>" required>

        <input type="submit" name="action" value="Update" onclick=" return updateCurrency()">
    </form>

    <script>
          function updateCurrency() {
      const rateInput = document.getElementById("rate");
      const rate = parseFloat(rateInput.value);

      if (rate < 0) {
        alert("Error: Rate cannot be negative.");
        return false; // Prevent form submission
      } else {
        // Proceed with form submission (if needed)
        alert("Currency rate updated successfully!");
      }
    }
    </script>
</body>

</html>