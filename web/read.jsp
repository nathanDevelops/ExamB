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
        <h1>Customer Database</h1>
        <%= table %>
        <div style="text-align: center">
        <a href ="add">Add A New Customer</a>
        <br> <br>
        <a href="search.jsp">Search Customers</a>
        </div>
        
    </body>
</html>
