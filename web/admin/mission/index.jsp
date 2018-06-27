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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USER}!</h1>
        
        <a href="RedirectController?page=admin/index.jsp">Home</a>
        <a href="RedirectController?page=admin/user/index.jsp">User Manager</a>
        <a href="RedirectController?page=admin/mission/index.jsp">Mission Manager</a>
        
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
    </body>
</html>
