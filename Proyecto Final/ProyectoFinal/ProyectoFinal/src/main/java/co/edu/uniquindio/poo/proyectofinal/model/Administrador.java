package co.edu.uniquindio.poo.proyectofinal.model;

import java.util.ArrayList;
import java.util.Collection;

public class Administrador extends Persona implements IGestionPaciente {
    public Administrador(String nombre, String cedula, String correo, String edad){
        super(nombre, cedula, correo, edad);
    }

    //METODO PARA CREAR PACIENTE
    @Override
    public boolean agregarPaciente(String id, String nombre, String correo, String edad){
        for(Paciente paciente : Hospital.getListPacientes()){
            if(paciente.getCedula().equals(id)){
                 return false;
            }
        }
        Paciente newpaciente = new Paciente(id, nombre, correo, edad);
        Hospital.getListPacientes().add(newpaciente);
        return true;
    }

    //METODO PARA ELIMINAR PACIENTE
    public boolean eliminarPaciente(String id){
        boolean i = false;
        ArrayList<Paciente> listPacientes = Hospital.getListPacientes();
        for(Paciente paciente : listPacientes){
            if(paciente.getCedula().equals(id)){
                listPacientes.remove(paciente);
                i = true;
                break;

            }
        }
        return i;
    }

    //METODO PARA ACTUALIZAR PACIENTE
    @Override
    public boolean actualizarPaciente(String cedula, String nombre, String correo, String edad){
        boolean i = false;
        for(Paciente paciente : Hospital.getListPacientes()){
            if(paciente.getCedula().equals(cedula)){
                paciente.setNombre(nombre);
                paciente.setCorreo(correo);
                paciente.setEdad(edad);
                i = true;
                break;
            }
        }
        return i;
    }

    //METODO PARA BUSCAR PACIENTE
    public static Paciente buscarPaciente(String id){
        boolean i = false;
        ArrayList<Paciente> listPacientes = Hospital.getListPacientes();
        for(Paciente paciente : listPacientes){
            if(paciente.getCedula().equals(id)){
                return paciente;
            }
        }
        return null;
    }

    //METODO PARA CREAR MEDICO
    public boolean crearMedico(String id, String nombre, String correo, String edad, String especialidad){
        for(Medico medico : Hospital.getListMedicos()){
            if(medico.getCedula().equals(id)){
                return false;
            }
        }
        Medico newmedico = new Medico(nombre, id, correo, edad, especialidad);
        Hospital.getListMedicos().add(newmedico);
        return true;
    }

    //METODO PARA ELIMINAR MEDICO
    public boolean eliminarMedico(String id){
        boolean i = false;
        ArrayList<Medico> listMedicos = Hospital.getListMedicos();
        for(Medico medico : listMedicos){
            if(medico.getCedula().equals(id)){
                listMedicos.remove(medico);
                i = true;
                break;
            }
        }
        return i;
    }

    //METODO PARA ACTUALIZAR MEDICO
    public boolean actualizarMedico(String id, String nombre, String correo, String edad, String especialidad){
        boolean i = false;
        for(Medico medico : Hospital.getListMedicos()){
            if(medico.getCedula().equals(id)){
                medico.setNombre(nombre);
                medico.setCorreo(correo);
                medico.setEdad(edad);
                medico.setEspecialidad(especialidad);
                i = true;
                break;
            }
        }
        return i;
    }

    //METODO PARA BUSCAR MEDICO
    public Medico buscarMedico(String id){
        for(Medico medico : Hospital.getListMedicos()){
            if(medico.getCedula().equals(id)){
                return medico;
            }
        }
        return null;
    }
//    Metodo para asignar un paciente a un medico
public void asignarPacienteAMedico(Paciente paciente, Medico medico) {
    if (paciente != null && medico != null) {
        medico.agregarPaciente(paciente);
        System.out.println("Paciente asignado al médico correctamente.");
    } else {
        System.out.println("No se pudo asignar el paciente. Verifica los datos.");
    }
}


    public Collection<Object> getMedicos() {
     return null;
    }

    public Collection<Object> getPacientes() {
        return null;
    }



    public void agregarSala(co.edu.uniquindio.poo.proyectofinal.model.Sala sala) {

    }

    public void asignarHorarioSala(Sala sala, HorarioConsulta horarioConsulta) {

    }

    public Collection<Object> getSalas() {
        return null;
    }

    public Reporte generarReporteCitas() {
        return null;
    }

    public Reporte generarReporteOcupacion() {
        return null;
    }
}
