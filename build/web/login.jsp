<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to HRManager</title>
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
    </head>
    <body>
        <div class="header">
            <br>
            <h1 align="center">Employees Manager</h1>
            <div class="menu bubplastic horizontal orange">
                <ul>
                    <li class="highlight"><span class="menu_r"><a href="login.jsp"><span class="menu_ar">login</span></a></span></li>
                    <li><span class="menu_r"><a href="EmployeeManager"><span class="menu_ar">Employee Manager</span></a></span></li>
                    <li><span class="menu_r"><a href="ProcessEmployee"><span class="menu_ar">Add New Employee</span></a></span></li>
                    <li><span class="menu_r"><a href="searchEmployee.jsp"><span class="menu_ar">Search Employee</span></a></span></li>
                    <li><span class="menu_r"><a href="LogoutServlet"><span class="menu_ar">logout</span></a></span></li>
                </ul>
                <br class="clearit" />
            </div>
        </div>
        <div class="content">
            <br><br>
            <%
                String error = request.getParameter("error");
            %>
            <jsp:useBean id="valid" class="HRManager.ValidData" scope="session"/>

            <table align="center" id="tb2">
                <form method="post" action="Login">
                    <tr>
                        <th colspan="3" hight="50px"><h4>Login to HRManager</h4></th>
                    </tr>
                    <tr>
                        <td>User Name: </td>
                        <td><input type="text" name="txtUserName"></td>
                            <%
                                if (error != null && error.equals("UserName")) {
                                    out.println("<td>Not null...</td>");
                            }%>
                    </tr>
                    <tr>
                        <td>Password: </td>
                        <td><input type="password" name="txtPassword"></td>
                            <%
                                if (error != null && error.equals("Password")) {
                                    out.println("<td>Password incorrect!</td>");
                            }%>
                    </tr>
                    <tr>
                        <td colspan="2"><center><input type="submit" name="btnLogin" value="Login"></center></td>
                    </tr>
                </form>
            </table>
            <%
                if (error != null) {
                    out.println("Login Error!");
                }
            %>
        </div>
    </body>
</html>