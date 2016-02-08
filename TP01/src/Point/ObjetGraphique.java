package Point;

public interface ObjetGraphique<T> {
  void affiche();
  void translate(int tx,int ty);
  void symX();
  void symY();
  void symO();
  T duplicate(String nom,int dx,int dy);
}
