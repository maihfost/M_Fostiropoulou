package models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private ArrayList<Student> studentsPerCourse=new ArrayList<Student>();
    private ArrayList<Trainer> trainersPerCourse;
    private ArrayList<Assignment> assignmentsPerCourse;
    
    
    Course(String title,String stream,String type,LocalDate startingDate,LocalDate endingDate){
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
    }
     
    Course(String title,String stream,String type,LocalDate startingDate,
        LocalDate endingDate, ArrayList<Trainer> trainersPerCourse){
        this(title,stream,type,startingDate,endingDate);
        this.trainersPerCourse=trainersPerCourse;
    }
    
    Course(String title,String stream,String type,LocalDate startingDate,
        LocalDate endingDate, ArrayList<Trainer> trainersPerCourse,
        ArrayList<Assignment> assignmentsPerCourse){
        this(title,stream,type,startingDate,endingDate,trainersPerCourse);
        this.assignmentsPerCourse=assignmentsPerCourse;
    }
    
    Course(String title,String stream,String type,LocalDate startingDate,
           LocalDate endingDate,
           ArrayList<Trainer> trainersPerCourse,ArrayList<Assignment> assignmentsPerCourse,
           ArrayList<Student> studentsPerCourse){
        this(title,stream,type,startingDate,endingDate,trainersPerCourse,assignmentsPerCourse);
        this.studentsPerCourse=studentsPerCourse;
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

    public List<Student> getStudentsPerCourse() {
        return studentsPerCourse;
    }

    public List<Trainer> getTrainersPerCourse() {
        return trainersPerCourse;
    }

    public List<Assignment> getAssignmentsPerCourse() {
        return assignmentsPerCourse;
    }

    public void setStudentsPerCourse(ArrayList<Student> studentsPerCourse) {
        this.studentsPerCourse = studentsPerCourse;
    }

    public void setTrainersPerCourse(ArrayList<Trainer> trainersPerCourse) {
        this.trainersPerCourse = trainersPerCourse;
    }

    public void setAssignmentsPerCourse(ArrayList<Assignment> assignmentsPerCourse) {
        this.assignmentsPerCourse = assignmentsPerCourse;
    }
    
    

    @Override
    public String toString() {
        return  "Title: " + title + " | Stream:  " + stream 
                                  + " | Type: " + type 
                                  + " | Starts on : " + startingDate 
                                  + " | Ends on: " + endingDate +"\n";
    }

}
