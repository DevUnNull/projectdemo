package dal;

import models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<>();
        String query = "SELECT * FROM Account";
        
        try {
            DBContext dbContext = new DBContext(); // Tạo instance của DBContext
            Connection conn = dbContext.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Account account = new Account();
                account.setId(rs.getInt("id"));
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setRole(rs.getInt("role"));
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public void addAccount(Account account) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}