package iva;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleController {

	@FXML
	private TextField importe;
	@FXML
	private Label resultado;

	@FXML
	private void handleButtonClick(ActionEvent event) {
		String idBotonPulsado = ((Button) event.getSource()).getId();
		
		switch(idBotonPulsado) {
		case "4":
			float iva4 = Float.parseFloat(importe.getText())*1.04f;
			resultado.setText("Resultado: "+iva4);
			break;
			
		case "10":
			float iva10 = Float.parseFloat(importe.getText())*1.10f;
			resultado.setText("Resultado: "+iva10);
			break;
			
		case "21":
			float iva21 = Float.parseFloat(importe.getText())*1.21f;
			resultado.setText("Resultado: "+iva21);
			break;
			
		case "limpiar":
			importe.setText("");
			resultado.setText("Resultado:");
			System.out.println("Campos limpiados");
			break;
			
		case "salir":
			System.out.println("Has salido");
			System.exit(0);
			break;
		}
	}

}
