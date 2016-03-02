package gui.model;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SensorApplicationModel {
	ObjectProperty<Sensor> sensor;
	DoubleProperty average;

	public SensorApplicationModel() {
		sensor = new SimpleObjectProperty<>();
		average = new SimpleDoubleProperty();
	}

	public ObjectProperty<Sensor> sensorProperty() {
		return sensor;
	}

	public DoubleProperty averageProperty() {
		return average;
	}

	public void addSensor() {
		addSensor(new Sensor(1000, "Kitchen"));
	}

	public void addSensor(Sensor s) {
		Optional.ofNullable(sensor.getValue()).ifPresent(
				ssor -> ssor.stopTimer());
		s.averageProperty().addListener(
				(obs, old, newv) -> average.setValue(newv));
		sensor.setValue(s);
	}

	public void parse(Optional<File> optf) {
		optf.ifPresent(file -> parse(file.getAbsolutePath()));
	}

	public void parse(String fileName) {
		Path p = Paths.get(fileName);
		List<String> l;
		try {
			l = Files.readAllLines(p, StandardCharsets.UTF_8);
			l.forEach(line -> {
				if (!line.isEmpty()) {
					Scanner sc = new Scanner(line);
					String name = sc.next("\\w+");
					Integer delay = sc.nextInt();
					Sensor s = new Sensor(delay, name);
					sensor.setValue(s);
					sc.close();
				}

			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
