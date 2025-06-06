package citas;

import model.Cita;
import java.sql.SQLException;
import java.util.List;

public class CitaService {

    private CitaDAO citaDAO;

    public CitaService() {
        citaDAO = new CitaDAO();
    }

    // Obtener todas las citas
    public List<Cita> obtenerCitas() throws SQLException {
        return citaDAO.getCitas();
    }

    // Agregar una nueva cita
    public void agregarCita(Cita cita) throws SQLException {
        citaDAO.insertarCita(cita);
    }
}
