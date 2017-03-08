package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class employeeManager_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("\"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Employees Manager</title>\n");
      out.write("        <link href=\"css/menu_style.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

        if (session.getAttribute("username") != null) {
        
      out.write("\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <br>\n");
      out.write("            <h1 align=\"center\">Employees Manager</h1>\n");
      out.write("            <div class=\"menu bubplastic horizontal orange\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"login.jsp\"><span class=\"menu_ar\">Login</span></a></span></li>\n");
      out.write("                    <li class=\"highlight\"><span class=\"menu_r\"><a href=\"employeeManager.jsp\"><span class=\"menu_ar\">Employee Manager</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"ProcessEmployee\"><span class=\"menu_ar\">Add New Employee</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"searchEmployee.jsp\"><span class=\"menu_ar\">Search Employee</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"logout.jsp\"><span class=\"menu_ar\">logout</span></a></span></li>\n");
      out.write("                </ul>\n");
      out.write("                <br class=\"clearit\" />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <br><br>\n");
      out.write("            <table id=\"tb\" width=\"100%\" align=\"center\">\n");
      out.write("                <tr>\n");
      out.write("                    <th colspan=\"11\" height=\"50px\"><h4>EMPLOYEE LIST</h4></th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Bithday Date</th>\n");
      out.write("                    <th>Hire Date</th>\n");
      out.write("                    <th>Address</th>\n");
      out.write("                    <th>City</th>\n");
      out.write("                    <th>Country</th>\n");
      out.write("                    <th>Home Phone</th>\n");
      out.write("                    <th>Mobile</th>\n");
      out.write("                    <th>Email</th>\n");
      out.write("                    <th colspan=\"2\"></th>\n");
      out.write("                </tr>\n");
      out.write("                ");
      HRManager.bol.EmployeeBO ebo = null;
      synchronized (request) {
        ebo = (HRManager.bol.EmployeeBO) _jspx_page_context.getAttribute("ebo", PageContext.REQUEST_SCOPE);
        if (ebo == null){
          ebo = new HRManager.bol.EmployeeBO();
          _jspx_page_context.setAttribute("ebo", ebo, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\n");
      out.write("                ");

            HRManager.entities.Employee[] arr=null;
            String option = request.getParameter("option");
            String value = request.getParameter("value");
            if (option == null || value == null) {
                arr = ebo.select();
            } else {
                if (option.equals("Name")) {
                    arr = ebo.find(0, value);
                } else if (option.equals("City")) {
                    arr = ebo.find(1, value);
                }
            }
            HRManager.ConvertData convert = new HRManager.ConvertData();
            if (arr.length > 0) {
                for (int i = 0; i < arr.length; i++) {
                    out.println("<tr><td>" + arr[i].getFirstName() + " " + arr[i].getLastName() + "</td>");
                    out.println("<td>" + convert.date2string(arr[i].getBirthDate()) + "</td>");
                    out.println("<td>" + convert.date2string(arr[i].getHireDate()) + "</td>");
                    out.println("<td>" + arr[i].getAddress() + "</td>");
                    out.println("<td>" + arr[i].getCity() + "</td>");
                    out.println("<td>" + arr[i].getCountry() + "</td>");
                    out.println("<td>" + arr[i].getHomePhone() + "</td>");
                    out.println("<td>" + arr[i].getMobile() + "</td>");
                    out.println("<td>" + arr[i].getEmail() + "</td>");
                    out.println("<td align='center'><a href='ProcessEmployee?action=edit&id=" + arr[i].getEmployeeID() + "'>Edit </a></td>");
                    out.println("<td align='center'><a href='ProcessEmployee?action=delete&id=" + arr[i].getEmployeeID() + "'> Delete</a></td></tr>");
                }
            }
                
      out.write("\n");
      out.write("            </table>\n");
      out.write("            <br>\n");
      out.write("            ");
} else {
            
      out.write("\n");
      out.write("            ");
      if (true) {
        _jspx_page_context.forward("login.jsp");
        return;
      }
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
