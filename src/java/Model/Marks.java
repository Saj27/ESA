/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Owner
 */
public class Marks {

 

    private String studentID,subject;
    private int marks;
    
    
    public Marks(String studentID, String subject, int marks) {
        this.studentID = studentID;
        this.subject = subject;
        this.marks = marks;
    }
    
       public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
    
}
