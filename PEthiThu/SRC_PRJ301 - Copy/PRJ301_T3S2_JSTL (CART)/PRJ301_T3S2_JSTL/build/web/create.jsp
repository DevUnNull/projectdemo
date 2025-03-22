<%@page import="sample.user.UserError"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/login.css">
        <title>Create User</title>

    </head>

    <body>

        <div id="logreg-forms">
            <form action="MainController" method="POST">
                <h1 class="h3 mb-3 font-weight-normal" style="text-align: center"> Create User</h1>
                User ID: <input type="text" name="userID" required=""/> 
                <div class="d-block mx-4 mb-3 mb-lg-4  text-danger"><b>${requestScope.USER_ERROR.userIDError}</b></div>
                </br>Full Name: <input type="text" name="fullName" required=""/>
                <div class="d-block mx-4 mb-3 mb-lg-4  text-danger"><b>${requestScope.USER_ERROR.fullNameError}</b></div>
                </br>Role ID: <input type="text" name="roleID" value="US"readonly=""/>
                </br>Password: <input type="password" name="password" required=""/>
                </br>Confirm: <input type="password" name="confirm" required=""/>
                <div class="d-block mx-4 mb-3 mb-lg-4  text-danger"><b>${requestScope.USER_ERROR.confirmError}</b></div>
                </br><input type="submit" name="action" value="Create"/>
                <input type="reset" value="reset" />
            </form>

        </div>                          
    </body>

</html>

