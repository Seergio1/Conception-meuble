package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Employe;
import Models.Meuble;
import Models.Profil_duree;


public class EmployeDAO {
    public void insert(String nom,double experience,Connection connexion) {
        String sql = "INSERT INTO employe VALUES (default,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setString(1,nom );
                preparedStatement.setDouble(2, experience);
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
    public  Vector<Employe> selectAll(Connection connexion) {
        Vector<Employe> employes = new Vector<>();
        String sql = "SELECT * FROM employe";
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
                    double exp = resultSet.getDouble("annee_exp");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Employe employe = new Employe(id, nom, exp);
                    employes.add(employe);
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

        return employes;
    }


    // SELECT * FROM employe ORDER BY id DESC LIMIT 1;
public  Employe selectLastEmploye(Connection connexion) {
        String sql = "SELECT * FROM employe ORDER BY id DESC LIMIT 1";
        Employe employe = null;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nom = resultSet.getString("nom");
                        double exp = resultSet.getDouble("annee_exp");
                        employe = new Employe(id, nom, exp);
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

        return employe;
    }
    public  double getExpById(int id, Connection connexion) {
        String sql = "select annee_exp from employe where id =  ?";
        double exp = 0.0;
        boolean commit = true;
        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }
            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        exp = resultSet.getDouble("annee_exp");
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
        return exp;
    }


    
}

