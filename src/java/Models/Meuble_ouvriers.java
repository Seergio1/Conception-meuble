package Models;



public class Meuble_ouvriers {
    int id;
    int id_meuble;
    int id_ouvrier;

    public Meuble_ouvriers(int id, int id_meuble, int id_ouvrier) {
        this.id = id;
        this.id_meuble = id_meuble;
        this.id_ouvrier = id_ouvrier;
    }

    public Meuble_ouvriers() {
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

    public int getId_ouvrier() {
        return id_ouvrier;
    }

    public void setId_ouvrier(int id_ouvrier) {
        this.id_ouvrier = id_ouvrier;
    }

   
}
