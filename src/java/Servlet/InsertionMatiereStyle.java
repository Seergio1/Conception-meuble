/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import java.io.IOException;
import java.util.Vector;

import DAO.MatiereDAO;
import DAO.MatiereStyleDAO;
import DAO.StyleDAO;
import Models.Matiere;
import Models.Style;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author sergi
 */
@WebServlet(name = "InsertionMatiereStyle", urlPatterns = { "/insertionMatiereStyle" })
public class InsertionMatiereStyle extends HttpServlet {

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
        int id_style = Integer.valueOf(request.getParameter("style_meuble"));
        int id_matiere = Integer.valueOf(request.getParameter("matiere_meuble"));
        System.out.println(id_style);
        System.out.println(id_matiere);
        MatiereStyleDAO matiereStyleDAO = new MatiereStyleDAO();
        MatiereDAO matiereDAO = new MatiereDAO();
        StyleDAO styleDAO = new StyleDAO();
        

        try {

            matiereStyleDAO.insert(id_matiere, id_style, null);
            Vector<Style> allStyle = styleDAO.selectAll(null);
            Vector<Matiere> allMatiere = matiereDAO.selectAll(null);

            request.setAttribute("allStyle", allStyle);
            request.setAttribute("allMatiere", allMatiere);
            request.getRequestDispatcher("/insertionMatiereStyle.jsp").forward(request, response);

        } catch (Exception e) {
            // TODO: handle exception
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
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
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
        try {

        } catch (Exception e) {
            // TODO: handle exception
        }
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
