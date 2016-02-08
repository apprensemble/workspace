package nature;

public class Main {
	public static void context() {
		System.out.println("Quelque part...Au mileu d'une foret(celle de compiegne peut être)");

	}
	public static void animaux() {
	
		 new Loup("loulou",50,"gris").boire();
		 new Chien("toutouLinux",1,"bleu").se_deplacer();
		 new Chat("le_chat_botte",50,"monochrome").manger();
		 new Lion("Simba",200,"flamboyant").se_deplacer();
		 new Tigre("tigrou",100,"rayé roux").crier();

	}
	public static void main(String[] args) {
		context();
		animaux();


	
	}
}
