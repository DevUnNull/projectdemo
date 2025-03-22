/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.spring23.shopping.CART;
import pe.spring23.shopping.DAO;
import pe.spring23.shopping.Product;
import pe.spring23.shopping.ProductDTO;

/**
 *
 * @author hd
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";

    private static final String SHOPPING_PAGE = "shopping.jsp";
    private static final String CART_PAGE = "viewCart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            if (action == null) {
                action = "home";
                url = SHOPPING_PAGE;
            }

//            your code here
            HttpSession session = request.getSession();
            if (session == null || session.getAttribute("cart") == null) {
                session.setAttribute("cart", new CART(new HashMap<String, Product>()));
            }

            CART currentCart = (CART) session.getAttribute("cart");
            switch (action) {
                case "home":
                    break;
                case "get_products":
                    url = handleGetProducts(request, response);
                    break;
                case "get_cart":
                    url = handleGetCart(request, response, currentCart);
                    break;
                case "add_cart":
                    url = handleAddCart(request, response, currentCart, session);
                    break;
                case "remove_cart":
                    url = handleRemoveCart(request, response, currentCart, session);
                    break;
                default:
                    url = ERROR;
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.toString());
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

    private String handleRemoveCart(HttpServletRequest request, HttpServletResponse response, CART cart, HttpSession session) {
        String id = request.getParameter("id");

        cart.getCart().remove(id);

        List<Product> cartList = new ArrayList();
        for (String key : cart.getCart().keySet()) {
            cartList.add(cart.getCart().get(key));
        }
        session.setAttribute("cart", cart);
        request.setAttribute("cart", cartList);

        return CART_PAGE;
    }

    private String handleAddCart(HttpServletRequest request, HttpServletResponse response, CART cart, HttpSession session) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        DAO dao = new DAO();

        String id = request.getParameter("id");

        ProductDTO pDTO = dao.getById(id);
        if (pDTO == null) {
            return ERROR;
        }

        cart.add(pDTO.mapToProduct());
        session.setAttribute("cart", cart);

        return SHOPPING_PAGE;
    }

    private String handleGetCart(HttpServletRequest request, HttpServletResponse response, CART cart) {
        List<Product> cartList = new ArrayList();
        for (String key : cart.getCart().keySet()) {
            cartList.add(cart.getCart().get(key));
        }

        request.setAttribute("cart", cartList);

        return CART_PAGE;
    }

    private String handleGetProducts(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException {
        DAO dao = new DAO();

        List<ProductDTO> prods = dao.getAll();

        request.setAttribute("products", prods);

        return SHOPPING_PAGE;
    }
}
