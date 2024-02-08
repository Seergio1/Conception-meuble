package Models;



public class Region {
    int id_region;
    String nom;

    public Region(int id_region, String nom) {
        this.id_region = id_region;
        this.nom = nom;
    }

    public Region() {
    }

    public int getId_region() {
        return id_region;
    }

    public void setId_region(int id_region) {
        this.id_region = id_region;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
