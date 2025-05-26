package co.edu.uniquindio.poo.proyectofinal;

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

public class HelloController {

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
        String tipoUsuario = cmbTipoUsuario.getValue(); // Obtiene el valor seleccionado del ComboBox

        System.out.println("--- Intento de Inicio de Sesión ---");
        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + password); // ¡En una aplicación real, nunca imprimas contraseñas!
        System.out.println("Tipo de Usuario: " + (tipoUsuario != null ? tipoUsuario : "No seleccionado"));

        // Aquí agregarías tu lógica de autenticación.
        // Por ejemplo, verificar contra una base de datos, una lista de usuarios codificados, etc.
        if (usuario.equals("admin") && password.equals("123") && "Administrador".equals(tipoUsuario)) {
            System.out.println("¡Inicio de sesión como Administrador exitoso!");
            // TODO: Navegar al panel de administrador
        } else if (usuario.equals("medico") && password.equals("pass") && "Médico".equals(tipoUsuario)) {
            System.out.println("¡Inicio de sesión como Médico exitoso!");
            // TODO: Navegar a la interfaz del médico

        }else if (usuario.equals("paciente") && password.equals("345")&&"Paciente".equals(tipoUsuario)) {
            System.out.println("¡Inicio de sesión como Paciente exitoso!"); // Es buena idea mantener este log
            FXMLLoader loader = new FXMLLoader(getClass().getResource("paciente.fxml")); // Ruta al FXML del paciente
            Parent root = loader.load();

            // Si tienes un controlador específico para paciente.fxml, puedes obtenerlo aquí:
            pacienteViewController pacienteViewController = loader.getController();
            // Y luego, si necesitas, pasarle datos iniciales a ese controlador.
            // pacienteController.initData(datosDelPaciente);

            Stage stage = (Stage) btnLogin.getScene().getWindow(); // Obtienes la ventana actual
            Scene scene = new Scene(root); // Creas la nueva escena con la vista del paciente
            stage.setScene(scene); // Estableces la nueva escena en la ventana
            stage.setTitle("Panel de Paciente"); // Cambias el título de la ventana
            stage.show(); // Muestras la nueva interfaz

        } else {
            System.out.println("Usuario, contraseña o tipo de usuario incorrectos.");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorNadaSeleccionado.fxml"));
            Parent root = loader.load();
            errorNadaSelecionado errNadaSelecionado = loader.getController();
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Error");
            stage.show();
            // TODO: Mostrar un mensaje de error al usuario (por ejemplo, usando un diálogo de Alerta)
        }
    }

    // Manejador de eventos para el botón "Registrarse"
    // La propiedad onAction="#btnRegistrar_Click" en tu FXML enlaza a este método.
    @FXML
    protected void btnRegistrar_Click(ActionEvent event) throws IOException {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("errorNadaSeleccionado.fxml"));
            Parent root = loader.load();
            errorNadaSelecionado errNadaSelecionado = loader.getController();
            Stage stage = (Stage) btnRegistrar.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Error");
            stage.show();
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
