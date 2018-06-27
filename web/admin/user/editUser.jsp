<%-- 
    Document   : editUser.jsp
    Created on : Jun 19, 2018, 11:49:30 PM
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
        <h1>Edit User</h1>
        
        <c:url var="viewInfo" value="UserManager.MainController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="txtUsername" value="${requestScope.INFO_USER.username}"></c:param>
            <c:param name="action" value="ViewInfo"></c:param>
        </c:url>
        
        <form method="POST" action="UserManager.MainController">
            <input required readonly name="txtUsername" value="${requestScope.INFO_USER.username}"/>
            <input required name="txtRole" value="${requestScope.INFO_USER.role}"/>
            <input required name="txtFullname" value="${requestScope.INFO_USER.fullname}"/>
            <input name="txtAbilities" value="${requestScope.INFO_USER.abilities}"/>
            <input name="txtPowers" value="${requestScope.INFO_USER.powers}"/>
            <input name="txtHeight" value="${requestScope.INFO_USER.height}"/>
            <input name="txtWeight" value="${requestScope.INFO_USER.weight}"/>
            <input type="date" name="txtdateJoined" value="${requestScope.INFO_USER.dateJoined}"/>
            
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>
            
            <a href="${viewInfo}"><button type="button">Back to view</button></a>
            <input name="action" type="submit" value="Update"/>
        </form>
            

    </body>
</html>
