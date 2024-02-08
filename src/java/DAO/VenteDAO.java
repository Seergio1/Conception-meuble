package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class VenteDAO {
    public void insert(int id_client,int nombre,int id_meuble,Connection connexion) {
        String sql = "INSERT INTO vente VALUES (default,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_client);
                preparedStatement.setInt(2, nombre);
                preparedStatement.setInt(3, id_meuble);
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
}
