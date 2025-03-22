<!DOCTYPE html>
<html>
    <head>
        <title>Sum Odd/Even</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="sum" method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Enter an integer number n: <input type="text" name="nb"></td>
                        <td>
                            <table border="1">
                                <tr>
                                    <td><input type="radio" name="opt" value="odd"> Sum odd</td>
                                </tr>
                                <tr>
                                    <td><input type="radio" name="opt" value="even"> Sum even</td>
                                </tr>
                            </table>
                        </td>
                        <td><input type="submit" value="Execute"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
