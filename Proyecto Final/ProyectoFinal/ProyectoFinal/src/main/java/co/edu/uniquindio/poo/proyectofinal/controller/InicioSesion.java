package co.edu.uniquindio.poo.proyectofinal.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label; // Asegúrate de importar todas las clases necesarias
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent; // Para los eventos de los botones

public class InicioSesion {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cmbTipoUsuario; // Declara la ComboBox con el mismo fx:id y tipo de dato

    @FXML
    private void btnLogin_Click(ActionEvent event) {
        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String tipoUsuario = cmbTipoUsuario.getSelectionModel().getSelectedItem(); // Obtiene el valor seleccionado

        if (tipoUsuario == null) {
            // Manejar el caso donde no se ha seleccionado un tipo de usuario
            System.out.println("Por favor, seleccione un tipo de usuario.");
            // Aquí podrías mostrar un mensaje de error en la interfaz
            return;
        }

        System.out.println("Usuario: " + usuario);
        System.out.println("Contraseña: " + password);
        System.out.println("Tipo de Usuario: " + tipoUsuario);

        // A partir de aquí, implementa tu lógica de autenticación
        // basándote en el 'tipoUsuario' seleccionado.
        // Por ejemplo:
        if (tipoUsuario.equals("Administrador")) {
            // Lógica de autenticación para administradores
            // y luego cargar la vista del administrador
        } else if (tipoUsuario.equals("Médico")) {
            // Lógica de autenticación para médicos
            // y luego cargar la vista del médico
        } else if (tipoUsuario.equals("Paciente")) {
            // Lógica de autenticación para pacientes
            // y luego cargar la vista del paciente
        }
    }

    @FXML
    private void btnRegistrar_Click(ActionEvent event) {
        // Lógica para el botón de registrarse
        System.out.println("Botón Registrarse clickeado");
    }

    // Si necesitas inicializar el ComboBox programáticamente (por ejemplo, si las opciones vinieran de una DB)
    // podrías usar el método initialize()
    /*
    @FXML
    public void initialize() {
        // No es estrictamente necesario aquí ya que los items están en el FXML,
        // pero si quisieras añadir más, lo harías aquí:
        // cmbTipoUsuario.getItems().add("Otro Rol");
    }
    */
}
