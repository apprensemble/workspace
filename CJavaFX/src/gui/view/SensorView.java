package gui.view;

import gui.model.Sensor;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class SensorView extends VBox {
	Sensor sensor;
	Label name;
	Button start;
	Button stop;

	public SensorView(Sensor sensor) {
		super();
		this.sensor = sensor;
		name = new Label(sensor.getName());
		TextField sensorValue = new TextField();
		sensorValue.setMaxWidth(140);
		sensorValue.setEditable(false);
		sensorValue.alignmentProperty().setValue(Pos.CENTER);
		sensorValue.textProperty().bind(sensor.tempProperty().asString());
		start = new Button("Start");
		stop = new Button("Stop");
		start.setDisable(true);
		start.setOnAction(event -> {
			sensor.startTimer(1000);
			start.setDisable(true);
			stop.setDisable(false);
		});

		stop.setOnAction(event -> {
			sensor.stopTimer();
			start.setDisable(false);
			stop.setDisable(true);
		});
		setEventFilters();
		getChildren().addAll(name, sensorValue, start, stop);
		this.alignmentProperty().setValue(Pos.CENTER);
		this.setSpacing(5);
		initialize();
	}

	private void initialize() {
		sensor.isStoppedProperty().addListener((obs, oldv, newv) -> {
			start.setDisable(!newv);
			stop.setDisable(newv);
		});
	}

	private void setEventFilters() {
		name.addEventFilter(MouseEvent.MOUSE_ENTERED, evt -> {
			getScene().setCursor(Cursor.HAND);
			name.setScaleX(1.5);
			name.setScaleY(1.5);
		});
		// name.addEventFilter(MouseEvent.MOUSE_EXITED, evt -> {
		// getScene().setCursor(Cursor.DEFAULT);
		// name.setScaleX(1);
		// name.setScaleY(1);
		// });
		name.setOnMouseExited(evt -> {
			getScene().setCursor(Cursor.DEFAULT);
			name.setScaleX(1);
			name.setScaleY(1);
		});
	}
}
