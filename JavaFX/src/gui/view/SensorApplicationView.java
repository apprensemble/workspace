package gui.view;

import java.io.File;

import gui.controller.SensorApplicationController;
import gui.model.Sensor;

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
	private Label tNbrSensor, nbrSensor, moy, action;
	private SensorApplicationController sac;

	public SensorApplicationView() {
		super();
		ajoutMenu();
		ajoutContainer();
		ajoutStatus();
	}

	public void setController(SensorApplicationController sac) {
		this.sac = sac;
	}

	private void ajoutMenu() {
		MenuBar menu = new MenuBar();
		Menu fichier = new Menu("Fichier");
		Menu sensor = new Menu("Sensor");
		MenuItem parser = new MenuItem("à parser");
		parser.setOnAction(event -> aParser());
		menu.getMenus().addAll(fichier,sensor);

		fichier.getItems().add(parser);
		MenuItem quitter = new MenuItem("quitter");
		fichier.getItems().add(quitter);
		quitter.setOnAction(e -> quit());
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
	//TODO passer par le controller pour creer le sensor
		sac.ajoutSensor();
		SensorView sv = new SensorView();
		principal.getChildren().add(sv);
	}

	private void quit() {
		sac.quit();
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
		tNbrSensor = new Label("sensor(s) :");
		nbrSensor = new Label("0");
		Label tMoy = new Label("moyenne :");
		moy = new Label("0");
		Label tAction = new Label("derniere action : ");
		action = new Label("aucune");
		//nbrSensor.
		//TODO comment les binder en respectant le mvc
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

	/**
	 * @return the tNbrSensor
	 */
	public Label gettNbrSensor() {
		return tNbrSensor;
	}

	/**
	 * @param tNbrSensor the tNbrSensor to set
	 */
	public void settNbrSensor(Label tNbrSensor) {
		this.tNbrSensor = tNbrSensor;
	}

	/**
	 * @return the nbrSensor
	 */
	public Label getNbrSensor() {
		return nbrSensor;
	}

	/**
	 * @param nbrSensor the nbrSensor to set
	 */
	public void setNbrSensor(Label nbrSensor) {
		this.nbrSensor = nbrSensor;
	}

	/**
	 * @return the moy
	 */
	public Label getMoy() {
		return moy;
	}

	/**
	 * @param moy the moy to set
	 */
	public void setMoy(Label moy) {
		this.moy = moy;
	}

	/**
	 * @return the action
	 */
	public Label getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(Label action) {
		this.action = action;
	}
}
