package fichiers;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;

import outils.Pres;

public class ExFichiers {
	public static void main(String[] args) {
		Pres.titre("Les Fichiers");
		Path image = Paths.get("src/ressources/boot_menu_w.png");
		Path res = Paths.get("src/res/nimage.png");
		Consumer<Path> fichierExiste = f -> System.out.println(Files.exists(f) ? f+" existe" : f+" n'existe pas"); 
		try {
			fichierExiste.accept(res);
			Files.deleteIfExists(res);
			Files.deleteIfExists(res.getParent());
			Files.createDirectory(res.getParent());
			fichierExiste.accept(res);
		}
		catch (IOException e) {
			Pres.titre("erreur mkdir");
			e.printStackTrace();
		}
		try {
			Files.copy(image,res);
			fichierExiste.accept(res);
		}
		catch (IOException e) {
			Pres.titre("erreur copy");
			e.printStackTrace();
		}
	}
}
