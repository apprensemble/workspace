package IF;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	public static String un = "1";
	
	/**
	 *
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		Function<String,Double> f = s->Double.valueOf(s);
		Double iUn = f.apply(un);
		System.out.println(iUn+1);
		Supplier<String> sup = ()->new String("hello supplier");
		
		System.out.println(sup.get());
		Predicate<String> p = s -> s.length() >= 10;
		System.out.println(p.test("hello"));
		Function<String,Integer> f2 = s->s.length() * 2;
		System.out.println(f2.apply("coucou"));	
		Comparator<String> cs = (s,c)->s.compareToIgnoreCase(c);
		System.out.println(cs.compare("a","b"));
		Consumer<String> af = s->System.out.format("hello %s",s); 
		af.accept("Thierry");
		Pattern pat = Pattern.compile("\\d{3}(\\d{1})");
		Matcher m = pat.matcher("1234");
		Optional<String> opts = m.find() ?
			Optional.of(m.group(1)) :
			Optional.empty();
		//opts.ifPresent(s->System.out.println(s));
		System.out.println(opts.map(s->Integer.valueOf(s)).orElse(0));
		BiFunction<Couple<Integer>,Couple<Integer>,Integer> produitScalaire = (s1,s2)->s1.getFirst() * s2.getFirst() + s1.getSecond() * s2.getSecond();   
		Couple<Integer> c1 = new Couple<Integer>(3,4);
		Couple<Integer> c2 = new Couple<Integer>(0,-5);
		Couple<Integer> c3 = new Couple<Integer>(-1,-2);

		Integer i = produitScalaire.apply(c1,c2);
		Function<Couple<Integer>,Integer> calculDistance = s->s.getFirst() * s.getFirst() + s.getSecond() * s.getSecond();
		Comparator<Couple<Integer>> comparePoint = (p1,p2) -> calculDistance.apply(p1) - calculDistance.apply(p2);
		Function<Integer,String> signe = r -> r < 0 ? "<" : (r > 0 ? ">" : "=");
		int r1 = comparePoint.compare(c1,c2);
		int r2 = comparePoint.compare(c2,c3);
		System.out.format("%s %s %s\n",c1,signe.apply(r1),c2);
		System.out.format("%s %s %s\n",c2,signe.apply(r2),c3);

		//Optionnal
		//exercice5
		Optional<String> phrase = Optional.of("Bonjour, comment allez vous M. Bond, ou devrais-je dire M. Moulin?\n");
		Function<String,Integer> calcNbrMaj = s -> {
			int n = 0;
			for (int x = 0; x < s.length(); x++) {
				String t = s.substring(x, x + 1);
				if (t.matches("\\p{Upper}")) {
					n++;
				}
			}
			return n;
		};
		Optional<Integer> nbrMaj = phrase.map(s->calcNbrMaj.apply(s));
		System.out.format("nbr Maj %d", nbrMaj.orElse(0));
		//exercice6
		String[] tab = new String[]{"content",null};
		Optional<String> tab1 = Optional.ofNullable(tab[0]);
		Optional<String> tab2 = Optional.ofNullable(tab[1]);
		System.out.format("tab1 : %s; tab2 : %s\n",tab1.orElse("null"),tab2.orElse("null"));

		//exercice7

		Integer[] tabInt = new Integer[]{12,14,2,8,16};
		Integer[] tabTest = new Integer[]{15,12,18,20,8};
		//System.out.println(Arrays.asList(tabInt).contains(12) ? "contient" : "ne contient pas");
		BiFunction<Integer[],Integer,Optional<Integer>> tabContient = (monTab,monInt)->Arrays.asList(monTab).contains(monInt) ? Optional.of(monInt) : Optional.empty();
		for (Integer valeur : tabTest) {
			tabContient.apply(tabInt,valeur).ifPresent(v -> System.out.format("la valeur %s est presente\n",v));
		}
	}
}
