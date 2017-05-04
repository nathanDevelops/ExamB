<%-- 
    Document   : updateForm
    Created on : May 3, 2017, 9:19:16 AM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Customers"%>
<% Customers customer = (Customers) request.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="examCSS.css"/>
    </head>
    <body>
        
        <div class="wrap">
            
            <%@ include file="includes/header.jsp" %>
            
            <%@ include file="includes/menu.jsp" %>
        
        <div class="main">
     
                <div class="center">

                <form name="updateForm" action="updateCustomer" method="post">
                    <h3>Update a Customer</h3>
                    <hr width="90%" color="white">

                    <br>
                            <label>Customer ID:</label>
                            <input type="text" name="custID" value="<%= customer.getCustID() %>"  size="20" readonly/>
                            <br>
                            <label>*First Name:</label>
                            <input type="text" name="firstName" value="<%= customer.getFirstName() %>" size="20" required/>
                            <br>
                            <label>*Last Name:</label>
                                <input type="text" name="lastName" value="<%= customer.getLastName() %>" size="20" required/>
                            <br>
                            <label>*Address 1:</label>
                                <input type="text" name="addr1" value="<%= customer.getAddr1() %>" size="20" required/>
                            <br>
                            <label>Address 2:</label>
                                <input type="text" name="addr2" value="<%= customer.getAddr2() %>" size="20" />
                            <br>
                            <label>*City:</label>
                                <input type="text" name="city" value="<%= customer.getCity() %>" size="20" required/>
                            <br>
                            <label>*State:</label>
                                <input type="text" name="state" value="<%= customer.getState() %>" size="20" required/>
                            <br>
                            <label>*Zip Code:</label>
                                <input type="text" name="zip" value="<%= customer.getZip() %>" size="20" required/>
                            <br>
                            <label>*Email Address:</label>
                                <input type="text" name="emailAddr" value="<%= customer.getEmailAddr() %>" size="20" required/>
                            <br>
                            <br>
                            <div style="text-align: center">
                            <input type="submit" name="submit" value="Update" />
                            </div>
                            <br>
                            <label>*Required Information</label>
                    </form>
                </div>
        </div>
          <%@ include file="includes/footer.jsp" %>
        </div>
    </body>
</html>
