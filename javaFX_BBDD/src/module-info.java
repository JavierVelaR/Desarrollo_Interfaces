module javaFX_BBDD {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	requires javafx.graphics;
	
	opens Ejercicio1 to javafx.graphics, javafx.fxml;
	opens Ejercicio2 to javafx.graphics, javafx.fxml;
	opens Ejercicio3 to javafx.graphics, javafx.fxml;
	opens Ejercicio4 to javafx.graphics, javafx.fxml;

}