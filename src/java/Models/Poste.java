package Models;

public class Poste {
    int id;
    String nom;
    double salaire_base;
    public Poste(int id, String nom, double salaire_base) {
        this.id = id;
        this.nom = nom;
        this.salaire_base = salaire_base;
    }
    public Poste() {
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
    public double getSalaire_base() {
        return salaire_base;
    }
    public void setSalaire_base(double salaire_base) {
        this.salaire_base = salaire_base;
    }
}
