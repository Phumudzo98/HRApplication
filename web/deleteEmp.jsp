<%-- 
    Document   : deleteEmp
    Created on : Dec 25, 2023, 5:39:53 PM
    Author     : phumu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Employee</title>
    </head>
    <body>
        <form action="EmpSer" method="get">
            
         <p>Enter employee ID</p><input type="text" name="empID"><br>
          
         <input type="submit" value="remove" name="button"><br>
         
         </form>
    </body>
</html>
