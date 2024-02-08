/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Question_benef;

import java.io.IOException;
import java.util.Vector;

import DAO.Meuble_ouvriersDAO;
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
@WebServlet(name = "insertionMeubleOuvrierSuite", urlPatterns = {"/insertionMeubleOuvrierSuite"})
public class insertionMeubleOuvrierSuite extends HttpServlet {

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
        double coeff = 0;
        Meuble_ouvriersDAO meuble_ouvriersDAO = new Meuble_ouvriersDAO();
        Vector<Integer> tabIdEmp = new Vector<Integer>();
        try {
            coeff = Double.valueOf(request.getParameter("coefficient"));
            idM = Integer.valueOf(request.getParameter("idMeuble"));
            for (int i = 0; i < coeff; i++) {
                int idE = Integer.valueOf(request.getParameter("employe"+i));
                tabIdEmp.add(idE);
            }
                if (Utils.hasDuplicates(tabIdEmp)) {
                    String erreur = "Vous avez choisis le même employé pour ce meuble";
                    request.setAttribute("erreur", erreur);
                    System.out.println("error insert meuble ouvrier  1: Vous avez choisis le même employé pour ce meuble");
                    request.getRequestDispatcher("/getAffichageMeubleOuvrier").forward(request, response);
                }else{
                    for (int i = 0; i < tabIdEmp.size(); i++) {
                        meuble_ouvriersDAO.insert(tabIdEmp.get(i), idM, null);
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
           
        } catch (Exception e) {
            System.out.println("error insert meuble ouvrier 2 : "+e.getLocalizedMessage());
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
