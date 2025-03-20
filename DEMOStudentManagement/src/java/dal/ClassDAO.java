package dal;

import models.Class;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassDAO {
    public List<Class> getAllClasses() {
        List<Class> classList = new ArrayList<>();
        String query = "SELECT * FROM Class";
        
        try {
            DBContext dbContext = new DBContext(); // Tạo instance của DBContext
            Connection conn = dbContext.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Class clazz = new Class();
                clazz.setId(rs.getInt("id"));
                clazz.setName(rs.getString("name"));
                classList.add(clazz);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classList;
    }
}