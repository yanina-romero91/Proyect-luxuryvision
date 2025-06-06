package inventarios;

import model.Inventario;
import java.sql.SQLException;
import java.util.List;

public class InventarioService {

    private InventarioDAO inventarioDAO;

    public InventarioService() {
        inventarioDAO = new InventarioDAO();
    }

    // Obtener todos los productos en inventario
    public List<Inventario> obtenerInventarios() throws SQLException {
        return inventarioDAO.getInventarios();
    }

    // Agregar un nuevo producto al inventario
    public void agregarInventario(Inventario inventario) throws SQLException {
        inventarioDAO.insertarInventario(inventario);
    }
}
