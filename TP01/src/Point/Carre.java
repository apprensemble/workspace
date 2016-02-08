package Point;

public class Carre implements ObjetGraphique<Carre> {
	private Point psh;
	private Integer cote;
	private String nom;
	private static Integer id = 0;

	/**
	 *
	 */
	public Carre() {
		psh = new Point("psh",0,0);
		cote = 5;
		nom = "carre"+id++;
	}
	public Carre(String cNom,Point cPsh,Integer cCote) {
		nom = cNom;
		psh = cPsh;
		cote = cCote;
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
	 * @return the cote
	 */
	public Integer getCote() {
		return cote;
	}

	/**
	 * @param cote the cote to set
	 */
	public void setCote(Integer cote) {
		this.cote = cote;
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
		Carre.id = id;
	}

	@Override
	public void affiche() {
		System.out.println("Carre "+getNom()+" de psh :");
		psh.affiche();
		System.out.println("et de cote "+cote.toString());
	}

	@Override
	public void translate(int tx, int ty) {
		psh.translate(tx,ty);
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
	public Carre duplicate(String nom, int dx, int dy) {
		Carre dCarre = new Carre("dup"+getNom()+"_"+nom,new Point("psh",dx,dy),cote);
		return dCarre;
	}

}
