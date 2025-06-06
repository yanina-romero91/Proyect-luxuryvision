package citas;

import model.Cita;
import config.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    // Obtener todas las citas
    public List<Cita> getCitas() throws SQLException {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas"; // Consulta SQL para obtener todas las citas
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setId(rs.getInt("id"));
                cita.setClienteId(rs.getInt("cliente_id"));
                cita.setFecha(rs.getDate("fecha"));
                cita.setEstado(rs.getString("estado"));
                citas.add(cita);
            }
        }
        return citas;
    }

    // Insertar una nueva cita
    public void insertarCita(Cita cita) throws SQLException {
        String sql = "INSERT INTO citas (cliente_id, fecha, estado) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
             
            stmt.setInt(1, cita.getClienteId());
            stmt.setDate(2, new java.sql.Date(cita.getFecha().getTime()));
            stmt.setString(3, cita.getEstado());
            stmt.executeUpdate();
        }
    }
}
