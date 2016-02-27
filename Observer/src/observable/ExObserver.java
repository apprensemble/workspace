package observable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExObserver {
	public static void exercice1() {
		PremierEssai pe = new PremierEssai();
		pe.nomProperty("Thirry?");
		pe.nomProperty("Thierry!");
		pe.nomProperty("Thierry");
		pe.nomProperty("Thierry");
		
	}
	public static void main(String[] args) {
		exercice1();
	
	}

}
