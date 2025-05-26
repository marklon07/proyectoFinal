package co.edu.uniquindio.poo.proyectofinal;



import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional; // Para diálogos de confirmación

// Importa tus clases de modelo aquí (necesitarás crearlas)
// import co.edu.uniquindio.poo.proyectofinal.model.Medico;
// import co.edu.uniquindio.poo.proyectofinal.model.Paciente;
// import co.edu.uniquindio.poo.proyectofinal.model.Sala;
// import co.edu.uniquindio.poo.proyectofinal.model.HorarioMedico;
// import co.edu.uniquindio.poo.proyectofinal.model.CitaMedica;

// Importa tus clases de servicio/DAO aquí (necesitarás crearlas)
// import co.edu.uniquindio.poo.proyectofinal.service.UserService;
// import co.edu.uniquindio.poo.proyectofinal.service.RoomService;
// import co.edu.uniquindio.poo.proyectofinal.service.ScheduleService;
// import co.edu.uniquindio.poo.proyectofinal.service.ReportService;
public class admins {

    // ====================================================================================================
    // Componentes de UI comunes
    // ====================================================================================================
    @FXML
    private Label lblWelcomeAdmin;

    // ====================================================================================================
    // Pestaña: Gestión de Usuarios
    // ====================================================================================================
    @FXML
    private TextField txtUserId;
    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtUserPassword;
    @FXML
    private ComboBox<String> cmbUserType;
    @FXML
    private Button btnRegisterUser;
    @FXML
    private Button btnModifyUser;
    @FXML
    private Button btnDeleteUser;
    @FXML
    private Button btnCleanFields;
    @FXML
    private TableView<Object> tblUsers; // Puede ser TableView<Usuario> si defines una clase base Usuario
    @FXML
    private TableColumn<Object, String> colUserId;
    @FXML
    private TableColumn<Object, String> colUserName;
    @FXML
    private TableColumn<Object, String> colUserPassword; // Cuidado con mostrar contraseñas reales
    @FXML
    private TableColumn<Object, String> colUserType;

    // ====================================================================================================
    // Pestaña: Gestión de Salas y Horarios
    // ====================================================================================================
    @FXML
    private TextField txtRoomId;
    @FXML
    private TextField txtRoomCapacity;
    @FXML
    private Button btnRegisterRoom;
    @FXML
    private Button btnModifyRoom;
    @FXML
    private Button btnDeleteRoom;
    @FXML
    private TableView<Object> tblRooms; // TableView<Sala>
    @FXML
    private TableColumn<Object, String> colRoomId;
    @FXML
    private TableColumn<Object, Integer> colRoomCapacity;
    @FXML
    private TableColumn<Object, Boolean> colRoomAvailability;

    @FXML
    private ComboBox<String> cmbDoctorForSchedule; // ComboBox<Medico>
    @FXML
    private ComboBox<String> cmbScheduleDay;
    @FXML
    private TextField txtScheduleStartTime;
    @FXML
    private TextField txtScheduleEndTime;
    @FXML
    private Button btnAssignSchedule;
    @FXML
    private TableView<Object> tblSchedules; // TableView<HorarioMedico>
    @FXML
    private TableColumn<Object, String> colScheduleDoctor;
    @FXML
    private TableColumn<Object, String> colScheduleDay;
    @FXML
    private TableColumn<Object, String> colScheduleStartTime;
    @FXML
    private TableColumn<Object, String> colScheduleEndTime;

    // ====================================================================================================
    // Pestaña: Monitoreo y Asignación
    // ====================================================================================================
    @FXML
    private DatePicker dpMonitorDate;
    @FXML
    private Button btnShowAvailability;
    @FXML
    private TableView<Object> tblDoctorAvailability; // TableView<DisponibilidadMedico>
    @FXML
    private TableColumn<Object, String> colDocAvailDoctor;
    @FXML
    private TableColumn<Object, String> colDocAvailTime;
    @FXML
    private TableColumn<Object, String> colDocAvailRoom;
    @FXML
    private TableColumn<Object, String> colDocAvailStatus;

    @FXML
    private ComboBox<String> cmbPatientToAssign; // ComboBox<Paciente>
    @FXML
    private ComboBox<String> cmbAppointmentToAssign; // ComboBox<CitaMedica>
    @FXML
    private Button btnAssignAppointment;

    // ====================================================================================================
    // Pestaña: Reportes
    // ====================================================================================================
    @FXML
    private ComboBox<String> cmbReportType;
    @FXML
    private DatePicker dpReportStartDate;
    @FXML
    private DatePicker dpReportEndDate;
    @FXML
    private Button btnGenerateReport;
    @FXML
    private TableView<Object> tblReportData; // Las columnas se configurarían dinámicamente según el reporte


    // ====================================================================================================
    // Clases de Servicio (simuladas por ahora) - Idealmente inyectadas
    // ====================================================================================================
    // private UserService userService;
    // private RoomService roomService;
    // private ScheduleService scheduleService;
    // private ReportService reportService;

    // ====================================================================================================
    // Método Initialize
    // Se llama automáticamente al cargar el FXML
    // ====================================================================================================
    @FXML
    public void initialize() {
        // Asume que las clases de servicio ya están inicializadas o inyectadas
        // userService = new UserService();
        // roomService = new RoomService();
        // scheduleService = new ScheduleService();
        // reportService = new ReportService();

        // 1. Configurar ComboBoxes
        cmbUserType.setItems(FXCollections.observableArrayList("Médico", "Paciente"));
        cmbScheduleDay.setItems(FXCollections.observableArrayList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"));
        cmbReportType.setItems(FXCollections.observableArrayList("Citas Médicas por Fecha", "Ocupación de Salas", "Pacientes Registrados", "Médicos por Especialidad"));

        // TODO: Poblar cmbDoctorForSchedule, cmbPatientToAssign, cmbAppointmentToAssign
        // Esto requeriría cargar datos de médicos, pacientes y citas disponibles de tu modelo/base de datos.
        // Ejemplo: cmbDoctorForSchedule.setItems(FXCollections.observableArrayList(userService.getAllDoctorsNames()));

        // 2. Configurar TableViews (mapear columnas a propiedades del modelo)
        // Las propiedades de PropertyValueFactory deben coincidir con los nombres de los atributos
        // (con getters correspondientes) de tus clases de modelo (ej. Medico, Paciente, Sala).
        colUserId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colUserPassword.setCellValueFactory(new PropertyValueFactory<>("password")); // ¡Cuidado al mostrar passwords!
        colUserType.setCellValueFactory(new PropertyValueFactory<>("tipo")); // Si tienes un campo 'tipo' en tu modelo

        colRoomId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colRoomCapacity.setCellValueFactory(new PropertyValueFactory<>("capacidad"));
        colRoomAvailability.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        colScheduleDoctor.setCellValueFactory(new PropertyValueFactory<>("nombreMedico")); // O el atributo que relacione
        colScheduleDay.setCellValueFactory(new PropertyValueFactory<>("dia"));
        colScheduleStartTime.setCellValueFactory(new PropertyValueFactory<>("horaInicio"));
        colScheduleEndTime.setCellValueFactory(new PropertyValueFactory<>("horaFin"));

        colDocAvailDoctor.setCellValueFactory(new PropertyValueFactory<>("nombreMedico"));
        colDocAvailTime.setCellValueFactory(new PropertyValueFactory<>("horaDisponible"));
        colDocAvailRoom.setCellValueFactory(new PropertyValueFactory<>("salaAsignada"));
        colDocAvailStatus.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // 3. Cargar datos iniciales en las tablas
        // TODO: Cargar todos los usuarios, salas, y horarios existentes al inicio
        // tblUsers.setItems(FXCollections.observableArrayList(userService.getAllUsers()));
        // tblRooms.setItems(FXCollections.observableArrayList(roomService.getAllRooms()));
        // tblSchedules.setItems(FXCollections.observableArrayList(scheduleService.getAllSchedules()));

        // 4. Configurar listener para seleccionar filas en tblUsers (para Modificar/Eliminar)
        tblUsers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // TODO: Rellenar los campos de texto con los datos del usuario seleccionado
                // Asume que 'newSelection' es una instancia de tu clase Usuario o una interfaz común.
                // txtUserId.setText(newSelection.getId());
                // txtUserName.setText(newSelection.getNombre());
                // txtUserPassword.setText(newSelection.getPassword());
                // cmbUserType.setValue(newSelection.getTipo());
            }
        });

        // Configurar otros listeners para selección en tablas si es necesario
    }

    // Método para establecer el mensaje de bienvenida (llamado desde HelloController)
    public void setWelcomeMessage(String adminUsername) {
        lblWelcomeAdmin.setText("Bienvenido, Administrador " + adminUsername);
    }

    // ====================================================================================================
    // Manejadores de Eventos: Pestaña Gestión de Usuarios
    // ====================================================================================================
    @FXML
    protected void handleRegisterUser(ActionEvent event) {
        String id = txtUserId.getText();
        String name = txtUserName.getText();
        String password = txtUserPassword.getText();
        String type = cmbUserType.getValue();

        if (id.isEmpty() || name.isEmpty() || password.isEmpty() || type == null) {
            mostrarAlerta(AlertType.WARNING, "Campos Incompletos", "Por favor, complete todos los campos para registrar un usuario.");
            return;
        }

        // TODO: Lógica para registrar un nuevo médico o paciente en la base de datos
        // try {
        //     if ("Médico".equals(type)) {
        //         userService.registerMedico(id, name, password, /* otros campos de médico */);
        //     } else { // Paciente
        //         userService.registerPaciente(id, name, password, /* otros campos de paciente */);
        //     }
        //     mostrarAlerta(AlertType.INFORMATION, "Registro Exitoso", "Usuario " + name + " registrado correctamente.");
        //     clearUserFields();
        //     refreshUserTable(); // Actualiza la tabla para mostrar el nuevo usuario
        // } catch (Exception e) {
        //     mostrarAlerta(AlertType.ERROR, "Error de Registro", "No se pudo registrar el usuario: " + e.getMessage());
        // }
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Usuario " + name + " (" + type + ") registrado (simulado).");
        clearUserFields();
        // refreshUserTable(); // No implementado en simulación
    }

    @FXML
    protected void handleModifyUser(ActionEvent event) {
        // TODO: Lógica para modificar un usuario existente
        // Obtener el usuario seleccionado de la tabla o los campos de texto.
        // Validar que se ha seleccionado un usuario y que los campos no están vacíos.
        // Llamar a userService.modifyUser(...)
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Usuario modificado (simulado).");
    }

    @FXML
    protected void handleDeleteUser(ActionEvent event) {
        // TODO: Lógica para eliminar un usuario
        // Obtener el usuario seleccionado de la tabla.
        // Mostrar un diálogo de confirmación (Alert.CONFIRMATION).
        // Si confirma, llamar a userService.deleteUser(...)
        Alert confirm = new Alert(AlertType.CONFIRMATION, "¿Está seguro de que desea eliminar este usuario?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> result = confirm.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.YES) {
            mostrarAlerta(AlertType.INFORMATION, "Simulación", "Usuario eliminado (simulado).");
        }
    }

    @FXML
    protected void handleCleanFields(ActionEvent event) {
        clearUserFields();
    }

    private void clearUserFields() {
        txtUserId.clear();
        txtUserName.clear();
        txtUserPassword.clear();
        cmbUserType.getSelectionModel().clearSelection();
    }

    // private void refreshUserTable() {
    //     tblUsers.setItems(FXCollections.observableArrayList(userService.getAllUsers()));
    // }

    // ====================================================================================================
    // Manejadores de Eventos: Pestaña Gestión de Salas y Horarios
    // ====================================================================================================
    @FXML
    protected void handleRegisterRoom(ActionEvent event) {
        // TODO: Lógica para registrar una nueva sala
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Sala registrada (simulado).");
    }

    @FXML
    protected void handleModifyRoom(ActionEvent event) {
        // TODO: Lógica para modificar una sala
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Sala modificada (simulado).");
    }

    @FXML
    protected void handleDeleteRoom(ActionEvent event) {
        // TODO: Lógica para eliminar una sala
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Sala eliminada (simulado).");
    }

    @FXML
    protected void handleAssignSchedule(ActionEvent event) {
        // TODO: Lógica para asignar un horario a un médico
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Horario asignado (simulado).");
    }

    // ====================================================================================================
    // Manejadores de Eventos: Pestaña Monitoreo y Asignación
    // ====================================================================================================
    @FXML
    protected void handleShowAvailability(ActionEvent event) {
        LocalDate date = dpMonitorDate.getValue();
        if (date == null) {
            mostrarAlerta(AlertType.WARNING, "Fecha Requerida", "Por favor, seleccione una fecha para mostrar la disponibilidad.");
            return;
        }
        // TODO: Lógica para mostrar la disponibilidad de médicos en la fecha seleccionada
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Disponibilidad mostrada para " + date + " (simulado).");
    }

    @FXML
    protected void handleAssignAppointment(ActionEvent event) {
        // TODO: Lógica para asignar un paciente a una cita
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Cita asignada (simulado).");
    }

    // ====================================================================================================
    // Manejadores de Eventos: Pestaña Reportes
    // ====================================================================================================
    @FXML
    protected void handleGenerateReport(ActionEvent event) {
        String reportType = cmbReportType.getValue();
        LocalDate startDate = dpReportStartDate.getValue();
        LocalDate endDate = dpReportEndDate.getValue();

        if (reportType == null) {
            mostrarAlerta(AlertType.WARNING, "Selección Requerida", "Por favor, seleccione el tipo de reporte a generar.");
            return;
        }
        // TODO: Lógica para generar el reporte basado en el tipo y rango de fechas
        mostrarAlerta(AlertType.INFORMATION, "Simulación", "Reporte de " + reportType + " generado (simulado).");
    }

    // ====================================================================================================
    // Métodos Auxiliares
    // ====================================================================================================
    private void mostrarAlerta(AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
