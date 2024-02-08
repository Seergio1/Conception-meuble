package Models;

public class V_stock_meuble {
    String nom_categorie;
    String nom_style;
    String nom_taille;
    double quantite_actuelle;
    public V_stock_meuble(String nom_categorie, String nom_style, String nom_taille, double quantite_actuelle) {
        this.nom_categorie = nom_categorie;
        this.nom_style = nom_style;
        this.nom_taille = nom_taille;
        this.quantite_actuelle = quantite_actuelle;
    }

    public String getNomMeuble(){
        return this.nom_categorie +" "+this.nom_style+" "+this.nom_taille;
    }

    public V_stock_meuble() {
    }
    public String getNom_categorie() {
        return nom_categorie;
    }
    public void setNom_categorie(String nom_categorie) {
        this.nom_categorie = nom_categorie;
    }
    public String getNom_style() {
        return nom_style;
    }
    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }
    public String getNom_taille() {
        return nom_taille;
    }
    public void setNom_taille(String nom_taille) {
        this.nom_taille = nom_taille;
    }
    public double getQuantite_actuelle() {
        return quantite_actuelle;
    }
    public void setQuantite_actuelle(double quantite_actuelle) {
        this.quantite_actuelle = quantite_actuelle;
    }
}
