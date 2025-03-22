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
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.spring23.utils.DBUtils;

/**
 *
 * @author hd
 */
public class DAO {
    private Connection con;
    
    public DAO() throws ClassNotFoundException, SQLException {
        con = DBUtils.getConnection();
    }
    
//    your code here
    public List<ProductDTO> getAll() {
        List<ProductDTO> prods = new ArrayList();
        String sql = "select productId, productName, description, price, status from tblProducts where status = 1";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ProductDTO p = new ProductDTO();
                p.setProductId(rs.getString("productId"));
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setStatus(rs.getBoolean("status"));
                
                prods.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return prods;
    }
    
    public ProductDTO getById(String id) {
        ProductDTO p = null;
        String sql = "select productId, productName, description, price, status from tblProducts where status = 1 and productId = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, id);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                p = new ProductDTO();
                p.setProductId(rs.getString("productId").trim());
                p.setProductName(rs.getString("productName"));
                p.setDescription(rs.getString("description"));
                p.setPrice(rs.getDouble("price"));
                p.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return p;
    }
}
