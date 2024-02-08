package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Meuble;
import Models.Profil;
import Models.Profil_duree;




public class ProfilDAO {
    public void insert(int id_profil,double experience,double coeff,Connection connexion) {
        String sql = "INSERT INTO profil_duree VALUES (default,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_profil);
                preparedStatement.setDouble(2, experience);
                preparedStatement.setDouble(3, coeff);
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

    public  Vector<Profil> selectAll(Connection connexion) {
        Vector<Profil> profils = new Vector<>();
        String sql = "SELECT * FROM profil";
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
                    String nom = resultSet.getString("nom");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Profil profil = new Profil(id, nom);
                    profils.add(profil);
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

        return profils;
    }


     public  int getProfilExp(double exp, Connection connexion) {
        String sqlQuery = "SELECT CASE " +
                                    "WHEN ? >= 0 AND ? < (SELECT experience FROM profil_duree WHERE id_profil = 1) THEN 1 " +
                                    "WHEN ? >= (SELECT experience FROM profil_duree WHERE id_profil = 1) AND ? < (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 2 " +
                                    "WHEN ? >= (SELECT experience FROM profil_duree WHERE id_profil = 2) THEN 3 " +
                                "END AS idProfil";
        int idProfil = 0;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sqlQuery)) {
                // Paramètres pour la valeur d'expérience
                preparedStatement.setDouble(1, exp);
                preparedStatement.setDouble(2, exp);
                preparedStatement.setDouble(3, exp);
                preparedStatement.setDouble(4, exp);
                preparedStatement.setDouble(5, exp);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        idProfil = resultSet.getInt("idProfil");
                    }
                }
            }catch (SQLException e) {
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
            
        }catch(SQLException  e){
            e.printStackTrace();
        }
        return idProfil;
    }

       
}

    

