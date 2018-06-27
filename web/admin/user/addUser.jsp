<%-- 
    Document   : addUser
    Created on : Jun 23, 2018, 9:46:07 PM
    Author     : ThoDT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <h1>Add User</h1>

        <c:url var="searchInfo" value="UserManager.SearchController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="action" value="Search"></c:param>
        </c:url>

        <form method="POST" action="UserManager.AddController" enctype="multipart/form-data">
            <input autofocus required name="txtUsername" />
            <p id="arlet_username"></p>
            <input required minlength=8 type="password" id="password" name="txtPassword" />
            <input required minlength=8 type="password" id="passwordConfirm" />
            <p id="arlet_rpw"></p>
            <input required name="txtRole" />
            <input required name="txtFullname" />
            <input name="txtAbilities" />
            <input name="txtPowers" />
            <input name="txtHeight" />
            <input name="txtWeight" />
            <input type="date" name="txtdateJoined" />
            <input type="file" name="txtAvatar" value="" />
            
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>

            <a href="${searchInfo}"><button type="button">Back</button></a>
            <input id="action" name="action" type="submit" value="Add"/>
        </form>

        <script>
            const checkValid = () => {
                if ($('#arlet_rpw').html() === '' && $('#arlet_username').html() === '') {
                    $('#action').attr('disabled', false);
                } else {
                    $('#action').attr('disabled', true);
                }
            };
                
            $('#passwordConfirm').on('keyup', function () {
                if ($('#password').val() === $('#passwordConfirm').val()) {
                    $('#arlet_rpw').html('');
                } else {
                    $('#arlet_rpw').html('* Not Matching');
                }
                checkValid();
            });

            $('input[name="txtUsername"').on('keyup', () => {
                $.post("UserManager.MainController", {action: "Check Username", txtUsername: $('input[name="txtUsername"').val()}, (respond) => {
                    if (respond === 'existed') {
                        $('#arlet_username').html('Existed username');
                    } else {
                        $('#arlet_username').html('');
                    }
                    checkValid();
                });
            });
        </script>
    </body>
</html>
