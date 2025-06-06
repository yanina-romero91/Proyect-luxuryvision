package clientes;

import model.Cliente;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {

    private ClienteDAO clienteDAO;

    public ClienteService() {
        clienteDAO = new ClienteDAO();
    }

    // Obtener todos los clientes
    public List<Cliente> obtenerClientes() throws SQLException {
        return clienteDAO.getClientes();
    }

    // Agregar un nuevo cliente
    public void agregarCliente(Cliente cliente) throws SQLException {
        clienteDAO.insertarCliente(cliente);
    }
}
