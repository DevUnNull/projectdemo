/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.spring23.utils.DBUtils;

/**
 *
 * @author hd
 */
public class DAO extends DBUtils {
//    your code here

    public List<Product> getAll() throws Exception {
        List<Product> list = new ArrayList();
        String sql = "select * from tblProducts ";
        PreparedStatement st = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                st = conn.prepareStatement(sql);
                rs = st.executeQuery();
                while(rs.next()){
                    String productID =rs.getString("productID");
                    String productName =rs.getString("productName");
                    String description =rs.getString("description");
                    float price =rs.getFloat("price");
                    int status =rs.getInt("status");
                    list.add(new Product(productID, productName, description, price, status));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
     public Product getListProductByID(String ID) throws SQLException {
        Connection conn = null;
        String sql = "select * from tblProducts where productID=?";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                st = conn.prepareStatement(sql);
                st.setString(1, ID);
                rs = st.executeQuery();
                if (rs.next()) {
                    String productID =rs.getString("productID");
                    String productName =rs.getString("productName");
                    String description =rs.getString("description");
                    float price =rs.getFloat("price");
                    int status =rs.getInt("status");
                    return new Product(productID, productName, description, price, status);
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }
}
