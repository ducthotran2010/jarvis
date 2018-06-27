<%-- 
    Document   : index
    Created on : Jun 17, 2018, 5:30:39 PM
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
        <h1>Login</h1>
        <form method="POST" action="MainController">
            username: <input type="text" name="txtUsername" autofocus/><br/>
            password: <input type="password" name="txtPassword"/>
            <input type="submit" name="action" value="Login"/>
        </form>     
</html>