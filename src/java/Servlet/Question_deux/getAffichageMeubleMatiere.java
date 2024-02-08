/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_deux;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import DAO.MatiereDAO;
import DAO.MeubleDAO;
import Models.Matiere;
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
@WebServlet(name = "getAffichageMeubleMatiere", urlPatterns = {"/getAffichageMeubleMatiere"})
public class getAffichageMeubleMatiere extends HttpServlet {

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
        try {
            PrintWriter out = response.getWriter();
            MeubleDAO meubleDAO = new MeubleDAO();
            MatiereDAO matiereDAO = new MatiereDAO();

            
            

            Vector<Matiere> allMatieres = matiereDAO.selectAll(null);
            Vector<V_meuble> allMeubles = meubleDAO.selectAllVMeuble(null);
            
            request.setAttribute("allMatiere", allMatieres);
            request.setAttribute("allMeubles", allMeubles);
            
            request.getRequestDispatcher("/question_deux/getAffichageMeubleMatiere.jsp").forward(request, response);
            

        } catch (Exception e) {
           System.out.println(e.getMessage());
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
