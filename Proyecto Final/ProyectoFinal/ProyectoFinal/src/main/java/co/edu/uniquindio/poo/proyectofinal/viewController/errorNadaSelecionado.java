package co.edu.uniquindio.poo.proyectofinal.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.event.ActionEvent; // Necesario para el ActionEvent del botón
import javafx.stage.Stage; // Necesario para cerrar la ventana

import java.io.IOException;

public class errorNadaSelecionado {

    @FXML
    private Button btnRegresar;

    @FXML
    public void initialize() {
        System.out.println("Ventana de error 'Nada Seleccionado' cargada.");

    }

    @FXML
    private void handleRegresar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inicioSesion.fxml"));
        Parent root = loader.load();
        errorNadaSelecionado controller = loader.getController();
        Stage stage = new Stage();
        Stage stage1 = (Stage) btnRegresar.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

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