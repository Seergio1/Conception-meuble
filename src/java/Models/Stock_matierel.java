package Models;

import java.sql.Timestamp;

public class Stock_matierel {
    int id;
    int id_matiere;
    double entree;
    double sortie;
    Timestamp date_stock;

    public Stock_matierel(int id, int id_matiere,double entree, double sortie,
            Timestamp date_stock) {
        this.id = id;
        this.id_matiere = id_matiere;
        this.entree = entree;
        this.sortie = sortie;
        this.date_stock = date_stock;
    }

    public Stock_matierel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

  
    public double getEntree() {
        return entree;
    }

    public void setEntree(double entree) {
        this.entree = entree;
    }

    public double getSortie() {
        return sortie;
    }

    public void setSortie(double sortie) {
        this.sortie = sortie;
    }


    public Timestamp getDate_stock() {
        return date_stock;
    }

    public void setDate_stock(Timestamp date_stock) {
        this.date_stock = date_stock;
    }
}
