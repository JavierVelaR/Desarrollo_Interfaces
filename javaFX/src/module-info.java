module javaFX {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
	opens ejExamenJavaFX to javafx.graphics, javafx.fxml;
	opens simulacroo to javafx.graphics, javafx.fxml;
	opens ej2 to javafx.graphics, javafx.fxml;
	opens ej3 to javafx.graphics, javafx.fxml;
	opens ej4 to javafx.graphics, javafx.fxml;
	opens ej5 to javafx.graphics, javafx.fxml;
	opens ej6 to javafx.graphics, javafx.fxml;
	opens ej7 to javafx.graphics, javafx.fxml;
	opens ej8 to javafx.graphics, javafx.fxml;
	opens ej9 to javafx.graphics, javafx.fxml;
	opens ej10 to javafx.graphics, javafx.fxml;
	opens calculadora to javafx.graphics, javafx.fxml;
	opens iva to javafx.graphics, javafx.fxml;
	opens formulario to javafx.graphics, javafx.fxml;
	opens calculadoraVisual to javafx.graphics, javafx.fxml;
}
