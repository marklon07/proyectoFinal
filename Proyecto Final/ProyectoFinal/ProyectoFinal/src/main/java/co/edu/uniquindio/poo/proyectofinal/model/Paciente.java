package co.edu.uniquindio.poo.proyectofinal.model;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Persona{
    private HistorialMedico historialMedico;
    private List<CitaMedica> citas;
    private List<String> notificaciones;

    public Paciente(String nombre, String cedula, String correo, String edad) {
        super(nombre, cedula, correo, edad);
        this.historialMedico = new HistorialMedico("HIST-" + cedula, this);
        this.citas = new ArrayList<>();
        this.notificaciones = new ArrayList<>();
    }

    // 1. Registro y actualización de datos personales (heredado de Persona, puedes usar setters)

    public void actualizarDatos(String nombre, String correo, String edad) {
        setNombre(nombre);
        setCorreo(correo);
        setEdad(edad);
    }

    // 2. Solicitud de cita médica
    public void solicitarCita(CitaMedica cita) {
        citas.add(cita);
        notificaciones.add("Cita solicitada para el " + cita.getFecha() + " con el Dr. " + cita.getMedico().getNombre());
    }

    // 3. Cancelación de cita médica
    public void cancelarCita(CitaMedica cita) {
        if (citas.remove(cita)) {
            notificaciones.add("Cita cancelada para el " + cita.getFecha());
        }
    }

    // 4. Consulta del historial médico
    public HistorialMedico getHistorialMedico() {

        return historialMedico;
    }

    // 5. Recepción de notificaciones
    public void recibirNotificacion(String mensaje) {

        notificaciones.add(mensaje);
    }

    public List<String> getNotificaciones() {

        return notificaciones;
    }

    public List<CitaMedica> getCitas() {

        return citas;
    }
}
