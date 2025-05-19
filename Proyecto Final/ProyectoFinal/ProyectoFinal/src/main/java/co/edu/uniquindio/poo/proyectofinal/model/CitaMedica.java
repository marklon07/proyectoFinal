package co.edu.uniquindio.poo.proyectofinal.model;

public class CitaMedica {
    private String fecha;
    private Medico medico;

    public CitaMedica(String fecha, Medico medico) {
        this.fecha = fecha;
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public Medico getMedico() {
        return medico;
    }
}
