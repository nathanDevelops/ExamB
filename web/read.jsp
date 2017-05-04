<%-- 
    Document   : read
    Created on : May 3, 2017, 9:06:39 AM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="examCSS.css"/>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
            
            <br><br><br><br><br>
            <div style="float: center">
                <a href ="add">Add A New Customer</a>
            </div>
            <%= table %>
           
            
            <%@ include file="includes/footer.jsp" %>
        </div>
        
    </body>
</html>
