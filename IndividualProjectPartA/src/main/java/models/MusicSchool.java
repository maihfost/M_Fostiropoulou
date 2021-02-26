package models;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import static models.Data.formatter;
import static models.Data.formatter1;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MusicSchool {
    private final String schoolName = "Music School of Athens";
    private Data data=new Data();
    private ArrayList<Course> courses = new ArrayList<Course>();
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>();
   
    public MusicSchool(){
        System.out.println("Welcome to Music School of Athens!");
        enterData();
    }
    
    public void enterData(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Would you like to Enter Data(Y/N)?");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")) {
                Menu();
                break;
            }
            else if (answer.equals("Y")) {
                enterDataCSTA();
                goBackToMenu();
                break;
            }
            else
                answer="";
                System.out.println("Enter Y OR N");
        }
    }
    public void enterDataCSTA(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the number of your selection:\n"
                + "1.Enter new Course\n" 
                + "2.Enter new Student\n"
                + "3.Enter new Trainer\n" 
                + "4.Enter new Assignment\n"
                + "Regret it? Press 'S' to go to main Menu..");
        
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("1")){
                courses=createCourse();
                break;
            }
            else if (answer.equals("2")){
                if (courses.isEmpty()){
                    System.out.println("There are no courses to add a Student,please add course first.");
                    enterDataCSTA();
                    break;   
                }
                else{
                    students=createStudent();
                    break;
                }
            }    
            else if (answer.equals("3")){
                if (courses.isEmpty()){
                    System.out.println("There are no courses to add a Trainer,please add course first.");
                    enterDataCSTA();
                    break;
                }
                else{
                    trainers=createTrainer();
                    break;
                }
            }
            else if (answer.equals("4")){
                if (courses.isEmpty()){
                    System.out.println("There are no courses to add an assignment,please add course first.");
                    enterDataCSTA();
                    break;
                }
                else{
                assignments=createAssignment();
                break;
                }
            }
            else if (answer.equals("S")){
                Menu();
                break;
            }
            else
                answer="";
                System.out.println("Enter one of the above numbers or 'S' to go to main Menu.");
        }
    }
    public void Menu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Services(Please enter the number of the service you prefere): \n"
                            + "1.School's Courses\n" 
                            + "2.School's Students\n" 
                            + "3.School's Trainers\n"
                            + "4.School's Assignments\n"
                            + "5.Students per Course\n"
                            + "6.Trainers per Course\n"
                            + "7.Assignments per Course\n"
                            + "8.Assignments per Students\n"
                            + "9.Students that have more than one courses\n"
                            + "10.Enter date, to search which students have to"
                            + " submit assignments on the date's calendar week\n"
                            + "11.Exit");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("1")){
                if (this.courses.isEmpty()){
                    introduceCourse(data.coursesArr());
                    
                }
                else{
                    introduceCourse(this.courses);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("2")){
                if (this.students.isEmpty()){
                    introduceStudent(data.studentsArr());
                }
                else{
                    introduceStudent(this.students);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("3")){
                if (this.trainers.isEmpty()){
                    introduceTrainer(data.trainersArr());
                }
                else{
                    introduceTrainer(this.trainers);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("4")){
                if (this.assignments.isEmpty()){
                    introduceAssignment(data.assignmentsArr());
                }
                else{
                    introduceAssignment(assignments);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("5")){
                if (this.students.isEmpty()){
                    
                    introduceStudentsPerCourse(data.coursesArr());
                }
                else{
                    introduceStudentsPerCourse(this.courses);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("6")){
               if (this.trainers.isEmpty()){
                    introduceTrainersPerCourse(data.coursesArr());
                }
                else{
                    introduceTrainersPerCourse(this.courses);
                }
                goBackToMenu();
                break;
            }    
            else if (answer.equals("7")){
                if (this.assignments.isEmpty()){
                    introduceAssignmentsPerCourse(data.coursesArr());
                }
                else{
                    introduceAssignmentsPerCourse(this.courses);
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("8")){
                if (this.courses.isEmpty()){
                    for (Student student:data.studentsArr()){
                        System.out.println(student.getFirstName().toUpperCase() 
                                + " " + student.getLastName().toUpperCase());
                        ArrayList<Assignment> studentAssignments=new ArrayList<Assignment>();  
                        studentAssignments= student.studentAssignmentsMethod(data.coursesArr());
                        System.out.println( "Assignments : " + studentAssignments.toString());
                    }
                }
                else{
                    for (Student student:students){
                        System.out.println(student.getFirstName().toUpperCase() 
                                + " " + student.getLastName().toUpperCase());
                        System.out.println( "Assignments : " + student.getStudentAssignments());
                    }
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("9")){
                ArrayList<Student> listOfStudentsWithMoreThanOneCourses=new ArrayList<Student>();
                if (this.courses.isEmpty()){
                    for (Student student:data.studentsArr()){
                       if (student.countStudentCourses(data.coursesArr())>1){
                           listOfStudentsWithMoreThanOneCourses.add(student);
                       }
                    }
                    System.out.println(listOfStudentsWithMoreThanOneCourses.toString());
                }
                else{
                    for (Student student:students){
                       if (student.countStudentCourses(courses)>1){
                           listOfStudentsWithMoreThanOneCourses.add(student);
                       }
                    }
                    System.out.println(listOfStudentsWithMoreThanOneCourses.toString());
                }
                goBackToMenu();
                break;
            }
            else if (answer.equals("10")){
                Scanner sc1 =new Scanner(System.in);
                System.out.println("Enter a Date (YEAR-MONTH-DAY) :");
                LocalDate ld = LocalDate.parse(sc.next(),formatter);
                datesOfWeekDate(ld);
                if (this.courses.isEmpty()){
                    ArrayList<Student> studentsAssignmentSubDate=new ArrayList<Student>();
                    for (Student student:data.studentsArr()){
                        int x=0;
                        ArrayList<Assignment> studentAssignments=new ArrayList<Assignment>();  
                        studentAssignments= student.studentAssignmentsMethod(data.coursesArr());
                        int size = studentAssignments.size();
                        for (int j=0;j<size;j++){
                            System.out.println("1");
                            for (LocalDate date:datesOfWeekDate(ld)){
                                System.out.println("2");
                                if ((studentAssignments.get(j).getSubDateTime().toLocalDate()).equals(date)){
                                    System.out.println("3");
                                    studentsAssignmentSubDate.add(student);
                                    x=1;
                                    break;
                                }   
                            }
                            if (x==1){
                                break;
                            }
                        }   
                    }
                    if (studentsAssignmentSubDate.isEmpty()){
                        System.out.println("No student has to submit one or more assignments on this callendar week");
                    }
                    else{
                        System.out.println("Students that have to submit anassignment "
                                + "on the Callendar week of the date you entered: ");
                        for (int i=0;i<studentsAssignmentSubDate.size();i++){
                            System.out.println(studentsAssignmentSubDate.get(i).getFirstName()
                                               + " " + studentsAssignmentSubDate.get(i).getLastName());
                        }
                    }
                }
                else{
                    ArrayList<Student> studentsAssignmentSubDate=new ArrayList<Student>();
                    for (Student student:students){
                        int x=0;
                        ArrayList<Assignment> studentAssignments=new ArrayList<Assignment>();  
                        studentAssignments= student.getStudentAssignments();
                        for (int j=0;j<studentAssignments.size();j++){
                            for (LocalDate date:datesOfWeekDate(ld)){
                                if ((studentAssignments.get(j).getSubDateTime().toLocalDate()).equals(date)){
                                    studentsAssignmentSubDate.add(student);
                                    x=1;
                                    break;
                                }   
                            }
                            if (x==1){
                                break;
                            }
                        }  
                    }
                    if (studentsAssignmentSubDate.isEmpty()){
                        System.out.println("No student has to submit one or more assignments on this callendar week");
                    }
                    else{
                        System.out.println("Students that have to submit anassignment "
                                + "on the Callendar week of the date you entered: ");
                        for (int i=0;i<studentsAssignmentSubDate.size();i++){
                            System.out.println(studentsAssignmentSubDate.get(i).getFirstName()
                                               + " " + studentsAssignmentSubDate.get(i).getLastName());
                        }
                    }
                }
            }    
            else if (answer.equals("11")){
                System.exit(0);
            }
            else
                answer="";
        }
    }
    public void goBackToMenu(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Do you want to go back to Menu?(Y/N");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("Y")){
                Menu();
                break;
            }
            else if (answer.equals("N")){
                System.exit(0);
            }
            else
                answer="";
                System.out.println("Enter Y or N");
        }
    }
           
    //Print Courses
    public void introduceCourse(ArrayList<Course> courses){
        System.out.println("Music School's Courses:" + "\n" + courses);
    }
    
    //Print Students
    public void introduceStudent(ArrayList<Student> students){
        System.out.println("Music School's Courses: " + "\n" + students);
    }
    
    //Synthetic Trainers ArrayList
    public void introduceTrainer(ArrayList<Trainer> trainers){
        System.out.println("Music School's Trainers: " + "\n" + trainers);
    }
    
    //Synthetic Assignments ArrayList
    public void introduceAssignment(ArrayList<Assignment> assignments){
        System.out.println("Music School's Assignments: " + "\n" + assignments);
    }
    
    //User Inputs Courses
    public ArrayList<Course> createCourse(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Course name(instrument)");
        String title=sc.next();
        System.out.println("Course stream(Jazz/Classic/Traditional)");
        String stream=sc.next();
        System.out.println("Course type(Full Time/Part Time)");
        sc.nextLine();
        String type=sc.nextLine();
        System.out.println("Course Starting Date(ex. 2020.09.15)");
        LocalDate startingDate= LocalDate.parse(sc.next(),formatter);
        System.out.println("Course Ending Date(ex. 2020.09.15)");
        LocalDate endingDate= LocalDate.parse(sc.next(),formatter);
        
        Course course1=new Course(title,stream,type,startingDate,endingDate);
        
        System.out.println("Enter Trainers of the Course :");
        ArrayList<Trainer> trainersPerCourse=new ArrayList<Trainer>();
        trainersPerCourse=createTrainer(trainersPerCourse);      
        
        Course course2=new Course(title,stream,type,startingDate,endingDate,trainersPerCourse);
        
        System.out.println("Enter Assignments of the Course :");
        ArrayList<Assignment> assignmentsPerCourse=new ArrayList<Assignment>();
        assignmentsPerCourse=createAssignment(assignmentsPerCourse);
        
        Course course3=new Course(title,stream,type,startingDate,endingDate,trainersPerCourse,assignmentsPerCourse);
        
        System.out.println("Enter Students of the Course :");
        ArrayList<Student> studentsPerCourse=new ArrayList<Student>();
        studentsPerCourse=createStudent(course3,studentsPerCourse);
        
        Course course=new Course(title,stream,type,startingDate,endingDate,trainersPerCourse,assignmentsPerCourse,studentsPerCourse);
        courses.add(course);
        
        System.out.println("Do you want to add more courses?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                enterData();
                break;
            }
            else if (answer.equals("Y")){
                createCourse();
            }
            else
                answer="";
                System.out.println("Enter Y( to add student) OR N(to continue))");
        }
        return courses;
    }
    
    //User Inputs Students
    public ArrayList<Student> createStudent(){
        Scanner sc=new Scanner(System.in);
        System.out.println("First name");
        String firstName=sc.next();
        System.out.println("Last name");
        String lastName=sc.next();
        System.out.println("Date of Birth(ex 1992.05.16");
        LocalDate dateOfBirth= LocalDate.parse(sc.next(),formatter);
        System.out.println("Tuition fees");
        int tuitionFees=sc.nextInt();
        
        Scanner sc2=new Scanner(System.in);
        System.out.println("In which course will the student enroll?Choose number from the above list: \n");
        int size=courses.size();
        for (int i=0;i<size;i++){
            System.out.println(i + ". " + courses.get(i));
        }
        ArrayList<Course> studentCourses=new ArrayList<Course>();
        studentCourses.add(courses.get(sc2.nextInt()));
        System.out.println("Do you want to another course(Y/N)");
        String answer1="";
        while (answer1.equals("")){
            answer1=sc.next();
            if (answer1.equals("Y")){
                System.out.println("In which course will the student enroll?Choose number from the above list: \n");
                for (int i=0;i<size;i++){
                    System.out.println(i + ". " + courses.get(i));
                }
                studentCourses.add(courses.get(sc2.nextInt()));
            }
            else if (answer1.equals("N")){
                break;
            }
            else{
                answer1="";
                System.out.println("Answer Y or N");
            }
        }
        Student student=new Student(firstName,lastName,dateOfBirth,tuitionFees,studentCourses);
        for (Course course:studentCourses){
            course.getStudentsPerCourse().add(student);
        }
        students.add(student);
        System.out.println("Do you want to add more students?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createStudent();
                break;
            }
            else
                answer="";
                System.out.println("Enter Y( to add student) OR N(to continue))");
        }
        return students;
    }
    
    //User Inputs Students in Create Course(OVERlOAD)
    public ArrayList<Student> createStudent(Course course,ArrayList<Student> studentsPerCourse){
        Scanner sc=new Scanner(System.in);
        System.out.println("First name");
        String firstName=sc.next();
        System.out.println("Last name");
        String lastName=sc.next();
        System.out.println("Date of Birth(ex 1992.05.16");
        LocalDate dateOfBirth= LocalDate.parse(sc.next(),formatter);
        System.out.println("Tuition fees");
        int tuitionFees=sc.nextInt();
        
        ArrayList<Course> studentCourses=new ArrayList<Course>();
        studentCourses.add(course);
        Student student=new Student(firstName,lastName,dateOfBirth,tuitionFees,studentCourses);
        
        students.add(student);
        studentsPerCourse.add(student);
        
        System.out.println("Do you want to add more students?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createStudent(course,studentsPerCourse);
                break;
            }
            else
                answer="";
                System.out.println("Enter Y( to add student) OR N(to continue))");
        }
        return studentsPerCourse;
    }
    
    //User Inputs Trainers
    public ArrayList<Trainer> createTrainer(){
        Scanner sc=new Scanner(System.in);
        System.out.println("First name:");
        String firstName=sc.next();
        System.out.println("Last name:");
        String lastName=sc.next();
        System.out.println("Subject");
        String subject=sc.next();
        
        Scanner sc2=new Scanner(System.in);
        System.out.println("In which course will the Trainer teach?Choose number from the above list: \n");
        int size=courses.size();
        for (int i=0;i<size;i++){
            System.out.println(i + ". " + courses.get(i));
        }
        ArrayList<Course> trainerCourses=new ArrayList<Course>();
        trainerCourses.add(courses.get(sc2.nextInt()));
        System.out.println("Do you want to another course(Y/N)");
        String answer1="";
        while (answer1.equals("")){
            answer1=sc.next();
            if (answer1.equals("Y")){
                System.out.println("In which course will the Trainer teach?Choose number from the above list: \n");
                for (int i=0;i<size;i++){
                    System.out.println(i + ". " + courses.get(i));
                }
                trainerCourses.add(courses.get(sc2.nextInt()));
            }
            else if (answer1.equals("N")){
                break;
            }
            else{
                answer1="";
                System.out.println("Answer Y or N");
            }
        }        
        Trainer trainer=new Trainer(firstName,lastName,subject,trainerCourses);
        
        for (Course course:trainerCourses){
            course.getTrainersPerCourse().add(trainer);
        }
        
        trainers.add(trainer);
        System.out.println("Do you want to add more trainers?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createTrainer();
            }
            else
                answer="";
                System.out.println("Enter Y( to add trainer) OR N(to continue))");
        }
        return trainers;
    }
    
    //User Inputs Trainers in Create Course(OVERlOAD)
    public ArrayList<Trainer> createTrainer(ArrayList<Trainer> trainersPerCourse){
        Scanner sc=new Scanner(System.in);
        System.out.println("First name:");
        String firstName=sc.next();
        System.out.println("Last name:");
        String lastName=sc.next();
        System.out.println("Subject");
        String subject=sc.next();
        Trainer trainer=new Trainer(firstName,lastName,subject);
        trainers.add(trainer);
        trainersPerCourse.add(trainer);
        System.out.println("Do you want to add more trainers?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createTrainer(trainersPerCourse);
            }
            else
                answer="";
                System.out.println("Enter Y( to add trainer) OR N(to continue))");
        }
        return trainersPerCourse;
    }
    
    //User Inputs Assignments
    public ArrayList<Assignment> createAssignment(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Assignment piece: ");
        String piece=sc.next();
        System.out.println("Description: ");
        sc.nextLine();
        String description=sc.nextLine();
        System.out.println("Examination Day and Hour(ex 2015.09.15-12:00:00): ");
        LocalDateTime examinationDateTime = LocalDateTime.parse(sc.next(),formatter1);
        System.out.println("Technic Mark: ");
        int technicMark=sc.nextInt();
        System.out.println("Total Mark ");
        int totalMark=sc.nextInt();
        
                
        Scanner sc2=new Scanner(System.in);
        System.out.println("In which course will the Assignment be?Choose number from the above list: \n");
        int size=courses.size();
        for (int i=0;i<size;i++){
            System.out.println(i + ". " + courses.get(i));
        }
        ArrayList<Course> assignmentCourses=new ArrayList<Course>();
        assignmentCourses.add(courses.get(sc2.nextInt()));
        System.out.println("Do you want to another course(Y/N)");
        String answer1="";
        while (answer1.equals("")){
            answer1=sc.next();
            if (answer1.equals("Y")){
                System.out.println("In which course will the Assignment be?Choose number from the above list: \n");
                for (int i=0;i<size;i++){
                    System.out.println(i + ". " + courses.get(i));
                }
                assignmentCourses.add(courses.get(sc2.nextInt()));
            }
            else if (answer1.equals("N")){
                break;
            }
            else{
                answer1="";
                System.out.println("Answer Y or N");
            }
        }
        
        Assignment assignment=new Assignment(piece,description,examinationDateTime,assignmentCourses);
        for (Course course:assignmentCourses){
            course.getAssignmentsPerCourse().add(assignment);
        }
        
        assignments.add(assignment);
        System.out.println("Do you want to add more Assignments?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createAssignment();
            }
            else
                answer="";
        }
        return assignments;
    }
    
    //User Inputs Assignments
    public ArrayList<Assignment> createAssignment(ArrayList<Assignment> assignmentsPerCourse){
        Scanner sc=new Scanner(System.in);
        System.out.println("Assignment piece: ");
        String piece=sc.next();
        System.out.println("Description: ");
        sc.nextLine();
        String description=sc.nextLine();
        System.out.println("Examination Day and Hour(ex 2015.09.15-12:00:00): ");
        LocalDateTime examinationDateTime = LocalDateTime.parse(sc.next(),formatter1);
        System.out.println("Technic Mark: ");
        int technicMark=sc.nextInt();
        System.out.println("Total Mark ");
        int totalMark=sc.nextInt();
        Assignment assignment=new Assignment(piece,description,examinationDateTime,technicMark,totalMark);
        assignments.add(assignment);
        assignmentsPerCourse.add(assignment);
        System.out.println("Do you want to add more Assignments?(Y/N)");
        String answer="";
        while (answer.equals("")){
            answer=sc.next();
            if (answer.equals("N")){
                break;
            }
            else if (answer.equals("Y")){
                createAssignment(assignmentsPerCourse);
            }
            else
                answer="";
        }
        return assignmentsPerCourse;
    }

    //Students Per Course
    public void introduceStudentsPerCourse(ArrayList<Course> courses){
        for (Course course:courses){
            System.out.println("Students of " + course.getStream() + course.getTitle()
                    + " " + course.getType() + ": " + course.getStudentsPerCourse());
        }
    }
    
    //Trainers Per Course
    public void introduceTrainersPerCourse(ArrayList<Course> courses){
        for (Course course:courses){
            System.out.println("Course: " + course.getTitle() + course.getStream()
                             + course.getType() + course.getTrainersPerCourse());
        }
    }
    
    //Assignments Per Course
    public void introduceAssignmentsPerCourse(ArrayList<Course> courses){
        for (Course course:courses){
            System.out.println("Course: " + course.getTitle() + course.getStream()
                             + course.getType() + course.getAssignmentsPerCourse());
        }
    }
    
    //Dates of Calendar Week,calculated by given date
    public static List<LocalDate> datesOfWeekDate(LocalDate date) {
        LocalDate monday = date.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return IntStream.range(0, 5).mapToObj(monday::plusDays).collect(Collectors.toList());
    }

}    
