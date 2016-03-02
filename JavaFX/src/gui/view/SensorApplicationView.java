package gui.view;

import gui.model.Sensor;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;

public class SensorApplicationView extends BorderPane {
	private FlowPane principal;

	public SensorApplicationView() {
		super();
		ajoutMenu();
		ajoutContainer();
		ajoutStatus();
	}
	private void ajoutMenu() {
		MenuBar menu = new MenuBar();
		Menu fichier = new Menu("Fichier");
		Menu sensor = new Menu("Sensor");
		menu.getMenus().addAll(fichier,sensor);
		fichier.getItems().add(new MenuItem("quitter"));
		fichier.getItems().get(0).setOnAction(e -> quit());
		sensor.getItems().add(new MenuItem("ajouter"));
		sensor.getItems().get(0).setOnAction(e -> ajoutSensor());

		setTop(menu);
	}

	private void ajoutSensor() {
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
		status.getChildren().addAll(new Label("sensor(s) :"), new Label("0"), new Label("moyenne :"), new Label("0"), new Label("derniere action : "), new Label("aucune"));
		setBottom(status);
	}
}
