package ej6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Escena6.fxml"));
		
        Scene scene = new Scene(root, 650, 400);

        String cssFile = getClass().getResource("style.css").toExternalForm();
        
        scene.getStylesheets().add(cssFile);
        
		primaryStage.setTitle("Mi Aplicación JavaFX");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
