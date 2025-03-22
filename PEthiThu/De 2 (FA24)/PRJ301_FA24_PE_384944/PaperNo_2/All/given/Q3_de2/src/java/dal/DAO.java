/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.Types;
import java.sql.*;
import model.Executions;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public Vector<Types> getTypes(String sql) {
        Vector<Types> vector = new Vector<>();

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int typeID = rs.getInt(1);
                String typeName = rs.getString(2);
                vector.add(new Types(typeID, typeName));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public Vector<Executions> getExecutions(String sql) {
        Vector<Executions> vector = new Vector<>();

        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int executionID = rs.getInt(1);
                String inputString = rs.getString(2);
                int result = rs.getInt(3);
                int typeID = rs.getInt(4);
                Types type = getTypes("select * from Types where TypeID = " + typeID).get(0);

                vector.add(new Executions(executionID, inputString, result, type));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }
}
