package observable;

public class X {
	private static Integer nbrChangement = 0;
	public static Integer incX() {
		return nbrChangement++;
	}
}
