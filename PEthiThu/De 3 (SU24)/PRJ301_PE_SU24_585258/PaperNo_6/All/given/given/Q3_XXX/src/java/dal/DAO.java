/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.Executions;
import java.sql.*;
import model.ExecutionItems;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {
    
    public Vector<Executions> getExecutions(String sql) {
        Vector<Executions> vector = new Vector<>();
        
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                int executionID = rs.getInt(1);
                int result = rs.getInt(2);
                Vector<ExecutionItems> arr = getExecutionItems("select * from ExecutionItems where ExecutionID = " + executionID);
                
                vector.add(new Executions(executionID, result, arr));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return vector;
    }
    
    public Vector<ExecutionItems> getExecutionItems(String sql) {
        Vector<ExecutionItems> vector = new Vector<>();
        
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);
            
            while (rs.next()) {
                int executionItemID = rs.getInt(1);
                int arrayItem = rs.getInt(2);
                
                vector.add(new ExecutionItems(executionItemID, arrayItem));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return vector;
    }
    
    public int delete(int id) {
        int n = 0;
        String sql = "DELETE FROM [dbo].[Executions]\n" +
"      WHERE ExecutionID = " + id;
        
        String sql2 = "DELETE FROM [dbo].[ExecutionItems]\n" +
"      WHERE ExecutionID = " + id;
        try {
            Statement statement = connection.createStatement();
            
            statement.executeUpdate(sql2);
            n = statement.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }
    
}
