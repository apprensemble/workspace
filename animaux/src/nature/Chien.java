package nature;

public class Chien extends Canin {

	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Chien(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void crier() {
		System.out.println("Wouwou, J'aboie!");
	}
}
