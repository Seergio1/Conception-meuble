package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;


import Models.Meuble;
import Models.MeublePrix;
import Models.V_meuble;


public class MeubleDAO {
    public void insert(int id_categorie,int id_taille,double prix_vente,int id_style ,Connection connexion) {
        String sql = "INSERT INTO meuble VALUES (default,?,?,?,?)";
        boolean commit = true;
        
        try {
            if (connexion == null) {
                connexion = Connect.obtenirConnexion();
            }

            // Début de la transaction
            connexion.setAutoCommit(false);

            try (PreparedStatement preparedStatement = connexion.prepareStatement(sql)) {
                preparedStatement.setInt(1, id_style);
                preparedStatement.setInt(2, id_categorie);
                preparedStatement.setInt(3, id_taille);
                preparedStatement.setDouble(4, prix_vente);
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

    public  Vector<Meuble> selectAll(Connection connexion) {
        Vector<Meuble> meubles = new Vector<>();
        String sql = "SELECT * FROM meuble";
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
                    int idC = resultSet.getInt("id_categorie");
                    int idS = resultSet.getInt("id_style");
                    int idT = resultSet.getInt("id_taille");
                    double prix_vente = resultSet.getDouble("prix_vente");
                    // Ajoute d'autres colonnes selon ta structure de table

                    Meuble meuble = new Meuble(id,idS,idC,idT,prix_vente);
                    meubles.add(meuble);
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

        return meubles;
    }

    public  Vector<V_meuble> selectAllVMeuble(Connection connexion) {
        Vector<V_meuble> meubles = new Vector<>();
        String sql = "SELECT * FROM v_meuble";
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
                    int id_meuble = resultSet.getInt("id_meuble");
                    String nom_style = resultSet.getString("nom_style");
                    String nom_categorie = resultSet.getString("nom_categorie");
                    String nom_taille = resultSet.getString("nom_taille");
                    double prix_vente = resultSet.getDouble("prix_vente");
                    // Ajoute d'autres colonnes selon ta structure de table

                    V_meuble meuble = new V_meuble(nom_style,nom_categorie,nom_taille,id_meuble,prix_vente);
                    meubles.add(meuble);
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

        return meubles;
    }

    public  Meuble selectById(int id, Connection connexion) {
        String sql = "SELECT * FROM meuble WHERE id = ?";
        Meuble meuble = null;
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
                        int idC = resultSet.getInt("id_categorie");
                        int idS = resultSet.getInt("id_style");
                        int idT = resultSet.getInt("id_taille");
                        double prix_vente = resultSet.getDouble("prix_vente");

                        meuble = new Meuble(id,idS,idC,idT,prix_vente);
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

        return meuble;
    }

    public  Vector<Meuble> selectAllById(int id, Connection connexion) {
        String sql = "SELECT * FROM meuble WHERE id = ?";
        Vector<Meuble> meubles = new Vector<>();
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
                        int idC = resultSet.getInt("id_categorie");
                        int idS = resultSet.getInt("id_style");
                        int idT = resultSet.getInt("id_taille");
                        double prix_vente = resultSet.getDouble("prix_vente");
    
                        Meuble meuble = new Meuble(id,idS,idC,idT,prix_vente);
                        meubles.add(meuble);
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

        return meubles;
    }

    public  double getPrixMeuble(int id, Connection connexion) {
        String sql = "select sum((quantite*pm.prix_unitaire)) as prix_total,id_meuble from meuble_matiere mm join (select min(prix) as prix_unitaire,id_matiere from prix_matiere where id_fournisseur = 1 group by id_matiere) as pm on mm.id_matiere = pm.id_matiere where id_meuble = ? group by id_meuble";
        double prix_total = 0.0;
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
                        prix_total = resultSet.getDouble("prix_total");
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

        return prix_total;
    }

    public  Vector<MeublePrix> getAllMeublePrix(Connection connexion) {
        String sql = "select * from v_info_meuble";
        Vector<MeublePrix> meublePrixs= new Vector<MeublePrix>();
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
                    double prix_total = resultSet.getDouble("prix_total");
                    int idM = resultSet.getInt("id_meuble");
                    String nomCategorie = resultSet.getString("nom_categorie");
                    String nomStyle = resultSet.getString("nom_style");
                    String nomTaille = resultSet.getString("nom_taille");
                    MeublePrix meublePrix = new MeublePrix(idM, nomCategorie, nomStyle, nomTaille, prix_total);
                    meublePrixs.add(meublePrix);
                }

            }catch (SQLException e) {
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

        return meublePrixs;
    }
}
