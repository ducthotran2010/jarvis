<%-- 
    Document   : editMission
    Created on : Jun 21, 2018, 9:22:11 PM
    Author     : ThoDT
--%>

<%@page import="Tho.Models.MissionDTO"%>
<%@page import="java.util.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    </head>
    <body>
        <h1>Edit Mission</h1>

        <c:url var="searchInfo" value="MissionManager.SearchController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
        </c:url>

        <%! Date currentDate = new Date(Calendar.getInstance().getTimeInMillis());%>
        <form method="POST" action="MissionManager.MainController">
            <input type="hidden" name="txtSearch" value="${param.txtSearch}"/>

            <input required readonly name="txtId" value="${requestScope.INFO_MISSION.id}"/>
            <input required name="txtName" value="${requestScope.INFO_MISSION.name}"/>
            <input required type="date" name="txtDateStart" id="txtDateStart" value="${requestScope.INFO_MISSION.dateStart}" min="<%= currentDate %>"/>
            <input type="date" name="txtDateEnd" id="txtDateEnd" value="${requestScope.INFO_MISSION.dateEnd}"/>
            <select required id="txtStatus" name="txtStatus"></select>

            <a href="${searchInfo}"><button type="button">Back</button></a>
            <input name="action" type="submit" value="Update"/>
        </form>
            
        <% MissionDTO dto = (MissionDTO) request.getAttribute("INFO_MISSION"); %>
        <script>
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
                $('#txtStatus').val('<%= dto.getRealStatus(currentDate) %>');
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
                    $('#txtStatus').val('<%= dto.getRealStatus(currentDate) %>');
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
                    $('#txtStatus').val('<%= dto.getRealStatus(currentDate) %>');
                });
            });
        </script>
    </body>
</html>
