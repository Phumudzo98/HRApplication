<%-- 
    Document   : report
    Created on : Oct 25, 2023, 10:05:40 PM
    Author     : phumu
--%>

<%@page import="java.util.List"%>
<%@page import="pojo.Employee"%>
<%@page import="Stateful.employeeInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
           employeeInterface ei = (employeeInterface)request.getSession().getAttribute("bean");
           
           List<Employee> collect=ei.getAll();
           
           double salaries =0;
           double avgAge=0;
           int numPeople=0;
           
           for(Employee employee: collect)
           {
               
                      salaries = salaries +  employee.getSalary();
                      avgAge = avgAge + employee.getAge();
                      numPeople++;
           }
           
           
               %>
               
               <p>The amount of money being spent on salary in this company is a total of: R<%=salaries%>
                   which in average is <%=salaries/numPeople%></p><br>
               <p>The total average age in a <%=numPeople%> people company is: <%=avgAge/numPeople%>
    </body>
</html>
