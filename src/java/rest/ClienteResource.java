package rest;

import model.Cliente;
import clientes.ClienteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.SQLException;
import java.util.List;

@Path("/clientes")
public class ClienteResource {

    private ClienteService clienteService = new ClienteService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> getClientes() throws SQLException {
        return clienteService.obtenerClientes();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCliente(Cliente cliente) throws SQLException {
        clienteService.agregarCliente(cliente);
        return Response.status(Response.Status.CREATED).entity(cliente).build();
    }
}
