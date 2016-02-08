package Point;
public class Main {
	public static void testCercle() {
		Cercle c1 = new Cercle("c1",new Point("ctr",1,5),5);
		c1.affiche();
		c1.duplicate("nouveau",3,2).affiche();
		c1.translate(4,1);
		c1.affiche();
		c1.symY();
		c1.affiche();
		c1.symX();
		c1.affiche();
		c1.symO();
		c1.affiche();
	}
	public static void testPoint() {
		Point p = new Point("a",1,1);
		p.affiche();
		Point p1 = new Point();
		Point p2 = new Point("p2",1,1);
		p1.affiche();
		p2.affiche();
		Point dp2 = p2.duplicate("dp2",2,2);
		dp2.affiche();
		dp2.translate(1,1);
		dp2.affiche();
		dp2.symY();
		dp2.symX();
		dp2.affiche();
		dp2.symO();
		dp2.affiche();
	}
	public static void main(String [] args) {
		//testPoint();
		//testCercle();
		//testCarre();
		testRectangle();

	}

	private static void testRectangle() {
		Rectangle r1 = new Rectangle();
		r1.affiche();
		Rectangle r2 = new Rectangle("r2",new Point("psh",2,2),3,6);
		r2.affiche();
		r2.duplicate("inc",2,5).affiche();
	}

	private static void testCarre() {
		Carre c1 = new Carre();
		Carre c2 = new Carre("c2",new Point("psh",2,2),3);
		c1.affiche();
		c2.affiche();
		c2.symO();
		c2.affiche();
		c2.duplicate("coucou",3,5).affiche();


	}

}
