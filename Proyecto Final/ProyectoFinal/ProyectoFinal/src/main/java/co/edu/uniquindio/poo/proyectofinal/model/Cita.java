package co.edu.uniquindio.poo.proyectofinal.model;

import java.time.LocalDate;

public class Cita {
    LocalDate fecha;
    String hora;
    Paciente paciente;
    Medico medico;

    public  Cita(LocalDate fecha, String hora, Paciente paciente, Medico medico){
        this.fecha=fecha;
        this.hora=hora;
        this.paciente=paciente;
        this.medico=medico;
    }

    //METODO GETTER Y SETTER

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
