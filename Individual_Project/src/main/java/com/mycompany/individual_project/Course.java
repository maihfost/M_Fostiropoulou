package com.mycompany.individual_project;

import java.time.LocalDate;

public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private Student [] studentsPerCourse;
    private Trainer [] trainersPerCourse;
    private Assignment [] assignmentsPerCourse;
    
    
    Course(String title,String stream,String type,LocalDate startingDate,LocalDate endingDate){
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
    }
    
    Course(String title,String stream,String type,LocalDate startingDate,
            LocalDate endingDate,Student [] studentsPerCourse,Trainer [] trainersPerCourse,Assignment [] assignmentsPerCourse){
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
        this.studentsPerCourse=studentsPerCourse;
        this.trainersPerCourse=trainersPerCourse;
        this.assignmentsPerCourse=assignmentsPerCourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public String getStream() {
        return stream;
    }

    public String getType() {
        return type;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public Student[] getStudentsPerCourse() {
        return studentsPerCourse;
    }

    public Trainer[] getTrainersPerCourse() {
        return trainersPerCourse;
    }

    public Assignment[] getAssignmentsPerCourse() {
        return assignmentsPerCourse;
    }

    public void setStudentsPerCourse(Student[] studentsPerCourse) {
        this.studentsPerCourse = studentsPerCourse;
    }

    public void setTrainersPerCourse(Trainer[] trainersPerCourse) {
        this.trainersPerCourse = trainersPerCourse;
    }

    public void setAssignmentsPerCourse(Assignment[] assignmentsPerCourse) {
        this.assignmentsPerCourse = assignmentsPerCourse;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", startingDate=" + startingDate + ", endingDate=" + endingDate + '}';
    }
    
    
    
            

}
