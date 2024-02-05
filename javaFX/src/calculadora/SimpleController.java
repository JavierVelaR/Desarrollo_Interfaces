package calculadora;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleController {
	
	
	@FXML
	private TextField operador1;
	@FXML
	private TextField operador2;
	@FXML
	private Label resultado;
	
	@FXML
	private void handleButtonClick(ActionEvent event) {
		String idBotonPulsado = ((Button) event.getSource()).getId();
		
		switch(idBotonPulsado) {
		case "limpiar":
			operador1.setText("");
			operador2.setText("");
			resultado.setText("Resultado:");
			System.out.println("Campos limpiados");
			break;
			
		case "salir":
			System.out.println("Has salido");
			System.exit(0);
			break;
			
		case "sumar":
			float suma = Float.parseFloat(operador1.getText()) + Float.parseFloat(operador2.getText());
			resultado.setText("Resultado: "+suma);
			System.out.println("¡Has pulsado el botón sumar!");
			break;
			
		case "restar":
			float resta = Float.parseFloat(operador1.getText()) - Float.parseFloat(operador2.getText());
			resultado.setText("Resultado: "+resta);
			System.out.println("¡Has pulsado el botón restar!");
			break;
			
		case "multiplicar":
			float producto = Float.parseFloat(operador1.getText()) * Float.parseFloat(operador2.getText());
			resultado.setText("Resultado: "+producto);
			System.out.println("¡Has pulsado el botón multiplicar!");
			break;
			
		case "dividir":
			float division = Float.parseFloat(operador1.getText()) / Float.parseFloat(operador2.getText());
			resultado.setText("Resultado: "+division);
			System.out.println("¡Has pulsado el botón dividir!");
			break;
		}
	}
	
}
