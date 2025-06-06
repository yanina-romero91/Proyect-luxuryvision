package rest;

import model.Inventario;
import inventarios.InventarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/inventarios")
public class InventarioResource {

    private InventarioService inventarioService = new InventarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Inventario> getInventarios() throws SQLException {
        return inventarioService.obtenerInventarios();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addInventario(Inventario inventario) throws SQLException {
        inventarioService.agregarInventario(inventario);
        return Response.status(Response.Status.CREATED).entity(inventario).build();
    }
}
