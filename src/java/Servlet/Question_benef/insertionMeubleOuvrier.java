/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_benef;

import java.io.IOException;
import java.util.Vector;

import DAO.EmployeDAO;
import DAO.MeubleDAO;
import DAO.TailleDAO;
import Models.Employe;
import Models.Meuble;
import Models.Taille_nombre;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "insertionMeubleOuvrier", urlPatterns = {"/insertionMeubleOuvrier"})
public class insertionMeubleOuvrier extends HttpServlet {

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
        int idM = 0;
       
        MeubleDAO meubleDAO = new MeubleDAO();
        TailleDAO tailleDAO = new TailleDAO();
        EmployeDAO employeDAO = new EmployeDAO();
        try {
            idM = Integer.valueOf(request.getParameter("meuble"));
            Meuble meuble = meubleDAO.selectById(idM, null);
            Taille_nombre taille_nombre = tailleDAO.selectTailleNombreByMeuble(meuble.getId_taille(), null);
            Vector<Employe> allEmployes = employeDAO.selectAll(null);

            request.setAttribute("allEmployes", allEmployes);
            request.setAttribute("idMeuble", idM);
            request.setAttribute("coeff", taille_nombre.getCoeff());
            request.getRequestDispatcher("/question_benef/affichageMeubleOuvrierSuite.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("error insert meuble ouvrier par 1 : "+e.getLocalizedMessage());
            request.getRequestDispatcher("/getAffichageMeubleOuvrier").forward(request, response);
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
