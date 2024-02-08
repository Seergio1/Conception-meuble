package Models;

import java.util.Vector;

import DAO.Employe_embaucheDAO;
import DAO.MeubleDAO;
import DAO.Meuble_ouvriersDAO;
import DAO.StyleDAO;

public class Meuble {
    int id;
    int id_style;
    int id_categorie;
    int id_taille;
    double prix_vente;

   

    public Meuble(int id, int id_style, int id_categorie, int id_taille,double prix_vente) {
        this.id = id;
        this.id_style = id_style;
        this.id_categorie = id_categorie;
        this.id_taille = id_taille;
        this.prix_vente = prix_vente;
    }

    public double getPrixMeubleEmploye(Meuble meuble){
        double resultat = 0.0;
        double prix_un_emp = 0.0;
         Meuble_ouvriersDAO meuble_ouvriersDAO = new Meuble_ouvriersDAO();
         Employe_embaucheDAO employe_embaucheDAO = new Employe_embaucheDAO();
         StyleDAO styleDAO = new StyleDAO();
        try {
            Vector<Meuble_ouvriers> meuble_ouvriers = meuble_ouvriersDAO.selectAllById(meuble.getId(), null);
            double heure_travail = styleDAO.selectDureeStyleByMeuble(meuble.getId_style(), null).getDuree();
            for (int i = 0; i < meuble_ouvriers.size(); i++) {
                int idE = meuble_ouvriers.get(i).getId_ouvrier();
                double salaire_employe = employe_embaucheDAO.selectSalaireByEmp(idE, null);
                prix_un_emp = salaire_employe * heure_travail;
                resultat += prix_un_emp;
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
      
        return resultat;
    }
    
    public double getPrixVente(double prix_revient,double pourcentage){
        double resultat = 0.0;
        resultat = prix_revient + ((prix_revient*pourcentage)/100);
        System.out.println(resultat);
        return resultat;
    }


    public Meuble() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_style() {
        return id_style;
    }

    public void setId_style(int id_style) {
        this.id_style = id_style;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_taille() {
        return id_taille;
    }

    public void setId_taille(int id_taille) {
        this.id_taille = id_taille;
    }
    public double getPrix_vente() {
        return prix_vente;
    }

    public void setPrix_vente(double prix_vente) {
        this.prix_vente = prix_vente;
    }
}
