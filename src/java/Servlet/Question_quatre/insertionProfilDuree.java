/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_quatre;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.ProfilDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "insertionProfilDuree", urlPatterns = {"/insertionProfilDuree"})
public class insertionProfilDuree extends HttpServlet {

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
        int idP = 0;
        double experience = 0.0;
        double coeff = 0.0;
        ProfilDAO profilDAO = new ProfilDAO();
        try {
            idP = Integer.valueOf(request.getParameter("profil"));
            experience = Double.valueOf(request.getParameter("experience"));
            coeff = Double.valueOf(request.getParameter("coeff"));
            if (experience >= 0 && coeff > 0) {
                profilDAO.insert(idP, experience, coeff, null);
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }else{
                String erreur = "Veuillez remplir correctement les champs";
                request.setAttribute("erreur", erreur);
                request.getRequestDispatcher("/getAffichageProfilDuree").forward(request, response);
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
