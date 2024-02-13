package Ejercicio2;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.SQLException;
import java.util.List;


public class Controller {


    @FXML
    private TableView<TProducto> tableViewProductos;

    @FXML
    private TableColumn<TProducto, Integer> idColumn;
    
    @FXML
    private TableColumn<TProducto, String> nombreColumn;
    
    @FXML
    private TableColumn<TProducto, Double> precioColumn;

    @FXML
    private TableColumn<TProducto, Integer> codigo_fabricanteColumn;

    private TProductoModel model;


    public void inicializar(String dbURL, String dbUser, String dbPassword) throws SQLException {
        // Inicializa el modelo de la base de datos
        model = new TProductoModel(dbURL, dbUser, dbPassword);


        // Configura las columnas de la TableView utiliza instrucciones tipo lambda, cada columna de la tabla le
        //corresponde un campo de la base de datos
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        codigo_fabricanteColumn.setCellValueFactory(cellData -> cellData.getValue().codigo_fabricanteProperty().asObject());


        // Al inicializar el controlador, carga los juegos desde la base de datos
        try {
            cargarProductos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void cargarProductos() throws SQLException {
        // Limpiar la TableView antes de cargar nuevos datos
        tableViewProductos.getItems().clear();


        List<TProducto> productos = model.getAllProductos();
    
        // Agrega los datos a la TableView
        tableViewProductos.getItems().addAll(productos);
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
