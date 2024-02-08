package Models;

import java.util.Vector;

public class Resultat_benefice {
    Vector<Double> benefice = new Vector<Double>();
    Vector<String> nom_meuble = new Vector<String>();
    Vector<Double> prix_vente = new Vector<Double>();
    Vector<Double> prix_revient = new Vector<Double>();
    
    
    public Resultat_benefice(Vector<Double> benefice, Vector<String> nom_meuble, Vector<Double> prix_vente,
            Vector<Double> prix_revient) {
        this.benefice = benefice;
        this.nom_meuble = nom_meuble;
        this.prix_vente = prix_vente;
        this.prix_revient = prix_revient;
    }
    public Resultat_benefice() {
    }
    public Vector<Double> getBenefice() {
        return benefice;
    }
    public void setBenefice(Vector<Double> benefice) {
        this.benefice = benefice;
    }
    public Vector<String> getNom_meuble() {
        return nom_meuble;
    }
    public void setNom_meuble(Vector<String> nom_meuble) {
        this.nom_meuble = nom_meuble;
    }
    public Vector<Double> getPrix_vente() {
        return prix_vente;
    }
    public void setPrix_vente(Vector<Double> prix_vente) {
        this.prix_vente = prix_vente;
    }
    public Vector<Double> getPrix_revient() {
        return prix_revient;
    }
    public void setPrix_revient(Vector<Double> prix_revient) {
        this.prix_revient = prix_revient;
    }
}
