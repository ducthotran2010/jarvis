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
        <title>Javis Web</title>
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

        <div style="
             text-align:  center;
             ">
            <img src="src/img/logo.png" width="150">
            <h2 style="text-align:  center;color:  white;">
                <span style="font-weight: 100;">Sign in to</span>
                Jarvis Web
            </h2>
        </div>

        <%
            String respond = (String) request.getAttribute("ERROR");
            if (respond != null) {
        %>
        <div class="error">
            <p>
                <i class="close icon" style="float:right;cursor: pointer;"></i>
                <%= respond %>
            </p>
        </div>
        <%
            }
        %>


        <form method="POST" action="MainController" class="ui big form">
            <div class="field">
                <div class="ui labeled input">
                    <label for="txtUsername" class="ui label"><i class="user circle icon"></i></label>
                    <input type="text" name="txtUsername" autofocus placeholder="Username"/>
                </div>
            </div>
            <div class="field">
                <div class="ui labeled input">
                    <label for="txtPassword" class="ui label"><i class="lock icon"></i></label>
                    <input type="password" name="txtPassword" id="txtPassword" placeholder="Password"/>
                </div>
            </div>
            <input type="hidden" name="action" value="Login"/>
            <button class="ui big button" type="submit">Login</button>
        </form>

        <div class="ui large message signup">
            <p>New to Jarvis Web? <a>Create an account</a></p>
        </div>

        <script>
            $("i[class='close icon']").click(() => {
                $("div[class*='error']").slideToggle();
            })

            $("button[type='submit']").click(() => {
                $("button[type='submit']").attr("class", "ui loading big button");
            });
        </script>

</html>