<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/menu_style.css" type="text/css" rel="stylesheet" />
        <link href="css/style.css" type="text/css" rel="stylesheet" />
        <title></title>
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
                <br>
                <c:set var="type" value="${requestScope.type}"/>
                <c:set var="msg" value="${requestScope.msg}"/>
                <c:set var="errorVal" value="error"/>
                <c:set var="warningVal" value="warning"/>
                <c:set var="infoVal" value="info"/>
                <c:if test="${type==errorVal}">
                    <h1 class="error"><c:out value="${msg}"/></h1>
                </c:if>
                <c:if test="${type==warningVal}">
                    <h1 class="info"><c:out value="${msg}"/></h1>
                </c:if>
                <c:if test="${type==infoVal}">
                    <h1 class="warning"><c:out value="${msg}"/></h1>
                </c:if>
            </div>
        </c:otherwise>
    </body>
</html>
