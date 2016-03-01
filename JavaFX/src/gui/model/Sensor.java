package gui.model;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Sensor {
	private String name;
	private Random r;
	private IntegerProperty value;
	private Timer t;

	public Sensor(long delay) {
		this(delay,"noname");
	}
	
	public Sensor(long delay, String name) {
		this.name = name;
		r = new Random();
		value = new SimpleIntegerProperty();
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
	}
	public void stopTimer() {
		try {
			Thread.sleep(6000);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		t.cancel();
	}

	/**
	 * @return the value
	 */
	public IntegerProperty getValue() {
		return value;
	}

	private class SensorTask extends TimerTask {
		@Override
		public void run() {
			read();
		}
	}
}
