package Point;

public class Rectangle implements ObjetGraphique<Rectangle> {
	private Point psh;
	private Integer longueur;
	private Integer largeur;
	private static Integer id = 0;
	private String nom;

	/**
	 *
	 */
	public Rectangle() {
		nom = "Rectangle"+id++;
		longueur = 5;
		largeur = 2;
		psh = new Point("psh",5,5);
	}

	public Rectangle(String string, Point point, Integer longueur2, Integer largeur2) {
		nom = string;
		psh = point;
		longueur = longueur2;
		largeur = largeur2;
	}

	/**
	 * @return the psh
	 */
	public Point getPsh() {
		return psh;
	}

	/**
	 * @param psh the psh to set
	 */
	public void setPsh(Point psh) {
		this.psh = psh;
	}

	/**
	 * @return the longueur
	 */
	public Integer getLongueur() {
		return longueur;
	}

	/**
	 * @param longueur the longueur to set
	 */
	public void setLongueur(Integer longueur) {
		this.longueur = longueur;
	}

	/**
	 * @return the largeur
	 */
	public Integer getLargeur() {
		return largeur;
	}

	/**
	 * @param largeur the largeur to set
	 */
	public void setLargeur(Integer largeur) {
		this.largeur = largeur;
	}

	/**
	 * @return the id
	 */
	public static Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public static void setId(Integer id) {
		Rectangle.id = id;
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
		System.out.println("Rectangle " + getNom() + " de psh :");
		psh.affiche();
		System.out.println("de longueur " + getLongueur() + " et de largeur " + getLargeur());

	}

	@Override
	public void translate(int tx, int ty) {
		psh.translate(tx, ty);

	}

	@Override
	public void symX() {
		psh.symX();

	}

	@Override
	public void symY() {
		psh.symY();
	}

	@Override
	public void symO() {
		psh.symO();

	}

	@Override
	public Rectangle duplicate(String nom, int dx, int dy) {
		Rectangle dRect = new Rectangle("dup"+getNom()+"_"+nom,new Point("psh",dx,dy),longueur,largeur);
		return dRect;
	}

}
