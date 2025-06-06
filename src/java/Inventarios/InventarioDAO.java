package inventarios;

import model.Inventario;
import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    // Obtener todos los productos en inventario
    public List<Inventario> getInventarios() throws SQLException {
        List<Inventario> inventarios = new ArrayList<>();
        String sql = "SELECT * FROM inventarios"; // Consulta SQL para obtener todos los productos
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Inventario inventario = new Inventario();
                inventario.setId(rs.getInt("id"));
                inventario.setProducto(rs.getString("producto"));
                inventario.setCantidad(rs.getInt("cantidad"));
                inventario.setPrecio(rs.getDouble("precio"));
                inventarios.add(inventario);
            }
        }
        return inventarios;
    }

    // Insertar un nuevo producto en inventario
    public void insertarInventario(Inventario inventario) throws SQLException {
        String sql = "INSERT INTO inventarios (producto, cantidad, precio) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, inventario.getProducto());
            stmt.setInt(2, inventario.getCantidad());
            stmt.setDouble(3, inventario.getPrecio());
            stmt.executeUpdate();
        }
    }
}
