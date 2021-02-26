package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Assignment {
    private String title;
    private String description;
    private LocalDateTime subDateTime;
    private int technicMark;
    private int totalMark;
    private ArrayList<Course> assignmentCourses;
    
    public Assignment(String title, String description, LocalDateTime subDateTime){
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
    }
    
    public Assignment(String title, String description, LocalDateTime subDateTime,ArrayList<Course> assignmentCourses){
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.assignmentCourses=assignmentCourses;
    }
    
    public Assignment(String title, String description, LocalDateTime subDateTime,
                      int technicMark, int totalMark){
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.technicMark = technicMark;
        this.totalMark = totalMark;
    }
    

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getSubDateTime() {
        return subDateTime;
    }

    public int getOralMark() {
        return technicMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(LocalDateTime subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setOralMark(int oralMark) {
        this.technicMark = oralMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public ArrayList<Course> getAssignmentCourses() {
        return assignmentCourses;
    }

    public void setAssignmentCourses(ArrayList<Course> assignmentCourses) {
        this.assignmentCourses = assignmentCourses;
    }
    

    @Override
    public String toString() {
        return "Piece: "+ title + " | Description: " + description 
                                + " | Examination Date and Time: " + subDateTime
                                + "\n";
    }
    
}
