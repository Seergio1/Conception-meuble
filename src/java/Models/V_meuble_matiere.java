package Models;

public class V_meuble_matiere {
   
    String nom_style;
    String  nom_categorie;
    String nom_matiere;
    String nom_taille;
    int id_matiere;
    double quantite;
    int id_meuble;
    
    public V_meuble_matiere(String nom_style, String nom_categorie, String nom_matiere, String nom_taille,
            int id_matiere, double quantite) {
        this.nom_style = nom_style;
        this.nom_categorie = nom_categorie;
        this.nom_matiere = nom_matiere;
        this.nom_taille = nom_taille;
        this.id_matiere = id_matiere;
        this.quantite = quantite;
    }
    public V_meuble_matiere(String nom_style, String nom_categorie, String nom_matiere, String nom_taille,
    double quantite, int id_meuble) {
this.nom_style = nom_style;
this.nom_categorie = nom_categorie;
this.nom_matiere = nom_matiere;
this.nom_taille = nom_taille;
this.quantite = quantite;
this.id_meuble = id_meuble;
}
    public V_meuble_matiere() {
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
    public String getNom_matiere() {
        return nom_matiere;
    }
    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    public String getNom_taille() {
        return nom_taille;
    }
    public void setNom_taille(String nom_taille) {
        this.nom_taille = nom_taille;
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
    public int getId_meuble() {
        return id_meuble;
    }
    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }
}
