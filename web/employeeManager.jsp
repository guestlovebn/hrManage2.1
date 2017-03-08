<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employees Manager</title>
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
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
                        <li class="highlight"><span class="menu_r"><a href="EmployeeManager"><span class="menu_ar">Employee Manager</span></a></span></li>
                        <li><span class="menu_r"><a href="ProcessEmployee"><span class="menu_ar">Add New Employee</span></a></span></li>
                        <li><span class="menu_r"><a href="searchEmployee.jsp"><span class="menu_ar">Search Employee</span></a></span></li>
                        <li><span class="menu_r"><a href="LogoutServlet"><span class="menu_ar">logout</span></a></span></li>
                    </ul>
                    <br class="clearit" />
                </div>
            </div>
            <div class="content">
                <br><br>
                <table id="tb" width="100%" align="center">
                    <tr>
                        <th colspan="11" height="50px"><h4>EMPLOYEE LIST</h4></th>
                    </tr>
                    <tr>
                        <th>Name</th>
                        <th>Birthday Date</th>
                        <th>Hire Date</th>
                        <th>Address</th>
                        <th>City</th>
                        <th>Country</th>
                        <th>Home Phone</th>
                        <th>Mobile</th>
                        <th>Email</th>
                        <th colspan="2"></th>
                    </tr>
                    <jsp:useBean id="ebo" class="hrManager.bol.EmployeeBO" scope="request"/>

                    <c:if var="searchResult" test="!=null">
                        <c:forEach var="searchResult" items="emp">
                            <tr>
                                <td>${emp.getFirstName() + " " + emp.getLastName()}</td>
                                <td>${emp.getBirthDate()}</td>
                                <td>${emp.getHireDate()}</td>
                                <td>${emp.getAddress()}</td>
                                <td>${emp.getCity()}</td>
                                <td>${emp.getCountry()}</td>
                                <td>${emp.getHomePhone()}</td>
                                <td>${emp.getMobile()}</td>
                                <td>${emp.getEmail()}</td>
                                <td align='center'><a href='ProcessEmployee?action=edit&id=" + emp.getEmployeeID() + "'>Edit </a></td>
                                <td align='center'><a href='ProcessEmployee?action=delete&id=" + emp.getEmployeeID() + "'> Delete</a></td>
                            </tr>
                        </c:forEach>
                    </c:if>

                </table>
                <br>
            </c:otherwise>
            </div>
        </body>
    </html>