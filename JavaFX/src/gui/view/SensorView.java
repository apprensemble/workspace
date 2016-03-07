package gui.view;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SensorView extends VBox {
	private IntegerProperty iTemp;
	private BooleanProperty bEtat;
private TextField temp;
private Button stop_start;
private Label etat;
//TODO retirer le sensor de la vue et deplacer les bindings dans le controller

/**
 *
 */
public SensorView(IntegerProperty val, BooleanProperty etat) {
	super();
	iTemp = val;
	bEtat = etat;
	ajoutComposants();
}

private void ajoutComposants() {
	ajoutTitre();
	stop_start = new Button("stop");
	temp = new TextField("0");
	temp.setEditable(false);
	getChildren().addAll(temp,stop_start);
	iTemp.addListener((o,v,nv) -> temp.setText(nv.toString()));
		ajoutStatus();
	}

	private void ajoutTitre() {
		Label titre = new Label("Titre");
		//TODO demander le nom au controller
		//titre.textProperty().setValue(sensor.getName());
		getChildren().add(titre);
	}

	private void ajoutStatus() {
		HBox status = new HBox(8);
		etat = new Label("true");
		//je commence par un as string mais a terme je souhaiterais une lambda expression qui affiche demarré ou arreté
		status.getChildren().addAll(new Label("demarré :"), etat);
	bEtat.addListener((o,v,nv) -> etat.setText(nv.toString()));
		getChildren().add(status);
	
	}

	/**
	 * @return the temp
	 */
	public TextField getTemp() {
		return temp;
	}

	/**
	 * @return the stop_start
	 */
	public Button getStop_start() {
		return stop_start;
	}

	/**
	 * @return the etat
	 */
	public Label getEtat() {
		return etat;
	}
	
}
