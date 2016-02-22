package collections;

import java.util.Map;
import java.util.TreeMap;

public class Entity {
	String mot;
	Map<Character,Integer> occurences;

	/**
	 * @param mot
	 */
	public Entity(String mot) {
		this.mot = mot;
		occurences = new TreeMap<>();
		initOccurences();
		calculOccurences();
	}

	private void initOccurences() {
		mot.chars().forEach(c -> occurences.putIfAbsent((char)c,0));
	}

	private void calculOccurences() {
		mot.chars().forEach(c -> occurences.computeIfPresent((char)c, (k,i) -> ++i));
		//J'aimerais un putIfAbsent qui renvoie une cle, c'est dommage. Je ne vois pas comment faire init+calcul en 1 ligne;
	}

	public void etat() {
		System.out.println("mot "+mot+" occ "+occurences);
	
	}
	public boolean isAnagramme(Entity mot2) {
				return occurences.equals(mot2.getOccurences());
	}

	/**
	 * @return the occurences
	 */
	public Map<Character, Integer> getOccurences() {
		return occurences;
	}
}
