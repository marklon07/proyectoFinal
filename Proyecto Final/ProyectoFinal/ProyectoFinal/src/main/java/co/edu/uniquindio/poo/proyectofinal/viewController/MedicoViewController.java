package co.edu.uniquindio.poo.proyectofinal.viewController;

import javafx.event.ActionEvent;
import co.edu.uniquindio.poo.proyectofinal.controller.MedicoController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MedicoViewController {
    MedicoController medicoController;

    @FXML
    private Button btnDiagnostico;

    @FXML
    private Button btnHistorialMedico;

    @FXML
    private Button btnHorario;

    @FXML
    private Button btnSalir;

    @FXML
    private Button btnTratamiento;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtMedico;

    @FXML
    void cambiarVentana(ActionEvent event) {
        Button boton = (Button) event.getSource();
        String ventana = "";

        if (boton.getId().equals("btnHistorialMedico")) {
            ventana = "ViewHistorialMedico.fxml";
        } else if (boton.getId().equals("btnDiagnostico")) {
            ventana = "ViewDiagnostico.fxml";
        } else if (boton.getId().equals("btnTratamiento")) {
            ventana = "ViewTratamiento.fxml";
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/" + ventana));
            Parent root = loader.load();

            Stage stage = (Stage) boton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void mostrarEspecialidad(ActionEvent event) {
        medicoController.verEspecialidad();
    }

    @FXML
    void mostrarMedico(ActionEvent event) {
        medicoController.verMedico();
    }

    @FXML
    void ventanaAnterior(ActionEvent event) {
        Button boton = (Button) event.getSource();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/iniciosesion.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) boton.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
