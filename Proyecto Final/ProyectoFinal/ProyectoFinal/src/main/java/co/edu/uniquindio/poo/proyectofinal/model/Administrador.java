package co.edu.uniquindio.poo.proyectofinal.model;

import java.util.ArrayList;

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
    public static boolean eliminarPaciente(String id){
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
    public static Paciente buscarPacient(String id){
        boolean i = false;
        ArrayList<Paciente> listPacientes = Hospital.getListPacientes();
        for(Paciente paciente : listPacientes){
            if(paciente.getCedula().equals(id)){
                return paciente;
            }
        }
        return null;
    }


}
