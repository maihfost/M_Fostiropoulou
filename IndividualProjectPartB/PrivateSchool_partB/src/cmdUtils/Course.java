package cmdUtils;

import Interfaces.ICourseCmdUtils;
import java.time.LocalDate;
import java.util.Scanner;


public class Course implements ICourseCmdUtils{
    private Scanner sc;

    public Course(Scanner sc) {
        this.sc = sc;
    }
    
    public models.Course askData(){
        models.Course course=new models.Course();
        Command cmd=new Command();

        course.setTitle(cmd.getStringAttribute(sc, "Title :"));
        course.setStream(cmd.getStringAttribute(sc, "Stream:"));
        course.setType(cmd.getStringAttribute(sc, "Type :"));
        course.setStart_date(LocalDate.parse(cmd.getStringAttribute(sc,"Starting Date(2020-02-15) :")));
        course.setEnd_date(LocalDate.parse(cmd.getStringAttribute(sc,"Ending Date (2020-08-15) :")));
        return(course);
    }

}
