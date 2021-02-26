package models;

import java.time.LocalDate;


public class Student {
    private int id;
    private String first_name;
    private String last_name;
    private LocalDate dob;

    public Student() {
    }
    
    public Student(String first_name, String last_name, LocalDate dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
    }

    public Student(int id, String first_name, String last_name, LocalDate dob) {
        this();
        this.id = id;
    }
    
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{first_name=").append(first_name);
        sb.append(", last_name=").append(last_name);
        sb.append(", dob=").append(dob);
        sb.append('}');
        return sb.toString();
    }

}
