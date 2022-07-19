<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Con Scriptlets</title>
    </head>
    <body>
        <h1>JSP Con Scriptlets</h1>
        <br/>
        <br/>
        <%-- scriptlet para enviar  informacion al nevegador --%>
        <%
           out.println("Saludos desde un scriptlet");  
        %>
        <%-- scriptlet para manipular los objetos al nevegador --%>
        <%
            String nombreAplicacion = request.getContextPath();
            out.println("Nombre de la aplicacion: " + nombreAplicacion );  
        %>
        <br/>
        <%-- scriptlet con codigo condicionado --%>
        <%
            if(session != null && session.isNew()){
                
        %>
            la sesion SI es nueva
        <%
            } else  if(session != null){
                
        %>
            la sesion NO es nueva
        <% } %>
        
        <br/>
        <a href="index.html">Regresar a la pagina de inicio</a>
    </body>
</html>
