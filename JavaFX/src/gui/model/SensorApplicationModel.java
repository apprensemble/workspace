package gui.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SensorApplicationModel {
	private ObjectProperty<Sensor> sensor;
	private IntegerProperty nbrSensors;

	/**
	 *
	 */
	public SensorApplicationModel() {
		nbrSensors = new SimpleIntegerProperty();
		nbrSensors.setValue(0);
	}

	/**
	 * @return the nbrSensors
	 */
	public IntegerProperty nbrSensorsProperty() {
		return nbrSensors;
	}

	/**
	 * @return the sensor
	 */
	public ObjectProperty<Sensor> sensorProperty() {
		return sensor;
	}
}
