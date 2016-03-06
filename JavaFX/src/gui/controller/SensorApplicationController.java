package gui.controller;

import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;

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
		sam.nbrSensorsProperty().add(1);
	}

	public void quit() {
		System.exit(0);
	}
}
