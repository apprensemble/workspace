package gui.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SensorView extends VBox {
private TextField temp;
private Button stop_start;
private Label etat, titre;
//TODO retirer le sensor de la vue et deplacer les bindings dans le controller

/**
 *
 */
public SensorView() {
	super();
	ajoutComposants();
}

private void ajoutComposants() {
	ajoutTitre();
	stop_start = new Button("stop");
	//stop_start.setOnAction(e -> 
	temp = new TextField("0");
	temp.setEditable(false);
	getChildren().addAll(temp,stop_start);
		ajoutStatus();
	}

	private void ajoutTitre() {
		titre = new Label("Titre");
		getChildren().add(titre);
	}

	private void ajoutStatus() {
		HBox status = new HBox(8);
		etat = new Label("true");
		//je commence par un as string mais a terme je souhaiterais une lambda expression qui affiche demarré ou arreté
		status.getChildren().addAll(new Label("demarré :"), etat);
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

	/**
	 * @return the titre
	 */
	public Label getTitre() {
		return titre;
	}
	
}
