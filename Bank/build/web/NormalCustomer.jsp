<%--
    Document   : MoreThanZero
    Created on : 20 Mar, 2013, 3:04:17 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NormalCustomer Page</title>
    </head>
    <body>
        <h1>NormalCustomer Page</h1>
        <jsp:useBean id="bb" class="Bank.BankBean"></jsp:useBean>
        
        Id : <%=bb.getId()%></br>
        Name : <%=bb.getName()%></br>
        Balance :<%=bb.getBalance()%></br>
    </body>
</html>
