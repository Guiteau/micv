package dad.javafx.micv;

import dad.javafx.controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	MainController controller;

	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		App.primaryStage = primaryStage;

		controller = new MainController();

		Scene escena = new Scene(controller.getMainView());

		primaryStage.getIcons().add(new Image("/images/cv64x64.png"));
		primaryStage.setScene(escena);
		primaryStage.setTitle("MiCV\t");
		primaryStage.show();

	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {

		launch(args);

	}

}
