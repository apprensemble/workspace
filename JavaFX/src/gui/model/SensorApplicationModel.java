package gui.model;

import java.util.Optional;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SensorApplicationModel {
	private ObjectProperty<Sensor> sensor;
	private IntegerProperty nbrSensors;

	/**
	 *
	 */
	public SensorApplicationModel() {
		nbrSensors = new SimpleIntegerProperty();
		nbrSensors.setValue(0);
		sensor = new SimpleObjectProperty<>();
	}

	public void ajoutSensor() {
		//Optional.ofNullable(sensor.getValue()).ifPresent(s -> s.stopTimer());
		sensor.setValue(new Sensor(2000));
		nbrSensors.set(nbrSensors.get()+1);
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
