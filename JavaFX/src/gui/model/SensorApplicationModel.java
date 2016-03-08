package gui.model;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class SensorApplicationModel {
	private ObjectProperty<Sensor> sensor;
	private IntegerProperty nbrSensors, moyenne;
	private NumberBinding total,moy;
	private ObservableList<Sensor> ol;

	/**
	 *
	 */
	public SensorApplicationModel() {
		nbrSensors = new SimpleIntegerProperty();
		nbrSensors.setValue(0);
		moyenne = new SimpleIntegerProperty();
		moyenne.setValue(0);
		sensor = new SimpleObjectProperty<>();
		total = moyenne.add(moyenne);
		
	}

	public void ajoutSensor() {
		//Optional.ofNullable(sensor.getValue()).ifPresent(s -> s.stopTimer());
		Sensor s = new Sensor(1000);
		sensor.setValue(s);
		nbrSensors.set(nbrSensors.get()+1);
		total = total.add(sensor.get().tempProperty());
		moy = total.divide(nbrSensors);
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

	/**
	 * @return the total
	 */
	public NumberBinding totalProperty() {
		return total;
	}

	/**
	 * @return the moy
	 */
	public NumberBinding getMoy() {
		return moy;
	}
}
