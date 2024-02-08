package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import Models.Employe_embauche;
import Models.Meuble;
import Models.V_info_employe_actuel;



public class Employe_embaucheDAO {
    public void insert(int id_profil,int id_employe,Timestamp date_embauche,int id_poste ,Connection connexion) {
        String sql = "INSERT INTO employe_embauche VALUES (default,?,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_profil);
                preparedStatement.setInt(2, id_employe);
                preparedStatement.setInt(3, id_poste);
                preparedStatement.setTimestamp(4, date_embauche);
                preparedStatement.executeUpdate();
                System.out.println("Données insérées avec succès");
            } catch (SQLException e) {
                commit = false;
                e.printStackTrace();
            } finally {
                // Fin de la transaction
                if (commit) {
                    connexion.commit();
                } else {
                    connexion.rollback();
                }
                connexion.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  Vector<Employe_embauche> selectAll(Connection connexion) {
        Vector<Employe_embauche> employe_embauches = new Vector<>();
        String sql = "SELECT * FROM employe_embauche";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            
            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    int idProfil = resultSet.getInt("id_profil");
                    int idEmploye = resultSet.getInt("id_employe");
                    int idPoste = resultSet.getInt("id_poste");
                    Timestamp dateEmbauche = resultSet.getTimestamp("date_embauche");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Employe_embauche employe_embauche = new Employe_embauche(id, idProfil, idEmploye, idPoste, dateEmbauche);
                    employe_embauches.add(employe_embauche);
                }

            } catch (SQLException e) {
                commit = false;
                e.printStackTrace();
            } finally {
                // Fin de la transaction
                if (commit) {
                    connexion.commit();
                } else {
                    connexion.rollback();
                }
                connexion.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employe_embauches;
    }

    // select * from employe_embauche where id_employe = 4 order by date_embauche asc limit 1
    public  Employe_embauche selectEmployeFirstEmbaucheById(int idE, Connection connexion) {
        String sql = "select * from employe_embauche where id_employe = ? order by date_embauche asc limit 1";
        Employe_embauche employe_embauche = null;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idE);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int idProfil = resultSet.getInt("id_profil");
                        int idPoste = resultSet.getInt("id_poste");
                        Timestamp dateEmbauche = resultSet.getTimestamp("date_embauche");

                        employe_embauche = new Employe_embauche(id, idProfil, idE, idPoste, dateEmbauche);
                    }
                }
            } catch (SQLException e) {
                commit = false;
                e.printStackTrace();
            } finally {
                // Fin de la transaction
                if (commit) {
                    connexion.commit();
                } else {
                    connexion.rollback();
                }
                connexion.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employe_embauche;
    }


    // select * from v_info_employe_with_idemp where id_employe = 2 order by date_embauche asc limit 1
    public  V_info_employe_actuel selectEmployeLastPromotionById(int idE, Connection connexion) {
        String sql = "select * from v_info_employe_with_idemp where id_employe = ? order by date_embauche desc limit 1";
        V_info_employe_actuel v_info_employe_actuel = null;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idE);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        String nomEmp = resultSet.getString("employe_nom");
                        String nomProfil = resultSet.getString("profil_nom");
                        String nom_poste = resultSet.getString("nom_poste");
                        Timestamp datePromo = resultSet.getTimestamp("date_embauche");
                        double salaire = resultSet.getDouble("salaire_employe");
                        double annee_exp = resultSet.getDouble("annee_exp");

                        v_info_employe_actuel = new V_info_employe_actuel(nomEmp, nomProfil, nom_poste, datePromo, salaire, annee_exp);
                    }
                }
            } catch (SQLException e) {
                commit = false;
                e.printStackTrace();
            } finally {
                // Fin de la transaction
                if (commit) {
                    connexion.commit();
                } else {
                    connexion.rollback();
                }
                connexion.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return v_info_employe_actuel;
    }


    public  double selectSalaireByEmp(int idE, Connection connexion) {
        String sql = "select salaire_employe from v_info_employe_with_idemp where id_employe = ? order by date_embauche desc limit 1";
        double salaire = 0.0;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idE);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        salaire = resultSet.getDouble("salaire_employe");
                    }
                }
            } catch (SQLException e) {
                commit = false;
                e.printStackTrace();
            } finally {
                // Fin de la transaction
                if (commit) {
                    connexion.commit();
                } else {
                    connexion.rollback();
                }
                connexion.setAutoCommit(true);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return salaire;
    }

}
