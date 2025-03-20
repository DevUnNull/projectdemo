package controllers;

import dal.ClassDAO;
import models.Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ClassController", urlPatterns = {"/ClassController"})
public class ClassController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || (role != 1 && role != 2)) {
            response.sendRedirect("login.jsp");
            return;
        }

        ClassDAO classDAO = new ClassDAO();
        List<Class> classList = classDAO.getAllClasses();
        request.setAttribute("classList", classList);
        request.setAttribute("contentPage", "classList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}