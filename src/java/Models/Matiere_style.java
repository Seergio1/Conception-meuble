/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;


/**
 *
 * @author sergi
 */
public class Matiere_style  {
    int id;
    int id_matiere;
    int id_style;
    

    public Matiere_style(int id, int id_matiere, int id_style) {
        this.id = id;
        this.id_matiere = id_matiere;
        this.id_style = id_style;
    }

    public Matiere_style() {
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

    public int getId_style() {
        return id_style;
    }

    public void setId_style(int id_style) {
        this.id_style = id_style;
    }
}
