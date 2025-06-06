package clientes;

import model.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import config.DatabaseConnection;

public class ClienteDAO {

    // Método para obtener todos los clientes
    public List<Cliente> getClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes"; // Consulta SQL para obtener todos los clientes
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDni(rs.getString("dni"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setEmail(rs.getString("email"));
                cliente.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    // Método para insertar un nuevo cliente en la base de datos
    public void insertarCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clientes (nombre, dni, telefono, direccion, email, fecha_nacimiento) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getDni());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getDireccion());
            stmt.setString(5, cliente.getEmail());
            stmt.setDate(6, new java.sql.Date(cliente.getFechaNacimiento().getTime()));
            stmt.executeUpdate();
        }
    }
}
