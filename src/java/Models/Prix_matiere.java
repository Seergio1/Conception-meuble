package Models;

import java.sql.Timestamp;



public class Prix_matiere  {
    int id;
    int id_matiere;
    int id_fournisseur;
    double prix;
    Timestamp date_prix;

    public Prix_matiere(int id, int id_matiere, int id_fournisseur, double prix, Timestamp date_prix) {
        this.id = id;
        this.id_matiere = id_matiere;
        this.id_fournisseur = id_fournisseur;
        this.prix = prix;
        this.date_prix = date_prix;
    }

    


    public Prix_matiere() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getId_fournisseur() {
        return id_fournisseur;
    }

    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public Timestamp getDate_prix() {
        return date_prix;
    }

    public void setDate_prix(Timestamp date_prix) {
        this.date_prix = date_prix;
    }
}
