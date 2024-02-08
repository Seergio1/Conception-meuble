package Models;

import java.util.Vector;

import DAO.MeubleDAO;

public class MeublePrix {
    int idMeuble;
    String nom_categorie;
    String nom_style;
    String nom_taille;
    double prix;

    public Vector<MeublePrix> getMeubleEntre(double min, double max) {
        Vector<MeublePrix> resultat = new Vector<MeublePrix>();
        MeubleDAO meubleDAO = new MeubleDAO();
        try {
            Vector<MeublePrix> allMeuble = meubleDAO.getAllMeublePrix(null);
            System.out.println("min : " + min);
            System.out.println("max : " + max);
            for (int i = 0; i < allMeuble.size(); i++) {

                if (allMeuble.get(i).getPrix() >= min && allMeuble.get(i).getPrix() <= max) {
                    resultat.add(allMeuble.get(i));
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultat;
    }

    public MeublePrix(int idMeuble, String nom_categorie, String nom_style, String nom_taille, double prix) {
        this.idMeuble = idMeuble;
        this.nom_categorie = nom_categorie;
        this.nom_style = nom_style;
        this.nom_taille = nom_taille;
        this.prix = prix;
    }

    public MeublePrix() {
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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
}
