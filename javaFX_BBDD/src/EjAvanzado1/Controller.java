package EjAvanzado1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.SQLException;
import java.util.List;



public class Controller {

    @FXML
    private TableView<Alumno> tableViewAlumnos;

    @FXML
    private TableColumn<Alumno, String> nombreColumn;

    @FXML
    private TableColumn<Alumno, String> apellido1Column;

    @FXML
    private TableColumn<Alumno, String> apellido2Column;

    @FXML
    private TableColumn<Alumno, Boolean> es_repetidorColumn;

    @FXML
    private TableColumn<Alumno, String> fecha_nacimientoColumn;

    @FXML
    private TableColumn<Alumno, Integer> telefonoColumn;

    private AlumnoModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new AlumnoModel(dbURL, dbUser, dbPassword);


        // Configura las columnas de la TableView utiliza instrucciones tipo lambda, cada columna de la tabla le //corresponde un campo de la base de datos
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        apellido1Column.setCellValueFactory(cellData -> cellData.getValue().apellido1Property());
        apellido2Column.setCellValueFactory(cellData -> cellData.getValue().apellido2Property());
        es_repetidorColumn.setCellValueFactory(cellData -> cellData.getValue().es_repetidorProperty());
        fecha_nacimientoColumn.setCellValueFactory(cellData -> cellData.getValue().fecha_nacimientoProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty().asObject());


        // Al inicializar el controlador, carga los juegos desde la base de datos
        try {
            cargarAlumnos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void cargarAlumnos() throws SQLException {
        // Limpiar la TableView antes de cargar nuevos datos
        tableViewAlumnos.getItems().clear();


        List<Alumno> alumnos = model.getAllAlumnos();
    
        // Agrega los datos a la TableView
        tableViewAlumnos.getItems().addAll(alumnos);
    }

    @FXML
    private void cerrarConexion() {
        // Cierra la conexión a la base de datos
        try {
            model.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
