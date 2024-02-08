package Models;

public class Profil_duree {
    int id;
    int id_profil;
    double experience;
    double coeff;
    public Profil_duree(int id, int id_profil, double experience, double coeff) {
        this.id = id;
        this.id_profil = id_profil;
        this.experience = experience;
        this.coeff = coeff;
    }
    public Profil_duree() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_profil() {
        return id_profil;
    }
    public void setId_profil(int id_profil) {
        this.id_profil = id_profil;
    }
    public double getExperience() {
        return experience;
    }
    public void setExperience(double experience) {
        this.experience = experience;
    }
    public double getCoeff() {
        return coeff;
    }
    public void setCoeff(double coeff) {
        this.coeff = coeff;
    }
}
