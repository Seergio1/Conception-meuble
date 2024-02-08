/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_quatre;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import DAO.EmployeDAO;
import DAO.Employe_embaucheDAO;
import DAO.ProfilDAO;
import Models.Employe;
import Models.Employe_embauche;
import Models.V_info_employe_actuel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "dataAffichageExperience", urlPatterns = { "/dataAffichageExperience" })
public class dataAffichageExperience extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Employe_embauche employe_embauche = new Employe_embauche();
        EmployeDAO employeDAO = new EmployeDAO();
        ProfilDAO profilDAO = new ProfilDAO();
        Employe_embaucheDAO employe_embaucheDAO = new Employe_embaucheDAO();
        Vector<Employe> allEmployes = employeDAO.selectAll(null);
        Vector<V_info_employe_actuel> dataEmployeActuel = new Vector<V_info_employe_actuel>();
        try {
            employe_embauche.checkPromo();
            for(Employe emp : allEmployes){
                V_info_employe_actuel empActu = employe_embaucheDAO.selectEmployeLastPromotionById(emp.getId(), null);
                dataEmployeActuel.add(empActu);
            }
            request.setAttribute("allDataEmpActu", dataEmployeActuel);
            request.getRequestDispatcher("/question_quatre/getEtatEmployeActuel.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
