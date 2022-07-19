<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP con Expresiones</title>
    </head>
    <body>
        <h1>JSP con Expresiones</h1>
        <br/>
        Concatenacion: <%= "Saludos" + " " + "JSP" %>
        <br/>
        Operacion Matemática: <%= 2 * 3  /2 %>  
        <br/>
        Session id: <%= session.getId()  %>
        <br/>
        <br/>
        <a href="index.html">regresar al index  </a>
    </body>
</html>
