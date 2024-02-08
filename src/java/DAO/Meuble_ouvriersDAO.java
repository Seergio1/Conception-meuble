package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Meuble;
import Models.Meuble_ouvriers;
import Models.V_meuble;

public class Meuble_ouvriersDAO {
    public void insert(int id_employe,int id_meuble,Connection connexion) {
        String sql = "INSERT INTO meuble_ouvriers VALUES (default,?,?)";
        boolean commit = true;
        
        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_meuble);
                preparedStatement.setInt(2, id_employe);
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

   


    public  Vector<Meuble_ouvriers> selectAllById(int idM, Connection connexion) {
        String sql = "SELECT * FROM meuble_ouvriers WHERE id_meuble = ?";
        Vector<Meuble_ouvriers> meuble_ouvriers = new Vector<>();
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
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        int idE = resultSet.getInt("id_employe");
                        Meuble_ouvriers meuble = new Meuble_ouvriers(id, idM, idE);
                        meuble_ouvriers.add(meuble);
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

        return meuble_ouvriers;
    }

}
