package Models;



public class Meuble_matiere  {
    int id;
    int id_meuble;
    int id_matiere;
    double quantite;

    public Meuble_matiere(int id, int id_meuble, int id_matiere, double quantite) {
        this.id = id;
        this.id_meuble = id_meuble;
        this.id_matiere = id_matiere;
        this.quantite = quantite;
    }

    public Meuble_matiere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_meuble() {
        return id_meuble;
    }

    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }


    public double getQuantite() {
        return quantite;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
}
