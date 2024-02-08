package Models;

public class V_meuble {
    String nom_style;
    String nom_categorie;
    String nom_taille;
    int id_meuble;
    double prix_vente;
    public V_meuble(String nom_style, String nom_categorie, String nom_taille, int id_meuble, double prix_vente) {
        this.nom_style = nom_style;
        this.nom_categorie = nom_categorie;
        this.nom_taille = nom_taille;
        this.id_meuble = id_meuble;
        this.prix_vente = prix_vente;
    }
    public String getNomMeuble(){
        return this.nom_categorie +" "+this.nom_style+" "+this.nom_taille;
    }
    public V_meuble() {
    }
    public String getNom_style() {
        return nom_style;
    }
    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }
    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public String getNom_taille() {
        return nom_taille;
    }
    public void setNom_taille(String nom_taille) {
        this.nom_taille = nom_taille;
    }
    public int getId_meuble() {
        return id_meuble;
    }
    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }
    public double getPrix_vente() {
        return prix_vente;
    }
    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }
}
