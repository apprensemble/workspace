package gui.controller;


import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;
import gui.view.SensorView;

import javafx.application.Platform;
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
	}

	public void ajoutSensor(SensorView sv) {
		sam.ajoutSensor();
		Platform.runLater(new Runnable() {
			public void run() {
				sv.getTemp().textProperty().bind(sam.sensorProperty().get().tempProperty().asString());
				sv.getEtat().textProperty().bind(sam.sensorProperty().get().stateProperty().asString());
			}
		});
	}

	public void quit() {
		System.exit(0);
	}
}
