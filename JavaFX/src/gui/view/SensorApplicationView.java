package gui.view;

import java.io.File;

import gui.model.Sensor;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class SensorApplicationView extends BorderPane {
	private FlowPane principal;
	private IntegerProperty nbrSensors;

	public SensorApplicationView() {
		super();
		nbrSensors = new SimpleIntegerProperty();
		nbrSensors.setValue(0);
		ajoutMenu();
		ajoutContainer();
		ajoutStatus();
	}
	private void ajoutMenu() {
		MenuBar menu = new MenuBar();
		Menu fichier = new Menu("Fichier");
		Menu sensor = new Menu("Sensor");
		MenuItem parser = new MenuItem("à parser");
		parser.setOnAction(event -> aParser());
		menu.getMenus().addAll(fichier,sensor);

		fichier.getItems().add(parser);
		fichier.getItems().add(new MenuItem("quitter"));
		fichier.getItems().get(0).setOnAction(e -> quit());
		sensor.getItems().add(new MenuItem("ajouter"));
		sensor.getItems().get(0).setOnAction(e -> ajoutSensor());

		setTop(menu);
	}

	private void aParser() {
		FileChooser sel = new FileChooser();
		sel.setTitle("selectionnez le fichier sensor à integrer");
		sel.setInitialDirectory(new File("."));
		File f = sel.showOpenDialog(new Stage());
	}

	private void ajoutSensor() {
	nbrSensors.setValue(nbrSensors.getValue()+1);
		SensorView sv = new SensorView(new Sensor(2000));
		principal.getChildren().add(sv);
	}

	private void quit() {
		System.exit(0);
	}

	private void ajoutContainer() {
		//difficile de faire des bordures...
		principal = new FlowPane();
		principal.setVgap(8);
		principal.setHgap(10);
		setCenter(principal);
	}

	private void ajoutStatus() {
		HBox status = new HBox(8);
		Label tNbrSensor = new Label("sensor(s) :");
		Label nbrSensor = new Label("0");
		Label tMoy = new Label("moyenne :");
		Label moy = new Label("0");
		Label tAction = new Label("derniere action : ");
		Label action = new Label("aucune");
		//nbrSensor.
		nbrSensor.textProperty().bind(nbrSensors.asString());
		nbrSensor.textProperty().addListener((o,v,nv) -> {
			if (Integer.valueOf(nv) > 1) {
				tNbrSensor.setText("sensors");
			}
			else {
				tNbrSensor.setText("sensor");
			}
		});
		status.getChildren().addAll(tNbrSensor, nbrSensor, tMoy, moy, tAction, action);
		setBottom(status);
	}
}
