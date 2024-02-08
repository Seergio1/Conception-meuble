package Models;

import java.sql.Timestamp;

public class V_info_employe_actuel {
    String nomEmp;
    String nomProfil;
    String nom_poste;
    Timestamp datePromo;
    double salaire;
    double annee_exp;
    public V_info_employe_actuel(String nomEmp, String nomProfil, String nom_poste, Timestamp datePromo, double salaire,
            double annee_exp) {
        this.nomEmp = nomEmp;
        this.nomProfil = nomProfil;
        this.nom_poste = nom_poste;
        this.datePromo = datePromo;
        this.salaire = salaire;
        this.annee_exp = annee_exp;
    }
    public V_info_employe_actuel() {
    }
    public String getNomEmp() {
        return nomEmp;
    }
    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }
    public String getNomProfil() {
        return nomProfil;
    }
    public void setNomProfil(String nomProfil) {
        this.nomProfil = nomProfil;
    }
    public String getNom_poste() {
        return nom_poste;
    }
    public void setNom_poste(String nom_poste) {
        this.nom_poste = nom_poste;
    }
    public Timestamp getDatePromo() {
        return datePromo;
    }
    public void setDatePromo(Timestamp datePromo) {
        this.datePromo = datePromo;
    }
    public double getSalaire() {
        return salaire;
    }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
    public double getAnnee_exp() {
        return annee_exp;
    }
    public void setAnnee_exp(double annee_exp) {
        this.annee_exp = annee_exp;
    }
}
