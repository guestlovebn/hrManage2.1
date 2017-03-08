/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hrManager.servlet;

import hrManager.bol.EmployeeBO;
import hrManager.entities.Employee;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProcessEmployee extends HttpServlet {

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
        HttpSession session = request.getSession(false);
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        EmployeeBO ebo = new hrManager.bol.EmployeeBO();
        Employee e;
        String action = request.getParameter("action");
        String lB = "";
        if (action == null || action.equals("add")) {
            lB = "Add New";
        } else if (action.equals("delete")) {
            lB = "Delete";
        } else if (action.equals("edit")) {
            lB = "Update";
        }
        String id = request.getParameter("id");
        String fName = request.getParameter("txtFirstName");
        String lName = request.getParameter("txtLastName");
        if (lName == null || fName == null) {
            if (action == null || action.equals("add")) {
                e = new Employee();
            } else {
                e = ebo.getByID(Integer.parseInt(id));
            }
            request.setAttribute("e", e);
            request.setAttribute("actionName", action);
            request.setAttribute("empId", id);
            request.setAttribute("lB", lB);
            RequestDispatcher reqdis = request.getRequestDispatcher("processEmployee.jsp");
            reqdis.forward(request, response);
            return;
        }
        if (action != null && action.equals("delete")) {
            try {
                e = ebo.getByID(Integer.parseInt(id));
                if (e == null) {
                    response.sendRedirect("InformationPage.jsp?type=error&msg=No have this EmployeeID");
                } else {
                    if (ebo.delete(e) > 0) {
                        response.sendRedirect("InformationPage.jsp?type=info&msg=This EmployeeID deleted");
                    } else {
                        response.sendRedirect("InformationPage.jsp?type=warning&msg=This EmployeeID can't delete");
                    }
                }
            } catch (NumberFormatException ex) {
                response.sendRedirect("InformationPage.jsp?type=error&msg=This ins't EmployeeID");
                return;
            }
        } else {
            e = new hrManager.entities.Employee();
            hrManager.ConvertData convert = new hrManager.ConvertData();
            e.setFirstName(fName);
            e.setLastName(lName);
            e.setBirthDate(convert.string2date(request.getParameter("txtBirthDate")));
            e.setHireDate(convert.string2date(request.getParameter("txtHireDate")));
            e.setAddress(request.getParameter("txtAddress"));
            e.setCity(request.getParameter("txtCity"));
            e.setCountry(request.getParameter("txtCountry"));
            e.setEmail(request.getParameter("txtEmail"));
            e.setHomePhone(request.getParameter("txtHomePhone"));
            e.setMobile(request.getParameter("txtMobile"));
            e.setNote(request.getParameter("txtNote"));
            if (action.equals("edit")) {
                try {
                    e.setEmployeeID(Integer.parseInt(id));
                    if (ebo.edit(e) > 0) {
                        response.sendRedirect("InformationPage.jsp?type=info&msg=This EmployeeID updated");
                    } else {
                        response.sendRedirect("InformationPage.jsp?type=warning&msg=This EmployeeID can't update");
                    }
                } catch (NumberFormatException ex) {
                    response.sendRedirect("InformationPage.jsp?type=error&msg=This ins't EmployeeID");
                    return;
                }
            } else {
                if (ebo.add(e) > 0) {
                    response.sendRedirect("InformationPage.jsp?type=info&msg=This EmployeeID inserted to database");
                } else {
                    response.sendRedirect("InformationPage.jsp?type=warning&msg=This EmployeeID can't insert to database");
                }
            }
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
            throws ServletException,
            IOException {
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
            throws ServletException,
            IOException {
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
