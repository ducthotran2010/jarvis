<%-- 
    Document   : resetPassword
    Created on : Jun 20, 2018, 9:20:10 AM
    Author     : ThoDT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reset password ${param.txtUser}</h1>

        <c:url var="viewInfo" value="UserManager.MainController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="action" value="ViewInfo"></c:param>
            <c:param name="txtUsername" value="${param.txtUsername}"></c:param>
        </c:url>
        
        <form method="POST" action="UserManager.MainController">
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            <input type="hidden" name="txtType" value="User"/>
            
            <input readonly name="txtUsername" value="${param.txtUsername}"/>
            <input name="txtPassword" type="password" />
            <input name="txtPasswordConfirm" type="password" />
            
            <a href="${viewInfo}"><button type="button">Back to view</button></a>
            <input name="action" value="Update password" type="submit" />
        </form>
    </body>
</html>
