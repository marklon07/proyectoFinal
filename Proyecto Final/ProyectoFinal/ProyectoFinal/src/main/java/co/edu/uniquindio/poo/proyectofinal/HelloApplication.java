package co.edu.uniquindio.poo.proyectofinal;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Asegúrate de que "hello-view.fxml" es el nombre correcto de tu archivo FXML
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("inicioSesion.fxml"));
        // Ancho y Alto de tu FXML
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Sistema Hospitalario UQ"); // Título de tu ventana
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}