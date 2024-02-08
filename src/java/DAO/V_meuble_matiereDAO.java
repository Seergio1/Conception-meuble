package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import Models.Matiere_style;
import Models.Meuble_matiere;
import Models.V_matiere_style;
import Models.V_meuble_matiere;

public class V_meuble_matiereDAO {
    public void insert(int id_meuble,int id_matiere,double quantite ,Connection connexion) {
        String sql = "INSERT INTO meuble_matiere VALUES (default,?,?,?)";
        System.out.println(sql);
        boolean commit = true;

        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_meuble);
                preparedStatement.setInt(2, id_matiere);
                preparedStatement.setDouble(3, quantite);
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

    // public  Vector<V_meuble_matiere> selectAll(Connection connexion) {
    //     Vector<V_meuble_matiere> v_meuble_matieres = new Vector<>();
    //     String sql = "SELECT * FROM v_meuble_matiere";
    //     boolean commit = true;

    //     try {
    //         if (connexion == null) {
    //             connexion = Connect.obtenirConnexion();
    //         }

    //         // Début de la transaction
    //         connexion.setAutoCommit(false);

    //         try (PreparedStatement preparedStatement = connexion.prepareStatement(sql);
    //              ResultSet resultSet = preparedStatement.executeQuery()) {

    //             while (resultSet.next()) {
    //                 int id = resultSet.getInt("id");
    //                 int idMeuble = resultSet.getInt("id_meuble");
    //                 int idMatiere = resultSet.getInt("id_matiere");
    //                 int idFournisseur = resultSet.getInt("id_fournisseur");
    //                 double quantite = resultSet.getDouble("quantite");
    //                 // Ajoute d'autres colonnes selon ta structure de table

    //                 V_meuble_matiere v_meuble_matiere = new V_meuble_matiere(id,idMeuble,idMatiere,idFournisseur,quantite);
    //                 v_meuble_matieres.add(v_meuble_matiere);
    //             }

    //         } catch (SQLException e) {
    //             commit = false;
    //             e.printStackTrace();
    //         } finally {
    //             // Fin de la transaction
    //             if (commit) {
    //                 connexion.commit();
    //             } else {
    //                 connexion.rollback();
    //             }
    //             connexion.setAutoCommit(true);
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return v_meuble_matieres;
    // }

    // public  Matiere_style selectById(int id, Connection connexion) {
    //     String sql = "SELECT * FROM matiere_style WHERE id = ?";
    //     Matiere_style matiere_style = null;
    //     boolean commit = true;

    //     try {
    //         if (connexion == null) {
    //             connexion = Connect.obtenirConnexion();
    //         }

    //         // Début de la transaction
    //         connexion.setAutoCommit(false);

    //         try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
    //             preparedStatement.setInt(1, id);

    //             try (ResultSet resultSet = preparedStatement.executeQuery()) {
    //                 if (resultSet.next()) {
    //                     int idM = resultSet.getInt("id_matiere");
    //                     int idS = resultSet.getInt("id_style");
    //                     // Ajoute d'autres colonnes selon ta structure de table

    //                     matiere_style = new Matiere_style(id,idM,idS);
    //                 }
    //             }
    //         } catch (SQLException e) {
    //             commit = false;
    //             e.printStackTrace();
    //         } finally {
    //             // Fin de la transaction
    //             if (commit) {
    //                 connexion.commit();
    //             } else {
    //                 connexion.rollback();
    //             }
    //             connexion.setAutoCommit(true);
    //         }

    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }

    //     return matiere_style;
    // }

    public  Vector<V_meuble_matiere> selectAllById(int id, Connection connexion) {
        String sql = "SELECT * FROM v_meuble_matiere WHERE id_matiere = ?";
        Vector<V_meuble_matiere> v_meuble_matieres = new Vector<>();
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
                        String nomCategorie = resultSet.getString("nom_categorie");
                        String nomTaille = resultSet.getString("nom_taille");
                        double quantite = resultSet.getDouble("quantite");
                       
                        // Ajoute d'autres colonnes selon ta structure de table
    
                        V_meuble_matiere v_meuble_matiere = new V_meuble_matiere(nomStyle,nomCategorie,nomMatiere,nomTaille,id,quantite);
                        v_meuble_matieres.add(v_meuble_matiere);
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

        return v_meuble_matieres;
    }

    public  Vector<V_meuble_matiere> selectAllMatiereByMeuble(int id, Connection connexion) {
        String sql = "SELECT * FROM v_meuble_matiere WHERE id_meuble = ?";
        Vector<V_meuble_matiere> v_meuble_matieres = new Vector<>();
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
                        String nomCategorie = resultSet.getString("nom_categorie");
                        String nomTaille = resultSet.getString("nom_taille");
                        double quantite = resultSet.getDouble("quantite");
                        int idM = resultSet.getInt("id_matiere");
                       
                        // Ajoute d'autres colonnes selon ta structure de table
    
                        V_meuble_matiere v_meuble_matiere = new V_meuble_matiere(nomStyle, nomCategorie, nomMatiere, nomTaille, idM, quantite);
                        v_meuble_matieres.add(v_meuble_matiere);
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

        return v_meuble_matieres;
    }
    
}
