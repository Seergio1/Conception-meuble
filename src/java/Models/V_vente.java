package Models;

public class V_vente {
    String nomCategorie;
    String nomStyle;
    String nomTaille;
    String nom_genre;
    int nombreHomme;
    public int getNombreHomme() {
        return nombreHomme;
    }
    public void setNombreHomme(int nombreHomme) {
        this.nombreHomme = nombreHomme;
    }
    int nombreFemme;
    
   
    public V_vente(String nomCategorie, String nomStyle, String nomTaille, String nom_genre, int nombreHomme,
            int nombreFemme) {
        this.nomCategorie = nomCategorie;
        this.nomStyle = nomStyle;
        this.nomTaille = nomTaille;
        this.nom_genre = nom_genre;
        this.nombreHomme = nombreHomme;
        this.nombreFemme = nombreFemme;
    }
    public int getNombreFemme() {
        return nombreFemme;
    }
    public void setNombreFemme(int nombreFemme) {
        this.nombreFemme = nombreFemme;
    }
    public V_vente() {
    }
    public String getNomCategorie() {
        return nomCategorie;
    }
    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
    public String getNomStyle() {
        return nomStyle;
    }
    public void setNomStyle(String nomStyle) {
        this.nomStyle = nomStyle;
    }
    public String getNomTaille() {
        return nomTaille;
    }
    public void setNomTaille(String nomTaille) {
        this.nomTaille = nomTaille;
    }
    public String getNom_genre() {
        return nom_genre;
    }
    public void setNom_genre(String nom_genre) {
        this.nom_genre = nom_genre;
    }
}
