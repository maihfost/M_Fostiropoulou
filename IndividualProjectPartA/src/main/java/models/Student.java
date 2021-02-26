package models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Student{
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private ArrayList<Course> studentCourses=new ArrayList<Course>();
    private ArrayList<Assignment> studentAssignments=new ArrayList<Assignment>();
    
    Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.tuitionFees=tuitionFees;
    }
    
    Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees,
            ArrayList<Course> studentCourses){
        this(firstName,lastName,dateOfBirth,tuitionFees);
        this.studentCourses=studentCourses;
    }
    
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setTuitionFees(int tuituinFees) {
        this.tuitionFees = tuituinFees;
    }

    public ArrayList<Assignment> getStudentAssignments() {
        for (Course course:this.studentCourses){
            int size=course.getAssignmentsPerCourse().size();
            for (int i=0;i<size;i++){
                studentAssignments.add(course.getAssignmentsPerCourse().get(i));
            }
        }        
        return studentAssignments;
    }

    public void setStudentAssignments(ArrayList<Assignment> studentAssignments) {
        this.studentAssignments = studentAssignments;
    }

    public void setStudentCourses(ArrayList<Course> studentCourses) {
        this.studentCourses = studentCourses;
    }

    public ArrayList<Course> getStudentCourses() {
        return studentCourses;
    }
    
    
    
    public int countStudentCourses(ArrayList<Course> courses){
        int counter=0;
        for (Course course:courses){
            for (Student st:course.getStudentsPerCourse()){
                if (this.lastName.equals(st.lastName) && this.firstName.equals(st.firstName)){
                    this.studentCourses.add(course);
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

    public ArrayList<Assignment> studentAssignmentsMethod(ArrayList<Course> courses){
        for (Course course:courses){
            int size=course.getAssignmentsPerCourse().size();
            for (Student st:course.getStudentsPerCourse()){
                if (this.lastName.equals(st.lastName) && this.firstName.equals(st.firstName)){
                    this.studentCourses.add(course);
                    for (int i=0;i<size;i++){
                        this.studentAssignments.add(course.getAssignmentsPerCourse().get(i));
                    }
                    break;
                }
            }
        }
        return studentAssignments;
    }
        

    @Override
    public String toString() {
        return "First Name: " + firstName + " | Last Name: " + lastName 
                                          + " | Date of Birth: " + dateOfBirth
                                          + " | Tuition Fees=" + tuitionFees+ "\n";
    }
    
    
    
    
}
