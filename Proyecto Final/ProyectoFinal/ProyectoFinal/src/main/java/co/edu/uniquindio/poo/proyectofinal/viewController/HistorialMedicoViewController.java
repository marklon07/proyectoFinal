package co.edu.uniquindio.poo.proyectofinal.viewController;

import co.edu.uniquindio.poo.proyectofinal.controller.MedicoController;
import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HistorialMedicoViewController {
    MedicoController medicoController;
    Paciente paciente;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private ListView<?> lvw1;

    @FXML
    private TextField txt1;

    @FXML
    void cambiarVentana(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/ViewMedico.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Medico");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void verHistorialMedico(ActionEvent event) {
        TextField txt = (TextField) event.getSource();
        if(txt.getText().equals(paciente.getCedula())){
            medicoController.verHistorial(paciente);
        }
    }




}
