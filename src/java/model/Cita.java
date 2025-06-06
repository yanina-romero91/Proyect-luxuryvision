package model;

import java.util.Date;

public class Cita {

    private int id;
    private int clienteId;
    private Date fecha;
    private String estado; // Ejemplo: Pendiente, Confirmada, Cancelada

    // Constructor vacío
    public Cita() {}

    // Constructor con todos los atributos
    public Cita(int id, int clienteId, Date fecha, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
