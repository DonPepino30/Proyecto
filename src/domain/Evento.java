package domain;

import java.time.LocalDate;
import java.util.List;

class Evento {
    
    private int idEvento;
    private LocalDate fecha;
    private String nombre;
    private int duracionMinutos;
    
    List<Persona> personas;
    List<String> equipamientos;

    public Evento(int idEvento, LocalDate fecha, String nombre, int duracionMinutos) {
        this.idEvento = idEvento;
        this.fecha = fecha;
        this.nombre = nombre;
        this.duracionMinutos = duracionMinutos;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public List<String> getEquipamientos() {
        return equipamientos;
    }

    public void setEquipamientos(List<String> equipamientos) {
        this.equipamientos = equipamientos;
    }
    
}
