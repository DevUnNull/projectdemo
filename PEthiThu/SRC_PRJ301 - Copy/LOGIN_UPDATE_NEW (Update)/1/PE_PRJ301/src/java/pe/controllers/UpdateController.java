/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.DAO.DAO;
import pe.models.CapstonesDTO;

/**
 *
 * @author Thep
 */
public class UpdateController extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "SearchController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String id = request.getParameter("ID");
            String name = request.getParameter("name");
            String description = request.getParameter("description");
            String userID = request.getParameter("userID");

            CapstonesDTO capstone = new CapstonesDTO(id, name, description, userID);
            DAO dao = new DAO();
            boolean checkUpdate = dao.updateCapstone(capstone);

            if (checkUpdate) {
                request.setAttribute("MESS", "ok");
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR_MESSAGE", "Update failed, userID does not exist or other issue.");
            }
        } catch (Exception e) {
            log("Error at UpdateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
