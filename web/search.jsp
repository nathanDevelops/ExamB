<%-- 
    Document   : search
    Created on : May 3, 2017, 9:16:43 AM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Customers</title>
        <link rel="stylesheet" type="text/css" href="examCSS.css"/>
    </head>
    <body>
        
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
       
        <div class="main">
                <div class="center">
                <h1>Search Customers</h1>

                <form name="searchForm" action="search" method="post">

                    <input type="text" name="searchVal" value="" /><input type="submit" name="submit" value="Search" />

                </form>
                </div>
        </div>
            <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
