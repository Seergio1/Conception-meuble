package Models;

public class Employe {
    int id;
    String nom;
    double exp;
    

   

    public Employe(int id, String nom, double exp) {
        this.id = id;
        this.nom = nom;
        this.exp = exp;
    }

    public Employe() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }
}
