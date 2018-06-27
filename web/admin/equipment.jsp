<%-- 
    Document   : equipment
    Created on : Jun 22, 2018, 2:30:37 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USER}!</h1>
        
        <a href="RedirectController?page=admin/index.jsp">User Manager</a>
        <a href="RedirectController?page=admin/mission.jsp">Mission Manager</a>
        <a href="RedirectController?page=admin/equipment.jsp">Equipment Manager</a>
        <h2>Search Equipment</h2>
        
        <form method="POST" action="MainController">
            <input name="txtSearch" value="${param.txtSearch}" autofocus />
            <input type="hidden" name="txtType" value="User" />
            <input type="submit" name="action" value="Search"/>
        </form>

    </body>
</html>
