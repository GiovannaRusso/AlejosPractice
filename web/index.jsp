<%-- 
    Document   : index
    Created on : 26/11/2012, 01:41:11 AM
    Author     : gio
--%>
<%@page import="java.sql.ResultSet"%>
<%@page import = "data.SQL" %>
<%
    SQL mySql = new SQL();
    ResultSet myResult = mySql.getClientes();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.css" />
        <link rel="stylesheet" href="css/bootstrap-responsive.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Hello World!</h1>
            <p> This is the fist paragraph</p>
        </div>
    </body>
</html>
