<%-- 
    Document   : uploadImage
    Created on : Jun 27, 2018, 11:04:13 AM
    Author     : ThoDT
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Upload Image</h1>
        
        <c:url var="searchInfo" value="UserManager.SearchController">
            <c:param name="txtSearch" value="${param.txtSearch}"></c:param>
            <c:param name="action" value="Search"></c:param>
        </c:url>
        
        <form method="POST" action="UserManager.UploadImageController" enctype="multipart/form-data">
            <input type="hidden" name="txtUsername" value="${param.txtUsername}"/>
            <input name="txtSearch" value="${param.txtSearch}" />
            <input type="file" name="urlAvatar"/>
            
            <a href="${searchInfo}"><button type="button">Skip</button></a>
            <input id="action" name="action" type="submit" value="Upload"/>
        </form>
        

    </body>
</html>
