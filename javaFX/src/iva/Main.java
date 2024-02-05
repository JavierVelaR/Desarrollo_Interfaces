package iva;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Iva.fxml"));
		primaryStage.setTitle("Calculadora en JavaFX");
		primaryStage.setScene(new Scene(root, 650, 400));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
