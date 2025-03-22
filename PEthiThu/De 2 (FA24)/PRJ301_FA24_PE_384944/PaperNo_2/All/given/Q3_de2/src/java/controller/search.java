/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;
import model.Executions;
import model.Types;

/**
 *
 * @author Admin
 */
public class search extends HttpServlet {

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

        DAO dao = new DAO();
        Vector<Types> listT = dao.getTypes("select * from Types");
        request.setAttribute("listT", listT);

        Vector<Executions> listE = dao.getExecutions("select * from Executions");
        request.setAttribute("listE", listE);

        request.getRequestDispatcher("show.jsp").forward(request, response);

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
        DAO dao = new DAO();
        String res = request.getParameter("res");
        String opt = request.getParameter("opt");
        String submit = request.getParameter("submit");

        if ("FILTER".equals(submit)) {

            if ("all".equals(opt)) {
                response.sendRedirect("search");
                return;
            }

            Vector<Executions> listE = dao.getExecutions("select * from Executions where TypeID = " + opt);
            request.setAttribute("listE", listE);
            Vector<Types> listT = dao.getTypes("select * from Types");
            request.setAttribute("listT", listT);
            
            request.getRequestDispatcher("show.jsp").forward(request, response);
            return;
        }

        if ("SEARCH".equals(submit)) {
            
            if (res.isEmpty()) {
                response.sendRedirect("search");
                return;
            }

            Vector<Executions> listE = dao.getExecutions("select * from Executions where Result = " + res);
            request.setAttribute("listE", listE);
            Vector<Types> listT = dao.getTypes("select * from Types");
            request.setAttribute("listT", listT);
            
            request.getRequestDispatcher("show.jsp").forward(request, response);
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
