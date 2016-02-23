package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
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
		//Comparator<String> cmpTailleStr = (s1,s2) -> s1.length() - s2.length();
		//BiPredicate<Entity,Entity> cmpOcc = (e1,e2) -> e1.isAnagramme(e2);
		/*
		BiConsumer<String, SortedMap<String, SortedMap<String, Entity>>> ajoutEntity = (s, m) -> {
			String cle1 = new Entity(s).getOccurences().toString(), cle2 = s;
			if (m.containsKey(cle1)) {
				m.get(cle1).put(s,new Entity(s));
			}
			else {
				SortedMap<String,Entity> a = new TreeMap<>();
				a.put(s,new Entity(s));
				m.put(cle1,a);
			}
		};
		*/
		BiConsumer<String,SortedMap<String, SortedMap<String, Entity>>> ajoutEntity = (s,m) -> {
			String cle1 = new Entity(s).getOccurences().toString();
			SortedMap<String, Entity> a = Optional.ofNullable(m.get(cle1)).orElse(new TreeMap<String,Entity>());
			a.put(s,new Entity(s));
			m.put(cle1,a);
		};
		BiConsumer<List<String>, SortedMap<String, SortedMap<String, Entity>>> ajoutListEntity = (l,m) -> l.forEach(s -> ajoutEntity.accept(s,m));
		SortedMap<String, SortedMap<String, Entity>> entities = new TreeMap<>();
		ajoutListEntity.accept(words,entities);
		System.out.println("essai en version longue");
		entities.forEach((s,m) -> System.out.format("%s -> %s\n",s,m.keySet()));
		System.out.println("test des ajouts");
		List<String> betises = Arrays.asList("cirer","caroline","crocodile","rivo");
		ajoutListEntity.accept(betises,entities);
		entities.forEach((s,m) -> System.out.format("%s -> %s\n",s,m.keySet()));
		System.out.println("test des doublons");
		List<String> words2 = Arrays.asList("virer","tri","rit","meurs","voir","tir","river","muser");
		ajoutListEntity.accept(words2,entities);
		entities.forEach((s,m) -> System.out.format("%s -> %s\n",s,m.keySet()));


			

			/*m.computeIfAbsent(
					new Entity(s).getOccurences().toString(),new TreeMap<String,Entity>().put(s,new Entity(s))
					);*/
		//Map<String,Liste<Entity>> a = new TreeMap<>();
		
		
		//classement par taille
		//comparaison des occurences
		//peut on faire des maps d'occurences? oui il suffit de faire un toString d'un TreeMap
		//cmp(e1,e2) -> si e1 n'existe pas -> ajouter e1 -> si different -> si meme taille -> si meme occurences -> ajouter au Map<occ,List<String>>
		//ajout(e) -> si e n'existe pas -> ajouter e dans son bac occ
		
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
