package fichiers;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Consumer;

import outils.Pres;
import collections.Entity;

public class ExFichiers {
	private static Path ficLstStr = Paths.get("src/res","fichierStr.txt");
	private static List<String> l = Arrays.asList("un","deux","trois","soleil","tri","tir");
	private static Path image = Paths.get("src/ressources/boot_menu_w.png");
	private static Path res = Paths.get("src/res/nimage.png");
	private static Consumer<Path> fichierExiste = f -> System.out.println(Files.exists(f) ? f+" existe" : f+" n'existe pas"); 
	private static Comparator<String> cmpStr = (v1,v2) -> v1.compareTo(v2);
	private static Optional<List<String>> lr;

	private static void net() {
		fichierExiste.accept(res);
		try {
			Files.deleteIfExists(ficLstStr);
			Files.deleteIfExists(res);
			Files.deleteIfExists(res.getParent());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void exercice1() {
		try {
			Files.createDirectory(res.getParent());
			fichierExiste.accept(res);
		}
		catch (IOException e) {
			Pres.titre("erreur mkdir");
			e.printStackTrace();
		}
		try {
			Files.copy(image,res);
			fichierExiste.accept(res);
		}
		catch (IOException e) {
			Pres.titre("erreur copy");
			e.printStackTrace();
		}
	}
	private static void exercice2() {
		Pres.titre("Exercice 2");
		//creation via Path mais on peut aussi faire un File
		try {
			Files.write(ficLstStr,l, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			lr = Optional.ofNullable(Files.readAllLines(ficLstStr,StandardCharsets.UTF_8));
		}
		catch (IOException e) {

		}
		StringJoiner sj = new StringJoiner("<=");
		StringJoiner sj2 = new StringJoiner("<=");
		lr.ifPresent(l -> {
			l.sort(cmpStr);
			l.forEach(f -> sj.add(f));
			System.out.println(sj);
		});
		Pres.titre("pour l'exemple");
		lr.get().stream().forEachOrdered(f -> sj2.add(f));
		System.out.println(sj2);

		//question : pourquoi SringJoiner plutot qu'un join?

	}
	private static void exercice3() {
		Pres.titre("Exercice 3");
		LecteurFichier lf = new LecteurFichier(ficLstStr);
		lf.lecture();


	}
	public static void main(String[] args) {
		Pres.titre("Les Fichiers");
		net();
		exercice1();
		exercice2();
		exercice3();
	}
}
