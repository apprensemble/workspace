package fichiers;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import couple.Couple;

import outils.Pres;

public class ExFichiers {
	private static Path ficLstStr = Paths.get("src/res","fichierStr.txt");
	private static List<String> l = Arrays.asList("un","deux","trois","soleil","tri","tir");
	private static Path image = Paths.get("src/ressources/boot_menu_w.png");
	private static Path res = Paths.get("src/res/nimage.png");
	private static Consumer<Path> fichierExiste = f -> System.out.println(Files.exists(f) ? f+" existe" : f+" n'existe pas"); 
	private static Comparator<String> cmpStr = (v1,v2) -> v1.compareTo(v2);
	private static Optional<List<String>> lr;
	private static Path source = Paths.get("src/ressources/varNombre.txt");
	private static Path objetCouple = Paths.get("src/ressources/objetCouple.dat");

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
	public static void exercice4() {
		Pres.titre("exercice4");
		//deux maniere de capture les elements dans un fichier :
		//1 - ligne par ligne puis on split
		//2 - ligne par ligne avec scanner (exercice 4Bis)
		//3 - caractere par caractere avec des conditions(pas le temps)
		SortedMap<String,Integer> cible = new TreeMap<>();

		Function<String,Optional<List<String>>> splitForMap = s -> {
			List<String> lst = Collections.emptyList();
			Pattern cv = Pattern.compile("\\s*([A-Za-z ]+) = (\\d+)\\s*");
			Matcher mCv = cv.matcher(s);
			if (mCv.matches() && mCv.groupCount() == 2) {
				lst = Arrays.asList(mCv.group(1),mCv.group(2));
				return Optional.ofNullable(lst);
			}
			else {
				System.out.format("aucun matches pour %s\n",s);
				return Optional.empty();
			}
		};

		/*
		Function<String,Optional<List<String>>> splitForMap = s -> {
			List<String> lst = Collections.emptyList();
			String[] cv = s.split("=");
			Pattern str = Pattern.compile("(\\S+)\\s+");
			Pattern nbr = Pattern.compile(".(\\d+)");
			Matcher mStr = str.matcher(cv[0]);
			Matcher mNbr = nbr.matcher(cv[1]);
			if (mNbr.matches() && mStr.matches()) {
				String vNbr = mNbr.group(1);
				String vStr = mStr.group(1);
				lst = Arrays.asList(vStr,vNbr);
				return Optional.ofNullable(lst);
			}
			else {
				System.out.format("aucun matches pour %s -> %s\n",cv[0],cv[1]);
				return Optional.empty();
			}
		};
		*/
		BiConsumer<String,SortedMap<String,Integer>> strToMap = (s,m) -> {
			Optional<List<String>> opLst;
			opLst = splitForMap.apply(s);
			opLst.ifPresent(l -> m.put(l.get(0),Integer.valueOf(l.get(1))));
			//m.put(cv[0],Integer.valueOf(cv[1]));
		};
		try {
			Files.readAllLines(source,StandardCharsets.UTF_8).forEach(l -> strToMap.accept(l,cible));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cible);
	}
	public static void exercice4Bis() {
		SortedMap<String,Integer> cible = new TreeMap<>();
		try {
			Scanner sc = new Scanner(Files.newInputStream(source,StandardOpenOption.READ));
			//sc.findInLine("\\s*([A-Za-z ]+) = (\\d+)\\s*");
			sc.useDelimiter("\\s*(=|\\n)\\s*");
			while(sc.hasNext()) {
				//System.out.println(sc.next().toString()+"->"+sc.nextInt());
				cible.put(sc.next(),sc.nextInt());
			}
			sc.close();
		
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(cible);
	
	}
	public static void exercice5() {
		Couple<Integer> c1 = new Couple<>(1,1), c2 = new Couple<>(2,2), c3 = new Couple<>(3,3);
		try {
			OutputStream os = Files.newOutputStream(objetCouple);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(Arrays.asList(c1,c2,c3));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void exercice6()  {
		Optional<List<Couple<Integer>>> lst = Optional.ofNullable(Collections.emptyList());
		try {
		InputStream in = Files.newInputStream(objetCouple,StandardOpenOption.READ);
		ObjectInputStream ois = new ObjectInputStream(in);
		List<Couple<Integer>> lstCouple = (List<Couple<Integer>>) ois.readObject();
		lst = Optional.ofNullable(lstCouple);
		ois.close();
		
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
lst.ifPresent(v -> System.out.println(v));

	
	}
	public static void main(String[] args) {
		Pres.titre("Les Fichiers");
		net();
		exercice1();
		exercice2();
		exercice3();
		exercice4();
		exercice4Bis();
		exercice5();
		exercice6();
	}
}
