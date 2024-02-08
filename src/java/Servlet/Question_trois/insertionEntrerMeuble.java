/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_trois;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;

import DAO.Stock_materielDAO;
import DAO.Stock_meubleDAO;
import DAO.V_meuble_matiereDAO;
import Models.V_meuble_matiere;
import Utils.ErreurStock;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "insertionEntrerMeuble", urlPatterns = {"/insertionEntrerMeuble"})
public class insertionEntrerMeuble extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int idMeuble = 0;
        int quantite = 0;
        int countMeuble = 0;
        V_meuble_matiereDAO v_meuble_matiereDAO = new V_meuble_matiereDAO();
        Stock_materielDAO stock_materielDAO = new Stock_materielDAO();
        Stock_meubleDAO stock_meubleDAO = new Stock_meubleDAO();
        ErreurStock erreurStock = new ErreurStock();

        try {
            idMeuble = Integer.valueOf(request.getParameter("meuble"));
            quantite = Integer.valueOf(request.getParameter("quantite"));
            Vector<V_meuble_matiere> matieresMeuble = v_meuble_matiereDAO.selectAllMatiereByMeuble(idMeuble, null);
            if (quantite>0 && !request.getParameter("quantite").equalsIgnoreCase("")) {
                for (int i = 0; i < quantite; i++) {
                    int countMatiere = 0;
                    for (int j = 0; j < matieresMeuble.size(); j++) {
                        double quantiteMatiereStock = stock_materielDAO.selectEtatStockByMatiere(matieresMeuble.get(j).getId_matiere(), null);
                        double quantiteMatiereDemande = matieresMeuble.get(j).getQuantite();
                        // System.out.println("matiere : "+matieresMeuble.get(j).getNom_matiere());
                        // System.out.println("stock : "+quantiteMatiereStock);
                        // System.out.println("demander: "+quantiteMatiereDemande);
    
                        if (quantiteMatiereStock >= quantiteMatiereDemande) {
                            countMatiere++; 
                            // System.out.println(countMatiere);
                        }else{
                            erreurStock.getNom_matiere().add(matieresMeuble.get(j).getNom_matiere());
                            erreurStock.getQuantiteStock().add(stock_materielDAO.selectEtatStockByMatiere(matieresMeuble.get(j).getId_matiere(), null));
                            erreurStock.getQuantiteDemande().add(matieresMeuble.get(j).getQuantite());
                        }
                    }
    
                    if (countMatiere==matieresMeuble.size()) {
                        
                        for (int j = 0; j < matieresMeuble.size(); j++) {
                            stock_materielDAO.insert(matieresMeuble.get(j).getId_matiere(), 0.0,matieresMeuble.get(j).getQuantite(), Timestamp.valueOf(LocalDateTime.now()), null);
                        }   
                        stock_meubleDAO.insert(idMeuble, 1, 0.0, Timestamp.valueOf(LocalDateTime.now()), null);
                        countMeuble++;
                    } else{
                        System.out.println("Stock de matiere insuffisante, fabrication terminé : "+i+"/"+matieresMeuble.size());
                        erreurStock.setErreur("Stock de matiere insuffisante, fabrication terminé : "+i+"/"+matieresMeuble.size());
                        request.setAttribute("erreurStock", erreurStock);
                        request.getRequestDispatcher("/getAffichageCreationMeuble").forward(request, response);
                    }
    
                }             
            }else{
                System.out.println("Quantité invalide");
                erreurStock.setErreur("Quantité invalide");
                request.setAttribute("erreurStock", erreurStock);
                request.getRequestDispatcher("/getAffichageCreationMeuble").forward(request, response);
            }
            if (countMeuble==quantite) {
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }    
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
