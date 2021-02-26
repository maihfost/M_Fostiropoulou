package cmdUtils;

import java.util.Scanner;


public class Command {

    public Command() {
    }

    public String getStringAttribute(Scanner sc,String message){
        System.out.println(message);
        return(sc.nextLine());
    }
    
    public int getIntAttribute(Scanner sc,String message){
        System.out.println(message);
        return(sc.nextInt());
    }
 
}
