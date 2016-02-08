package nature;

public class Lion extends Felin {


	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Lion(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void crier() {
		System.out.println("Rouuuuaaaaaaouhh, je rugis!");
	}
}
