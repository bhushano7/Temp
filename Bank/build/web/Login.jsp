<%-- 
    Document   : index
    Created on : 20 Mar, 2013, 2:29:24 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form action="Customer">
            <table>
                <tr>
                    <td>Customer Id</td>
                    <td><input type="text" name="txtId"/></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="btnSubmit"/>
                    </td>
                </tr>
            </table>
        </form>
        <%
            String data = (String) request.getAttribute("data");
            if (data == null) {
                data=" ";
            }
        %>
        <%=data%>
    </body>
</html>
