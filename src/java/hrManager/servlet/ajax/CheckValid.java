/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HRManager.servlet.ajax;

import HRManager.ValidData;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CheckValid extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/xml");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter();
        String check = request.getParameter("check");
        String value = request.getParameter("value");
        try {
            ValidData valid = new ValidData();
            if (check.equals("email")) {
                if (valid.isEmail(value)) {
                    out.write("");
                } else {
                    out.write("This isn't a Email Address !");
                }
            } else if (check.equals("birth")) {
                if (valid.isDate(value)) {
                    out.write("");
                } else {
                    out.write("This isn't Date Format !");
                }
            } else if (check.equals("hire")) {
                if (valid.isDate(value)) {
                    out.write("");
                } else {
                    out.write("This isn't Date Format !");
                }
            } else if (check.equals("first")) {
                if (value.equals("") || value == null) {
                    out.write("First Name must not blank !");
                } else {
                    out.write("");
                }
            }else if (check.equals("last")) {
                if (value.equals("") || value == null) {
                    out.write("Last Name must not blank !");
                } else {
                    out.write("");
                }
            }else if (check.equals("home")) {
                if (valid.isPhone(value)) {
                    out.write("");
                } else {
                    out.write("This isn't Telephone Number !");
                }
            }else if (check.equals("mobile")) {
                if (valid.isPhone(value)) {
                    out.write("");
                } else {
                    out.write("This isn't Telephone Number !");
                }
            }
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
