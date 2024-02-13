package Ejercicio4;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.SQLException;

public class Controller {

    @FXML
    private TextField nombreTextField;

    @FXML
    private Button btnBorrarJuego;

    private TVideojuegoModel model;

    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new TVideojuegoModel(dbURL, dbUser, dbPassword);
          
        // Configura el botón de borrar juego
        btnBorrarJuego.setOnAction(event -> borrarJuego());

        // Al inicializar el controlador, carga los juegos desde la base de datos
        
    }

    @FXML
    private void borrarJuego(){
    	try {
			model.removeVideojuego(nombreTextField.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Mostrar un mensaje indicando que el juego ha sido añadido
    	String mensaje = "Juego borrado:\n" +
                "Nombre: " + nombreTextField.getText() + "\n";

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Juego Borrado");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();

        // Limpiar los campos después de agregar el juego
        limpiarCampos();
    }

    private void limpiarCampos() {
        nombreTextField.clear();
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
