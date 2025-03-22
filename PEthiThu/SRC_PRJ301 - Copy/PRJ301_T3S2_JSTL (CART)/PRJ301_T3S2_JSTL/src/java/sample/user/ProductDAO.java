/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;
import sample.shopping.Comestics;
import sample.utils.DBUtils;

/**
 *
 * @author Admin
 */
public class ProductDAO {
    private static final String VIEW = "SELECT productID, name, price, quantity FROM tblProducts";
    private static final String FINDONEPRODUCT = "SELECT productID, name, price, quantity FROM tblProducts WHERE name LIKE ? ";
        public List<Comestics> getListProduct() throws SQLException, ClassNotFoundException, NamingException{
        List<Comestics> listComestics = new ArrayList<Comestics>();
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        try {
           conn = DBUtils.getConnection();
           if(conn!= null){
               Statement stmt = conn.createStatement();
               rs= stmt.executeQuery(VIEW);
               while(rs.next()){
                  Comestics comestics = new Comestics();
                  comestics.setId(rs.getString("productID"));
                  comestics.setName(rs.getString("name"));
                  comestics.setPrice(rs.getDouble("price"));
                  comestics.setQuantity(rs.getInt("quantity"));
                  listComestics.add(comestics);
               }
           }
        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return listComestics;
    }
        public Comestics getProduct(String nameComes) throws SQLException, ClassNotFoundException, NamingException{
        Connection conn= null;
        PreparedStatement ptm= null;
        ResultSet rs= null;
        Comestics comestics = new Comestics();
        try {
           conn = DBUtils.getConnection();
           if(conn!= null){
               ptm = conn.prepareStatement(FINDONEPRODUCT);
               ptm.setString(1, "%"+ nameComes +"%");
               rs= ptm.executeQuery();
               while(rs.next()){
                   comestics.setId(rs.getString("productID"));
                   comestics.setName(rs.getString("name"));
                   comestics.setPrice(rs.getDouble("price"));
                   comestics.setQuantity(rs.getInt("quantity"));
               }
           }

        }finally{
            if(rs!= null) rs.close();
            if(ptm!= null) ptm.close();
            if(conn!= null) conn.close();
        }
        return comestics;
    }
}
