package gui.model;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SensorApplicationModel {
	private ObjectProperty<Sensor> sensor;
	private IntegerProperty nbrSensors, moyenne;
	private NumberBinding moy;

	/**
	 *
	 */
	public SensorApplicationModel() {
		nbrSensors = new SimpleIntegerProperty();
		nbrSensors.setValue(0);
		moyenne = new SimpleIntegerProperty();
		moyenne.setValue(0);
		sensor = new SimpleObjectProperty<>();
	}

	public void ajoutSensor() {
		//Optional.ofNullable(sensor.getValue()).ifPresent(s -> s.stopTimer());
		sensor.setValue(new Sensor(2000));
		nbrSensors.set(nbrSensors.get()+1);
		moy = moyenne.add(sensor.get().tempProperty()).divide(nbrSensors);
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

	/**
	 * @return the moyenne
	 */
	public IntegerProperty moyenneProperty() {
		return moyenne;
	}

	/**
	 * @return the moy
	 */
	public NumberBinding moyProperty() {
		return moy;
	}
}
