package dal;

import models.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    public List<Teacher> getAllTeachers() {
        List<Teacher> teacherList = new ArrayList<>();
        String query = "SELECT * FROM Teacher";
        
        try {
            DBContext dbContext = new DBContext(); // Tạo instance của DBContext
            Connection conn = dbContext.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Teacher teacher = new Teacher(); 
                teacher.setId(rs.getInt("id"));
                teacher.setName(rs.getString("name"));
                teacher.setDob(rs.getString("dob"));
                teacherList.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacherList;
    }

    public void addTeacher(Teacher teacher) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteTeacher(int teacherID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}