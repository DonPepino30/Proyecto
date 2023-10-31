package domain;

public class Participante extends Persona {
    
    private int idParticipante;

    public Participante(int idParticipante, String nombre, int edad, String sexo) {
        super(nombre, edad, sexo);
        this.idParticipante = idParticipante;
    }

    public int getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }
    
}
