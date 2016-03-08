package gui.controller;


import gui.model.Sensor;
import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;
import gui.view.SensorView;

import javafx.application.Platform;
import javafx.scene.control.Label;

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
				
				Sensor sensor = sam.sensorProperty().get();
			//	sav.getMoy().textProperty().bind(sensor.tempProperty().asString());
				sam.moyProperty().asString().addListener((o,v,nv) -> {
					Platform.runLater(new Runnable() {
						public void run() {
							sav.getMoy().setText(nv);
						}
					});
				}
					);
				sv.getTemp().textProperty().bind(sensor.tempProperty().asString());
				sv.getTitre().setText(sensor.getName());
				sv.getEtat().textProperty().bind(sensor.stateProperty().asString());
				sv.getStop_start().setOnAction(event -> {
					//if (sensor.stateProperty().get() == true) {
					if (Boolean.TRUE.equals(sensor.stateProperty().get())) {
						sv.getStop_start().setText("start");
						sensor.stopTimer();
					}
					else {
						sv.getStop_start().setText("stop");
						sensor.startTimer(1000);
					}
				});
			}
			});
	}

	public void quit() {
		System.exit(0);
	}
}
