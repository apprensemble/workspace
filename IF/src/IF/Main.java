package IF;

import java.util.function.Function;

public class Main {
	public static String un = "1";
	
	public static void main(String[] args) {
	Function<String,Double> f = s->Double.valueOf(s);
		Double iUn = f.apply(un);
		System.out.println(iUn+1);
	
	}
}
