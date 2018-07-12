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
        <title>Reset password | ${param.txtUsername}</title>
        <link href="<%= request.getContextPath()%>/src/css/app.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath()%>/src/js/jquery.min.js" type="text/javascript"></script>
        <link href="<%= request.getContextPath()%>/src/css/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="<%= request.getContextPath()%>/src/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath()%>/src/js/semantic.js" type="text/javascript"></script>
        <script src="<%= request.getContextPath()%>/src/js/semantic.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="components/sideBar.jspf" %>
        <div class="main-content">
            <%@include file="components/resetPassword.jspf" %>
        </div>
    </body>
</html>
