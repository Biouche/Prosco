package Prosco.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Prosco.App.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EventControllerViewInfoEcole extends AnchorPane implements
		Initializable {

	@FXML
	public TextField textFieldNomEcole;
	@FXML
	public TextField textFieldNumEcole;
	@FXML
	public Label labelNomEcole;
	@FXML
	public ImageView imgEcole;
	
	public EventControllerViewInfoEcole() {

		// Constructeur de la classe EventControllerViewInfoEcole pour acceder
		// aux �l�ments du FXML
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

	@FXML
	public void BackButton(ActionEvent event) throws IOException {

		// Fermer la fen�tre courante
		Stage stage1 = App.getCurrentStage();
		stage1.hide();

		// Charger et afficher la fenetre pr�c�dente
		EventControllerStartView root = new EventControllerStartView();
		root.chargerVue();

	} // BackButton

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}

}
