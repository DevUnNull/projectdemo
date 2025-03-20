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

@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy dữ liệu từ StudentDAO
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getAllStudents(); // Giả sử StudentDAO có phương thức này

        // Đặt danh sách sinh viên vào request
        request.setAttribute("studentList", studentList);
        request.setAttribute("contentPage", "studentList.jsp");

        // Chuyển tiếp về AdminSidebar.jsp
        request.getRequestDispatcher("AdminSidebar.jsp").forward(request, response);
    }
}