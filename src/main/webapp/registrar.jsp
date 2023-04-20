<%@page import="com.emergentes.modelo.Registro"%>
<%
    Registro item = (Registro) request.getAttribute("regis");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
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
    <center><h1><%= (item.getId() == 0) ? "Registro de calificaciones" : "Editar registro" %></h1></center>
    <center>     
        <form action="MainController" method="post">
            <table border="1" cellspacing="0" cellpadding="30">
                <tr>
                    <td>
                        <center>
                            <input type="hidden" name="id" value="<%= item.getId()%>">
                            <label>Nombre del Estudiante: </label>
                            <input type="text" name="nombre" value="<%= item.getNombre()%>">
                            <br><br>
                            <label>Primer parcial (sobre 30 pts): </label>
                            <input type="text" name="primer" value="<%= item.getPrimer()%>">
                            <br><br>
                            <label>Segundo parcial (sobre 30 pts): </label>
                            <input type="text" name="segundo" value="<%= item.getSegundo()%>">
                            <br><br>
                            <label>Examen final (sobre 40 pts): </label>
                            <input type="text" name="exfinal" value="<%= item.getExfinal()%>">
                            <br><br>
                            <input type="submit" value="Enviar">
                         </center>
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
