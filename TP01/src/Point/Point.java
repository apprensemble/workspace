package Point;

public class Point implements ObjetGraphique<Point> {
	public static Integer id = 0;
	public Integer x;
	public Integer y;
	public String nom;

	/**
	 *
	 */
	public Point() {
		x = 0;
		y = 0;
		nom = "Point"+id.toString();
		id++;
	}

	public Point(String pnom,Integer px,Integer py) {
		nom = pnom;
		x = px;
		y = py;
	}

	@Override
	public void affiche() {
		System.out.println("Point "+getNom()+" ("+getX()+","+getY()+")");
	}

	@Override
	public void translate(int tx, int ty) {
		x+=tx;
		y+=ty;
	}

	@Override
	public void symX() {
		x=-x;
	}

	@Override
	public void symY() {
		y=-y;
	}

	@Override
	public void symO() {
		x=-x;
		y=-y;
	}

	@Override
	public Point duplicate(String nNom,int dx, int dy) {
		return new Point (nNom,x+dx,y+dy);

	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
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
