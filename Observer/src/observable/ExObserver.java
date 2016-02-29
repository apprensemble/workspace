package observable;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.binding.NumberBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;

import json.City;

import sensor.Sensor;

public class ExObserver {
	private static Path villes = Paths.get("res","villes.txt");
	private static void exercice1() {
		System.out.println("Exercice 1");
		PremierEssai pe = new PremierEssai();
		pe.nomProperty("Thirry?");
		pe.nomProperty("Thierry!");
		pe.nomProperty("Thierry");
		pe.nomProperty("Thierry");
		
	}
	private static void exercice1Bis() {
		System.out.println("Exercice 1Bis");
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
		System.out.println("Exercice 2");
		ObservableSet<City> oc = FXCollections.observableSet();
		//oc.addListener(change -> System.out.format(change.wasAdded() ? "ajout de %s" : "retrait de %s",change.getElementAdded(),change.getElementRemoved()));
/*	java un langage pour les devins	
 *		oc.addListener(change -> {
			if (change.wasAdded()) {
				System.out.println(change.getElementAdded().toString());
			}
		});*/

		//finalement on va faire comme le prof(à peu pres :))
		SetChangeListener<City> stl = change -> System.out.println(change.toString());
		SetChangeListener<City> nbrAdd = change -> System.out.println("nbr de changement : "+X.incX());
		oc.addListener(stl);
		oc.addListener(nbrAdd);
		oc.add(new City("paris",200));
		oc.forEach(f -> oc.remove(f));
		try { 
			Scanner sc = new Scanner(villes);
			sc.useDelimiter("\n");
			Pattern p = Pattern.compile("([A-Za-z]+)\\s+(\\d+)");
			while (sc.hasNext()) {
				String l = sc.next();
				Matcher m = p.matcher(l);
				if (m.matches() && m.groupCount() == 2) {
					oc.add(new City(m.group(1),Integer.valueOf(m.group(2))));
				}
				else {
					System.out.format("pattern non trouvé : %s\n",l);
				
				}
			}
			sc.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void exercice3() {
		System.out.println("Exercice 3");
		//l'exercice 3 consiste a construire la classe Sensor et ajouter le calcul d'une valeur de temperature lisible
		Sensor s = new Sensor(3000);
		s.getValue().addListener((o,v,nv) -> System.out.format("temp : %s\n",nv));
		s.stopTimer();
	}
	public static void exercice4() {
		System.out.println("Exercice 4");
		Sensor s1 = new Sensor(1000);
		Sensor s2 = new Sensor(1000);
		s1.getValue().addListener((o,v,nv) -> System.out.format("s1->%s\n",nv));
		s2.getValue().addListener((o,v,nv) -> System.out.format("s2->%s\n",nv));
		NumberBinding somme = s1.getValue().add(s2.getValue());
		somme.addListener((o,v,nv) -> {
			Double intNv = Double.valueOf(nv.toString());
			System.out.format(" moyenne s1,s2 : %s\n",intNv/2);
		});
				s1.stopTimer();
				s2.stopTimer();

	}
	public static void main(String[] args) {
		exercice1();
		exercice1Bis();
		exercice2();
		exercice3();
		exercice4();
	}

}
