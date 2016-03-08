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
	private IntegerProperty value, zero, moyenne;
	private BooleanProperty started;
	private Timer t;
	private Integer nbrVal, total;
	private static Integer idCapteur = 0;

	public Sensor(long delay) {
		this(delay,"Capteur "+idCapteur++);
	}
	
	public Sensor(long delay, String name) {
		this.name = name;
		nbrVal=0;
		total = 0;
		moyenne = new SimpleIntegerProperty();
		r = new Random();
		value = new SimpleIntegerProperty();
		started = new SimpleBooleanProperty();
		value.addListener((o,v,nv) -> {
			nbrVal++;
			total += nv.intValue();
			moyenne.set(total/nbrVal);
		});
		value.setValue(r.nextInt());
		startTimer(delay);
	}
	public void read() {
		//calcule un nombre entre 5 et 15
		nbrVal++;
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

	/**
	 * @param moyenne the moyenne to set
	 */
	public void setMoyenne(IntegerProperty moyenne) {
		this.moyenne = moyenne;
	}

	/**
	 * @return the moyenne
	 */
	public IntegerProperty moyenneProperty() {
		return moyenne;
	}

	private class SensorTask extends TimerTask {
		@Override
		public void run() {
			read();
		}
	}
}
