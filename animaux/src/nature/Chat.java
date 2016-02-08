package nature;

public class Chat extends Felin {

	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Chat(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void crier() {
		System.out.println("Miaaaaou, je miaule!");
	}
}
