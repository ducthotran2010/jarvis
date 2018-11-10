<%-- 
    Document   : editMission
    Created on : Jun 21, 2018, 9:22:11 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Equipment manager | ${requestScope.INFO.name}</title>
        <link href="<%= request.getContextPath() %>/src/css/app.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath() %>/src/js/jquery.min.js" type="text/javascript"></script>
        <link href="<%= request.getContextPath() %>/src/css/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="<%= request.getContextPath() %>/src/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath() %>/src/js/semantic.js" type="text/javascript"></script>
        <script src="<%= request.getContextPath() %>/src/js/semantic.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="components/sideBar.jspf" %>
        
        <div class="main-content">
            <%@include file="components/editEquipment.jspf" %>
        </div>
    </body>
</html>
