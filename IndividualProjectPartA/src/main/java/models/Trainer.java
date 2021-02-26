package models;

import java.util.ArrayList;

public class Trainer {
    private String firstName;
    private String lastName;
    private  String subject;
    private ArrayList<Course> trainerCourses;
    
    public Trainer(String firstName, String lastName ,String subject){
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;
    }
    
    public Trainer(String firstName, String lastName ,String subject,ArrayList<Course> trainerCourses){
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;
        this.trainerCourses=trainerCourses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ArrayList<Course> getTrainerCourses() {
        return trainerCourses;
    }

    public void setTrainerCourses(ArrayList<Course> trainerCourses) {
        this.trainerCourses = trainerCourses;
    }
    
    @Override
    public String toString() {
        return "First Name: " + firstName + " | Last Name: " + lastName
                                          + " | Subject: " + subject + "\n";
    }
    
    

}

