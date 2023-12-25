/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Stateful.employeeInterface;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Address;
import pojo.Employee;
import javax.swing.JOptionPane;

/**
 *
 * @author phumu
 */
@WebServlet(urlPatterns = {"/EmpSer"})
public class EmpSer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            //Providing a link to the Session bean
            InitialContext ic = new InitialContext();
            
            employeeInterface ei = (employeeInterface) request.getSession().getAttribute("bean");
            
            //If first connection returns a null, use another alternative
            if (ei == null)
            {
                ei = (employeeInterface)ic.lookup("Stateful.employeeInterface");
            }
            
            
            //extract value from a button on the index.html
            String choice=request.getParameter("button");
            
            
            //use the value in the variable choice to determine the selection of the client
            if(choice.equals("add"))
            {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                int age = Integer.parseInt(request.getParameter("age"));
                String department = request.getParameter("department");
                double salary =Double.parseDouble(request.getParameter("salary"));
                
                int streetNo=Integer.parseInt(request.getParameter("streetNumber"));
                String streetName=request.getParameter("streetName");
                String town = request.getParameter("town");
                int postalCode = Integer.parseInt(request.getParameter("postalCode"));
                
                Employee emp = new Employee();
                
                emp.setAge(age);
                emp.setDept(department);
                emp.setSalary(salary);
                emp.setSurname(surname);
                emp.setName(name);
                
                Address empAdd = new Address();
                
                empAdd.setStreetNo(streetNo);
                empAdd.setStreetName(streetName);
                empAdd.setTown(town);
                empAdd.setPostalCode(postalCode);
                
                ei.addEmployee(emp,empAdd);
                //JOptionPane.showMessageDialog(null, "Employee has been added","Employee system", JOptionPane.INFORMATION_MESSAGE);
                request.getSession().setAttribute("bean", ei);
                
                response.sendRedirect("index.html");
                
            }
            else if(choice.equals("view"))
            {
                response.sendRedirect("view.jsp");
            }
            else if(choice.equals("remove"))
            {
                int empID = Integer.parseInt(request.getParameter("empID"));
                
                ei.removeEmployee(empID);
                request.getSession().setAttribute("bean", ei);
                response.sendRedirect("index.html");
            }//Update certain profile of an employee
            else if (choice.equals("update"))
            {
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                int age = Integer.parseInt(request.getParameter("age"));
                String department = request.getParameter("department");
                double salary =Double.parseDouble(request.getParameter("salary"));
                int empID = Integer.parseInt(request.getParameter("empID"));
                
                ei.updateEmp(empID, name, surname, age, department, salary);
                
                response.sendRedirect("index.html");
            }//Display report
            else if (choice.equals("report"))
            {
                response.sendRedirect("report.jsp");
            }
            
            
            
        } catch (NamingException ex) {
            Logger.getLogger(EmpSer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
