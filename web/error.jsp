<%-- 
    Document   : error
    Created on : Jun 17, 2018, 10:16:18 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link href="src/css/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="src/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <link href="src/css/loginpage.css" rel="stylesheet" type="text/css"/>
        <script src="src/js/jquery.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="background">
            <div id="particles-js"></div> 
            <script src="src/js/particles.min.js" type="text/javascript"></script>
            <script src="src/js/particle-login.js" type="text/javascript"></script>
        </div>
        <div class="ui  large icon error message" style="width:450px">
            <i class="times icon"></i>
            <div class="content">
                <div class="header">
                    An error has occurred
                </div>
                <p><%= (request.getAttribute("ERROR") != null)
                        ? request.getAttribute("ERROR")
                        : "Your request URL is not found"%></p>
            </div>
        </div>
        <div class="ui large message signup" style="width:450px">
            <p>Want to turn back? <a href="<%= request.getContextPath() %>/RegistrationController">Click here.</a></p>
        </div>
    </body>
</html>
