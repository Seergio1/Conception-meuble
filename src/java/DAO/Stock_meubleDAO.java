package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

import Models.Stock_meuble;
import Models.V_stock_meuble;

public class Stock_meubleDAO {
    public void insert(int id_meuble,double entree,double sortie,Timestamp data_stock ,Connection connexion) {
        String sql = "INSERT INTO stock_meuble VALUES (default,?,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_meuble);
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
    public  Stock_meuble selectLastEnterById(int idM, Connection connexion) {
        String sql = "SELECT * FROM stock_meuble WHERE id_meuble= ? order by id desc limit 1";
        Stock_meuble stock_meuble = null;
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, idM);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int entree = resultSet.getInt("entree");
                        int sortie = resultSet.getInt("sortie");
                        Timestamp data_stock = resultSet.getTimestamp("date_stock");
                        stock_meuble = new Stock_meuble(id,idM, entree, sortie, data_stock);
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

        return stock_meuble;
    }

    public  double selectEtatStockByMeuble(int id, Connection connexion) {
        String sql = "SELECT SUM(entree) - SUM(sortie) AS quantite_actuelle\r\n" + //
                "FROM stock_meuble\r\n" + //
                "WHERE id_meuble = ?";
        double stock_meuble = 0.0;
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
                        stock_meuble = resultSet.getDouble("quantite_actuelle");
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

        return stock_meuble;
    }

    public  Vector<V_stock_meuble> selectAllStockMeuble(Connection connexion) {
        Vector<V_stock_meuble> v_stock_meubles = new Vector<>();
        String sql = "SELECT * FROM v_stock_meuble";
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
                    
                    String nom_categorie = resultSet.getString("nom_categorie");
                    String nom_style = resultSet.getString("nom_style");
                    String nom_taille = resultSet.getString("nom_taille");
                    double quantite_actuelle = resultSet.getDouble("quantite_actuelle");
                    // Ajoute d'autres colonnes selon ta structure de table

                    V_stock_meuble v_stock_meuble = new V_stock_meuble(nom_categorie, nom_style, nom_taille, quantite_actuelle);
                    v_stock_meubles.add(v_stock_meuble);
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

        return v_stock_meubles;
    }
}
