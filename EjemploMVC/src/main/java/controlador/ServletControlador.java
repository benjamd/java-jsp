
 
package controlador;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
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
        //2. creamos los javabeans 
        Rectangulo rec = new Rectangulo(3, 6);
        
        //3. Agregamos el javabean a algun alcance
        req.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession sesion = req.getSession();
        sesion.setAttribute("rectangulo", rec);
        //4. redireccionanr a la vista seleccionada
        RequestDispatcher rd = req.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(req, resp);
        
        
    }
    
    
    
}
