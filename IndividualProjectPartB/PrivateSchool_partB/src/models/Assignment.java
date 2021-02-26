package models;

import java.time.LocalDate;


public class Assignment {
    private String title;
    private String description;
    private LocalDate subDate;

    public Assignment() {
    }
    
    public Assignment(String title, String description, LocalDate subDate) {
        this.title = title;
        this.description = description;
        this.subDate = subDate;
    }

    public LocalDate getSubDate() {
        return subDate;
    }

    public void setSubDate(LocalDate subDate) {
        this.subDate = subDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Assignment{title=").append(title);
        sb.append(", description=").append(description);
        sb.append(", subDate=").append(subDate);
        sb.append('}');
        return sb.toString();
    }
    
    

}
