<%-- 
    Document   : index.jsp
    Created on : Jun 23, 2018, 1:31:15 PM
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
        <form method="POST" action="MainController">
            <input name="action" value="Logout" type="submit" />
        </form>
        <a href="<%= request.getContextPath() %>/RedirectController?page=admin/index.jsp">Home</a>
        <a href="<%= request.getContextPath() %>/RedirectController?page=admin/user/index.jsp">User Manager</a>
        <a href="<%= request.getContextPath() %>/RedirectController?page=admin/mission/index.jsp">Mission Manager</a>
    </body>
</html>
