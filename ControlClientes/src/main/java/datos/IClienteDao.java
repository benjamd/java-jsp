/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import dominio.Cliente;
import java.util.List;

/**
 *
 * @author benja
 */
public interface IClienteDao {
    
    public List<Cliente> listar();
    public Cliente encontrar(Cliente cliente);
    public int insertar(Cliente cliente);
    public int actualizar(Cliente cliente);
    public int eliminar(Cliente cliente);
    
}
