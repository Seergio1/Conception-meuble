package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Fournisseur;
import Models.Meuble;

public class FournisseurDAO {
    public  Vector<Fournisseur> selectAll(Connection connexion) {
        Vector<Fournisseur> fournisseurs = new Vector<>();
        String sql = "SELECT * FROM fournisseur";
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
                    int idR = resultSet.getInt("id_region");
                    int idV = resultSet.getInt("id_ville");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Fournisseur fournisseur = new Fournisseur(id, nom, idR, idV);
                    fournisseurs.add(fournisseur);
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

        return fournisseurs;
    }
}
