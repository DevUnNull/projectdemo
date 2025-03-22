import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DESKTOP-U5Q9M71:1433;databaseName=Project_PRJ301;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "your_password";

        try {
            // Load Driver (có thể không cần nhưng nên thêm để chắc chắn)
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            // Thử kết nối
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Kết nối thành công!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Không tìm thấy JDBC Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Lỗi kết nối: " + e.getMessage());
        }
    }
}
