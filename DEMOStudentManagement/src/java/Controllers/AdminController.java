package controllers;

import dal.StudentDAO;
import dal.TeacherDAO;
import dal.GradeDAO;
import dal.AccountDAO;
import models.Student;
import models.Teacher;
import models.Grades;
import models.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminController", urlPatterns = {"/AdminController"})
public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer role = (Integer) request.getSession().getAttribute("role");
        if (role == null || role != 1) {
            response.sendRedirect("login.jsp");
            return;
        }
        request.getRequestDispatcher("viewAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("addStudent".equals(action)) {
            Student student = new Student();
            student.setId(Integer.parseInt(request.getParameter("studentID")));
            student.setName(request.getParameter("studentName"));
            student.setPhone(Long.parseLong(request.getParameter("phone")));
            student.setEmail(request.getParameter("email"));
            student.setClassId(Integer.parseInt(request.getParameter("classID")));
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.addStudent(student);
        } else if ("deleteStudent".equals(action)) {
            int studentID = Integer.parseInt(request.getParameter("studentID"));
            StudentDAO studentDAO = new StudentDAO();
            studentDAO.deleteStudent(studentID);
        } else if ("addTeacher".equals(action)) {
            Teacher teacher = new Teacher();
            teacher.setId(Integer.parseInt(request.getParameter("teacherID")));
            teacher.setName(request.getParameter("teacherName"));
            teacher.setPhone(Long.parseLong(request.getParameter("phone")));
            teacher.setEmail(request.getParameter("email"));
            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.addTeacher(teacher);
        } else if ("deleteTeacher".equals(action)) {
            int teacherID = Integer.parseInt(request.getParameter("teacherID"));
            TeacherDAO teacherDAO = new TeacherDAO();
            teacherDAO.deleteTeacher(teacherID);
        } else if ("deleteGrade".equals(action)) {
            int gradeID = Integer.parseInt(request.getParameter("gradeID"));
            GradeDAO gradeDAO = new GradeDAO();
            gradeDAO.deleteGrade(gradeID);
        } else if ("addAccount".equals(action)) {
            Account account = new Account();
            account.setId(Integer.parseInt(request.getParameter("id")));
            account.setUsername(request.getParameter("username"));
            account.setPassword(request.getParameter("password"));
            account.setRole(Integer.parseInt(request.getParameter("role")));
            AccountDAO accountDAO = new AccountDAO();
            accountDAO.addAccount(account);
        }

        doGet(request, response); // Gọi lại doGet để hiển thị danh sách sau khi xử lý
    }
}