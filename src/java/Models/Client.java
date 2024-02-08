package Models;

public class Client {
    int id;
    String nom;
    int idGenre;
    public Client(int id, String nom, int idGenre) {
        this.id = id;
        this.nom = nom;
        this.idGenre = idGenre;
    }
    public Client() {
    }
    public int getIdGenre() {
        return idGenre;
    }
    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
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
}
