package co.edu.uniquindio.poo.proyectofinal.test;

import co.edu.uniquindio.poo.proyectofinal.model.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministradorTest {
    @Test
    public void testGestionarUsuarios() {
        Administrador admin = new Administrador("Ricardo", "1107978385","Ricardito@gmail.com","27");
        Medico medico = new Medico("Dr. Vega", "9900337766","Delavega@gmail.com","67","Oncologia");
        Paciente paciente = new Paciente("Sofia", "189456782", "sofi23@gmail.com","17");

        admin.crearMedico(medico);
        admin.agregarPaciente(paciente);
        assertTrue(admin.getMedicos().contains(medico));
        assertTrue(admin.getPacientes().contains(paciente));

        admin.actualizarMedico(medico, "Dr. Vega", "Hematología");
        assertEquals("Hematología", medico.getEspecialidad());

        admin.eliminarPaciente(String.valueOf(paciente));
        assertFalse(admin.getPacientes().contains(paciente));
    }
    @Test
    public void testGestionSalasYHorarios() {
        Administrador admin = new Administrador("Yoel", "77400024","admin123@gmail.com","40");
        Sala sala = new Sala("1", "Pediatría");
        HorarioConsulta horario = new HorarioConsulta("Martes", "09:00", "13:00");

        admin.agregarSala(sala);
        admin.asignarHorarioSala(sala, horario);

        assertTrue(admin.getSalas().contains(sala));
        assertTrue(sala.getHorarios().contains(horario));
    }
    @Test
    public void testMonitoreoYAsignacion() {
        Administrador admin = new Administrador("Yoel", "77400024","admin123@gmail.com","40");
        Medico medico = new Medico("Dr. Ruiz", "3456719","RuizDr@gmail.com","60","Ginecología");
        Paciente paciente = new Paciente("Elena", "7788990011", "elenita@gmail.com","66");

        admin.asignarPacienteAMedico(paciente, medico);
        assertTrue(medico.getPacientes().contains(paciente));
    }
    @Test
    public void testGenerarReportes() {
        Administrador admin = new Administrador("Yoel", "77400024","admin123@gmail.com","40");
        Reporte reporteCitas = admin.generarReporteCitas();
        Reporte reporteOcupacion = admin.generarReporteOcupacion();

        assertNotNull(reporteCitas);
        assertNotNull(reporteOcupacion);
    }




}
