package gui.model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sensor {
	private String name;
	private IntegerProperty temp;
	private BooleanProperty isStopped;
	private DoubleProperty average;
	private Random r;
	private Timer t;
	private Double av = 0d;
	private int nb = 0;

	public Sensor(long delay) {
		this(delay, "noname");
	}

	public Sensor(long delay, String name) {
		this.name = name;
		r = new Random();
		temp = new SimpleIntegerProperty(0);
		isStopped = new SimpleBooleanProperty(false);
		average = new SimpleDoubleProperty();
		startTimer(delay);
	}

	public String getName() {
		return name;
	}

	public IntegerProperty tempProperty() {
		return temp;
	}

	public BooleanProperty isStoppedProperty() {
		return isStopped;
	}

	public DoubleProperty averageProperty() {
		return average;
	}

	public void read() {
		temp.setValue(r.nextInt(11) + 5);
		av = (av * nb + temp.getValue()) / (nb + 1);
		average.setValue(av);
		nb++;
	}

	public String toString() {
		return String.format("%s: temp = %d", name, temp.getValue());
	}

	public void startTimer(long delay) {
		t = new Timer();
		nb = 0;
		av = 0d;
		average.setValue(0);
		t.schedule(new SensorTask(), delay, 2000);
		isStopped.setValue(false);
	}

	public void stopTimer() {
		t.cancel();
		isStopped.setValue(true);
	}

	private class SensorTask extends TimerTask {
		@Override
		public void run() {
			read();
		}

	}
}
