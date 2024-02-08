package Models;



public class Taille_nombre  {
    int id;
    int id_taille;
    double coeff;

    public Taille_nombre(int id, int id_taille, double coeff) {
        this.id = id;
        this.id_taille = id_taille;
        this.coeff = coeff;
    }

    public Taille_nombre() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_taille() {
        return id_taille;
    }

    public void setId_taille(int id_taille) {
        this.id_taille = id_taille;
    }

    public double getCoeff() {
        return coeff;
    }

    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }

}
