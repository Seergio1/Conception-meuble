package Models;

import java.sql.Timestamp;

public class Stock_meuble {
    int id;
    int id_meuble;
    int entree;
    int sortie;

    Timestamp date_stock;
    public Stock_meuble() {
    }
    public Stock_meuble(int id, int id_meuble, int entree, int sortie,Timestamp date_stock) {
        this.id = id;
        this.id_meuble = id_meuble;
        this.entree = entree;
        this.sortie = sortie;
  
        this.date_stock = date_stock;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_meuble() {
        return id_meuble;
    }
    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }
    public int getEntree() {
        return entree;
    }
    public void setEntree(int entree) {
        this.entree = entree;
    }
    public int getSortie() {
        return sortie;
    }
    public void setSortie(int sortie) {
        this.sortie = sortie;
    }
    public Timestamp getDate_stock() {
        return date_stock;
    }
    public void setDate_stock(Timestamp date_stock) {
        this.date_stock = date_stock;
    }

   
}
