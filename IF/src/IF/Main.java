package IF;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
	public static String un = "1";
	
	public static void main(String[] args) {
		Function<String,Double> f = s->Double.valueOf(s);
		Double iUn = f.apply(un);
		System.out.println(iUn+1);
		//Supplier<String> sup = new String("hello");
		//System.out.println(sup.get());
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
	}

	
	
}
