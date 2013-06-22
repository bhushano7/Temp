<%-- 
    Document   : GoodCustomer
    Created on : 20 Mar, 2013, 3:05:35 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Good Customer Page</title>
    </head>
    <body>
        <h1>Good Customer Page</h1>
        <%
         Bank.BankBean bb = (Bank.BankBean) request.getAttribute("data");
        %>
        Id : <%=bb.getId()%></br>
        Name : <%=bb.getName()%></br>
        Balance :<%=bb.getBalance()%></br>
    </body>
</html>
