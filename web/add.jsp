<%-- 
    Document   : add
    Created on : May 3, 2017, 9:09:35 AM
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="main">
                <div class="center">

                <form name="addForm" action="addCustomer" method="get">
                    <h3>Add a New Customer</h3>
                    <hr width="90%" color="white">

                    <br>
            
            
                    <label>First Name:</label>
                        <input type="text" name="firstName" value="" size="20" />
                    <br>
                    <label>Last Name:</label>
                        <input type="text" name="lastName" value="" size="20" />
                    <br>
                    <label>Address 1:</label>
                        <input type="text" name="addr1" value="" size="20" />
                    <br>
                    <label>Address 2:</label>
                        <input type="text" name="addr2" value="" size="20" />
                    <br>
                    <label>City:</label>
                        <input type="text" name="city" value="" size="20" />
                    <br>
                    <label>State:</label>
                        <input type="text" name="state" value="" size="20" />
                    <br>
                    <label>Zip Code:</label>
                        <input type="text" name="zip" value="" size="20" />
                    <br>
                    <label>Email Address:</label>
                        <input type="text" name="emailAddr" value="" size="20" />
                    <br>
                    <br>
                    <div style="text-align: center">
                    <input type="submit" name="submit" value="submit" />
                    </div>
            </form>
            </div>
        </div>
    </body>
</html>
