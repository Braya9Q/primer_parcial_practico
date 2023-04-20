<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Registro"%>
<%
    ArrayList<Registro> lista = (ArrayList<Registro>)session.getAttribute("listares");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de calificaciones</title>
    </head>
    <body bgcolor="#D2FFFC">
    <center>
        <table border="1" cellspacing="0" cellpadding="20">
            <tr>
                <th>                    
                    <h2> PRIMER PARCIAL TEM - 742 </h2>
                    <h3> Nombre : Brayan Quispe Alanoca </h3>
                    <h3> Carnet : 8427958 </h3> 
                </th>
            </tr>
        </table>
    </center>
    <center><h1>Registro de calificaciones</h1></center>
    <div align="center">
        <a href="MainController?op=nuevo">Nuevo</a>
        <br>
        <table border="1" cellspacing="0" cellpadding="10">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>P1(30)</th>
                <th>P2(30)</th>
                <th>EF(40)</th>
                <th>NOTA</th>
                <th></th>
                <th></th>
            </tr>
            <%
                if(lista != null){
                    for(Registro item: lista){
            %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getNombre() %></td>
                <td><%= item.getPrimer() %></td>
                <td><%= item.getSegundo() %></td>
                <td><%= item.getExfinal() %></td>
                <td><%= item.suma(item.getPrimer(), item.getSegundo(),item.getExfinal())%></td>
                <td><a href="MainController?op=editar&id=<%= item.getId() %>">Editar</a></td>
                <td><a href="MainController?op=eliminar&id=<%= item.getId() %>">Eliminar</a></td>
            </tr>
            <%
                    }
               }
            %>
        </table>
    </div>
</body>
</html>
