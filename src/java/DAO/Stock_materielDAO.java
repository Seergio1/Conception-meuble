package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import Models.Stock_matierel;
import Models.V_stock_materiel;

public class Stock_materielDAO {
    public void insert(int id_matiere,double entree,double sortie,Timestamp data_stock ,Connection connexion) {
        String sql = "INSERT INTO stock_materiel VALUES (default,?,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_matiere);
                preparedStatement.setDouble(2, entree);
                preparedStatement.setDouble(3, sortie);
                preparedStatement.setTimestamp(4, data_stock);
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
    // select * from stock_materiel where annee_exp = 6 order by id desc limit 1
    public  Stock_matierel selectLastEnterById(int id, Connection connexion) {
        String sql = "SELECT * FROM stock_materiel WHERE id_matiere = ? order by id desc limit 1";
        Stock_matierel stock_matierel = null;
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
                        double entree = resultSet.getInt("entree");
                        double sortie = resultSet.getInt("sortie");
                        Timestamp data_stock = resultSet.getTimestamp("date_stock");
                        stock_matierel = new Stock_matierel(id, idM, entree, sortie, data_stock);
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

        return stock_matierel;
    }

    public  double selectEtatStockByMatiere(int id, Connection connexion) {
        String sql = "SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle FROM stock_materiel WHERE id_matiere = ?";
        double stock_matierel = 0.0;
        boolean commit = true;
        System.out.println("idMatiere: "+id);
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
                        stock_matierel = resultSet.getDouble("quantite_actuelle");
                        System.out.println("quantite sql:"+stock_matierel);
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

        return stock_matierel;
    }

    public  Vector<V_stock_materiel> selectAllStockMatiere(Connection connexion) {
        Vector<V_stock_materiel> v_stock_materiels = new Vector<>();
        String sql = "SELECT * FROM v_stock_matiere";
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
                    
                    String nom = resultSet.getString("nom");
                    double quantite_actuelle = resultSet.getDouble("quantite_actuelle");
                    // Ajoute d'autres colonnes selon ta structure de table

                    V_stock_materiel v_stock_materiel = new V_stock_materiel(nom, quantite_actuelle);
                    v_stock_materiels.add(v_stock_materiel);
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

        return v_stock_materiels;
    }
}
