<%-- 
    Document   : index
    Created on : 26/11/2012, 01:41:11 AM
    Author     : gio
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import = "data.SQL" %>
<%
    SQL mySql = new SQL();
    ResultSet rs = mySql.getClientes();
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
            <table class="table table-bordered">
                <tr>
                    <td>ID</td>
                    <td>Nombre</td>
                    <td>Apellido</td>
                    <td>Edo. Civil</td>
                    <td>RIF</td>
                    <td></td>
                </tr>
                <%
                    try {
                        rs.first();
                        do { %>
                        
                        <tr>
                            <td><%= rs.getString(1) %></td>
                            <td><%= rs.getString(2) %></td>
                            <td><%= rs.getString(3) %></td>
                            <td><%= rs.getString(4) %></td>
                            <td><%= rs.getString(5) %></td>
                            <td><a class="btn" href="#"><i class="icon-edit"></i></a></td>
                        </tr>

                <% } while (rs.next());
                    } catch (SQLException e) {
                    }
                %>
            </table>
        </div>
    </body>
</html>
