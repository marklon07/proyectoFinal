package co.edu.uniquindio.poo.proyectofinal;

import co.edu.uniquindio.poo.proyectofinal.model.Hospital;
import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws Exception {
        AnchorPane load = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/inicioSesion.fxml"));
        Scene scene = new Scene(load);
        stage.setScene(scene);
        stage.show();
    }

    public void cargarDatosPrueba() {
        Paciente paciente1 = new Paciente("Laura Gómez", "1001", "laura.gomez@gmail.com", "25");
        Paciente paciente2 = new Paciente("Carlos Ramírez", "1002", "carlos.ramirez@hotmail.com", "32");
        Paciente paciente3 = new Paciente("Sofía Martínez", "1003", "sofia.martinez@yahoo.com", "28");
        Paciente paciente4 = new Paciente("Andrés Torres", "1004", "andres.torres@gmail.com", "40");
        Paciente paciente5 = new Paciente("Valentina Rojas", "1005", "valentina.rojas@outlook.com", "19");

        Hospital.getListPacientes().add(paciente1);
        Hospital.getListPacientes().add(paciente2);
        Hospital.getListPacientes().add(paciente3);
        Hospital.getListPacientes().add(paciente4);
        Hospital.getListPacientes().add(paciente5);
    }
}
