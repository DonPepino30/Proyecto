package domain;

import java.util.List;

class ComplejoDeportivo {
    
    private int idComplejoDeportivo;
    private String nombre;
    private String localizacion;
    private String jefeOrganizacion;
    
    List<String> deportes;
    List<Evento> eventos;

    public ComplejoDeportivo(int idComplejoDeportivo, String nombre, String localizacion, String jefeOrganizacion) {
        this.idComplejoDeportivo = idComplejoDeportivo;
        this.nombre = nombre;
        this.localizacion = localizacion;
        this.jefeOrganizacion = jefeOrganizacion;
    }

    public int getIdComplejoDeportivo() {
        return idComplejoDeportivo;
    }

    public void setIdComplejoDeportivo(int idComplejoDeportivo) {
        this.idComplejoDeportivo = idComplejoDeportivo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getJefeOrganizacion() {
        return jefeOrganizacion;
    }

    public void setJefeOrganizacion(String jefeOrganizacion) {
        this.jefeOrganizacion = jefeOrganizacion;
    }

    public List<String> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<String> deportes) {
        this.deportes = deportes;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    
    
}
