/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HandleStudents;
import Model.Student;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.apache.tomcat.jni.Buffer.address;

/**
 *
 * @author Owner
 */
public class studentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         String command = request.getParameter("command");
         System.out.println(command);
           switch (command) {
            case "ADD" : {
             try {
                 RegisterStudent(request, response);
             } catch (SQLException ex) {
                 Logger.getLogger(studentController.class.getName()).log(Level.SEVERE, null, ex);
             }
                break;
            }
        
    }
         }
    
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    
    private void RegisterStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        HandleStudents accessObject = new HandleStudents();

        String studentID = request.getParameter("studentID");  
        String email = request.getParameter("email");
        String fName = request.getParameter("fName");
        String lName  = request.getParameter("lName"); //Getting the parameters needed
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String grade = request.getParameter("grade");
        String password = request.getParameter("password");
        

        Student student = new Student(studentID,email,fName,lName,address,gender,grade,password) ;
    // Constructor creation
        accessObject.RegisterStudent(student); //Created object with the constructors
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");  //Directing to the JSP
        dispatcher.forward(request, response);
    }

}
