package rest;

import model.Cita;
import citas.CitaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/citas")
public class CitaResource {

    private CitaService citaService = new CitaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cita> getCitas() throws SQLException {
        return citaService.obtenerCitas();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCita(Cita cita) throws SQLException {
        citaService.agregarCita(cita);
        return Response.status(Response.Status.CREATED).entity(cita).build();
    }
}
