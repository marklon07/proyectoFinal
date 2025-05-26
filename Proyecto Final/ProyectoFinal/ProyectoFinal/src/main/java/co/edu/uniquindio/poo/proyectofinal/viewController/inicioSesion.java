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

    // Anotaciones FXML para inyectar los componentes de la UI desde tu archivo .fxml
    @FXML
    private TextField txtUsuario; // Corresponde a fx:id="txtUsuario" en tu FXML

    @FXML
    private PasswordField txtPassword; // Corresponde a fx:id="txtPassword" en tu FXML

    @FXML
    private ComboBox<String> cmbTipoUsuario; // Corresponde a fx:id="cmbTipoUsuario" en tu FXML

    @FXML
    private Button btnLogin; // Corresponde a fx:id="btnLogin" en tu FXML

    @FXML
    private Button btnRegistrar; // Corresponde a fx:id="btnRegistrar" en tu FXML

    // Este método es llamado automáticamente por JavaFX después de que el archivo FXML se carga.
    // Es un buen lugar para realizar tareas de inicialización, como poblar el ComboBox.
    @FXML
    public void initialize() {
        // Ya tienes los <items> definidos en tu FXML, así que quizás no necesites hacer esto aquí
        // a menos que quieras agregar elementos programáticamente o realizar otra configuración.
        // Ejemplo si quisieras agregar elementos programáticamente:
        // ObservableList<String> userTypes = FXCollections.observableArrayList(
        //     "Paciente", "Médico", "Administrador"
        // );
        // cmbTipoUsuario.setItems(userTypes);

        // Opcional: Establecer un valor seleccionado por defecto o un texto de sugerencia si no está en FXML
        // cmbTipoUsuario.getSelectionModel().selectFirst(); // Selecciona "Paciente"
    }

    // Manejador de eventos para el botón "Iniciar Sesión"
    // La propiedad onAction="#btnLogin_Click" en tu FXML enlaza a este método.
    @FXML
    protected void btnLogin_Click(ActionEvent event) throws IOException {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String tipoUsuario = cmbTipoUsuario.getValue();

        System.out.println("--- Intento de Inicio de Sesión ---");
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + password);
        System.out.println("Tipo de Usuario: " + (tipoUsuario != null ? tipoUsuario : "No seleccionado"));

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

    // Manejador de eventos para el botón "Registrarse"
    // La propiedad onAction="#btnRegistrar_Click" en tu FXML enlaza a este método.
    @FXML
    protected void btnRegistrar_Click(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String tipoUsuario = cmbTipoUsuario.getValue();

        System.out.println("--- Intento de Registro ---");
        System.out.println("Usuario a registrar: " + usuario);
        System.out.println("Contraseña a registrar: " + password);
        System.out.println("Tipo de Usuario seleccionado para registro: " + (tipoUsuario != null ? tipoUsuario : "No seleccionado"));

        // Aquí agregarías tu lógica de registro.
        // Por ejemplo, guardar el nuevo usuario en una base de datos.
        if (usuario.isEmpty() || password.isEmpty() || tipoUsuario == null) {
            System.out.println("Error de registro: Por favor, complete todos los campos.");
            // TODO: Mostrar un mensaje de error.
        } else {
            System.out.println("Usuario '" + usuario + "' de tipo '" + tipoUsuario + "' registrado (simulado) exitosamente.");
            // TODO: Guardar usuario en la base de datos, mostrar mensaje de éxito, quizás limpiar campos o navegar al inicio de sesión.
            txtUsuario.clear();
            txtPassword.clear();
            cmbTipoUsuario.getSelectionModel().clearSelection(); // Deselecciona el ítem
        }
    }
}