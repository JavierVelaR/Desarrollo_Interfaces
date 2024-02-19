package biblioteca;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.internal.ThreadLocalSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TableView<Libro> tableViewLibros;

	@FXML
	private TableColumn<Libro, String> nombreColumn;

	@FXML
	private TableColumn<Libro, String> editorialColumn;

	@FXML
	private TableColumn<Libro, String> autorColumn;

	@FXML
	private TableColumn<Libro, Integer> paginasColumn;

	@FXML
	private TextField nombreTextField;

	@FXML
	private ChoiceBox<String> choiceEditorial;

	@FXML
	private TextField autorTextField;

	@FXML
	private TextField paginasTextField;

	@FXML
	private Button btnAgregarLibro;

	@FXML
	private Button btnBorrarLibro;

	private LibroModel model;

	public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
		// Inicializa el modelo de la base de datos
		model = new LibroModel(dbURL, dbUser, dbPassword);

		// Configura las columnas de la TableView utiliza instrucciones tipo lambda,
		// cada columna de la tabla le //corresponde un campo de la base de datos
		nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
		editorialColumn.setCellValueFactory(cellData -> cellData.getValue().editorialProperty());
		autorColumn.setCellValueFactory(cellData -> cellData.getValue().autorProperty());
		paginasColumn.setCellValueFactory(cellData -> cellData.getValue().paginasProperty().asObject());

		// Configura el botón de agregar y eliminar libro
		btnAgregarLibro.setOnAction(event -> agregarLibro());
		btnBorrarLibro.setOnAction(event -> borrarLibro());

		// Al inicializar el controlador, carga los juegos desde la base de datos
		try {
			cargarLibros();
			cargarEditoriales();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void cargarLibros() throws SQLException {
		// Limpiar la TableView antes de cargar nuevos datos
		tableViewLibros.getItems().clear();

		List<Libro> libros = model.getAllLibros();

		// Agrega los datos a la TableView
		tableViewLibros.getItems().addAll(libros);
	}

	private void cargarEditoriales() {
		// Puedes obtener la lista de compañías desde la base de datos o definirla
		// estáticamente
		// Por ahora, la definiremos estáticamente
		List<String> editoriales = List.of("Alianza", "Atalanta", "Caja Negra", "Gredos", "Library of America", "RM",
				"Taurus", "Urano", "Otro");

		// Configura el ChioiceBox con las editoriales
		choiceEditorial.setItems(FXCollections.observableArrayList(editoriales));
	}

	// Sin hibernate
	@SuppressWarnings("static-access")
	@FXML
	private void agregarLibro() {

		// Obtener los valores de los campos de texto y desplegables
		String nombre = nombreTextField.getText();
		String editorial = choiceEditorial.getValue();
		String autor = autorTextField.getText();
		int paginas = 0;
		
		try {
			paginas = Integer.parseInt(paginasTextField.getText());

		}catch(NumberFormatException e) {
			System.err.println(e.getMessage());
		}

		if ((!nombre.equals("")) && editorial != null && !autor.equals("") && paginas > 0) {
			// Crear un nuevo Libro
			Libro nuevoLibro = new Libro(nombre, editorial, autor, paginas);

			try {
				model.addLibro(nuevoLibro);
				cargarLibros();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			// Mostrar un mensaje indicando que el juego ha sido añadido
			String mensaje = "Libro añadido:\n" + "Nombre: " + nombre + "\n" + "Editorial: " + editorial + "\n" + "Autor: "
					+ autor + "\n" + "Páginas: " + paginas + "\n";

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Libro Añadido");
			alert.setHeaderText(null);
			alert.setContentText(mensaje);
			alert.showAndWait();
			
			// Limpiar los campos después de agregar el juego
			limpiarCampos();
			
		}else {
			// Mostrar un mensaje indicando que el juego ha sido añadido
			String mensaje = "Error al añadir libro:\nFaltan campos por rellenar.\n";

			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Libro Añadido");
			alert.setHeaderText(null);
			alert.setContentText(mensaje);
			alert.showAndWait();
		}
	}

	/*
	 * //Insertar juego con hibernate
	 * 
	 * @SuppressWarnings("static-access")
	 * 
	 * @FXML private void agregarLibro() {
	 * 
	 * // Obtener los valores de los campos de texto y desplegables String nombre =
	 * nombreTextField.getText(); String editorial = choiceEditorial.getValue();
	 * String autor = autorTextField.getText(); int paginas =
	 * Integer.parseInt(paginasTextField.getText());
	 * 
	 * // Configurar la sesion del Hibernate SessionFactory sessionFactory = new
	 * Configuration().configure() // llama al fichero hibernate.cfg.xml
	 * 
	 * // .configure("hibernate.cfg.xml") // Ruta del archivo configuracion
	 * .buildSessionFactory(); // Construir la sesion de Hibernate
	 * 
	 * // Configurar la sesion en el contexto actual ThreadLocalSessionContext
	 * context = new ThreadLocalSessionContext((SessionFactoryImplementor)
	 * sessionFactory); context.bind(sessionFactory.openSession());
	 * 
	 * try { // Obtener la sesión actual Session session = context.currentSession();
	 * 
	 * // Iniciar transacción session.beginTransaction();
	 * 
	 * // Commit the transaction session.getTransaction().commit();
	 * 
	 * // Crear un nuevo Libro Libro nuevoLibro = new Libro(nombre, editorial,
	 * autor, paginas);
	 * 
	 * session.save(nuevoLibro);
	 * 
	 * cargarLibros(); } catch (Exception e) { e.printStackTrace(); } finally { //
	 * Desligar la sesion del contexto
	 * ThreadLocalSessionContext.unbind(sessionFactory); // Cerrar la sesion del
	 * Hibernate sessionFactory.close(); }
	 * 
	 * // Mostrar un mensaje indicando que el juego ha sido añadido String mensaje =
	 * "Libro añadido:\n" + "Nombre: " + nombre + "\n" + "Editorial: " + editorial +
	 * "\n" + "Autor: " + autor + "\n" + "Páginas: " + paginas + "\n";
	 * 
	 * Alert alert = new Alert(Alert.AlertType.INFORMATION);
	 * alert.setTitle("Libro Añadido"); alert.setHeaderText(null);
	 * alert.setContentText(mensaje); alert.showAndWait();
	 * 
	 * // Limpiar los campos después de agregar el juego limpiarCampos(); }
	 */

	@FXML
	private void borrarLibro() {

		try {
			if (model.comprobarLibro(nombreTextField.getText())) {
				model.removeLibro(nombreTextField.getText());

				// Mostrar un mensaje indicando que el juego ha sido añadido
				String mensaje = "Libro borrado:\n" + "Nombre: " + nombreTextField.getText() + "\n";

				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Libro Borrado");
				alert.setHeaderText(null);
				alert.setContentText(mensaje);
				alert.showAndWait();

				cargarLibros();
			} else {
				// Mostrar un mensaje indicando que el juego ha sido añadido
				String mensaje = "Error al borrar el libro:\n" + "Nombre: " + nombreTextField.getText()
						+ " no existe.\n";

				Alert alert = new Alert(Alert.AlertType.ERROR);
				alert.setTitle("Error al borrar");
				alert.setHeaderText(null);
				alert.setContentText(mensaje);
				alert.showAndWait();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Limpiar los campos después de agregar el juego
		limpiarCampos();
	}

	private void limpiarCampos() {
		nombreTextField.clear();
		choiceEditorial.setValue(null);
		autorTextField.clear();
		paginasTextField.clear();
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
