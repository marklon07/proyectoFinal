package co.edu.uniquindio.poo.proyectofinal.viewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class pacienteViewController implements Initializable {

    // --- Tab 1: Actualizar Perfil ---
    @FXML
    private Label lblWelcomePatient;
    @FXML
    private TextField txtProfileId;
    @FXML
    private TextField txtProfileName;
    @FXML
    private TextField txtProfileLastName;
    @FXML
    private TextField txtProfileEmail;

    // --- Tab 2: Solicitar Cita ---
    @FXML
    private DatePicker dpAppointmentDate;
    @FXML
    private TableView<HorarioDisponible> tblAvailableTimes;
    @FXML
    private TableColumn<HorarioDisponible, String> colAvailableDoctor;
    @FXML
    private TableColumn<HorarioDisponible, String> colAvailableDate;
    @FXML
    private TableColumn<HorarioDisponible, String> colAvailableTime;
    @FXML
    private TableColumn<HorarioDisponible, String> colAvailableRoom;

    // --- Tab 3: Cancelar Cita ---
    @FXML
    private TableView<CitaPaciente> tblMyAppointments;
    @FXML
    private TableColumn<CitaPaciente, String> colMyApptDoctor;
    @FXML
    private TableColumn<CitaPaciente, String> colMyApptSpecialty;
    @FXML
    private TableColumn<CitaPaciente, String> colMyApptDate;
    @FXML
    private TableColumn<CitaPaciente, String> colMyApptTime;
    @FXML
    private TableColumn<CitaPaciente, String> colMyApptStatus;

    // --- Tab 4: Ver Historial Médico ---
    @FXML
    private DatePicker dpHistoryStartDate;
    @FXML
    private DatePicker dpHistoryEndDate;
    @FXML
    private TableView<HistorialMedico> tblMedicalHistory;
    @FXML
    private TableColumn<HistorialMedico, String> colHistoryDate;
    @FXML
    private TableColumn<HistorialMedico, String> colHistoryDoctor;
    @FXML
    private TableColumn<HistorialMedico, String> colHistoryReason;
    @FXML
    private TableColumn<HistorialMedico, String> colHistoryDiagnosis;
    @FXML
    private TableColumn<HistorialMedico, String> colHistoryTreatment;

    // Datos del paciente actual
    private String pacienteId;
    private String pacienteNombre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configurar las columnas de las tablas
        configurarColumnasTablas();

        // Cargar datos iniciales
        cargarDatosPaciente();
        cargarHorariosDisponibles();
        cargarCitasPaciente();
        cargarHistorialMedico();
    }

    private void configurarColumnasTablas() {
        // Tabla de horarios disponibles
        colAvailableDoctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        colAvailableDate.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colAvailableTime.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colAvailableRoom.setCellValueFactory(new PropertyValueFactory<>("sala"));

        // Tabla de citas del paciente
        colMyApptDoctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        colMyApptSpecialty.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        colMyApptDate.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colMyApptTime.setCellValueFactory(new PropertyValueFactory<>("hora"));
        colMyApptStatus.setCellValueFactory(new PropertyValueFactory<>("estado"));

        // Tabla de historial médico
        colHistoryDate.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        colHistoryDoctor.setCellValueFactory(new PropertyValueFactory<>("doctor"));
        colHistoryReason.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        colHistoryDiagnosis.setCellValueFactory(new PropertyValueFactory<>("diagnostico"));
        colHistoryTreatment.setCellValueFactory(new PropertyValueFactory<>("tratamiento"));
    }

    private void cargarDatosPaciente() {
        // Aquí cargarías los datos del paciente desde tu base de datos o modelo
        // Por ahora, datos de ejemplo
        pacienteId = "PAC001";
        pacienteNombre = "Juan Pérez";

        lblWelcomePatient.setText("Bienvenido, " + pacienteNombre);
        txtProfileId.setText(pacienteId);
        txtProfileName.setText("Juan");
        txtProfileLastName.setText("Pérez");
        txtProfileEmail.setText("juan.perez@email.com");
    }

    private void cargarHorariosDisponibles() {
        ObservableList<HorarioDisponible> horarios = FXCollections.observableArrayList();

        // Datos de ejemplo - aquí conectarías con tu lógica de negocio
        horarios.add(new HorarioDisponible("Dr. García", "2024-02-15", "09:00", "Sala 101"));
        horarios.add(new HorarioDisponible("Dr. López", "2024-02-15", "10:30", "Sala 102"));
        horarios.add(new HorarioDisponible("Dr. Martínez", "2024-02-16", "14:00", "Sala 103"));

        tblAvailableTimes.setItems(horarios);
    }

    private void cargarCitasPaciente() {
        ObservableList<CitaPaciente> citas = FXCollections.observableArrayList();

        // Datos de ejemplo
        citas.add(new CitaPaciente("Dr. García", "Cardiología", "2024-02-20", "09:00", "Confirmada"));
        citas.add(new CitaPaciente("Dr. López", "Neurología", "2024-02-25", "15:30", "Pendiente"));

        tblMyAppointments.setItems(citas);
    }

    private void cargarHistorialMedico() {
        ObservableList<HistorialMedico> historial = FXCollections.observableArrayList();

        // Datos de ejemplo
        historial.add(new HistorialMedico("2024-01-15", "Dr. Ramírez", "Dolor de cabeza", "Migraña", "Ibuprofeno 400mg"));
        historial.add(new HistorialMedico("2024-01-10", "Dr. Silva", "Chequeo general", "Estado saludable", "Vitaminas"));

        tblMedicalHistory.setItems(historial);
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

    // --- Métodos de manejo de eventos ---

    @FXML
    private void handleSaveProfileChanges() {
        try {
            String nombre = txtProfileName.getText().trim();
            String apellido = txtProfileLastName.getText().trim();
            String email = txtProfileEmail.getText().trim();

            if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
                mostrarAlerta("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
                return;
            }

            // Aquí implementarías la lógica para guardar en tu base de datos
            // Por ejemplo: pacienteService.actualizarPaciente(pacienteId, nombre, apellido, email);

            mostrarAlerta("Éxito", "Perfil actualizado correctamente", Alert.AlertType.INFORMATION);
            lblWelcomePatient.setText("Bienvenido, " + nombre + " " + apellido);

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al guardar cambios: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleConfirmAppointment() {
        HorarioDisponible horarioSeleccionado = tblAvailableTimes.getSelectionModel().getSelectedItem();

        if (horarioSeleccionado == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione un horario disponible", Alert.AlertType.WARNING);
            return;
        }

        try {
            // Aquí implementarías la lógica para confirmar la cita
            // Por ejemplo: citaService.crearCita(pacienteId, horarioSeleccionado);

            mostrarAlerta("Éxito", "Cita confirmada para el " + horarioSeleccionado.getFecha() +
                            " a las " + horarioSeleccionado.getHora() + " con " + horarioSeleccionado.getDoctor(),
                    Alert.AlertType.INFORMATION);

            // Actualizar las tablas
            cargarHorariosDisponibles();
            cargarCitasPaciente();

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al confirmar cita: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void handleCancelSelectedAppointment() {
        CitaPaciente citaSeleccionada = tblMyAppointments.getSelectionModel().getSelectedItem();

        if (citaSeleccionada == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione una cita para cancelar", Alert.AlertType.WARNING);
            return;
        }

        Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmAlert.setTitle("Confirmar Cancelación");
        confirmAlert.setHeaderText("¿Está seguro de cancelar esta cita?");
        confirmAlert.setContentText("Cita con " + citaSeleccionada.getDoctor() + " el " + citaSeleccionada.getFecha());

        if (confirmAlert.showAndWait().get() == ButtonType.OK) {
            try {
                // Aquí implementarías la lógica para cancelar la cita
                // Por ejemplo: citaService.cancelarCita(citaSeleccionada.getId());

                mostrarAlerta("Éxito", "Cita cancelada correctamente", Alert.AlertType.INFORMATION);
                cargarCitasPaciente();
                cargarHorariosDisponibles();

            } catch (Exception e) {
                mostrarAlerta("Error", "Error al cancelar cita: " + e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    private void handleSearchHistory() {
        LocalDate fechaInicio = dpHistoryStartDate.getValue();
        LocalDate fechaFin = dpHistoryEndDate.getValue();

        if (fechaInicio == null || fechaFin == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione ambas fechas", Alert.AlertType.WARNING);
            return;
        }

        if (fechaInicio.isAfter(fechaFin)) {
            mostrarAlerta("Error", "La fecha de inicio no puede ser posterior a la fecha de fin", Alert.AlertType.ERROR);
            return;
        }

        try {
            // Aquí implementarías la lógica para filtrar el historial por fechas
            // Por ejemplo: List<HistorialMedico> historialFiltrado = historialService.buscarPorFechas(pacienteId, fechaInicio, fechaFin);

            // Por ahora, solo mostramos un mensaje
            mostrarAlerta("Información", "Búsqueda realizada del " + fechaInicio + " al " + fechaFin, Alert.AlertType.INFORMATION);

        } catch (Exception e) {
            mostrarAlerta("Error", "Error al buscar historial: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    // Método auxiliar para mostrar alertas
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    // Método para inicializar datos del paciente (llamado desde el controlador principal)
    public void initData(String pacienteId, String pacienteNombre) {
        this.pacienteId = pacienteId;
        this.pacienteNombre = pacienteNombre;

        lblWelcomePatient.setText("Bienvenido, " + pacienteNombre);
        txtProfileId.setText(pacienteId);

        // Recargar datos específicos del paciente
        cargarDatosPaciente();
        cargarCitasPaciente();
        cargarHistorialMedico();
    }

    // --- Clases modelo para las tablas ---

    public static class HorarioDisponible {
        private String doctor;
        private String fecha;
        private String hora;
        private String sala;

        public HorarioDisponible(String doctor, String fecha, String hora, String sala) {
            this.doctor = doctor;
            this.fecha = fecha;
            this.hora = hora;
            this.sala = sala;
        }

        // Getters y setters
        public String getDoctor() { return doctor; }
        public void setDoctor(String doctor) { this.doctor = doctor; }
        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
        public String getHora() { return hora; }
        public void setHora(String hora) { this.hora = hora; }
        public String getSala() { return sala; }
        public void setSala(String sala) { this.sala = sala; }
    }

    public static class CitaPaciente {
        private String doctor;
        private String especialidad;
        private String fecha;
        private String hora;
        private String estado;

        public CitaPaciente(String doctor, String especialidad, String fecha, String hora, String estado) {
            this.doctor = doctor;
            this.especialidad = especialidad;
            this.fecha = fecha;
            this.hora = hora;
            this.estado = estado;
        }

        // Getters y setters
        public String getDoctor() { return doctor; }
        public void setDoctor(String doctor) { this.doctor = doctor; }
        public String getEspecialidad() { return especialidad; }
        public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
        public String getHora() { return hora; }
        public void setHora(String hora) { this.hora = hora; }
        public String getEstado() { return estado; }
        public void setEstado(String estado) { this.estado = estado; }
    }

    public static class HistorialMedico {
        private String fecha;
        private String doctor;
        private String motivo;
        private String diagnostico;
        private String tratamiento;

        public HistorialMedico(String fecha, String doctor, String motivo, String diagnostico, String tratamiento) {
            this.fecha = fecha;
            this.doctor = doctor;
            this.motivo = motivo;
            this.diagnostico = diagnostico;
            this.tratamiento = tratamiento;
        }

        // Getters y setters
        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
        public String getDoctor() { return doctor; }
        public void setDoctor(String doctor) { this.doctor = doctor; }
        public String getMotivo() { return motivo; }
        public void setMotivo(String motivo) { this.motivo = motivo; }
        public String getDiagnostico() { return diagnostico; }
        public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }
        public String getTratamiento() { return tratamiento; }
        public void setTratamiento(String tratamiento) { this.tratamiento = tratamiento; }
    }
}