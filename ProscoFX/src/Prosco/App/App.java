package Prosco.App;

import java.io.IOException;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

	private static ObjectProperty<Stage> currentStage;

	public static ObjectProperty<Stage> currentStageProperty() {
		return currentStage;
	}

	public static Stage getCurrentStage() {
		return currentStageProperty().get();
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		currentStage = new SimpleObjectProperty<Stage>(primaryStage);

		// charger le fichier FXML de départ
		Parent root = FXMLLoader.load(getClass().getResource(
				"/Prosco/Resources/View/StartView.fxml"));

		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();

	} // start

	public static void main(String[] args) {
		launch(args);

	}
}
