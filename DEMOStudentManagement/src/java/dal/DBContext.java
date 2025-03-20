package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FPT University - PRJ30X
 */
public class DBContext {
    protected Connection connection;

    public DBContext() {
        //@Students: You are allowed to edit user, pass, url variables to fit 
        //your system configuration
        //You can also add more methods for Database Interaction tasks. 
        //But we recommend you to do it in another class
        // For example : StudentDBContext extends DBContext, 
        //where StudentDBContext is located in dal package, 
        try {
            String user = "sa";
            String pass = "123";
            String url = "jdbc:sqlserver://DESKTOP-U5Q9M71\\SQLEXPRESS:1433;databaseName=Project_PRJ301";
       
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Thêm phương thức getConnection để trả về connection
    public Connection getConnection() {
        return connection;
    }

    // Thêm phương thức closeConnection để đóng kết nối
    public void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }

    public static void main(String[] args) {
        DBContext a = new DBContext();
        System.out.println(a.connection);
    }
}