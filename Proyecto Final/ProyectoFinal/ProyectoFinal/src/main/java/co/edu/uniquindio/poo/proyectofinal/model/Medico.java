package co.edu.uniquindio.poo.proyectofinal.model;

public class Medico extends Persona {
    private String especialidad;
    public Medico(String nombre, String cedula, String correo, String edad, String especialidad){
        super(nombre, cedula, correo, edad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
