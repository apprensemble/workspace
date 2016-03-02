package gui.controller;

import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;

import java.io.File;
import java.util.Optional;

public class SensorApplicationController {
	SensorApplicationModel model;
	SensorApplicationView view;

	public SensorApplicationController(SensorApplicationView view) {
		super();
		this.view = view;
		model = new SensorApplicationModel();
		initialize();
	}

	public void initialize() {
		model.sensorProperty().addListener(
				(obs, oldv, newv) -> view.addSensor(newv));
		model.averageProperty().addListener(
				(obs, oldv, newv) -> view.averageField.setText(String.format(
						"%3.2f", newv)));
	}

	public void addSensor() {
		model.addSensor();
	}

	public void parse(Optional<File> optf) {
		model.parse(optf);
	}
}
