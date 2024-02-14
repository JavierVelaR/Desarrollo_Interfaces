package hilos;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PruebaHilos extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button("¡Hola desde JavaFX!");
        StackPane root = new StackPane();
        root.getChildren().add(btn);


        // Crear y empezar un hilo simple
        Thread thread = new Thread(() -> { //crea un hilo
            try {
                // Dormir el hilo por 3 segundos
                Thread.sleep(3000);


                // Después de 3 segundos, actualizar la interfaz gráfica
                Platform.runLater(() -> {
                    btn.setText("¡Hilo ejecutado!");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start(); //inicia el hilo creado anteriormente


        Scene scene = new Scene(root, 300, 250); //crea una nueva escena


        primaryStage.setTitle("JavaFX Thread Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

