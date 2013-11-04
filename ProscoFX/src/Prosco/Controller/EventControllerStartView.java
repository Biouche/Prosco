package Prosco.Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.mytdev.javafx.scene.control.AutoCompleteTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Prosco.App.App;
import Prosco.Class.ClassBDClasses;
import Prosco.Class.ClassBDEcole;
import Prosco.Class.ConnectBD;

public class EventControllerStartView extends AnchorPane implements
		Initializable {

	public EventControllerStartView() throws IOException {

	}

	public void chargerVue() throws IOException {

		// Charger la fen�tre courante de l'appel du bouton de retour (fonction
		// BackButton ()
		Stage stage1 = App.getCurrentStage();

		// Charger la fen�tre d'accueil
		Parent root = FXMLLoader.load(getClass().getResource(
				"/Prosco/Resources/View/StartView.fxml"));
		Scene scene = new Scene(root);

		// Afficher la fen�tre d'accueil
		stage1.setScene(scene);
		stage1.show();
	} // chargerVue

	@FXML
	public AutoCompleteTextField<String> AutoCompleteField;

	@FXML
	public void getTxtRechercheEcole(ActionEvent event) throws IOException {

		ClassBDEcole Ecole = new ClassBDEcole(AutoCompleteField.getText());

		EventControllerViewInfoEcole root = new EventControllerViewInfoEcole();

		root.labelNomEcole.setText(AutoCompleteField.getText());
		root.textFieldNumEcole.setText(Ecole.getNomEcole());

		Scene cc = AutoCompleteField.getScene();
		cc.setRoot(root);

	} // getTxtRechercheEcole

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> List = FXCollections.observableArrayList();

		/*************************** Cr�er le dictionnaire de donn�es pour l'auto Compl�tion ***************************/

		try {
			ConnectBD BD = new ConnectBD();
			// R�cup�ration des informations propres � l'�cole
			ResultSet res = BD.setQuery("SELECT NOMECOLE FROM APP.ECOLES");

			String elem = "";

			while (res.next()) {
				// R�cup�ration de toutes les valeurs de la colonne 'NOM' de
				// ECOLES
				elem = res.getString("NOMECOLE");

				// Ajout des Valeurs � la ObservableList
				List.add(elem);
			}

			// Ajout du dictionnaire de donn�es au textField
			AutoCompleteField.setItems(List);

			System.out.println(List);
			
			//TESTS
			
			/*ClassBDEcole ecole = new ClassBDEcole();
			ecole.InsertNewEcole("TEST3", "OK", "OK", 13090, "OK", "OK", "OK", 5555, 5555);
			ecole.UpdateEcole(5, "TEST3", "OK", "OK", 2000, "OK", "OK", "OK", 5555, 5555);*/
			
			ClassBDClasses classes = new ClassBDClasses(5);
		} catch (Exception e) {
			System.out.println("Probl�me de connexion � la BD : "
					+ e.getMessage());
			e.printStackTrace();
		}

	} // Initialize

}
