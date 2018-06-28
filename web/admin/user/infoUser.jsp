<%-- 
    Document   : infoUser
    Created on : Jun 19, 2018, 11:13:29 PM
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
        <h1>View User ${requestScope.INFO_USER.fullname}</h1>
        ${requestScope.INFO_USER.username}
        ${requestScope.INFO_USER.role}
        ${requestScope.INFO_USER.fullname}
        ${requestScope.INFO_USER.abilities}
        ${requestScope.INFO_USER.powers}
        ${requestScope.INFO_USER.height}
        ${requestScope.INFO_USER.weight}
        ${requestScope.INFO_USER.dateJoined}
        <a href="UserManager.SearchController?txtSearch=<%= request.getParameter("txtSearch") %>">
            <button>Back to home</button>
        </a>
        <form method="POST" action="UserManager.MainController">
            <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
            <input type="hidden" name="txtUsername" value="${requestScope.INFO_USER.username}" />
            <input name="action" value="Edit" type="submit" />
            <input name="action" value="Reset password" type="submit" />
            <input name="action" value="Update avatar" type="submit" />
        </form>
    </body>
</html>
