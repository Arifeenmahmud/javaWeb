<%-- 
    Document   : form
    Created on : Jun 11, 2022, 6:01:47 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--        <form method ="post" action="mystudent2">
                    <tr>
                        <td>Student Id :<input type="text" name="stdId"></td>
                    </tr>
                       <tr>
                        <td>Student Name :<input type="text" name="stdname"></td>
                        <td>Student Age :<input type="text" name="stage"></td>
                        <td><input type="submit" value="Insert" name="insert"></td>
                        <td><input type="submit" value="Update" name="update"></td>            
                     
                    </tr>
                </form>-->

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
                    <td>Student Age :</td>
                    <td><input type="text" name="stage"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Insert" name="insert"></td>
                    <td><input type="submit" value="Update" name="update"></td>
                     <td><input type="submit" value="Delete" name="delete"></td>
                    <td><input type="submit" value="Show" name="show"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
