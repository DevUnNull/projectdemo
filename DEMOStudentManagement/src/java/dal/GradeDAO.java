package dal;

import models.Grades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {
    public List<Grades> getAllGrades() {
        List<Grades> gradeList = new ArrayList<>();
        String query = "SELECT * FROM Grades";
        
        try {
            DBContext dbContext = new DBContext(); // Tạo instance của DBContext
            Connection conn = dbContext.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Grades grade = new Grades();
                grade.setId(rs.getInt("id"));
                grade.setStudentId(rs.getInt("studentId"));
                grade.setScore(rs.getDouble("score"));
                gradeList.add(grade);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gradeList;
    }

    public void deleteGrade(int gradeID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}