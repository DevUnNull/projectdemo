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

@WebServlet(name = "TeacherController", urlPatterns = {"/TeacherController"})
public class TeacherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || (role != 1 && role != 2)) {
            response.sendRedirect("login.jsp");
            return;
        }

        TeacherDAO teacherDAO = new TeacherDAO();
        List<Teacher> teacherList = teacherDAO.getAllTeachers();
        request.setAttribute("teacherList", teacherList);
        request.setAttribute("contentPage", "viewTeacher.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}