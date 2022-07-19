
<!DOCTYPE html>
<html>
    <head>
        <title>Ejemplo MVC 2</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h1>Ejemplo MVC 2</h1>
        <br/>
       <!-- <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet Controlador que despliega las variables
        </a>
        -->
        <div style="color: red">${mensaje}</div>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador">
            Link al Servlet Controlador sin parametros</a>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=agregaVariables">
            Link al Servlet Controlador para agregar las variables</a>
        <br/>
        <a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
            Link al Servlet Controlador para listar las variables</a>
        <br/>
           
            
            
        
    </body>
</html>
