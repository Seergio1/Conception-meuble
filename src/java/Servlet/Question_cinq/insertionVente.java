/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_cinq;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;

import DAO.Stock_meubleDAO;
import DAO.V_venteDAO;
import DAO.VenteDAO;
import Models.V_vente;
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
@WebServlet(name = "insertionVente", urlPatterns = {"/insertionVente"})
public class insertionVente extends HttpServlet {

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
        int id_client = 0;
        int nombre = 0;
        int id_meuble = 0;
        double quantite_meuble_stock = 0.0;
        Stock_meubleDAO stock_meubleDAO = new Stock_meubleDAO();
        VenteDAO venteDAO = new VenteDAO();
        ErreurStock erreurStock = new ErreurStock();

        try {
            if (!request.getParameter("nombre").equalsIgnoreCase("") && Integer.valueOf(request.getParameter("nombre"))>0) {
                id_client = Integer.valueOf(request.getParameter("client"));
                nombre = Integer.valueOf(request.getParameter("nombre"));
                id_meuble = Integer.valueOf(request.getParameter("meuble"));
                quantite_meuble_stock = stock_meubleDAO.selectEtatStockByMeuble(id_meuble, null);

                System.out.println("meuble en stock : "+quantite_meuble_stock);
                System.out.println("meuble(s) demandé(s) : "+nombre);
                if (quantite_meuble_stock >= nombre) {
                    venteDAO.insert(id_client, nombre, id_meuble, null);
                    stock_meubleDAO.insert(id_meuble, 0.0, nombre, Timestamp.valueOf(LocalDateTime.now()), null);
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }else{
                    System.out.println("Stock de meuble insuffisante");
                    erreurStock.getNom_matiere().add("Meuble");
                    erreurStock.getQuantiteDemande().add(Double.valueOf(nombre));
                    erreurStock.getQuantiteStock().add(Double.valueOf(quantite_meuble_stock));
                    erreurStock.setErreur("Stock de meuble insuffisante");
                    request.setAttribute("erreurStock", erreurStock);
                    request.getRequestDispatcher("/getAffichageVente").forward(request, response);
                }
                
            }else{
                erreurStock.setErreur("Quantité de meuble invalide");
                request.setAttribute("erreurStock", erreurStock);
                request.getRequestDispatcher("/getAffichageVente").forward(request, response);
            }
            
        } catch (Exception e) {
            System.out.println("Vente meuble : "+e.getLocalizedMessage());
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
