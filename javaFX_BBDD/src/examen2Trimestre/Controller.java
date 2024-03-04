package examen2Trimestre;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;


public class Controller {

	@FXML
	private TextField campoNombre;
	
	@FXML
	private TextField campoEdad;
	
	@FXML
	private TextField campoCorreo;
	
	@FXML
	private TextField campoTelefono;
	
	@FXML
	private Button btnAñadir;
	
	@FXML
	private Button btnMostrar;
	
	@FXML
	private Button btnBorrar;
	
	@FXML
	private Button btnActualizar;
	
	@FXML
	private TextField campoCurso;
	
    @FXML
    private TableView<Estudiante> tableViewEstudiantes;
    
    @FXML
    private TableColumn<Estudiante, Integer> idColumn;

    @FXML
    private TableColumn<Estudiante, String> nombreColumn;

    @FXML
    private TableColumn<Estudiante, String> correoColumn;

    @FXML
    private TableColumn<Estudiante, String> telefonoColumn;

    @FXML
    private TableColumn<Estudiante, String> cursoColumn;

    @FXML
    private TableColumn<Estudiante, String> fecha_inscripcionColumn;
    
    private EstudianteModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new EstudianteModel(dbURL, dbUser, dbPassword);


        // Configura las columnas de la TableView utiliza instrucciones tipo lambda, cada columna de la tabla le
        //corresponde un campo de la base de datos
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        correoColumn.setCellValueFactory(cellData -> cellData.getValue().correoProperty());
        telefonoColumn.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
        cursoColumn.setCellValueFactory(cellData -> cellData.getValue().cursoProperty());
        fecha_inscripcionColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());


        // Al inicializar el controlador, carga los estudiantes desde la base de datos
        try {
            cargarEstudiantes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        btnAñadir.setOnAction(event -> añadirEstudiante());
    }

    private void cargarEstudiantes() throws SQLException {
        // Limpiar la TableView antes de cargar nuevos datos
        tableViewEstudiantes.getItems().clear();

        List<Estudiante> estudiantes = model.getAllEstudiantes();
    
        // Agrega los datos a la TableView
        tableViewEstudiantes.getItems().addAll(estudiantes);
    }
    
    @FXML
    private void añadirEstudiante() {
    	String nombre = campoNombre.getText();
    	String correo = campoCorreo.getText();
    	String telefono = campoTelefono.getText();
    	String curso = campoCurso.getText();
    	String fecha = Date.valueOf(LocalDate.now()).toString();

    	Estudiante nuevoEstudiante = new Estudiante(-1, nombre, correo, telefono, curso, fecha);
    	
    	try {
			model.addEstudiante(nuevoEstudiante);
			limpiarCampos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    private void borrarEstudiante() {
    	String nombre = campoNombre.getText();
    	
    	try {
			model.deleteEstudiante(nombre);
			limpiarCampos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    }
    
    @FXML
    private void mostrarEstudiante() {
    	try {
			cargarEstudiantes();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    private void limpiarCampos() {
        campoNombre.clear();
        campoEdad.clear();
        campoCorreo.clear();
        campoTelefono.clear();
        campoCurso.clear();

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
