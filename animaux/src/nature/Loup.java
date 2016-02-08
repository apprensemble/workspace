package nature;

public class Loup extends Canin {

	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Loup(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void crier() {
		System.out.println("Je hurle Aouuuuuu!");
	}

}
