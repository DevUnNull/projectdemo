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
import pe.models.CurrencyDTO;
import pe.models.UserDTO;
import pe.utils.DBUtils;

/**
 *
 * @author Thep
 */
public class DAO {
     public UserDTO login(String username, String password) throws SQLException {
        UserDTO user = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM tblUser WHERE username = ? AND password = ?");
                ptm.setString(1, username);
                ptm.setString(2, password);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    user = new UserDTO(username, name, password);
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
         public List<CurrencyDTO> getListCurrency(String search1, String search2) throws SQLException {
        List<CurrencyDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM tblCurrency WHERE code LIKE ? AND name LIKE ?");
                ptm.setString(1, "%" + search1 + "%");
                ptm.setString(2, "%" + search2 + "%");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("code");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float rate = Float.parseFloat(rs.getString("rate"));

                        list.add(new CurrencyDTO(id, name, description, rate));
                                 
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

         public boolean Update(String name, String description, Float rate, String code)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement stm = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblCurrency SET name = ?, description  = ?, rate = ? WHERE code = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, name);
                stm.setString(2, description);
                stm.setFloat(3, rate);
                stm.setString(4, code);
                stm.executeUpdate();
                return true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public CurrencyDTO getObject(String code) throws ClassNotFoundException, SQLException {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    try {
        con = DBUtils.getConnection();
        if (con != null) {
            String sql = "SELECT * FROM tblCurrency WHERE code = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, code);

            rs = stm.executeQuery();

            if (rs.next()) { 
                String name = rs.getString("name");
                String des = rs.getString("description");
                float rate = rs.getFloat("rate");
                return new CurrencyDTO(code, name, des, rate);
            } 
        }
    } finally {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }
    return null; 
}

}