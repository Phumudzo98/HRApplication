<%-- 
    Document   : view
    Created on : Oct 25, 2023, 3:38:41 AM
    Author     : phumu
--%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.Employee"%>
<%@page import="Stateful.employeeInterface"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="viewClass.css">
        <title>JSP Page</title>
    </head>
    <body>
        
            <%
                employeeInterface ei = (employeeInterface) request.getSession().getAttribute("bean");
                InitialContext ic = new InitialContext();
                
                if(ei ==null)
                {
                    ei =(employeeInterface) ic.lookup("Stateful.employeeInterface");
                }
            
                List<Employee> emp=ei.getAll();
                
                
                
                for(Employee employee:emp)
                {
                    %>
                    
                    <p class="body"><%=employee.getName()%>&nbsp;<%=employee.getSurname()%>&nbsp;earns <%=employee.getSalary()%>&nbsp;monthly at the <%=employee.getDept()%> department.</p><br>
                    
                    <%
                }
            %>
            
        
    </body>
</html>
