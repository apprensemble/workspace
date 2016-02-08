package nature;

public abstract class Canin extends Animal {
	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Canin(String n, Integer p, String c) {
		super(n, p, c);
	}

	public void se_deplacer() {
		System.out.println("Nous sommes une meute");
	}

}
