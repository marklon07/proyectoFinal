package co.edu.uniquindio.poo.proyectofinal.model;

import java.util.Collection;

public class Sala {
    public int numSala;
    public String especialidad;

    public Sala(String numSala, String especialidad) {
        this.numSala = Integer.parseInt(numSala);
        this.especialidad = especialidad;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Collection<Object> getHorarios() {
        return null;
    }
}
