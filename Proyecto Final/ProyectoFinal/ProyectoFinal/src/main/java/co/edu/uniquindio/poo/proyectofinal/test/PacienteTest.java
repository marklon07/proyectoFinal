package co.edu.uniquindio.poo.proyectofinal.test;

import co.edu.uniquindio.poo.proyectofinal.model.CitaMedica;
import co.edu.uniquindio.poo.proyectofinal.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectofinal.model.Medico;
import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
import org.junit.Test;

import static org.junit.Assert.*;

public class PacienteTest {

    @Test
   public void testActualizarDatosPersonales() {
        Paciente paciente = new Paciente("Juan", "123456789", "Juancho@gmail.com","21");
        paciente.actualizarPaciente("10050923", "Carlos", "Carlitos@gmail.com","20");

        assertEquals("Carlos", paciente.getNombre());
        assertEquals("10050923", paciente.getCedula());
        assertEquals("Carlitos@gmail.com", paciente.getCorreo());
    }

    @Test
    public void testSolicitarYCancelaCita() {
        Medico medico = new Medico("Dr. Smith", "23906171","smit@gmail.com","60","Cardiologia");
        Paciente paciente = new Paciente("Ana", "1122334455", "anita123@gmail.com", "56");
        CitaMedica cita = new CitaMedica("2025-06-01", medico, paciente);
        paciente.solicitarCita(cita);
        assertTrue(paciente.getCitas().contains(cita));
        paciente.cancelarCita(cita);
        assertFalse(paciente.getCitas().contains(cita));
    }


    @Test
    public void testConsultarHistorialMedico() {
        Paciente paciente = new Paciente("Luis", "111222333444", "luisino@gmail.com","45");
        HistorialMedico historial = new HistorialMedico();
        historial.agregarEntrada("2025-05-01", "Consulta general");
        paciente.setHistorialMedico(historial);

        assertEquals(1, paciente.getHistorialMedico().getEntradas().size());
    }

    void testRecibirNotificacionCita() {
        // Crear una instancia de Paciente
        Paciente paciente = new Paciente("Maria", "5566778899", "mari203@gmail.com","52");
        String mensajeNotificacion = "Cita programada para el 2025-06-01 a las 10:00";
        paciente.recibirNotificacion(mensajeNotificacion);
        assertTrue(paciente.getNotificaciones().contains(mensajeNotificacion));
    }

}