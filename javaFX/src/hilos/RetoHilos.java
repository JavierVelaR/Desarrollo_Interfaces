package hilos;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RetoHilos extends Application{

	@Override
    public void start(Stage primaryStage) throws IOException {
		Label label = new Label("Soy el reto de los hilos");
        StackPane root = new StackPane();
        root.getChildren().add(label);

        generarHilo("Por favor", label, 1000);
        generarHilo("Deja de ejecutarme", label, 2000);
        generarHilo("No ves que funciono", label, 3000);
        generarHilo("Ponme un 10", label, 4000);
        generarHilo("Gracias alberto :)", label, 5000);
        
        Scene scene = new Scene(root, 300, 250); //crea una nueva escena

        String cssFile = getClass().getResource("style.css").toExternalForm();
        
        scene.getStylesheets().add(cssFile);
        
        primaryStage.setTitle("Reto hilos JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	
	public void generarHilo(String msg, Label label, int espera) {
		Thread thread = new Thread(() -> { //crea un hilo
            try {
                // Dormir el hilo por 1 segundo
                Thread.sleep(espera);


                // Después de 3 segundos, actualizar la interfaz gráfica
                Platform.runLater(() -> {
                    label.setText(msg);
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start(); //inicia el hilo creado anteriormente

	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
