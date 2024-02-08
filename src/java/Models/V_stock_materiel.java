package Models;

public class V_stock_materiel {
    String nom;
    double quantite_actuelle;
    public V_stock_materiel(String nom, double quantite_actuelle) {
        this.nom = nom;
        this.quantite_actuelle = quantite_actuelle;
    }
    public V_stock_materiel() {
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getQuantite_actuelle() {
        return quantite_actuelle;
    }
    public void setQuantite_actuelle(double quantite_actuelle) {
        this.quantite_actuelle = quantite_actuelle;
    }
}
