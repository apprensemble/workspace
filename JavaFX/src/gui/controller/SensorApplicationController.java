package gui.controller;

import gui.model.SensorApplicationModel;
import gui.view.SensorApplicationView;

public class SensorApplicationController {
	private SensorApplicationView sav;
	private SensorApplicationModel sam;

	/**
	 *
	 */
	public SensorApplicationController(SensorApplicationView sav) {
		super();
		sam = new SensorApplicationModel();
		this.sav = sav;
		
	}
}
