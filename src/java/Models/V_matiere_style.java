package Models;





public class V_matiere_style {
    int id;
    String nom_style;
    String nom_matiere;
    int id_style;

    

    public V_matiere_style(int id, String nom_style, String nom_matiere,int id_style) {
        this.id = id;
        this.nom_style = nom_style;
        this.nom_matiere = nom_matiere;
        this.id_style = id_style;
       
    }

    public V_matiere_style() {
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_style() {
        return nom_style;
    }

    public void setNom_style(String nom_style) {
        this.nom_style = nom_style;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    public int getId_style() {
        return id_style;
    }

    public void setId_style(int id_style) {
        this.id_style = id_style;
    }

    
}
