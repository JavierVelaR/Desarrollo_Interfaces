package formulario;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ResultadoController {

	@FXML
	private Label labelResultado;

	@FXML
	public void mostrarResultado(String resultado) {
		labelResultado.setText(resultado);
	}
}
