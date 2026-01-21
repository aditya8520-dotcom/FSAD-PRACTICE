
package com.klu.model;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class CourseRegistration {
    private int rollNo;
    private String studentName;
    private int semester;
  private String courseName;
    public CourseRegistration(@Value("101")int rollNo,@Value("Aditya")String studentName) {
    this.rollNo=rollNo;
    this.studentName=studentName;
    }
    @Value("FSAD")
    public void setCourseName(String courseName) {
      this.courseName=courseName;
    }
    @Value("4")
    public void  setSemester(int semester) {
      this.semester=semester;
    }
    public void display() {
      System.out.println("RollNo: " + rollNo);
      System.out.println("Name: " + studentName);
      System.out.println("Course: " + courseName);
      System.out.println("Semester: " + semester);
    }
}