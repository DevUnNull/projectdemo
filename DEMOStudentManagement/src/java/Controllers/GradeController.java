package controllers;

import dal.GradeDAO;
import models.Grades;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "GradeController", urlPatterns = {"/GradeController"})
public class GradeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || (role != 1 && role != 2)) {
            response.sendRedirect("login.jsp");
            return;
        }

        GradeDAO gradeDAO = new GradeDAO();
        List<Grades> gradeList = gradeDAO.getAllGrades();
        request.setAttribute("gradeList", gradeList);
        request.setAttribute("contentPage", "gradeList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}