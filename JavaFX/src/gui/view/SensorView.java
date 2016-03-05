package gui.view;

import gui.model.Sensor;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SensorView extends VBox {
	private TextField temp;
	private Button stop_start;
	//TODO retirer le sensor de la vue et deplacer les bindings dans le controller
	private Sensor sensor;

	/**
	 *
	 */
	public SensorView(Sensor sensor) {
		super();
		this.sensor = sensor;
		ajoutComposants();
	}

	private void ajoutComposants() {
		ajoutTitre();
		stop_start = new Button("stop");
		stop_start.setOnAction(event -> {
			//if (sensor.stateProperty().get() == true) {
			if (Boolean.TRUE.equals(sensor.stateProperty().get())) {
				stop_start.setText("start");
				sensor.stopTimer();
			}
			else {
				stop_start.setText("stop");
				sensor.startTimer(1000);
			}

		});
		temp = new TextField("0");
		temp.setEditable(false);
		temp.textProperty().bind(sensor.tempProperty().asString());
		getChildren().addAll(temp,stop_start);
		ajoutStatus();
	}

	private void ajoutTitre() {
		Label titre = new Label("Titre");
		titre.textProperty().setValue(sensor.getName());
		getChildren().add(titre);
	}

	private void ajoutStatus() {
		HBox status = new HBox(8);
		Label etat = new Label("démarré");
		//je commence par un as string mais a terme je souhaiterais une lambda expression qui affiche demarré ou arreté
		etat.textProperty().bind(sensor.stateProperty().asString());
		status.getChildren().addAll(new Label("demarré :"), etat);
		getChildren().add(status);
	
	}
	
}
