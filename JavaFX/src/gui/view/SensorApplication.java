package gui.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SensorApplication extends Application {
	public void start(Stage stage) {
		SensorApplicationView root = new SensorApplicationView();
		//SensorApplicationController controller = new SensorApplicationController(root);
		//root.setController(controller);
		Scene scene = new Scene(root, 300, 180);
		stage.setOnCloseRequest(event -> System.exit(0));
		stage.setTitle("Capteurs");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String [] args ) {
		launch(args);
	}
}
