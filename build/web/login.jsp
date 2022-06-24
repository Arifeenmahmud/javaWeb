<%-- 
    Document   : login
    Created on : Jun 12, 2022, 4:09:09 PM
    Author     : Arifeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">Please Give your ID and Name!</h1>

        <form method="post" action="mystudent2">
            <table align="center">
                <tr>
                    <td>Student Id:</td>
                    <td><input type="text" name="stdId"></td>
                </tr>
                <tr>
                    <td>Student Name :</td>
                    <td><input type="text" name="stdname"></td>
                </tr>

                <tr>
                    <td><input type="submit" value="Login" name="login"></td>

                </tr>
            </table>
        </form>
    </body>
</html>
