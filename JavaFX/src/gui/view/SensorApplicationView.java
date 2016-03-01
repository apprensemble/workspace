package gui.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class SensorApplicationView extends BorderPane {

	public SensorApplicationView() {
		super();
		BorderPane bp = new BorderPane();
		ToolBar tb = new ToolBar();
		HBox status = new HBox(8);
		TextField txt = new TextField();
		
		status.getChildren().addAll(new Label("Name :"), new TextField());
		bp.setTop(tb);
		bp.setCenter(txt);
		bp.setBottom(status);
	}
}
