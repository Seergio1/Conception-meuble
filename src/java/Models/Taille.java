package Models;





public class Taille {
    int id;
    String nom;
    int unite;


    public Taille(int id, String nom, int unite) {
        this.id = id;
        this.nom = nom;
        this.unite = unite;

    }

    public Taille() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getUnite() {
        return unite;
    }

    public void setUnite(int unite) {
        this.unite = unite;
    }

}
