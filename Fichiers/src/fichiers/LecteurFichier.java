package fichiers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

import collections.Entity;

public class LecteurFichier {
	private String nomFichier;
	private SortedMap<String, SortedMap<String,Entity>> mots;
	private Path fichier;
	private BiConsumer<String,SortedMap<String, SortedMap<String, Entity>>> ajoutEntity = (s,m) -> {
			String cle1 = new Entity(s).getOccurences().toString();
			SortedMap<String, Entity> a = Optional.ofNullable(m.get(cle1)).orElse(new TreeMap<String,Entity>());
			a.put(s,new Entity(s));
			m.put(cle1,a);
		};
		private BiConsumer<List<String>, SortedMap<String, SortedMap<String, Entity>>> ajoutListEntity = (l,m) -> l.forEach(s -> ajoutEntity.accept(s,m));

	/**
	 * @param nomFichier
	 */
	public LecteurFichier(String nomFichier) {
		this.nomFichier = nomFichier;
		fichier = Paths.get(nomFichier);
	}
	/**
	 * @param nomFichier
	 */
	public LecteurFichier(Path nomFichier) {
		this.nomFichier = nomFichier.toString();
		fichier = nomFichier;
	}
	/**
	 * @param aucun
	 */
	public void lecture() {
		//J'aurais bien fais un programme plus complet et plus modulaire mais ya d'autres TD alors je fais au minimum
		Optional<List<String>> le = Optional.empty();
		mots = new TreeMap<>();
		try {
		le = Optional.ofNullable(Files.readAllLines(fichier,StandardCharsets.UTF_8)); 
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		le.ifPresent(words -> ajoutListEntity.accept(words,mots));
		le.get().stream().forEach(w -> ajoutEntity.accept(w,mots));
		affiche();
	}
	public void affiche() {
		mots.forEach((s,m) -> System.out.format("%s -> %s\n",s,m.keySet()));
	}
}
