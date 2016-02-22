package if2;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import couple.Couple;

public class ExercicesIF {
	public static void exercice1() {
		System.out.println("Exercice 1");
		Function<String,Double> str2double = f -> Double.valueOf(f);
		String val1 = "25.458", val2 = "-12.98", val3 = "x32";
		System.out.format("%s + %s = %s\n",val1,val2,str2double.apply(val1) + str2double.apply(val2));
		//System.out.format("%s + %s = %s\n",val3,val2,str2double.apply(val3) + str2double.apply(val2));
	}

	/**
	 *
	 * L'exercice 2 est tordu il faut voir si la valeur absolue d'un double est inferieur a la valeur non absolue d'un autre double.
	 * C'est subtile puisque la question est verifier si la valeur absolue d'un double est inferieur a un autre double.
	 * Il faut d'abord faire un predicat verifiant si une valeur double absolue est inférieur a 10000.
	 * Ensuite comparer une valeur double absolue a un autre double via une fonction...Je pense qu'il considere une BiFonction comme aussi une fonction
	 * Enfin refaire le premier predicat pour qu'il s'appuit sur la bifonction.
	 *
	 */
	public static void exercice2() {
		System.out.println("Exercice 2");
		Predicate<Double> infA10k = d -> Math.abs(d)<10000;
		BiFunction<Double,Double,Boolean> doubleAInfB = (v1,v2) -> Math.abs(v1) < v2 ? true : false;
		Predicate<Double> infA10k2 = d -> doubleAInfB.apply(d,10000.00);
		Double val1 = 200.00, val2 = 20000.00;
		System.out.println(infA10k.test(200.00) ? "200 est inf a 10000" : "200 est sup a 10k");
		System.out.println(infA10k.test(20000.00) ? "20000 est inf a 10000" : "20000 est sup a 10k");
		System.out.println(doubleAInfB.apply(val1,val2) ? val1+" est inferieur a "+val2 : val1+" est superieur ou egale a "+val2);
		System.out.println("Predicate infA10k2 le retour");
		System.out.println(infA10k2.test(200.00) ? "200 est inf a 10000" : "200 est sup a 10k");
		System.out.println(infA10k2.test(20000.00) ? "20000 est inf a 10000" : "20000 est sup a 10k");
	}

	public static void exercice3() {
		System.out.println("Exercice 3");
		BiFunction<Couple<Double>,Couple<Double>,Double> PSDbl = (c1,c2) -> c1.getFirst() * c2.getFirst() + c1.getSecond() * c2.getSecond();
		System.out.format("(2.0,3.0),(4.0,5.0) = %s\n",PSDbl.apply(new Couple<Double>(2.0,3.0),new Couple<Double>(4.0,5.0)));
	}

	public static void exercice4() {
		System.out.println("Exercice 4");
		Function<Couple<Integer>,Integer> calcDist = (c1) -> c1.getFirst() * c1.getFirst() + c1.getSecond() * c1.getSecond();
		Couple<Integer> couple1 = new Couple<>(3,4), couple2 = new Couple<>(0,-5), couple3 = new Couple<>(-1,-2);
		Comparator<Couple<Integer>> cmpCouple = (c1,c2) -> (calcDist.apply(c1) - calcDist.apply(c2));
		BiConsumer<Couple<Integer>,Couple<Integer>> affCmpCouple = (c1,c2) -> {
			Integer c1_c2 = cmpCouple.compare(c1,c2);
			System.out.println( c1_c2 < 0 ? c1+"<"+c2 : c1_c2 == 0 ? c1+"="+c2 : c1+">"+c2);
		};
		/*
		 * remplaçont cette partie par un consumer :)
		Integer cpl1_cpl2 = cmpCouple.compare(couple1,couple2),
		cpl1_cpl3 = cmpCouple.compare(couple1,couple3);
		System.out.println( cpl1_cpl2 < 0 ? couple1+"<"+couple2 : cpl1_cpl2 == 0 ? couple1+"="+couple2 : couple1+">"+couple2);
		*/
		affCmpCouple.accept(couple1,couple2);
		affCmpCouple.accept(couple1,couple3);
	}

	public static void exercice5() {
		System.out.println("Exercice 5");
		Optional<String> phrase = Optional.of("Bijour Monsieur Vincent,Hahaha");
		Function<Optional<String>,Integer> cptMaj = p -> {
		Integer	maj = 0;
		for (int i = 0; i < p.get().length(); i++)
			if (p.get().substring(i, i+1).matches("\\p{Upper}")) maj++;
		return maj;
		}; 
		Consumer<Optional<String>> affCptMaj = p -> {
			System.out.println("nbr Maj dans la phrase "+p.get()+" : "+cptMaj.apply(p));
		};
		System.out.println("Ma version trop stylée");
		affCptMaj.accept(phrase);

		/*
		 * version demandé par le prof(je prefere la mienne)
		 *
		 */
		System.out.println("version demandé par le prof");
		System.out.println("nbr maj dans la phrase "+phrase.get()+" "+phrase.map(p -> {
		Integer	maj = 0;
		for (int i = 0; i < p.length(); i++)
			if (p.substring(i, i+1).matches("\\p{Upper}")) maj++;
		return maj;
		}));


		/*
		 * On remplace cette boucle par une fonction et le system.out par un Consumer
		Integer	maj = 0;
		for (int i = 0; i < phrase.get().length(); i++)
			if (phrase.get().substring(i, i+1).matches("\\p{Upper}")) maj++;
		System.out.println("nbr maj "+phrase.get()+" "+maj);
		*/
	}

	private static void exercice6() {
		System.out.println("Exercice 6");
		String[] tab = new String[]{"content",null};
		Optional<String> tab0 = Optional.of(tab[0]),
		tab1 = Optional.ofNullable(tab[1]);
		tab0.ifPresent(v -> System.out.println(v));
		tab1.ifPresent(v -> System.out.println(v));

	}

	private static void exercice7() {
		System.out.println("Exercice 7");
		Integer[] t = {12,11,68,56,34};
		Integer[] valTest = {1,2,12,68,25};
		BiFunction<Integer[], Integer, Optional<Integer>> tabContVal = (tab,v) -> Arrays.asList(tab).contains(v) ? Optional.of(v) : Optional.empty();
		tabContVal.apply(t,12).ifPresent(v -> System.out.format("La valeur %s a été trouvé\n",v));
		tabContVal.apply(t,10).ifPresent(v -> System.out.format("La valeur %s a été trouvé\n",v));
		System.out.println("test avec une boucle for :");
		for (Integer x : Arrays.asList(valTest)) 
			tabContVal.apply(t,x).ifPresent(v -> System.out.format("La valeur %s a été trouvé\n",v));
		System.out.println("J'ai trouvé comment faire l'iteration sans for :) l'iteration implicite");
		Arrays.asList(valTest).forEach(x -> tabContVal.apply(t,x).ifPresent(v -> System.out.format("La valeur %s a été trouvé\n",v)));
		
	}

	public static void main(String[] args) {
		exercice1();
		exercice2();
		exercice3();
		exercice4();
		exercice5();
		exercice6();
		exercice7();
	}

}
