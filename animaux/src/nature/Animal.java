package nature;

public abstract class Animal {
	private String couleur;
	private Integer poids;
	private String nom;

	/**
	 *
	 */
	public Animal(String n,Integer p,String c) {
		setNom(n);
		setPoids(p);
		setCouleur(c);
	}

	public void crier() {
		System.out.println("emet un cri meconnaissable");
	}
	public void se_deplacer() {
		System.out.println("se deplace");
	}
	public void manger() {
		System.out.println("mange de la viande");
	}
	public void boire() {
		System.out.println("boit de l'eau fraiche");
	}

	/**
	 * @return the couleur
	 */
	public String getCouleur() {
		return couleur;
	}

	/**
	 * @param couleur the couleur to set
	 */
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	/**
	 * @return the poids
	 */
	public Integer getPoids() {
		return poids;
	}

	/**
	 * @param poids the poids to set
	 */
	public void setPoids(Integer poids) {
		this.poids = poids;
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
}
