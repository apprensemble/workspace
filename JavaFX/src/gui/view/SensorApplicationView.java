package gui.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class SensorApplicationView extends BorderPane {

	public SensorApplicationView() {
		super();
		Button start = new Button("Start");
		Button stop = new Button("Stop");
		ToolBar tb = new ToolBar(start,stop);
		HBox status = new HBox(8);
		TextField nom = new TextField();
		TextField valeur = new TextField();
		nom.setEditable(false);
		valeur.setEditable(false);
		
		StackPane principal = new StackPane();
		principal.getChildren().addAll(nom,valeur);
		
		status.getChildren().addAll(new Label("Name :"), new TextField());
		setTop(tb);
		setCenter(principal);
		setBottom(status);
	}
}
