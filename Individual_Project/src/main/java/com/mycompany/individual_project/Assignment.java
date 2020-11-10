package com.mycompany.individual_project;

import java.time.LocalDateTime;

public class Assignment {
    private String title;
    private String description;
    private LocalDateTime subDateTime;
    private int oralMark;
    private int totalMark;

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
        return oralMark;
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
        this.oralMark = oralMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }
    
    

}
