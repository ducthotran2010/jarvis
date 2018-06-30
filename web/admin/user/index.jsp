<%-- 
    Document   : admin
    Created on : Jun 17, 2018, 5:47:02 PM
    Author     : ThoDT
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Tho.Models.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User manager</title>
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
            $('#SB-UserManager').attr('class', 'active item');
        </script>
        
        <div class="main-content">
            <h2>Search User</h2>

            <form method="POST" action="UserManager.MainController">
                <input name="txtSearch" value="${param.txtSearch}" autofocus />
                <input type="submit" name="action" value="Search"/>
            </form>

            <form method="POST" action="UserManager.MainController">
                <input name="txtSearch" value="${param.txtSearch}" type="hidden"/>
                <input type="hidden" name="action" value="Input Account"/>
                <button type="submit">Create new account</button>
            </form>

            <%
                ArrayList<UserDTO> result = (ArrayList<UserDTO>) request.getAttribute("INFO");
                if (result != null) {
                    %><h4>Result</h4><%
                    if (result.size() == 0) {
                        %>No record found<%
                    } else { 
                        int count = 0;
                    %>
                    <table>
                        <thead>
                            <tr>
                                <td>No</td>
                                <td>Avatar</td>
                                <td>Username</td>
                                <td>Full name</td>
                                <td>Role</td>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (UserDTO dto: result) { %>
                            <tr>
                                <td><%= ++count %></td>
                                <td><img height="100" src="<%= dto.getUrlAvatar() %>"/></td>
                                <td><%= dto.getUsername() %></td>
                                <td><%= dto.getFullname() %></td>
                                <td><%= dto.getRole() %></td>
                                <td>
                                    <c:url var="viewInfo" value="UserManager.MainController">
                                        <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
                                        <c:param name="txtUsername" value="<%= dto.getUsername() %>"></c:param>
                                        <c:param name="action" value="ViewInfo"></c:param>
                                    </c:url>
                                    <a href="${viewInfo}">More</a>
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
