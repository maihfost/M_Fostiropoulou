package com.mycompany.exercise3;

import java.time.LocalDate;

public class BootCamp {
    private String name;
    private LocalDate startingDate;
    private LocalDate endingDate;
    
    BootCamp(String name,LocalDate startingDate,LocalDate endingDate){
        this.name=name;
        this.startingDate=startingDate;
        this.endingDate=endingDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public boolean isAvailable(LocalDate searchForDate){
        boolean isAv;
        if (searchForDate.isAfter(startingDate) && searchForDate.isBefore(endingDate)){
            isAv=true;
        }
        else{
            isAv=false;
        }
        return isAv;
    }
}
