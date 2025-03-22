/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.models.CapstonesDTO;
import pe.models.UserDTO;
import pe.utils.DBUtils;

/**
 *
 * @author Thep
 */
public class DAO {
      private static final String CHECK_USERID_EXIST = "SELECT userID FROM tblUsers WHERE userID=?";
    private static final String UPDATE_CAPSTONE = "UPDATE tblCapstones SET name=?, description=?, userID=? WHERE id=?";

  
    public boolean updateCapstone(CapstonesDTO capstone) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean updateSuccess = false; // Initialize with false

        try {
            conn = DBUtils.getConnection();

            ps = conn.prepareStatement(CHECK_USERID_EXIST);
            ps.setString(1, capstone.getUserID());
            rs = ps.executeQuery();

            if (rs.next()) {
                ps = conn.prepareStatement(UPDATE_CAPSTONE);
                ps.setString(1, capstone.getName());
                ps.setString(2, capstone.getDescription());
                ps.setString(3, capstone.getUserID());
                ps.setString(4, capstone.getId());

                int rowsAffected = ps.executeUpdate();
                updateSuccess = rowsAffected > 0;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return updateSuccess;
    }

      public List<CapstonesDTO> getListProduct(String search) throws SQLException {
        List<CapstonesDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM tblCapstones WHERE name LIKE ?");
                ptm.setString(1, "%" + search + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String userID = rs.getString("userID");
                    
                        list.add(new CapstonesDTO(id, name, description,userID));
     
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    public UserDTO login(String username, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM tblUsers WHERE userID = ? AND password = ?");
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("fullname");
                    String roleID = rs.getString("roleID");
                    Boolean status = rs.getBoolean("status");
                    user = new UserDTO(username, name, password, roleID, status);
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return user;
}
}
