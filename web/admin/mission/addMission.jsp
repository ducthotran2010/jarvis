<%-- 
    Document   : addMission
    Created on : Jun 23, 2018, 1:54:00 PM
    Author     : ThoDT
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
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
        <h1>Add Mission</h1>

        <c:url var="searchInfo" value="MissionManager.SearchController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
        </c:url>

        <%! Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());%>
        <form method="POST" action="MissionManager.MainController">
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>

            <input required name="txtId" autofocus />
            <p id="arlet_id"></p>
            <input required name="txtName" />
            <input required type="date" id="txtDateStart" name="txtDateStart" min="<%= currentDate%>" />
            <input type="date" id="txtDateEnd" name="txtDateEnd" />
            <select required id="txtStatus" name="txtStatus"></select>

            <a href="${searchInfo}"><button type="button">Back</button></a>
            <input id="action" name="action" type="submit" value="Add"/>
        </form>
        <script>
            $('input[name="txtId"').on('keyup', () => {
                $.post("MissionManager.MainController", {action: "Check Id", txtId: $('input[name="txtId"').val()}, (respond) => {
                    if (respond === 'existed') {
                        $('#arlet_id').html('Existed id');
                        $('#action').attr('disabled', true);
                    } else {
                        $('#arlet_id').html('');
                        $('#action').attr('disabled', false);
                    }
                });
            });
            
            $('#txtDateEnd').attr('min', $('#txtDateStart').val());
            $.post("MissionManager.MainController", {
                action: "Get Status",
                txtDateStart: $('#txtDateStart').val(),
                txtDateEnd: $('#txtDateEnd').val()
            }, function (responseText) {
                var $select = $("#txtStatus");
                $select.find("option").remove();
                jQuery.parseJSON(responseText).map(i => {
                    $("<option>").val(i).text(i).appendTo($select);
                });
            });
            
            $('#txtDateStart').change(() => {
                $('#txtDateEnd').val('');
                $('#txtDateEnd').attr('min', $('#txtDateStart').val());
                $.post("MissionManager.MainController", {
                    action: "Get Status",
                    txtDateStart: $('#txtDateStart').val(),
                    txtDateEnd: $('#txtDateEnd').val()
                }, function (responseText) {
                    var $select = $("#txtStatus");
                    $select.find("option").remove();
                    jQuery.parseJSON(responseText).map(i => {
                        $("<option>").val(i).text(i).appendTo($select);
                    });
                });
            });

            $('#txtDateEnd').change(() => {
                $.post("MissionManager.MainController", {
                    action: "Get Status",
                    txtDateStart: $('#txtDateStart').val(),
                    txtDateEnd: $('#txtDateEnd').val()
                }, function (responseText) {
                    var $select = $("#txtStatus");
                    $select.find("option").remove();
                    jQuery.parseJSON(responseText).map(i => {
                        $("<option>").val(i).text(i).appendTo($select);
                    });
                });
            });
        </script>
    </body>
</html>
