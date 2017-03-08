/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hrManager.servlet;

import hrManager.entities.Employee;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EmployeeManager extends HttpServlet {

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
        }
        hrManager.bol.EmployeeBO ebo = new hrManager.bol.EmployeeBO();
        request.setAttribute("EmpBO", ebo);
        String valueTxt = request.getParameter("txtValue");
        String optionSearch = request.getParameter("ddlSearch");
        if (valueTxt == null || optionSearch == null) {
            ArrayList<Employee> empList = new ArrayList();
            String option = request.getParameter("option").toString();
            String value = request.getParameter("value");
            if (option == null || value == null) {
                empList = ebo.select();
            } else {
                if (option.equals("Name")) {
                    empList = ebo.find(0, value);

                } else if (option.equals("City")) {
                    empList = ebo.find(1, value);
                }
            }
            //Phần này em tìm hiểu nó sau thầy nhé
            hrManager.ConvertData convert = new hrManager.ConvertData();

            RequestDispatcher reqdis = request.getRequestDispatcher("employeeManager.jsp");
            if (empList.size() > 0) {
                request.setAttribute("searchResult", empList);
            }
            reqdis.forward(request, response);
        } else {
            RequestDispatcher reqdis = request.getRequestDispatcher("employeeManager.jsp?option=" + optionSearch + "&value=" + valueTxt);
            reqdis.forward(request, response);
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
