package cmdUtils;

import Interfaces.IStudentCmdUtils;
import java.time.LocalDate;
import java.util.Scanner;

public class Student implements IStudentCmdUtils{
    private Scanner sc;

    public Student(Scanner sc) {
        this.sc = sc;
    }
    
    public models.Student askData(){
        Command cmd=new Command();
        models.Student student=new models.Student();
        
        student.setFirst_name(cmd.getStringAttribute(sc,"First Name :"));
        student.setLast_name(cmd.getStringAttribute(sc,"Last Name :"));
        student.setDob(LocalDate.parse(cmd.getStringAttribute(sc,"Date of Birth (2020-03-29) :")));
        
        return(student);
    
    }

}
