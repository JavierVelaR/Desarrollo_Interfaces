package menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class SimpleController{
	@FXML
	private MenuItem newItem;
	
	@FXML
	private MenuItem openItem;
    
	@FXML
	private MenuItem saveItem;
	
	@FXML
	private MenuItem printItem;
    
	@FXML
	private MenuItem propertiesItem;
	
	@FXML
	private MenuItem copyItem;
    
	@FXML
	private MenuItem pasteItem;
	
	@FXML
	private MenuItem undoItem;
    
	@FXML
	private MenuItem redoItem;
	
	@FXML
	private MenuItem zoomInItem;
	
	@FXML
	private MenuItem zoomOutItem;
    
	@FXML
	private MenuItem toggleFSItem;

	@FXML
	private void handleMenuAction(ActionEvent event) {
		MenuItem sourceMenuItem = (MenuItem) event.getSource(); 
        System.out.println("Ha pulsado la opción: \"" + sourceMenuItem.getText() + "\" de la categoría: \"" + sourceMenuItem.getParentMenu().getText()+"\"");
	}
    


}
