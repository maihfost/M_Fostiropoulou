package cmdUtils;

import Interfaces.IAssignmentCmdUtils;
import java.time.LocalDate;
import java.util.Scanner;


public class Assignment implements IAssignmentCmdUtils {
    private Scanner sc;

    public Assignment(Scanner sc) {
        this.sc = sc;
    }
    
    public models.Assignment askData(){
        Command cmd=new Command();
        models.Assignment assignment=new models.Assignment();
        
        assignment.setTitle(cmd.getStringAttribute(sc, "Title :"));
        assignment.setDescription(cmd.getStringAttribute(sc, "Description :"));
        assignment.setSubDate(LocalDate.parse(cmd.getStringAttribute(sc," Submision Date (2020-04-27) :")));
        
        return(assignment);
    }
    
    

}
