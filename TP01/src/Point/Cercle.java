package Point;

public class Cercle implements ObjetGraphique<Cercle> {
	private Point centre;
	private	Integer rayon;
	private	String nom;
	private	static Integer id = 0;

	/**
	 *
	 */
	public Cercle() {
		centre = new Point();
		rayon = 2;
		nom = "Cercle"+id++;
	}
	public Cercle(String cNom,Point ctr,Integer r) {
		nom = cNom;
		centre = ctr;
		rayon = r;
	}

	/**
	 * @return the centre
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * @param centre the centre to set
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	/**
	 * @return the rayon
	 */
	public Integer getRayon() {
		return rayon;
	}

	/**
	 * @param rayon the rayon to set
	 */
	public void setRayon(Integer rayon) {
		this.rayon = rayon;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void affiche() {
		System.out.println("cercle "+nom+" de centre ");
		centre.affiche();
		System.out.println("et de rayon "+rayon.toString());

	}

	@Override
	public void translate(int tx, int ty) {
		centre.translate(tx,ty);
	}

	@Override
	public void symX() {
		centre.symX();
	}

	@Override
	public void symY() {
		centre.symY();
	}

	@Override
	public void symO() {
		centre.symO();
	}

	@Override
	public Cercle duplicate(String dNom, int dx, int dy) {
		Cercle cx = new Cercle(dNom,new Point("dup"+centre.getNom(),dx,dy),rayon);

		return cx;
	}

}
