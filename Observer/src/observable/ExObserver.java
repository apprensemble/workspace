package observable;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import json.City;

public class ExObserver {
	private static void exercice1() {
		PremierEssai pe = new PremierEssai();
		pe.nomProperty("Thirry?");
		pe.nomProperty("Thierry!");
		pe.nomProperty("Thierry");
		pe.nomProperty("Thierry");
		
	}
	private static void exercice1Bis() {
		//faisons simple
		StringProperty sp = new SimpleStringProperty();
		sp.addListener((o,v,nv) -> System.out.println(o));
		BooleanProperty bp = new SimpleBooleanProperty();
		bp.addListener((o,v,nv) -> System.out.format("%s -> %s\n",v,nv));
		sp.setValue("coucou");
		bp.setValue(true);
		bp.setValue(true);
		bp.setValue(false);
	
	}
	private static void exercice2() {
		ObservableSet<City> oc = FXCollections.observableSet();
		//oc.addListener(change -> System.out.format(change.wasAdded() ? "ajout de %s" : "retrait de %s",change.getElementAdded(),change.getElementRemoved()));
/*	java un langage pour les devins	
 *		oc.addListener(change -> {
			if (change.wasAdded()) {
				System.out.println(change.getElementAdded().toString());
			}
		});*/

		//finalement on va faire comme le prof
		SetChangeListener<City> stl = change -> System.out.println("ajout de "+change.getElementAdded()+" - retrait de "+change.getElementRemoved());
		oc.addListener(stl);
		oc.add(new City("paris",200));
		oc.forEach(f -> oc.remove(f));
	}
	public static void main(String[] args) {
		exercice1();
		exercice1Bis();
		exercice2();
	}

}
