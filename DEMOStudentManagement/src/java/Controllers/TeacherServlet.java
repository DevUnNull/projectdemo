package controllers;

import dal.TeacherDAO;
import models.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TeacherServlet", urlPatterns = {"/TeacherServlet"})
public class TeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teacherList = teacherDAO.getAllTeachers();

        request.setAttribute("teacherList", teacherList);
        request.setAttribute("contentPage", "teacherList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}