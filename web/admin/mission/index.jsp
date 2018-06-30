<%-- 
    Document   : searchMission
    Created on : Jun 19, 2018, 8:11:32 PM
    Author     : ThoDT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Calendar"%>
<%@page import="java.sql.Date"%>
<%@page import="Tho.Models.MissionDTO"%>
<%@page import="java.util.ArrayList"%>
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
        <%@include file="../components/sideBar.jspf" %>
        <script>
            $('#SB-MissionManager').attr('class', 'active item');
        </script>
        
        <div class="main-content">
            <h2>Search Mission</h2>

            <form method="POST" action="MissionManager.MainController">
                <input name="txtSearch" value="${param.txtSearch}" autofocus />
                <input type="submit" name="action" value="Search"/>
            </form>

            <form method="POST" action="MissionManager.MainController">
                <input name="txtSearch" value="${param.txtSearch}" type="hidden"/>
                <input type="hidden" name="action" value="Input Mission"/>
                <button type="submit">Create new Mission</button>
            </form>


            <%
                ArrayList<MissionDTO> resultMission = (ArrayList<MissionDTO>) request.getAttribute("INFO");
                if (resultMission != null) {
                    %><h4>Result</h4><%
                    if (resultMission.size() == 0) {
                        %>No record found<%
                    } else { 
                        int count = 0;
                    %>
                    <table>
                        <thead>
                            <tr>
                                <td>No</td>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Start Date</td>
                                <td>End Date</td>
                                <td>Status</td>
                            </tr>
                        </thead>
                        <tbody>
                            <%! Date currentDate = new Date(Calendar.getInstance().getTimeInMillis()); %>
                            <% for (MissionDTO dto: resultMission) { 
                                    String status = dto.getRealStatus(currentDate);
                            %>
                            <tr>
                                <td><%= ++count %></td>
                                <td><%= dto.getId() %></td>
                                <td><%= dto.getName() %></td>
                                <td><%= dto.getDateStart() %></td>
                                <td><%= dto.getDateEnd() %></td>
                                <td><%= status %></td>
                                <td>
                                    <c:url var="editMission" value="MissionManager.MainController">
                                        <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                        <c:param name="txtId" value="<%= dto.getId() %>"></c:param>
                                        <c:param name="action" value="Edit"></c:param>
                                    </c:url>
                                    <a href="${editMission}">Edit mission</a>
                                </td>
                            </tr>
                            <% } %>
                        </tbody>
                    </table>
                    <%
                    }
                }
            %>
        </div>
    </body>
</html>
