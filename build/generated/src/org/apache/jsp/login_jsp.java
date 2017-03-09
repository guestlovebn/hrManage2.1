package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login to HRManager</title>\n");
      out.write("        <link href=\"css/menu_style.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("        <link href=\"css/style.css\" type=\"text/css\" rel=\"stylesheet\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <br>\n");
      out.write("            <h1 align=\"center\">Employees Manager</h1>\n");
      out.write("            <div class=\"menu bubplastic horizontal orange\">\n");
      out.write("                <ul>\n");
      out.write("                    <li class=\"highlight\"><span class=\"menu_r\"><a href=\"login.jsp\"><span class=\"menu_ar\">login</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"EmployeeManager\"><span class=\"menu_ar\">Employee Manager</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"ProcessEmployee\"><span class=\"menu_ar\">Add New Employee</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"searchEmployee.jsp\"><span class=\"menu_ar\">Search Employee</span></a></span></li>\n");
      out.write("                    <li><span class=\"menu_r\"><a href=\"LogoutServlet\"><span class=\"menu_ar\">logout</span></a></span></li>\n");
      out.write("                </ul>\n");
      out.write("                <br class=\"clearit\" />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"content\">\n");
      out.write("            <br><br>\n");
      out.write("            ");

                String error = request.getParameter("error");
            
      out.write("\n");
      out.write("            ");
      hrManager.ValidData valid = null;
      synchronized (session) {
        valid = (hrManager.ValidData) _jspx_page_context.getAttribute("valid", PageContext.SESSION_SCOPE);
        if (valid == null){
          valid = new hrManager.ValidData();
          _jspx_page_context.setAttribute("valid", valid, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("\n");
      out.write("            <table align=\"center\" id=\"tb2\">\n");
      out.write("                <form method=\"post\" action=\"Login\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th colspan=\"3\" hight=\"50px\"><h4>Login to HRManager</h4></th>\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>User Name: </td>\n");
      out.write("                        <td><input type=\"text\" name=\"txtUserName\"></td>\n");
      out.write("                            ");

                                if (error != null && error.equals("UserName")) {
                                    out.println("<td>Not null...</td>");
                            }
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>Password: </td>\n");
      out.write("                        <td><input type=\"password\" name=\"txtPassword\"></td>\n");
      out.write("                            ");

                                if (error != null && error.equals("Password")) {
                                    out.println("<td>Password incorrect!</td>");
                            }
      out.write("\n");
      out.write("                    </tr>\n");
      out.write("                    <tr>\n");
      out.write("                        <td colspan=\"2\"><center><input type=\"submit\" name=\"btnLogin\" value=\"Login\"></center></td>\n");
      out.write("                    </tr>\n");
      out.write("                </form>\n");
      out.write("            </table>\n");
      out.write("            ");

                if (error != null) {
                    out.println("Login Error!");
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
