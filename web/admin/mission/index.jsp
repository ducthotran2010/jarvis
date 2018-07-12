<%-- 
    Document   : searchMission
    Created on : Jun 19, 2018, 8:11:32 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mission manager</title>
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
            <!--SEARCH-->
            <%@include file="components/searchMissionField.jspf" %>
            
            <!--ADD-->
            <%@include file="components/addMissionField.jspf" %>
            
            <!--SHOW RESULT-->
            <%@include file="components/showResultMission.jspf" %>
        </div>
    </body>
</html>
