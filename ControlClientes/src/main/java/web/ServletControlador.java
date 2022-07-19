/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.ClienteDaoJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String idCliente = req.getParameter("idCliente");

        if (accion != null && idCliente != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                case "eliminar":
                    this.eliminarCliente(req, resp);
                    break;
                default:
                    this.accionPorDefecto(req, resp);
                    break;
            }
        } else {
            this.accionPorDefecto(req, resp);
        }

    }

    private void accionPorDefecto(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        System.out.println("clientes = " + clientes);
//        req.setAttribute("clientes", clientes);
//        req.setAttribute("totalClientes", clientes.size());
//        req.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));
//        req.getRequestDispatcher("clientes.jsp").forward(req, resp);

        HttpSession session = req.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalClientes", clientes.size());
        session.setAttribute("saldoTotal", this.calcularSaldoTotal(clientes));

        resp.sendRedirect("clientes.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        String idCliente = req.getParameter("idCliente");
        if (accion != null && idCliente != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(req, resp);
                    break;
                case "modificar":
                    this.actualizarCliente(req, resp);
                    break;
                default:
                    this.accionPorDefecto(req, resp);
                    break;
            }
        } else {
            this.accionPorDefecto(req, resp);
        }

    }

    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        String saldoSRT = req.getParameter("saldo");
        double saldo = 0;
        if (saldoSRT != null && !saldoSRT.trim().equals("")) {
            saldo = Double.parseDouble(saldoSRT);
        }

        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int rows = clienteDao.insertar(cliente);
        System.out.println("client rows inserted = " + rows);

        this.accionPorDefecto(req, resp);
    }

    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        Cliente cliente = clienteDao.encontrar(new Cliente(idCliente));
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/paginas/clientes/editarCliente.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);

    }

    private void actualizarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String email = req.getParameter("email");
        String telefono = req.getParameter("telefono");
        String saldoSRT = req.getParameter("saldo");
        double saldo = 0;
        if (saldoSRT != null && !saldoSRT.trim().equals("")) {
            saldo = Double.parseDouble(saldoSRT);
        }

        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int rows = clienteDao.actualizar(cliente);
        System.out.println("client rows afected = " + rows);

        this.accionPorDefecto(req, resp);

    }

    private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        ClienteDaoJDBC clienteDao = new ClienteDaoJDBC();
        int rows = clienteDao.eliminar(new Cliente(idCliente));
        System.out.println("client rows afected = " + rows);

        this.accionPorDefecto(req, resp);
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;

        for (Cliente cli : clientes) {
            saldoTotal += cli.getSaldo();
        }

        return saldoTotal;
    }

}
