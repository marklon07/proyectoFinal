package co.edu.uniquindio.poo.proyectofinal.controller;


import co.edu.uniquindio.poo.proyectofinal.model.Diagnostico;
import co.edu.uniquindio.poo.proyectofinal.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectofinal.model.Hospital;
import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
import co.edu.uniquindio.poo.proyectofinal.model.Medico;
import co.edu.uniquindio.poo.proyectofinal.model.Tratamiento;

public class MedicoController {
    Hospital hospital;
    Medico medico;

    public MedicoController(Hospital hospital){
        this.hospital = hospital;
    }

    public String verEspecialidad(){
        return medico.getEspecialidad();
    }

    public String verMedico(){
        return medico.getNombre();
    }

    public HistorialMedico verHistorial(Paciente paciente){
        return paciente.getHistorialMedico();
    }

    public boolean agregarDiagnostico(Medico medico, Diagnostico diagnostico, Paciente paciente, String informacion){
        return medico.crearDiagnostico(paciente, diagnostico, informacion);
    }

    public boolean agregarTratamieto(Medico medico, Tratamiento tratamiento, Paciente paciente, String informacion) {
        return medico.crearTratamiento(paciente, tratamiento, informacion);
    }
}
