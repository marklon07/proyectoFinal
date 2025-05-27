package co.edu.uniquindio.poo.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Persona {
    private String especialidad;
    private List<Paciente> pacientes;
    private List<HorarioConsulta> horarios;
    private List<String> notificaciones;

    public Medico(String nombre, String cedula, String correo, String edad, String especialidad) {
        super(nombre, cedula, correo, edad);
        this.especialidad = especialidad;
        this.pacientes = new ArrayList<>();
        this.horarios = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // Acceder a historiales médicos
    public HistorialMedico verHistoriales(Paciente paciente) {
        HistorialMedico historial = null;
        for (Paciente pacienteIt : pacientes) {
            if (pacienteIt == paciente) {
                historial = paciente.getHistorialMedico();
                break;
            }
        }
        return historial;
    }

    //METODO PARA CREAR DIAGNOSTICO
    public boolean crearDiagnostico(Paciente paciente, String diagnostico, String informacion){
        boolean i = false;
        for (Paciente pacienteIt : pacientes) {
            if (pacienteIt == paciente) {
                diagnostico.formatted(informacion);
                diagnostico.split(String.valueOf(paciente));
                i = true;
                break;
            }
        }
        return i;
    }

    //METODO PARA CREAR TRATAMIENTO
    public boolean crearTratamiento(Paciente paciente, String tratamiento, String informacion){
        boolean i = false;
        for (Paciente pacienteIt : pacientes) {
            if (pacienteIt == paciente) {
                tratamiento.formatted(informacion);
                tratamiento.split(String.valueOf(paciente));
                i = true;
                break;
            }
        }
        return i;
    }



    // 2. Registrar diagnóstico y tratamiento a un paciente
    public boolean registrarDiagnosticoTratamiento(Paciente paciente, String diagnostico, String tratamiento) {
        boolean i = false;
        if (pacientes.contains(paciente)) {
            paciente.getHistorialMedico().agregarEntrada(diagnostico, tratamiento);
            i = true;
        }
        return i;
    }

    // 3. Administrar horarios de consulta
    public void agregarHorario(HorarioConsulta horario) {

        horarios.add(horario);
    }

    public void eliminarHorario(HorarioConsulta horario) {

        horarios.remove(horario);
    }

    public List<HorarioConsulta> getHorarios() {

        return horarios;
    }

    // 4. Notificaciones de cambios en citas
    public void notificarCambioCita(String mensaje) {

        notificaciones.add(mensaje);
    }

    public List<String> getNotificaciones() {

        return notificaciones;
    }

    // Getters y setters
    public String getEspecialidad() {

        return especialidad;
    }

    public void setEspecialidad(String especialidad) {

        this.especialidad = especialidad;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void agregarPaciente(Paciente paciente) {
    }
}
