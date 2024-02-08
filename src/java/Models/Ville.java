package Models;


public class Ville  {
    int id_region;
    int nom;

    public Ville(int id_region, int nom) {
        this.id_region = id_region;
        this.nom = nom;
    }

    public Ville() {
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }
}
