package co.edu.uniquindio.poo.proyectofinal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

// Importa aquí tus clases de modelo si las necesitas, por ejemplo:
// import co.edu.uniquindio.poo.proyectofinal.model.Paciente;

public class pacienteViewController {

    @FXML
    private Label lblWelcomePaciente; // Si agregaras un Label de bienvenida con fx:id="lblWelcomePaciente"

    // Este método se llamaría desde el HelloController para pasar el nombre de usuario
    public void setWelcomeMessage(String username) {
        // Si tienes un Label con fx:id="lblWelcomePaciente" en tu FXML, podrías hacer esto:
        // lblWelcomePaciente.setText("Bienvenido, " + username);
        System.out.println("Paciente logueado: " + username); // Solo para depuración si no hay Label
    }

    // Método initialize: se ejecuta automáticamente al cargar el FXML
    @FXML
    public void initialize() {
        // Aquí puedes realizar cualquier configuración inicial necesaria para la interfaz del paciente.
        // Por ejemplo, cargar datos iniciales del paciente desde tu modelo/base de datos.
        System.out.println("Panel de Paciente cargado.");
    }

    // --- Manejadores de Eventos para los Botones ---

    @FXML
    private void handleActualizarPerfil(ActionEvent event) {
        // Lógica para abrir la interfaz de actualización de perfil del paciente
        System.out.println("Botón 'Actualizar Perfil' presionado.");
        mostrarAlerta(AlertType.INFORMATION, "Funcionalidad", "Aquí se abriría la ventana para actualizar el perfil.");
        // TODO: Implementar la navegación a la interfaz de Actualizar Perfil
    }

    @FXML
    private void handleSolicitarCita(ActionEvent event) {
        // Lógica para abrir la interfaz de solicitud de citas
        System.out.println("Botón 'Solicitar Cita' presionado.");
        mostrarAlerta(AlertType.INFORMATION, "Funcionalidad", "Aquí se abriría la ventana para solicitar una nueva cita.");
        // TODO: Implementar la navegación a la interfaz de Solicitud de Citas
    }

    @FXML
    private void handleCancelarCita(ActionEvent event) {
        // Lógica para abrir la interfaz de cancelación de citas
        System.out.println("Botón 'Cancelar Cita' presionado.");
        mostrarAlerta(AlertType.INFORMATION, "Funcionalidad", "Aquí se abriría la ventana para cancelar una cita existente.");
        // TODO: Implementar la navegación a la interfaz de Cancelar Cita
    }

    @FXML
    private void handleVerHistorial(ActionEvent event) {
        // Lógica para abrir la interfaz de visualización del historial médico
        System.out.println("Botón 'Ver Historial Médico' presionado.");
        mostrarAlerta(AlertType.INFORMATION, "Funcionalidad", "Aquí se abriría la ventana para ver el historial médico.");
        // TODO: Implementar la navegación a la interfaz de Historial Médico
    }

    // --- Método Auxiliar para Alertas ---

    private void mostrarAlerta(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}