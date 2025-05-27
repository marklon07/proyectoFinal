package co.edu.uniquindio.poo.proyectofinal.test;

import co.edu.uniquindio.poo.proyectofinal.model.*;
import co.edu.uniquindio.poo.proyectofinal.model.Sala;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdministradorTest {
    @Test
    public void testAgregarPaciente() {
        Hospital hospital = new Hospital ("UQ");
        Administrador admin = new Administrador("Ricardo", "1107978385","Ricardito@gmail.com","27");
        hospital.getListaAdministradores().add(admin);

        admin.agregarPaciente("1010", "Hugo", "Ricardo@gmail.com", "27");
        assertEquals(1, Hospital.getListPacientes().size());

    }

    @Test
    public void testEliminarPaciente() {
        Hospital hospital = new Hospital ("UQ");
        Administrador admin = new Administrador("Ricardo", "1107978385","Ricardito@gmail.com","27");
        Paciente paciente = new Paciente("Juan", "1020", "juan@gmail.com", "27");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListPacientes().add(paciente);

        admin.eliminarPaciente("1020");
        assertEquals(0, Hospital.getListPacientes().size());
    }

    @Test
    public void testActualizarPaciente() {
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        Paciente paciente = new Paciente("Juan", "1020", "juan@gmail.com", "27");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListPacientes().add(paciente);

        admin.actualizarPaciente("1020", "Hugo", "Ricardo@gmail.com", "27");
        assertEquals("Hugo", Hospital.getListPacientes().get(0).getNombre());
    }

    @Test
    public void testBuscarPaciente() {
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        Paciente paciente = new Paciente("Juan", "1020", "juan@gmail.com", "27");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListPacientes().add(paciente);

        assertEquals(paciente, admin.buscarPaciente("1020"));
    }

    @Test
    public void testAgregarMedico(){
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        hospital.getListaAdministradores().add(admin);

        admin.crearMedico("1010", "Marcos", "marcos@gmail.com", "35", "Neurologo");
        assertEquals(1, Hospital.getListMedicos().size());
    }

    @Test
    public void testEliminarMedico(){
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        Medico medico = new Medico("Marcos", "1010", "marcos@gmail.com", "35", "Neurologo");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListMedicos().add(medico);

        admin.eliminarMedico("1010");
        assertEquals(0, Hospital.getListMedicos().size());
    }

    @Test
    public void testActualizarMedico(){
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        Medico medico = new Medico("Marcos", "1010", "marcos@gmail.com", "35", "Neurologo");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListMedicos().add(medico);

        admin.actualizarMedico("1010", "Juan", "Ricardo@gmail.com", "35", "Neurologo");
        assertEquals("Juan", Hospital.getListMedicos().get(0).getNombre());
    }

    @Test
    public void testBuscarMedico(){
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Ricardo", "1020", "juan@gmail.com", "27");
        Medico medico = new Medico("Marcos", "1010", "marcos@gmail.com", "35", "Neurologo");
        hospital.getListaAdministradores().add(admin);
        Hospital.getListMedicos().add(medico);

        assertEquals(medico, admin.buscarMedico("1010"));
    }




    @Test
    public void testGestionSalasYHorarios() {
        Hospital hospital = new Hospital("UQ");
        Administrador admin = new Administrador("Yoel", "77400024","admin123@gmail.com","40");
        hospital.getListaAdministradores().add(admin);

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
