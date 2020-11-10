package com.mycompany.individual_project;

import java.time.LocalDate;

public class Student {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    
    
    Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees){
        this.firstName=firstName;
        this.lastName=lastName;
        this.dateOfBirth=dateOfBirth;
        this.tuitionFees=tuitionFees;
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

    public int getTuituinFees() {
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

    public void setTuituinFees(int tuituinFees) {
        this.tuitionFees = tuituinFees;
    }
    
    
    
    
}
