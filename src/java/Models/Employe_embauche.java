package Models;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Vector;

import DAO.EmployeDAO;
import DAO.Employe_embaucheDAO;
import DAO.PosteDAO;
import DAO.ProfilDAO;

public class Employe_embauche {
    int id;
    int id_profil;
    int id_employe;
    int id_poste;
    Timestamp date_embauche;
    public Employe_embauche(int id, int id_profil, int id_employe, int id_poste, Timestamp date_embauche) {
        this.id = id;
        this.id_profil = id_profil;
        this.id_employe = id_employe;
        this.id_poste = id_poste;
        this.date_embauche = date_embauche;
    }
    public Employe_embauche() {
    }

    
    public Vector<Employe_embauche> getAllEmployeFirstEmbauche(){
        Vector<Employe_embauche> resultat = new Vector<Employe_embauche>();
        EmployeDAO employeDAO = new EmployeDAO();
        Vector<Employe> allEmploye = employeDAO.selectAll(null);
        Employe_embaucheDAO employe_embaucheDAO = new Employe_embaucheDAO(); 
        try {
            for(Employe emp : allEmploye){
                int idEmp = emp.getId();
                Employe_embauche empFirstEmbauche = employe_embaucheDAO.selectEmployeFirstEmbaucheById(idEmp, null);
                resultat.add(empFirstEmbauche);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultat;
    }

    public double getAnneeDeTravail(Timestamp dateEmbauche){
        double annee_travail = 0.0;
        try {
            LocalDate dateEmb = dateEmbauche.toLocalDateTime().toLocalDate();
            Period difference = Period.between(LocalDate.now(), dateEmb);
            annee_travail = difference.getYears() + difference.getMonths()/12.0+difference.getDays()/365.25;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return annee_travail;
    }

    public void checkPromo(){
        Employe_embauche employe_embauche = new Employe_embauche();
        EmployeDAO employeDAO = new EmployeDAO();
        ProfilDAO profilDAO = new ProfilDAO();
        Employe_embaucheDAO employe_embaucheDAO = new Employe_embaucheDAO();
         try {
            Vector<Employe_embauche> allEmployeFirstEmbauche = employe_embauche.getAllEmployeFirstEmbauche();
            for(Employe_embauche emp : allEmployeFirstEmbauche){
                double annee_travail = employe_embauche.getAnneeDeTravail(emp.getDate_embauche());
                double annee_exp = employeDAO.getExpById(emp.getId_employe(), null)+annee_travail;
                int idProfilActuel = profilDAO.getProfilExp(annee_exp, null);
                if (idProfilActuel!=emp.getId_profil() && idProfilActuel != 0) {
                    employe_embaucheDAO.insert(idProfilActuel, emp.getId_employe(), Timestamp.valueOf(LocalDateTime.now()), emp.getId_poste(), null);
                }else{
                    System.out.println("Cet employé n'est pas apte pour une promo");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public int getId_employe() {
        return id_employe;
    }
    public void setId_employe(int id_employe) {
        this.id_employe = id_employe;
    }
    public int getId_poste() {
        return id_poste;
    }
    public void setId_poste(int id_poste) {
        this.id_poste = id_poste;
    }
    public Timestamp getDate_embauche() {
        return date_embauche;
    }
    public void setDate_embauche(Timestamp date_embauche) {
        this.date_embauche = date_embauche;
    }
}
