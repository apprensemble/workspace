package observer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import sun.security.util.Length;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableNumberValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.collections.SetChangeListener;
import json.City;
import json.CityList;

public class ExerciceMain {

	public static void main(String[] args) {
		// exercice1();
		// exercice2();
		// exercice3();
		 exercice4();
	}

	public static void exercice1() {
		/**
		 * 1. Ecrire un programme contenant une StringProperty et une fonction
		 * listener de cette Property qui affichera la valeur actuelle de cette
		 * Property. Compléter le programme en assignant successivement quelques
		 * chaînes à la property. Observer. Que se passe-t-il lorsqu'on assigne
		 * deux fois de suite la même chaîne ?
		 */
		StringProperty s = new SimpleStringProperty();
		s.addListener((obsv, oldString, newString) -> {
			System.out.println(newString);
		});
		s.setValue("lundi");
		s.setValue("mardi");
		s.setValue("mercredi");
		s.setValue("jeudi");
		s.setValue("jeudi");
		s.setValue("vendredi");
	}

	public static void exercice2() {
		/**
		 * 2. Créer un programme contenant un ObservableSet destiné à recevoir
		 * des City (voir td sur JSON). Ecrire et associer la fonction listener
		 * qui permettra d'afficher toute ville ajoutée à cet ensemble. Ecrire
		 * un fichier contenant des lignes décrivant des City telles que :
		 * Marseille 800. Compléter le programme en parsant un tel fichier et en
		 * ajoutant au fur et à mesure les villes dans le Set. L'affichage doit
		 * se produire automatiquement.
		 */
		ObservableSet<City> obsSet = FXCollections.observableSet();
		SetChangeListener<City> f = change -> {
			if (change.wasAdded())
				System.out.println(change.getElementAdded());
		};
		obsSet.addListener(f);
		Path fileName = Paths.get("documents", "citylines.txt");
		try {
			List<String> l = Files.readAllLines(fileName);
			l.forEach(line -> {
				Scanner sc = new Scanner(line);
				City city = new City(sc.next("\\w+"), sc.nextInt());
				obsSet.add(city);
				sc.close();
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void exercice3() {
		/**
		 * 3. Compléter la classe Sensor en y ajoutant une Property pour qu'un
		 * programme puisse afficher les valeurs successives d'un capteur.
		 */
		Sensor s = new Sensor(1000);
		s.tempProperty().addListener((obsv, oldInt, newInt) -> {
			System.out.println(newInt);
		});
	}

	public static void exercice4() {
		/**
		 * 4. Ecrire un programme qui construit deux capteurs et qui affiche au
		 * fur et à mesure la moyenne des valeurs des deux capteurs. Utiliser
		 * une dépendance opérationnelle.
		 */
		Sensor s1 = new Sensor(1000);
		Sensor s2 = new Sensor(1200);
		Sensor s3 = new Sensor(1500);
		Sensor s4 = new Sensor(1600);
		
		Sensor[] sensors = {s1,s2,s3, s4};
		NumberBinding mean = Bindings.add(0,s1.tempProperty());
		for (int i = 1 ; i < sensors.length ; i ++) {
			mean = mean.add(sensors[i].tempProperty());
		}
		mean = mean.divide((float) sensors.length);
		NumberBinding mean1 = mean;
		mean.addListener((obs, oldv, newv) -> {
			System.out.format("Moy = %3.1f /%d \n", (float) mean1.getValue(), sensors.length);
		});
	}

}
