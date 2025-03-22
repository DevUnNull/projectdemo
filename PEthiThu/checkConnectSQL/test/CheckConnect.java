import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnect {
    public static void main(String[] args) {
        String url = "jdbc:sqlserver://DESKTOP-U5Q9M71\\SQLEXPRESS:1433;databaseName=Project_PRJ301;encrypt=false";
        String user = "sa";
        String password = "123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("ket noi thanh cong den database!");
            }
        } catch (SQLException e) {
            System.out.println("ket noi that bai: " + e.getMessage());
        }
    }
}
