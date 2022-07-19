package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Rectangulo;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //1. Procesamos los parametros
        String accion = req.getParameter("accion");

        //2. creamos los javabeans 
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);

        //3. Agregamos el javabean a algun alcance
        req.setAttribute("mensaje", "Saludos desde el Servlet");

        //revisamos la accion proporcionada
        if ("agregaVariables".equals(accion)) {
            //Alcance request 
            req.setAttribute("recRequest", recRequest);
            //Alcance session
            HttpSession sesion = req.getSession();
            sesion.setAttribute("recSession", recSession);
            //Alcance Application
            ServletContext application = this.getServletContext();
            application.setAttribute("recApplication", recApplication);

            req.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4. redireccionamos al jsp de index
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            

        } else if ("listarVariables".equals(accion)) {
            //4. redireccionanr al jsp que despliega las variables
            req.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(req, resp);
        } else {
            //4. Redireccionamos a la pagina de inicio
            req.setAttribute("mensaje", "Accion no proporcioanda o desconocida");
            req.getRequestDispatcher("index.jsp").forward(req, resp);

            //se puede usar response.sendRedirect("index.jsp") para redirigir 
            //pero no permite enviar o compartir informacion desde el Serlet 
            //porque no se está propagando el objeto request y response 
            //resp.sendRedirect("index.jsp");
        }
    }
}
