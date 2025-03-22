/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.controllers;

import item.ItemDAO;
import item.ItemDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

    private static final String ERROR = "itemsList.jsp";
    private static final String SUCCESS = "itemsList.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String fromValueText = request.getParameter("fromValue");
            String tovalueText = request.getParameter("toValue");
            ItemDAO dao = new ItemDAO();
            List<ItemDTO> list_item = new ArrayList<>();
            if ((fromValueText == null && tovalueText == null) || (fromValueText.isEmpty() && tovalueText.isEmpty())) { //both empty
                list_item = dao.getAll();
            } else {
                if (tovalueText.isEmpty()) { //only tovalue empty
                    float fromValue = Float.parseFloat(fromValueText);
                    list_item = dao.searchFromValue(fromValue);
                } else {
                    if (fromValueText.isEmpty()) {  //only fromValue empty
                        float toValue = Float.parseFloat(tovalueText);
                        list_item = dao.searchToValue(toValue);
                    } else { // both of them not empty
                        float fromValue = Float.parseFloat(fromValueText);
                        float toValue = Float.parseFloat(tovalueText);
                        list_item = dao.searchBoth(fromValue, toValue);
                    }
                }
            }
            HttpSession session = request.getSession();
            if (!list_item.isEmpty()) {
                session.setAttribute("LIST_ITEM", list_item);
                url = SUCCESS;
            } else {
                session.setAttribute("LIST_ITEM", null);
            }
        } catch (Exception e) {
            log("Error at SearchController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
