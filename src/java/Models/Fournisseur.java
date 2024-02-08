package Models;


public class Fournisseur  {
    int id;
    String nom;
    int id_region;
    int id_ville;

    public Fournisseur(int id, String nom, int id_region, int id_ville) {
        this.id = id;
        this.nom = nom;
        this.id_region = id_region;
        this.id_ville = id_ville;
    }

    public Fournisseur() {
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

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public int getId_ville() {
        return id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

}
