package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class ExCollections {

	public static void main(String[] args) {
		exercice1Et2();
		exercice3();
		exercice4();
		exercice5();
		exercice6();
		exercice7();
		exercice8();

	}

	private static void exercice8() {
		// TODO Auto-generated method stub

	}

	private static void exercice7() {
		// TODO Auto-generated method stub

	}

	private static void exercice6() {
		List<String> words = Arrays.asList("virer","tri","rit","meurs","voir","tir","river","muser");

		

	}

	private static void exercice5() {
		System.out.println("exercice 1 : anagramme");
		System.out.println("--------\ntest\n-------");
		Entity mot1 = new Entity("saalut");
		mot1.etat();
		String[] liste = {"virer","tri","rit","meurs","voir","tir","river","muser"};
	
		
		//version Arrays (inutile mais je voulais essayer)

		System.out.println("----\nVersion brut force\n----");
		List<String> lstStr = new ArrayList<>();
		lstStr.addAll(Arrays.asList(liste));
		Comparator<String> OrdreAlphabetique = (m1,m2) -> m1.compareTo(m2);
		Arrays.asList(liste).sort(OrdreAlphabetique);
		Arrays.asList(liste).forEach(mot -> new Entity(mot).etat());

//version plus facile a manipuler...enfin je crois...
		
		System.out.println("----\nVersion optimal\n----");
		BiConsumer<List<String>,Map<String,Entity>> str2Entity = (cs,ce) -> cs.forEach(mot -> ce.put(mot,new Entity(mot)));
		Map<String,Entity> motEntite = new TreeMap<>();
		str2Entity.accept(Arrays.asList("virer","tri","rit","meurs","voir","tir","river","muser"), motEntite);
		motEntite.forEach((s,m) -> m.etat());

		System.out.println("----\ntest anagramme\n----");
		System.out.println(motEntite.get("rit").isAnagramme(motEntite.get("tri")) ? "oui" : "non");
		System.out.println(motEntite.get("river").isAnagramme(motEntite.get("tri")) ? "oui" : "non");

	}

	private static void exercice4() {
		List<String> chaines = Arrays.asList("un","deux","trois","quatre","cinq","six");
		Comparator<String> cmpStr = ( s1, s2 ) -> s1.length() - s2.length();
		chaines.sort(cmpStr);
		System.out.println(chaines);
		Map<Integer, List<String>> longueurChaines = new TreeMap<>();
		chaines.forEach( chaine -> longueurChaines.put(chaine.length(), Arrays.asList(chaine) ));
		BiFunction<String, Map<Integer, List<String>>, Map<Integer, List<String>>> ajoutChaine = (s, m) -> {
			m.put(s.length(),Arrays.asList(s));
			return m;
		};
		System.out.println(longueurChaines);
		System.out.println(ajoutChaine.apply("h",longueurChaines));
		System.out.println(ajoutChaine.apply("grandMot",longueurChaines));


	}

	private static void exercice3() {
		List<String> lstStr = Arrays.asList("bonjour","rien","zoo","tasse","ordinateur");
		Map<String,Integer> nomTaille = new TreeMap<>();
		lstStr.forEach(v -> nomTaille.put(v.toString(),v.toString().length()));
		nomTaille.forEach((s,v) -> System.out.format("%s -> %s\n",s,v));

	}

	private static void exercice1Et2() {
		List<Integer> lstEntier = Arrays.asList(15,12,23,14);
		Comparator<Integer> cmpInt = (v1,v2) -> v1 - v2;
		lstEntier.sort(cmpInt);
		System.out.println(lstEntier);
		lstEntier.sort(cmpInt.reversed());
		System.out.println(lstEntier);
	}
}