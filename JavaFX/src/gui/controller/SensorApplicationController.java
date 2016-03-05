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
	}

	private void addSensor() {
		sam.nbrSensorsProperty().add(1);
	}
}
