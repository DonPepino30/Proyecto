package domain;

import java.util.List;

public class SedeOlimpica {

    private int idSedeOlimpica;
    private String nombre;
    private String ubicacion;
    
    List<ComplejoDeportivo> complejos;

    public SedeOlimpica(int idSedeOlimpica, String nombre, String ubicacion) {
        this.idSedeOlimpica = idSedeOlimpica;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public int getIdSedeOlimpica() {
        return idSedeOlimpica;
    }

    public void setIdSedeOlimpica(int idSedeOlimpica) {
        this.idSedeOlimpica = idSedeOlimpica;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public List<ComplejoDeportivo> getComplejos() {
        return complejos;
    }

    public void setComplejos(List<ComplejoDeportivo> complejos) {
        this.complejos = complejos;
    }
    
    
}
