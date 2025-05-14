package co.edu.uniquindio.poo.proyectofinal.model;

public class HistorialMedico {
    private String id;
    private Paciente paciente;
    private String informacion;

    public  HistorialMedico(String id, Paciente paciente, String informacion) {
        this.id = id;
        this.paciente = paciente;
        this.informacion = informacion;
    }

    //METODO GETTER Y SETTER

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
