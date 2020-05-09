/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Owner
 */
public class HandleStudents {

    private Connection connection;

    public HandleStudents() {
        connection = Database.getConnection();
    }

    //public HandleStudents(Student student) throws SQLException{
    public void RegisterStudent(Student student) throws SQLException {

        try {
            PreparedStatement ps = connection.prepareStatement("insert into student(email,fName,lName,address,gender,grade,password)" + "values(?,?,?,?,?,?,?);");
            ps.setString(1, student.getEmail());
            ps.setString(2, student.getfName());
            ps.setString(3, student.getlName());
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getGender());
            ps.setString(6, student.getGrade());
            ps.setString(7, student.getPassword());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}
