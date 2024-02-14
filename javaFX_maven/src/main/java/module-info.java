module javaFX_maven {
	//exports biblioteca;
	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.persistence;
	
	opens biblioteca to javafx.graphics, javafx.fxml;
}