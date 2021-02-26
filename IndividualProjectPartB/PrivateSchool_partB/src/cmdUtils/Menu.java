package cmdUtils;

import dbUtils.Database;
import java.util.Scanner;


public class Menu {
    Scanner sc = new Scanner(System.in);    
    Database database=new Database();
    
     public void enterMenu(){
         System.out.println("Welcome to Private School");
         int choice=chooseAction(sc);
        switch (choice) {
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            case 1:
                selects(chooseSelectList(sc));
                break;
            default:
                inserts(chooseInsertList(sc));
                break;
        }
     }
    
     public int chooseAction(Scanner sc){
        System.out.println("Menu");
        System.out.println("0. Exit the program");
        System.out.println("1. Check data");
        System.out.println("2. Insert data");
        System.out.println("Press one of the above numbers of your choice");
        
        String input=sc.nextLine();
        if (input.equals("0")) {
            return 0;
        } 
        else if (input.equals("1")) {
            return 1;
        } 
        else {
            return 2;
        }
    }
    
     public int chooseSelectList(Scanner sc){
        
        System.out.println("0. Exit the program");
        System.out.println("1. List of all Courses");
        System.out.println("2. List of all Students");
        System.out.println("3. List of all Trainers");
        System.out.println("4. List of all Assignments");
        System.out.println("5. List of all Students per Course");
        System.out.println("6. List of all Trainers per Course");
        System.out.println("7. List of all Assignments per Course");
        System.out.println("8. List of all Assignments per Course per Student");
        System.out.println("9. List of all Students with more than one courses");
        System.out.println("10. Menu");
        System.out.println("Press one of the above numbers of your choice");
        
        String input=sc.nextLine();
        if (input.equals("0")) {
            return 0;
        } 
        else if (input.equals("1")) {
            return 1;
        }
        else if (input.equals("2")) {
            return 2;
        } 
        else if (input.equals("3")) {
            return 3;
        } 
        else if (input.equals("4")) {
            return 4;
        } 
        else if (input.equals("5")) {
            return 5;
        } 
        else if (input.equals("6")) {
            return 6;
        } 
        else if (input.equals("7")) {
            return 7;
        } 
        else if (input.equals("8")) {
            return 8;
        } 
        else if (input.equals("9")) {
            return 9;
        } 
        else {
            return 10;
        }
        
            
    }
     
     public int chooseInsertList(Scanner sc){
        
        System.out.println("0. Exit the program");
        System.out.println("1. Insert new Student");
        System.out.println("2. Insert new Course");
        System.out.println("3. Insert new Trainer");
        System.out.println("4. Insert new Assignment");
        System.out.println("5. Associate trainer to course");
        System.out.println("6. Associate students to course");
        System.out.println("7. Associate assignments tu student to course");
        System.out.println("8. Menu");
        System.out.println("Press one of the above numbers of your choice");
        
        String input=sc.nextLine();
        if (input.equals("0")) {
            return 0;
        } 
        else if (input.equals("1")) {
            return 1;
        }
        else if (input.equals("2")) {
            return 2;
        } 
        else if (input.equals("3")) {
            return 3;
        } 
        else if (input.equals("4")) {
            return 4;
        } 
        else if (input.equals("5")) {
            return 5;
        } 
        else if (input.equals("6")) {
            return 6;
        } 
        else if (input.equals("7")){
            return 7;
        }
        else {
            return 8;
        }
    }

     public void selects(int select){ 
        Scanner sc = new Scanner(System.in);    
        Database database=new Database();
        Command cmd=new Command();
         
        switch (select) {
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            case 1:
                database.showListStudents();
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 2:
                database.showListCourses();
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 3:
                database.showListTrainers();
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 4:
                database.showListAssignments();
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 5:
                database.showListStudentsPerCourse(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 6:
                database.showListTrainersPerCourse(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 7:
                database.showListAssignmentsPerCourse(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 8:
                database.showListAssignmentsPerCoursePerStudent(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 9:
                database.showListStudentsWithMoreThanOneCourses();
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            default:
                enterMenu();
                break;
        }
         
         
         
     }
     
     public void inserts(int insert){ 
        Scanner sc = new Scanner(System.in);    
        Database database=new Database();
        Command cmd=new Command();
        
        switch (insert) {
            case 0:
                System.out.println("Goodbye!");
                System.exit(0);
            case 1:
                database.insertStudent(new cmdUtils.Student(sc).askData());
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 2:
                database.insertCourse(new cmdUtils.Course(sc).askData());
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 3:
                database.insertTrainer(new cmdUtils.Trainer(sc).askData());
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 4:
                database.insertAssignment(new cmdUtils.Assignment(sc).askData());
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 5:
                database.insertTrainersToCourse(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 6:
                database.insertStudentsToCourse(sc);
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            case 7:
                System.out.println(" -3 Marks! ");
                cmd.getStringAttribute(sc, "Press anything to continue");
                enterMenu();
                break;
            default:
                enterMenu();
                break;
        }
         
         
         
     }
}
      