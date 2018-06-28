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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Welcome ${sessionScope.USER}!</h1>
        
        <a href="RedirectController?page=admin/index.jsp">Home</a>
        <a href="RedirectController?page=admin/user/index.jsp">User Manager</a>
        <a href="RedirectController?page=admin/mission/index.jsp">Mission Manager</a>
        
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
    </body>
</html>
