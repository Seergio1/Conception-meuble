package Models;

import java.sql.Timestamp;

public class V_prix_matiere {
    double prix_matiere;
    Timestamp date_prix;
    int id_fournisseur;
    int id_matiere;
    String nom_matiere;
    String nom_fournisseur;
    public V_prix_matiere(double prix_matiere, Timestamp date_prix, int id_fournisseur, int id_matiere,
            String nom_matiere, String nom_fournisseur) {
        this.prix_matiere = prix_matiere;
        this.date_prix = date_prix;
        this.id_fournisseur = id_fournisseur;
        this.id_matiere = id_matiere;
        this.nom_matiere = nom_matiere;
        this.nom_fournisseur = nom_fournisseur;
    }
    public V_prix_matiere() {
    }
    public double getPrix_matiere() {
        return prix_matiere;
    }
    public void setPrix_matiere(double prix_matiere) {
        this.prix_matiere = prix_matiere;
    }
    public Timestamp getDate_prix() {
        return date_prix;
    }
    public void setDate_prix(Timestamp date_prix) {
        this.date_prix = date_prix;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public int getId_matiere() {
        return id_matiere;
    }
    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }
    public String getNom_matiere() {
        return nom_matiere;
    }
    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    public String getNom_fournisseur() {
        return nom_fournisseur;
    }
    public void setNom_fournisseur(String nom_fournisseur) {
        this.nom_fournisseur = nom_fournisseur;
    }
}
