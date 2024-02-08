/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_quatre;

import java.io.IOException;
import java.sql.Timestamp;

import DAO.EmployeDAO;
import DAO.Employe_embaucheDAO;
import DAO.ProfilDAO;
import Models.Employe;
import Utils.Utils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "Embauche", urlPatterns = {"/Embauche"})
public class Embauche extends HttpServlet {

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

        String nom = request.getParameter("nom");
        int idPoste = Integer.valueOf(request.getParameter("poste"));
        Timestamp date_embauche = Utils.convertDate(request.getParameter("date_embauche"));
        double exp = Double.valueOf(request.getParameter("experience"));
        EmployeDAO employeDAO = new EmployeDAO();
        Employe_embaucheDAO employe_embaucheDAO = new Employe_embaucheDAO();
        ProfilDAO profilDAO = new ProfilDAO();
        try {
            employeDAO.insert(nom, exp, null);
            Employe lastEmploye = employeDAO.selectLastEmploye(null);
            int idProfil = profilDAO.getProfilExp(exp, null);
           
            if (idProfil != 0 || Math.signum(exp)>0 || Math.signum(exp) == 0 ) {
                employe_embaucheDAO.insert(idProfil, lastEmploye.getId(), date_embauche, idPoste, null); 
            }
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
