package domain;

public class Comisario extends Persona {
    
    private String rol;

    public Comisario(String rol, String nombre, int edad, String sexo) {
        super(nombre, edad, sexo);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }  
    
}
