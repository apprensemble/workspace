package gui.controller;


import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class SensorApplicationController {

	private SensorApplicationView sav;
	private SensorApplicationModel sam;

	/**
	 *
	 */
	public SensorApplicationController(SensorApplicationView sav) {
		super();
		sam = new SensorApplicationModel();
		this.sav = sav;
		init();
	}


	private void init() {
		sav.getNbrSensor().textProperty().bind(sam.nbrSensorsProperty().asString());
		sam.sensorProperty().addListener((o,v,nv) -> sav.ajoutSensor(nv.tempProperty(),nv.stateProperty()));
		/*stop_start.setOnAction(event -> {
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
	temp.textProperty().bind(sensor.tempProperty().asString());
		etat.textProperty().bind(sensor.stateProperty().asString());
		*/
	}

	public void ajoutSensor() {
		sam.ajoutSensor();
		//sam.sensorProperty().addListener((o,v,nv) -> sav.getMoy().setText(nv.getName()));
		//sav.getMoy().textProperty().bind(sam.sensorProperty().getValue().tempProperty().asString());
		//sam.sensorProperty().getValue().tempProperty().addListener((o,v,nv) -> sav.getMoy().setText(nv.toString()));
	}

	public void quit() {
		System.exit(0);
	}
}
