/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Vector;
import model.Instructor;
import java.sql.*;
import model.Subject;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    public void insertInstructor(Instructor ins) {
        String sql = "INSERT INTO [dbo].[Instructors]\n"
                + "           ([InstructorID]\n"
                + "           ,[InstructorName]\n"
                + "           ,[BirthDate]\n"
                + "           ,[Gender]\n"
                + "           ,[SubjectID])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, ins.getInstructorID());
            ps.setString(2, ins.getInstructorName());
            ps.setDate(3, (Date) ins.getBirthDate());
            ps.setBoolean(4, ins.isGender());
            ps.setInt(5, ins.getSubject().getSubjectID());
            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public Vector<Subject> getSubjects() {
        Vector<Subject> vector = new Vector<>();
        String sql = "select * from Subjects";
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                int subjectID = rs.getInt(1);
                String subjectName = rs.getString(2);
                vector.add(new Subject(subjectID, subjectName));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

    public Subject getSubjectById(int id) {

        String sql = "select * from Subjects where SubjectID = " + id;
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                int subjectID = rs.getInt(1);
                String subjectName = rs.getString(2);
                return new Subject(subjectID, subjectName);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public Vector<Instructor> getInstructor() {
        Vector<Instructor> vector = new Vector<>();

        String sql = "select * from Instructors";
        try {
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String instructorID = rs.getString(1);
                String instructorName = rs.getString(2);
                Date birthDate = rs.getDate(3);
                boolean gender = rs.getBoolean(4);
                Subject subject = getSubjectById(rs.getInt(5));

                vector.add(new Instructor(instructorID, instructorName, birthDate, gender, subject));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return vector;
    }

}
