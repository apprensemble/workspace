package nature;

public abstract class Felin extends Animal {

	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Felin(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void se_deplacer() {
		System.out.println("je me deplace seul");
	}
}
