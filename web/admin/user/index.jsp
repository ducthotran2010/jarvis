<%-- 
    Document   : admin
    Created on : Jun 17, 2018, 5:47:02 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User manager</title>
        <link href="<%= request.getContextPath()%>/src/css/app.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath()%>/src/js/jquery.min.js" type="text/javascript"></script>
        <link href="<%= request.getContextPath()%>/src/css/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="<%= request.getContextPath()%>/src/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath()%>/src/js/semantic.js" type="text/javascript"></script>
        <script src="<%= request.getContextPath()%>/src/js/semantic.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="components/sideBar.jspf" %>

        <!--CONTENT-->
        <div class="main-content">
            <!--SEARCH FIELD-->
            <%@include file="components/searchUserField.jspf" %>

            <!--ADD FIELD-->
            <%@include file="components/addUserField.jspf" %>

            <!--SHOW RESULT SEARCH FIELD-->    
            <%@include file="components/showResultUser.jspf" %>
        </div>
    </body>
</html>
