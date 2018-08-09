package lens.make;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MainMain extends Application {

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage stage) throws Exception {
		StackPane root = FXMLLoader.load(getClass().getResource("main.fxml"));
		Scene sc = new Scene(root);
		stage.setScene(sc);
		stage.setTitle("관리시스템ver1.0");
		stage.getIcons().add(new Image("lens/make/images.png"));
		stage.show();
	}

}
