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

@WebServlet(name = "GradeServlet", urlPatterns = {"/GradeServlet"})
public class GradeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GradeDAO gradeDAO = new GradeDAO();
        List<Grades> gradeList = gradeDAO.getAllGrades();

        request.setAttribute("gradeList", gradeList);
        request.setAttribute("contentPage", "gradeList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}