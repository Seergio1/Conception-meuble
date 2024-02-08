package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;


import Models.Prix_matiere;
import Models.V_prix_matiere;


public class Prix_matiereDAO {
    public void insert(int id_matiere,int id_fournisseur,double prix,String date ,Connection connexion) {
        String sql = "INSERT INTO prix_matiere VALUES (default,?,?,?,?)";
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_matiere);
                preparedStatement.setInt(2, id_fournisseur);
                preparedStatement.setDouble(3, prix);
                preparedStatement.setTimestamp(4, Timestamp.valueOf(date));
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

    public  Vector<Prix_matiere> selectAll(Connection connexion) {
        Vector<Prix_matiere> prix_matieres = new Vector<>();
        String sql = "SELECT * FROM prix_matiere";
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
                    int idF = resultSet.getInt("id_fournisseur");
                    double prix = resultSet.getDouble("prix");
                    Timestamp date = resultSet.getTimestamp("date_prix");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Prix_matiere prix_matiere = new Prix_matiere(id,idM,idF,prix,date);
                    prix_matieres.add(prix_matiere);
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

        return prix_matieres;
    }

    public  Vector<V_prix_matiere> selectAllVPrixMatiere(Connection connexion) {
        Vector<V_prix_matiere> v_prix_matieres = new Vector<>();
        String sql = "SELECT * FROM v_prix_matiere";
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
                    double prix_matiere = resultSet.getDouble("prix_matiere");
                    Timestamp date_prix = resultSet.getTimestamp("date_prix");
                    int id_fournisseur = resultSet.getInt("id_fournisseur");
                    int id_matiere = resultSet.getInt("id_matiere");
                    String nom_matiere = resultSet.getString("nom_matiere");
                    String nom_fournisseur = resultSet.getString("nom_fournisseur");
                    
                    // Ajoute d'autres colonnes selon ta structure de table

                    V_prix_matiere v_prix_matiere = new V_prix_matiere(prix_matiere,date_prix,id_fournisseur,id_matiere,nom_matiere,nom_fournisseur);
                    v_prix_matieres.add(v_prix_matiere);
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

        return v_prix_matieres;
    }

    public  Prix_matiere selectById(int id, Connection connexion) {
        String sql = "SELECT * FROM meuble WHERE id = ?";
        Prix_matiere prix_matiere = null;
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
                        int idF = resultSet.getInt("id_fournisseur");
                        double prix = resultSet.getDouble("prix");
                        Timestamp date = resultSet.getTimestamp("date_prix");

                        prix_matiere = new Prix_matiere(id,idM,idF,prix,date);
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

        return prix_matiere;
    }

    public  Vector<Prix_matiere> selectAllById(int id, Connection connexion) {
        String sql = "SELECT * FROM prix_matiere WHERE id = ?";
        Vector<Prix_matiere> prix_matieres = new Vector<>();
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
                        int idM = resultSet.getInt("id_matiere");
                        int idF = resultSet.getInt("id_fournisseur");
                        double prix = resultSet.getDouble("prix");
                        Timestamp date = resultSet.getTimestamp("date_prix");
    
                        Prix_matiere prix_matiere =  new Prix_matiere(id,idM,idF,prix,date);
                        prix_matieres.add(prix_matiere);
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
        return prix_matieres;
    }


    public  double getPrixMatiere(int id, Connection connexion) {
        String sql = "SELECT prix FROM prix_matiere where id_matiere = ? order by date_prix asc limit 1;";
        double prix = 0.0;
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
                        prix = resultSet.getDouble("prix");
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
        return prix;
    }
}
