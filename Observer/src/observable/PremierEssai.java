package observable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PremierEssai {
	StringProperty nom;

	/**
	 *
	 */
	public PremierEssai() {
		nom = new SimpleStringProperty();
		nom.addListener((obs,anc,nouv) -> { System.out.println(obs); });
	}

	public StringProperty nomProperty() {
		return nom;
	}

	public void nomProperty(String valeur) {
		nom.setValue(valeur);
	
	}


}
