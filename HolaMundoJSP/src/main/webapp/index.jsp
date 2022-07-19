<%-- 
    Document   : index
    Created on : 5 feb. 2022, 12:28:13
    Author     : benja
--%>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hola mundo JSP</title>
    </head>
    <body>
        <h1>Hola mundo JSP</h1>
        <ul>
            <li> <% out.println("Hola mundo con Scriplets"); %> </li>
            <li> ${"Hola Mudo con Expression Language (EL)"}</li>
            <li> <%= "Hola mundo con expresiones" %> </li>
            <li><c:out value="Hola mundo con JSTL" /> </li>
        </ul>

    </body>
</html>
