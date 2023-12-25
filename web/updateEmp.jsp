<%-- 
    Document   : updateEmp
    Created on : Dec 25, 2023, 5:40:32 PM
    Author     : phumu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
    </head>
    <body>
        
        <form action="EmpSer" method="post">
            
            <p>Enter employee ID</p><input type="text" name="empID"><br>
            <p>Enter employee name: <input type="text" name="name"></p><br>
            <p>Enter employee surname: <input type="text" name="surname"></p><br>
            <p>Enter employee age: <input type="text" name="age"></p><br>
            <p>Enter employee department: <input type="text" name="department"></p><br>
            <p>Enter employee salary: <input type="text" name="salary"></p><br>
            
            <p>Enter street number: <input type="text" name="streetNumber"></p><br>
            <p>Enter street name: <input type="text" name="streetName"></p><br>
            <p>Enter Town: <input type="text" name="town"></p><br>
            <p>Enter postal code: <input type="text" name="postalCode"></p><br>
            
            <input type="submit" value="update" name="button"><br>
        </form>
    </body>
</html>
