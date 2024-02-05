package ej5;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SimpleController {

	@FXML
	private void handleButtonClick(ActionEvent event) {
		String idBotonPulsado = ((Button) event.getSource()).getId();
		System.out.println("Botón pulsado: " + idBotonPulsado);
		
		switch(idBotonPulsado) {
		case "boton 1":
			System.out.println("¡Has pulsado el botón 1!");
			break;
		case "boton 2":
			System.out.println("¡Has pulsado el botón 2!");
			break;
		case "boton 3":
			System.out.println("¡Has pulsado el botón 3!");
			break;
		case "boton 4":
			System.out.println("¡Has pulsado el botón 4!");
			break;
		}
	}
	
}
