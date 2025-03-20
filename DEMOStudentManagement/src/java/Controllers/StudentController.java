package controllers;

import dal.StudentDAO;
import models.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || (role != 1 && role != 2)) {
            response.sendRedirect("login.jsp");
            return;
        }

        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getAllStudents();
        request.setAttribute("studentList", studentList);
        request.setAttribute("contentPage", "studentList.jsp");
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}