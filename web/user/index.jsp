<%-- 
    Document   : index
    Created on : Jun 30, 2018, 9:22:07 PM
    Author     : ThoDT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${sessionScope.USER.fullname}</title>
        <link href="<%= request.getContextPath() %>/src/css/app.css" rel="stylesheet" type="text/css"/>
        <link href="<%= request.getContextPath()%>/src/css/chart.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath() %>/src/js/jquery.min.js" type="text/javascript"></script>
        <link href="<%= request.getContextPath() %>/src/css/semantic.css" rel="stylesheet" type="text/css"/>
        <link href="<%= request.getContextPath() %>/src/css/semantic.min.css" rel="stylesheet" type="text/css"/>
        <script src="<%= request.getContextPath() %>/src/js/semantic.js" type="text/javascript"></script>
        <script src="<%= request.getContextPath() %>/src/js/semantic.min.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.js" type="text/javascript"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.2/Chart.min.js" type="text/javascript"></script>
    </head>
    <body>
        <%@include file="components/sideBar.jspf" %>
        <script>$('#SB-Dashboard').attr('class', 'active item');</script>
        
        <div class="main-content">
            <div class="CenterVerticalCharts">
                <div class="ui segment">
                    <h2 class="ui header">Dashboard</h2>
                    <div class="ui icon message">
                    <i class="inbox icon"></i>
                    <div class="content">
                        <div class="header">
                            Do you want an overview of all three task managers?
                        </div>
                        <p>Please take a look at all three following charts</p>
                    </div>
                </div>
                </div>
                
                <div class="charts">
                    <div class="chart">
                        <%@include file="components/dashboardUser.jspf" %>
                        <div class="ui divider"></div>
                        <h3>User</h3>
                        <p style="color: graytext">Last statistics status and role's user</p>
                    </div>

                    <div class="chart">
                        <%@include file="components/dashboardMission.jspf" %>
                        <div class="ui divider"></div>
                        <h3>Mission</h3>
                        <p style="color: graytext">Increase number of mission</p>
                    </div>

                    <div class="chart">
                        <%@include file="components/dashboardEquipment.jspf" %>
                        <div class="ui divider"></div>
                        <h3>Equipment</h3>
                        <p style="color: graytext">A storage equipment for avengers</p>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
