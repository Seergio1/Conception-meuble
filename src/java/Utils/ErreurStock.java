package Utils;

import java.util.Vector;

public class ErreurStock {
    Vector<String> nom_matiere = new Vector<String>();
    Vector<Double> quantiteStock = new Vector<Double>();
    Vector<Double> quantiteDemande = new Vector<Double>();
    String erreur = "erreur stock par defaut";


    public ErreurStock(Vector<String> nom_matiere, Vector<Double> quantiteStock, Vector<Double> quantiteDemande,
            String erreur) {
        this.nom_matiere = nom_matiere;
        this.quantiteStock = quantiteStock;
        this.quantiteDemande = quantiteDemande;
        this.erreur = erreur;
    }
    public ErreurStock() {
    }
   
 

   
    public Vector<String> getNom_matiere() {
        return nom_matiere;
    }
    public void setNom_matiere(Vector<String> nom_matiere) {
        this.nom_matiere = nom_matiere;
    }
    public Vector<Double> getQuantiteStock() {
        return quantiteStock;
    }
    public void setQuantiteStock(Vector<Double> quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
    public Vector<Double> getQuantiteDemande() {
        return quantiteDemande;
    }
    public void setQuantiteDemande(Vector<Double> quantiteDemande) {
        this.quantiteDemande = quantiteDemande;
    }
    public String getErreur() {
        return erreur;
    }
    public void setErreur(String erreur) {
        this.erreur = erreur;
    }
}
