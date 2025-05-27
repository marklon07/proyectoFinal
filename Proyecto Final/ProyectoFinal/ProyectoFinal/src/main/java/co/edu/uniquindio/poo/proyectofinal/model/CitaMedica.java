package co.edu.uniquindio.poo.proyectofinal.model;

public class CitaMedica {
    private String fecha;
    private Medico medico;
    private Paciente paciente;

    // Constructor corregido: recibe objetos Medico y Paciente
    public CitaMedica(String fecha, Medico medico, Paciente paciente) {
        this.fecha = fecha;
        this.medico = medico;
        this.paciente = paciente;
    }


    // Getters y setters
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}




