package Models;

public class Duree_style {
    int id;
    int id_style;
    double duree;
    public Duree_style(int id, int id_style, double duree) {
        this.id = id;
        this.id_style = id_style;
        this.duree = duree;
    }
    public Duree_style() {
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
    public double getDuree() {
        return duree;
    }
    public void setDuree(double duree) {
        this.duree = duree;
    }
    
}
