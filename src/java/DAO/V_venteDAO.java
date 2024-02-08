package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Meuble;
import Models.V_vente;

public class V_venteDAO {
    public  Vector<V_vente> selectAll(Connection connexion) {
        Vector<V_vente> v_ventes = new Vector<>();
        String sql = "SELECT * FROM stat_all_meuble";
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
                    String nomCategorie = resultSet.getString("nom_categorie");
                    String nomStyle = resultSet.getString("nom_style");
                    String nomTaille = resultSet.getString("nom_taille");
                    String nomGenre = resultSet.getString("genre");
                    int nombreHomme = resultSet.getInt("ventes_homme");
                    int nombreFemme = resultSet.getInt("ventes_femme");
                    
                    // Ajoute d'autres colonnes selon ta structure de table

                   V_vente vente = new V_vente(nomCategorie, nomStyle, nomTaille, nomGenre, nombreHomme, nombreFemme);
                    v_ventes.add(vente);
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

        return v_ventes;
    }


    public  Vector<V_vente> selectById(int id, Connection connexion) {
        String sql = "SELECT\r\n" + //
                "    c.nom AS nom_categorie,\r\n" + //
                "    s.nom AS nom_style,\r\n" + //
                "    t.nom AS nom_taille,\r\n" + //
                "    g.nom AS genre,\r\n" + //
                "    SUM(CASE WHEN g.nom = 'homme' THEN v.nombre ELSE 0 END) AS ventes_homme,\r\n" + //
                "    SUM(CASE WHEN g.nom = 'femme' THEN v.nombre ELSE 0 END) AS ventes_femme\r\n" + //
                "FROM\r\n" + //
                "    vente v\r\n" + //
                "JOIN\r\n" + //
                "    client cl ON v.id_client = cl.id\r\n" + //
                "JOIN\r\n" + //
                "    genre g ON cl.id_genre = g.id\r\n" + //
                "JOIN\r\n" + //
                "    meuble m ON v.id_meuble = m.id\r\n" + //
                "JOIN\r\n" + //
                "    categorie c ON m.id_categorie = c.id\r\n" + //
                "JOIN\r\n" + //
                "    style s ON m.id_style = s.id\r\n" + //
                "JOIN\r\n" + //
                "    taille t ON m.id_taille = t.id\r\n" + //
                "WHERE\r\n" + //
                "    m.id = ? \r\n" + //
                "GROUP BY\r\n" + //
                " c.nom, s.nom, t.nom, g.nom;";
        Vector<V_vente> v_ventes = new Vector<>();
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
                        String nomCategorie = resultSet.getString("nom_categorie");
                    String nomStyle = resultSet.getString("nom_style");
                    String nomTaille = resultSet.getString("nom_taille");
                    String nomGenre = resultSet.getString("genre");
                    int nombreHomme = resultSet.getInt("ventes_homme");
                    int nombreFemme = resultSet.getInt("ventes_femme");
                    
                    // Ajoute d'autres colonnes selon ta structure de table

                   V_vente vente = new V_vente(nomCategorie, nomStyle, nomTaille, nomGenre, nombreHomme, nombreFemme);
                    v_ventes.add(vente);
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

        return v_ventes;
    }
}
