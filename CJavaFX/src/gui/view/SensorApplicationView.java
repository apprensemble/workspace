package gui.view;

import gui.controller.SensorApplicationController;
import gui.model.Sensor;

import java.io.File;
import java.util.Optional;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SensorApplicationView extends BorderPane {
	StackPane sensorPane;
	Rectangle r;
	SensorApplicationController controller;
	public TextField averageField;

	public SensorApplicationView() {
		super();
		SensorView fake = new SensorView(new Sensor(1000, "Kitchen"));
		sensorPane = new StackPane();
		r = new Rectangle(150, 150);
		r.setFill(Color.AZURE);
		r.setStroke(Color.BROWN);
		sensorPane.getChildren().add(r);
		setCenter(sensorPane);

		averageField = new TextField();
		averageField.setEditable(false);

		Label averageLabel = new Label("Moyenne");
		averageLabel.textAlignmentProperty().setValue(TextAlignment.CENTER);
		VBox averageBox = new VBox();
		averageBox.alignmentProperty().setValue(Pos.CENTER);
		averageBox.getChildren().addAll(averageLabel, averageField);
		setRight(averageBox);
		addMenus();
	}

	private void addMenus() {
		MenuBar menubar = new MenuBar();
		Menu fileMenu = new Menu("Files");
		MenuItem openItem = new MenuItem("Open");
		openItem.setOnAction(event -> openFile());
		fileMenu.getItems().add(openItem);

		Menu sensorMenu = new Menu("Sensors");
		MenuItem addItem = new MenuItem("Add");
		addItem.setOnAction(event -> addSensor());
		sensorMenu.getItems().add(addItem);
		menubar.getMenus().addAll(fileMenu, sensorMenu);
		setTop(menubar);
	}

	public void setController(SensorApplicationController controller) {
		this.controller = controller;
	}

	public void addSensor(Sensor s) {
		SensorView sv = new SensorView(s);
		sensorPane.getChildren().clear();
		sensorPane.getChildren().addAll(r, sv);
	}

	private void openFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.setInitialDirectory(new File("."));
		File f = fileChooser.showOpenDialog(new Stage());
		controller.parse(Optional.ofNullable(f));
	}

	private void addSensor() {
		controller.addSensor();
	}
}
