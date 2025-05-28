package co.edu.uniquindio.poo.proyectofinal.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent; // Importa ActionEvent para manejar eventos de los botones
import javafx.stage.Stage;

import java.io.IOException;

public class inicioSesion {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbTipoUsuario;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnRegistrar;


    @FXML
    public void initialize() {
    }

    @FXML
    protected void btnLogin_Click(ActionEvent event) throws IOException {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String tipoUsuario = cmbTipoUsuario.getValue();
        FXMLLoader loader;
        Parent root;
        Stage stage = (Stage) btnLogin.getScene().getWindow();

        if (usuario.equals("admin") && password.equals("123") && "Administrador".equals(tipoUsuario)) {
            loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/paneladministrador.fxml"));
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Administrador");
            stage.show();

        } else if (usuario.equals("medico") && password.equals("pass") && "Médico".equals(tipoUsuario)) {
            loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/viewMedico.fxml"));
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel del Médico");
            stage.show();

        } else if (usuario.equals("paciente") && password.equals("345") && "Paciente".equals(tipoUsuario)) {
            loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/paciente.fxml"));
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Paciente");
            stage.show();

        } else {
            System.out.println("Usuario, contraseña o tipo de usuario incorrectos.");
            loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/poo/proyectofinal/errorNadaSeleccionado.fxml"));
            root = loader.load();
            stage.setScene(new Scene(root));
            stage.setTitle("Error");
            stage.show();
        }
    }

    @FXML
    protected void btnRegistrar_Click(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String tipoUsuario = cmbTipoUsuario.getValue();

        System.out.println("--- Intento de Registro ---");
        System.out.println("Usuario a registrar: " + usuario);
        System.out.println("Contraseña a registrar: " + password);
        System.out.println("Tipo de Usuario seleccionado para registro: " + (tipoUsuario != null ? tipoUsuario : "No seleccionado"));


        if (usuario.isEmpty() || password.isEmpty() || tipoUsuario == null) {
            System.out.println("Error de registro: Por favor, complete todos los campos.");

        } else {
            System.out.println("Usuario '" + usuario + "' de tipo '" + tipoUsuario + "' registrado (simulado) exitosamente.");
            txtUsuario.clear();
            txtPassword.clear();
            cmbTipoUsuario.getSelectionModel().clearSelection(); // Deselecciona el ítem
        }
    }
}