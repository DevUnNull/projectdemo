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
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.Vector;
import model.Instructor;
import model.Subject;

/**
 *
 * @author Admin
 */
public class add extends HttpServlet {

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
        HttpSession session = request.getSession();
        Vector<Instructor> list = dao.getInstructor();
        session.setAttribute("list", list);
        
        for (Instructor o : list) {
            
        }
        
        
        Vector<Subject> listS = dao.getSubjects();
        request.setAttribute("listS", listS);

        request.getRequestDispatcher("show.jsp").forward(request, response);
        
//        HttpSession session = request.getSession();
//        
//        request.setAttribute(LEGACY_DO_HEAD, dao);
//        
//        request.getAttribute(LEGACY_DO_HEAD);
//        
//        
//        session.getAttribute(LEGACY_DO_HEAD);
//        
//        session.setAttribute(LEGACY_DO_HEAD, dao);
        
        
        
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
        
        DAO dao =new DAO();
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        Date dob = Date.valueOf(request.getParameter("dob"));
        boolean gender = request.getParameter("gender").equals("1") ? true : false;
        int subjectID = Integer.parseInt(request.getParameter("subject"));

        
        dao.insertInstructor(new Instructor(code, name, dob, gender, new Subject(subjectID, name)));
        response.sendRedirect("add");
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
