/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_benef;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import DAO.MeubleDAO;
import Models.Meuble;
import Models.Resultat_benefice;
import Models.V_meuble;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "rechercheBenefice", urlPatterns = {"/rechercheBenefice"})
public class rechercheBenefice extends HttpServlet {

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
            double max = 0.0;
            double min = 0.0;
            MeubleDAO meubleDAO = new MeubleDAO();
            Meuble meuble = new Meuble();
            Resultat_benefice resultat_benefice = new Resultat_benefice();
        try {
            max = Double.valueOf(request.getParameter("max"));
            min = Double.valueOf(request.getParameter("min"));
            Vector<Meuble> allMeubles = meubleDAO.selectAll(null);
            Vector<V_meuble> allDataMeuble = meubleDAO.selectAllVMeuble(null);
            double pourcentage = 0.0;
            for (int i = 0; i < allMeubles.size(); i++) {
                meuble = allMeubles.get(i);
                pourcentage = meuble.getPrix_vente(); // ito lay pourcentage
                double prix_meubleMatiere = meubleDAO.getPrixMeuble(meuble.getId(), null);
                double prix_meubleEmploye = meuble.getPrixMeubleEmploye(meuble);
                double prix_revient = prix_meubleEmploye + prix_meubleMatiere;
                double benefice = meuble.getPrixVente(prix_revient,pourcentage) - prix_revient;
                String nom_meuble = allDataMeuble.get(i).getNomMeuble();

                if (benefice >= min && benefice<=max) {
                    resultat_benefice.getBenefice().add(benefice);
                    resultat_benefice.getNom_meuble().add(nom_meuble);
                    resultat_benefice.getPrix_revient().add(prix_revient);
                    resultat_benefice.getPrix_vente().add(meuble.getPrixVente(prix_revient, pourcentage));
                }
            }
            request.setAttribute("dataBenefice", resultat_benefice);
            request.getRequestDispatcher("/question_benef/dataBenefice.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
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
