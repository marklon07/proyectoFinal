package co.edu.uniquindio.poo.proyectofinal.test;

import co.edu.uniquindio.poo.proyectofinal.model.HistorialMedico;
import co.edu.uniquindio.poo.proyectofinal.model.HorarioConsulta;
import co.edu.uniquindio.poo.proyectofinal.model.Medico;
import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedicoTest {

    @Test
    public void testAccederHistorialPaciente() {
        Medico medico = new Medico("Dr. Smith", "24805989","smith@gmail.com","41","Cardiologia");
        Paciente paciente = new Paciente("Carlos", "10050923", "Carlitos@gmail.com","20");
        HistorialMedico historial = new HistorialMedico();
        historial.agregarEntrada("2025-04-15", "Chequeo cardiaco");
        paciente.setHistorialMedico(historial);

        HistorialMedico obtenido = medico.verHistoriales(paciente);
        assertEquals(historial, obtenido);
    }

    @Test
    public void testRegistrarDiagnosticoYTratamiento() {
        Medico medico = new Medico("Dr. Lopez", "1094386","lopera@gmail.com","50","Dermatologia");
        Paciente paciente = new Paciente("Laura", "2233445566", "lauri@gmail.com","32");

        medico.crearDiagnostico(paciente, "Dermatitis","");
        medico.crearTratamiento(paciente, "Crema tópica","");

        assertEquals("Dermatitis", paciente.getDiagnostico());
        assertEquals("Crema tópica", paciente.getTratamiento());
    }

    @Test
    public void testAdministrarHorariosConsulta() {
        Medico medico = new Medico("Dr. Torres", "238904256","Torresin@gmail.com","47","Pediatra");
        HorarioConsulta horario = new HorarioConsulta("Lunes", "08:00", "12:00");

        medico.agregarHorario(horario);
        assertTrue(medico.getHorarios().contains(horario));

        medico.eliminarHorario(horario);
        assertFalse(medico.getHorarios().contains(horario));
    }
    @Test
    public void testNotificarCambioCita() {

            Medico medico = new Medico("Dr. Torres", "238904256","Torresin@gmail.com","47","Pediatria");
            HorarioConsulta horario = new HorarioConsulta("Lunes", "08:00", "12:00");

            medico.agregarHorario(horario);
            assertTrue(medico.getHorarios().contains(horario));

            medico.eliminarHorario(horario);
            assertFalse(medico.getHorarios().contains(horario));
    }
}
