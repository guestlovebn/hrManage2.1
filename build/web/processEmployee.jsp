<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
        <script src="script/valid_data.js"></script>
    </head>
    <body>
        <c:choose>
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
                    <li class="highlight"><span class="menu_r"><a href="ProcessEmployee"><span class="menu_ar"><c:out value="${lB}"> Employee</span></a></span></li>
                        <li><span class="menu_r"><a href="searchEmployee.jsp"><span class="menu_ar">Search Employee</span></a></span></li>
                        <li><span class="menu_r"><a href="LogoutServlet"><span class="menu_ar">logout</span></a></span></li>
                    </ul>
                    <br class="clearit" />
                </div>
            </div>
            <div class="content">
                <br><br>
                <jsp:useBean id="e" class="HRManager.entities.Employee" scope="request"/>
                <jsp:useBean id="convert" class="HRManager.ConvertData" scope="session"/>

                <table align="center" id="tb2">
                    <tr>
                        <td colspan="3"><h3 align="center"><c:out value="${actionName}"> Employee</h3></td>
                        </tr>
                        <form name="frmEmployee" method="post" action="ProcessEmployee" onsubmit="javascript:return check_submit()">
                            <input type="hidden" name="action" value="${actionName}"/>
                            <input type="hidden" name="id" value="${empId}"/>
                            <tr>
                                <td>First Name: </td>
                                <td><input type="text" name="txtFirstName" value='${e.getFirstName()}' onblur="check_valid('first', this.value)"></td>
                                <td><label id="lblFirstName" class="error" /></td>
                            </tr>
                            <tr>
                                <td>Last Name: </td>
                                <td><input type="text" name="txtLastName" value='${e.getLastName()}' onblur="check_valid('last', this.value)"></td>
                                <td><label id="lblLastName" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Birth Date: </td>
                                <td><input type="text" name="txtBirthDate"  value='${convert.date2string(e.getBirthDate())}' onblur="check_valid('birth', this.value)"></td>
                                <td><label id="lblBirthDate" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Hire Date: </td>
                                <td><input type="text" name="txtHireDate" value='${convert.date2string(e.getHireDate())}' onblur="check_valid('hire', this.value)"></td>
                                <td><label id="lblHireDate" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Address: </td>
                                <td><input type="text" name="txtAddress" value='${e.getAddress()}'></td>
                            </tr>
                            <tr>
                                <td>City: </td>
                                <td><input type="text" name="txtCity" value='${e.getCity()}'></td></tr>
                            <tr>
                                <td>Country: </td>
                                <td><input type="text" name="txtCountry" value='${e.getCountry()}'></td>
                            </tr>
                            <tr>
                                <td>Home Phone: </td>
                                <td><input type="text" name="txtHomePhone" value='${e.getHomePhone()}' onblur="check_valid('home', this.value)"></td>
                                <td><label id="lblHomePhone" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Mobile: </td>
                                <td><input type="text" name="txtMobile" value='${e.getMobile()}' onblur="check_valid('mobile', this.value)"></td>
                                <td><label id="lblMobile" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Email: </td>
                                <td><input type="text" name="txtEmail" value='${e.getEmail()}' onblur="check_valid('email', this.value)"></td>
                                <td><label id="lblEmail" class="error"/></td>
                            </tr>
                            <tr>
                                <td>Note: </td>
                                <td><input type="text" name="txtNote" value='<%=e.getNote()%>'></td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center"><center><input type="submit" value="${lB}"></center></td>
                            </tr>
                        </form>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>


        
        
            </body>
        </html>