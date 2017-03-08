<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
        <title>Search Employee</title>
    </head>
    <body>
    <c:when test="${sessionScope.username==null}">
        <jsp:forward page="login.jsp" />
    </c:when>
    <c:otherwise>
        <div class="header">
            <br>
            <h1 align="center">Employees Manager</h1>
            <div class="menu bubplastic horizontal orange">
                <ul>
                    <li><span class="menu_r"><a href="login.jsp"><span class="menu_ar">Login</span></a></span></li>
                    <li><span class="menu_r"><a href="EmployeeManager"><span class="menu_ar">Employee Manager</span></a></span></li>
                    <li><span class="menu_r"><a href="ProcessEmployee"><span class="menu_ar">Add New Employee</span></a></span></li>
                    <li class="highlight"><span class="menu_r"><a href="searchEmployee.jsp"><span class="menu_ar">search employee</span></a></span></li>
                    <li><span class="menu_r"><a href="LogoutServlet"><span class="menu_ar">logout</span></a></span></li>
                </ul>
                <br class="clearit" />
            </div>
        </div>
        <div class="content">
            <br><br>
            <form name="frmSearch" action="EmployeeManager" method="post">
                <table align="center" id="tb2">
                    <tr>
                        <th align="center" colspan="3"><h3>Search Employee</h3></th>
                    </tr>
                    <tr>
                        <td>Search Value</td>
                        <td><input type="text" name="txtValue"></td>
                    </tr>
                    <tr>
                        <td>Search By</td>
                        <td>
                            <select name="ddlSearch">
                                <option>Name</option>
                                <option>City</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" align="center"><input type="submit" name="btnSearch" value="Search"></td>
                    </tr>
                </table>
            </form>
        </div>
    </c:otherwise>
</body>
</html>
