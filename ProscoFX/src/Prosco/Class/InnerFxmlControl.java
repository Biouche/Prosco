package Prosco.Class;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class InnerFxmlControl extends AnchorPane {

	@FXML
	public TextField textFieldNomEcole;
	@FXML
	public TextField textFieldNumEcole;

	public InnerFxmlControl() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"/Prosco/Resources/View/ViewInfoEcole.fxml"));
		fxmlLoader.setRoot(this);
		fxmlLoader.setController(this);
		try {
			fxmlLoader.load();
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}
	}

}
