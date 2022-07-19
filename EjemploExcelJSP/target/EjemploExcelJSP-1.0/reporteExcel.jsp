<%@page errorPage="WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" %>
<%  
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
%>    
<!DOCTYPE html>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte de Excel</h1>
        <br/>
        <table border="1">
            <thead>
                <tr>
                    <th>Curso</th>
                    <th>Descripcion</th>
                    <th>Fecha</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1. Fundamentos de Java</td>
                    <td>Aprendemos la sintaxis basica</td>
                    <td><%= Conversiones.format(new Date()) %> </td>
                </tr>
                <tr>
                    <td>2. Programacion de Java</td>
                    <td>Pondremos en practica conceptos de la Programacion de Objetos</td>
                    <td><%= Conversiones.format(new Date()) %> </td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
