package gui.model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sensor {
	private String name;
	private Random r;
	private IntegerProperty value;
	private BooleanProperty started;
	private Timer t;
	private static Integer nbr = 0;

	public Sensor(long delay) {
		this(delay,"Capteur "+nbr++);
	}
	
	public Sensor(long delay, String name) {
		this.name = name;
		r = new Random();
		value = new SimpleIntegerProperty();
		started = new SimpleBooleanProperty();
		value.setValue(r.nextInt());
		startTimer(delay);
	}
	public void read() {
		//calcule un nombre entre 5 et 15
		value.setValue(r.nextInt(11)+5);
	}
	public void startTimer(long delay) {
		t = new Timer();
		t.schedule(new SensorTask(), delay, 2000);
		started.setValue(true);
	}
	public void stopTimer() {
		t.cancel();
		started.setValue(false);
	}

	/**
	 * @return the value
	 */
	public IntegerProperty tempProperty() {
		return value;
	}

	/**
	 * @return the etat
	 */
	public BooleanProperty stateProperty() {
		return started;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	private class SensorTask extends TimerTask {
		@Override
		public void run() {
			read();
		}
	}
}
