package Models;

public class Vente {
    int id;
    int id_client;
    int nombre;
    int id_meuble;
    public Vente(int id, int id_client, int nombre, int id_meuble) {
        this.id = id;
        this.id_client = id_client;
        this.nombre = nombre;
        this.id_meuble = id_meuble;
    }
    public Vente() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    public int getNombre() {
        return nombre;
    }
    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    public int getId_meuble() {
        return id_meuble;
    }
    public void setId_meuble(int id_meuble) {
        this.id_meuble = id_meuble;
    }
}
