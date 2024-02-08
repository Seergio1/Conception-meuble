/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Matiere_style;
import Models.V_matiere_style;



/**
 *
 * @author sergi
 */
public class MatiereStyleDAO {
    public void insert(int id_matiere,int id_style ,Connection connexion) {
        String sql = "INSERT INTO matiere_style VALUES (default,?,?)";
        System.out.println(sql);
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_matiere);
                preparedStatement.setInt(2, id_style);
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

    public  Vector<Matiere_style> selectAll(Connection connexion) {
        Vector<Matiere_style> matiere_styles = new Vector<>();
        String sql = "SELECT * FROM matiere_style";
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
                    int idM = resultSet.getInt("id_matiere");
                    int idS = resultSet.getInt("id_style");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Matiere_style matiere_style = new Matiere_style(id, idM,idS);
                    matiere_styles.add(matiere_style);
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

        return matiere_styles;
    }

    public  Matiere_style selectById(int id, Connection connexion) {
        String sql = "SELECT * FROM matiere_style WHERE id = ?";
        Matiere_style matiere_style = null;
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
                        int idM = resultSet.getInt("id_matiere");
                        int idS = resultSet.getInt("id_style");
                        // Ajoute d'autres colonnes selon ta structure de table

                        matiere_style = new Matiere_style(id,idM,idS);
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

        return matiere_style;
    }

    public  Vector<V_matiere_style> selectAllById(int id, Connection connexion) {
        String sql = "SELECT * FROM v_matiere_style WHERE id_style = ?";
        Vector<V_matiere_style> v_matiere_styles = new Vector<>();
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
                    while (resultSet.next()) {
                        
                        String nomStyle = resultSet.getString("nom_style");
                        String nomMatiere = resultSet.getString("nom_matiere");
                        int idS = resultSet.getInt("id_style");
                        // Ajoute d'autres colonnes selon ta structure de table
    
                        V_matiere_style v_matiere_style = new V_matiere_style(id,nomStyle,nomMatiere,idS);
                        v_matiere_styles.add(v_matiere_style);
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

        return v_matiere_styles;
    }
    

    

}
