package nature;

public class Tigre extends Felin {

	/**
	 * @param n
	 * @param p
	 * @param c
	 */
	public Tigre(String n, Integer p, String c) {
		super(n, p, c);
	}

	@Override
	public void crier() {
		System.out.println("gRooouaaahh, je grogne!");
	}
}
