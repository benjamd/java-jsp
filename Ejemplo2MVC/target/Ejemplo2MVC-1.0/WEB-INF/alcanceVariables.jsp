
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcance de Variables</title>
    </head>
    <body>
        <h1>Alcance de Variables</h1>
        <br/>
        Rectangulo - Variable Request:
        <br/>
        Base: ${recRequest.base}
        <br/>
        Altura: ${recRequest.altura}
        <br/>
        Area: ${recRequest.area}
        <br/><br/>
        Rectangulo - Variable Session:
        <br/>
        Base: ${recSession.base}
        <br/>
        Altura: ${recSession.altura}
        <br/>
        Area: ${recSession.area}
        <br/><br/>
         Rectangulo - Variable Application:
        <br/>
        Base: ${recApplication.base}
        <br/>
        Altura: ${recApplication.altura}
        <br/>
        Area: ${recApplication.area}
        <br/><br/>
        <a href="${pageContext.request.contextPath}/index.jsp">Link a Inicio</a> 
    </body>
</html>
