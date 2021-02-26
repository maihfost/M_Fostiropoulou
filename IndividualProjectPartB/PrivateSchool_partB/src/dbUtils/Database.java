package dbUtils;

import Interfaces.IDatabase;
import cmdUtils.Command;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;
import models.TrainerCourse;


public class Database implements IDatabase{
    
    public String server;
    public String username;
    public String password;
    public String database;

    Connection con;
    Statement statement;
    PreparedStatement pstatement;
    ResultSet rs;
    ResultSetMetaData rsmd;
    
    public Database(){
        
        database="Private School";
        username="root";
        password="lala1234";
        server="jdbc:mysql://172.17.0.2:3306/" + database + "?useSSL=false&serverTimeZone=Europe/Athens";
        
        try {
            con=DriverManager.getConnection(server,username,password);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection failed!");
        }
        
    }
    
    @Override
    public List<Integer> showListStudents(){
        List<Integer> studentsIds=new ArrayList<>();
        int i = 0;
        //SELECT * FROM students,courses
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT * FROM students");
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString("f_name") +
                                       " " + rs.getString("l_name") +
                                       " " + rs.getDate("date_of_birth"));
                studentsIds.add(rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(studentsIds);
    }
    
    public List<Integer> getListAllStudents(){
        List<Integer> studentsIds=new ArrayList<>();
        int i = 0;
        //SELECT * FROM students,courses
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT * FROM students");
            while(rs.next()){
                studentsIds.add(rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(studentsIds);
    }
    
    @Override
    public List<Integer> showListCourses(){
        List<Integer> coursesIds=new ArrayList<>();
        int i = 0;
        //SELECT * FROM courses
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT * FROM courses");
            
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString("title") +
                                       " " + rs.getString("stream") +
                                       " " + rs.getString("type") +
                                       " " + rs.getDate("start_date") +
                                       " " + rs.getDate("end_date"));
                coursesIds.add(rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(coursesIds);
    }
    
    @Override
    public List<TrainerCourse> showListTrainers(){
        //SELECT * FROM trainers
        List<TrainerCourse> trainersIds=new ArrayList<>();
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT * FROM trainers" );
            int i=0;
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString("f_name") +
                                       " " + rs.getString("l_name"));
                trainersIds.add(new TrainerCourse(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(trainersIds);
    }
    
    @Override
    public void showListAssignments(){
        //SELECT * FROM assignments
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT * FROM assignments" );
            int i=0;
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString("title") +
                                       " " + rs.getString("description") +
                                       " " + rs.getDate("subDate"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Integer> showListStudentsPerCourse(Scanner sc){
        //USER CHOOSE COURSE
        //METHOD chooseCourseId gets courseId
        //SELECT students.f_name,students.l_name,students.date_of_birth,studentspercourse.id FROM students 
        //INNER JOIN studentspercourse ON students.id=studentspercourse.student_id 
        //WHERE studentspercourse.course_id=|courseId|  ORDER BY students.l_name;
        List<Integer> studentsPerCourseIds=new ArrayList<>();
        int i = 0;
        int courseId=chooseCourseId(sc);

        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT students.f_name,students.l_name,students.date_of_birth,studentspercourse.id FROM students "
                                    + "INNER JOIN studentspercourse ON students.id=studentspercourse.student_id "
                                    + "WHERE studentspercourse.course_id=" + courseId + " ORDER BY students.l_name");
            
            while(rs.next()){
                i +=1;
                System.out.println(i + " " + rs.getString(1) +
                                       " " + rs.getString(2) +
                                       " " + rs.getDate(3));
                studentsPerCourseIds.add(rs.getInt("id"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(studentsPerCourseIds);
    }
    
    public List<Integer> getListStudentsPerCourse(int courseId){
    //USER CHOOSE COURSE
        //METHOD chooseCourseId gets courseId
        //SELECT students.f_name,students.l_name,students.date_of_birth,studentspercourse.id FROM students 
        //INNER JOIN studentspercourse ON students.id=studentspercourse.student_id 
        //WHERE studentspercourse.course_id=|courseId|  ORDER BY students.l_name;
        List<Integer> studentsOfaCourseIds=new ArrayList<>();
        int i = 0;

        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT students.id,students.f_name,students.l_name,students.date_of_birth,studentspercourse.id FROM students "
                                    + "INNER JOIN studentspercourse ON students.id=studentspercourse.student_id "
                                    + "WHERE studentspercourse.course_id=" + courseId + " ORDER BY students.l_name");
            
            while(rs.next()){
                studentsOfaCourseIds.add(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(studentsOfaCourseIds);
    }
    
     @Override
    public List<Integer> showListCoursesPerStudent(Scanner sc){
        //USER CHOOSE STUDENT
        //METHOD chooseStudentId gets studentId
        //SELECT courses.id,courses.title,courses.stream,courses.type FROM students 
        //INNER JOIN studentspercourse ON students.id=studentspercourse.student_id 
        //WHERE studentspercourse.course_id=|courseId|  ORDER BY students.l_name;
        List<Integer> coursesPerStudentIds = new ArrayList<>();
        int i = 0;
        int studentId=chooseStudentId(sc);

        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT studentspercourse.id,courses.title,courses.stream,courses.type FROM courses "
                                    + "INNER JOIN studentspercourse ON courses.id=studentspercourse.course_id "
                                    + "WHERE studentspercourse.student_id=" + studentId );
            
            while(rs.next()){
                i +=1;
                System.out.println(i + " " + rs.getString(2) +
                                       " " + rs.getString(3) +
                                       " " + rs.getString(4));
                coursesPerStudentIds.add(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(coursesPerStudentIds);
    }
   
    @Override
    public void showListTrainersPerCourse(Scanner sc){
        //USER CHOOSE COURSE
        //METHOD chooseCourseId gets courseId
        //SELECT courses.title,trainers.f_name,trainers.l_name FROM trainers 
        //INNER JOIN courses ON trainers.course_id=courses.id WHERE courses.id=|courseId|
        int courseId=chooseCourseId(sc);

        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT courses.title,trainers.f_name,trainers.l_name FROM trainers "
                                    + "INNER JOIN courses ON trainers.course_id=courses.id WHERE courses.id=" + courseId );
            int i=0;
            while(rs.next()){
                i +=1;
                System.out.println(i + " " + rs.getString(2) +
                                       " " + rs.getString(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
    @Override
    public void showListAssignmentsPerCourse(Scanner sc){
        //USER CHOOSE COURSE
        //METHOD chooseCourseId gets courseId
        //SELECT courses.title,assignments.title,assignments.description,assignments.subDate FROM trainers 
        //INNER JOIN courses ON assignments.course_id=courses.id WHERE courses.id=|courseId|
        int courseId=chooseCourseId(sc);

        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT courses.title,assignments.title,assignments.description,assignments.subDate FROM assignments "
                                    + "INNER JOIN courses ON assignments.course_id=courses.id WHERE courses.id=" + courseId );
            int i=0;
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString(2) +
                                       " " + rs.getString(3) + 
                                       " " + rs.getDate(4));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void showListAssignmentsPerCoursePerStudent(Scanner sc){
        //USER CHOOSE Student
        //SHOW STUDENTS COURSES
        //USER CHOOSE A COURSE FROM THE LIST
        //METHOD chooseStudentPerCourseId gets studentId
        //SELECT assignments.title,assignments.description FROM assignments 
        //INNER JOIN assignmentsperstudentpercourse ON assignments.id=assignmentsperstudentpercourse.assignments_id
        //WHERE assignmentsperstudentpercourse.studentspercourses_id=|coursePerStudentId|
        int coursePerStudentId=chooseCoursePerStudentId(sc);
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT assignments.title,assignments.description FROM assignments "
                                    + "INNER JOIN assignmentsperstudentpercourse ON assignments.id=assignmentsperstudentpercourse.assignments_id "
                                    + "WHERE assignmentsperstudentpercourse.studentspercourses_id=" + coursePerStudentId);
            int i=0;
            while(rs.next()){
                i +=1;
                System.out.println(i + "." + rs.getString(1) +
                                       " " + rs.getString(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void showListStudentsWithMoreThanOneCourses(){
        //Get STudents with more that one courses
        //SELECT students.f_name,students.l_name, COUNT(*) FROM students 
        //INNER JOIN studentspercourse ON studentspercourse.student_id=students.id 
        //GROUP BY studentspercourse.student_id
        
        int i=0;
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT students.f_name,students.l_name, COUNT(*) FROM students "
                                    + "INNER JOIN studentspercourse ON studentspercourse.student_id=students.id "
                                    + "GROUP BY studentspercourse.student_id");
            while(rs.next()){
                if (rs.getInt(3) > 1){
                i +=1;
                System.out.println(i + "." + rs.getString("f_name") +
                                       " " + rs.getString("l_name"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    public int chooseCourseId(Scanner sc){
        Command cmd = new Command();
        List<Integer> coursesIds = showListCourses();
        
        String y = cmd.getStringAttribute(sc, "Choose a number from the above courses");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > coursesIds.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any course."
                                         + "Please,choose a number from the above courses");
        }

        return(coursesIds.get(Integer.parseInt(y)-1));
    }
    
    public int chooseStudentId(Scanner sc){
        Command cmd = new Command();
        List<Integer> studentsIds = showListStudents();
        
        String y = cmd.getStringAttribute(sc, "Choose a number from the above students");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > studentsIds.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any student."
                                         + "Please,choose a number from the above students");
        }

        return(studentsIds.get(Integer.parseInt(y)-1));
    }
    
    public int chooseCoursePerStudentId(Scanner sc){
        Command cmd = new Command();
        List<Integer> coursePerStudentIds = showListCoursesPerStudent(sc);
        
        String y = cmd.getStringAttribute(sc, "Choose a number from the above courses");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > coursePerStudentIds.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any course."
                                         + "Please,choose a number from the above courses");
        }
        return(coursePerStudentIds.get(Integer.parseInt(y)-1));
    }
    
    public int chooseStudentperCourseId(Scanner sc){
        Command cmd = new Command();
        List<Integer> studentperCourseIds = showListStudentsPerCourse(sc);
        
        String y = cmd.getStringAttribute(sc, "Choose a number from the above students");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > studentperCourseIds.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any student."
                                         + "Please,choose a number from the above students");
        }

        return(studentperCourseIds.get(Integer.parseInt(y)-1));
    }
    
    public TrainerCourse chooseTrainer(List<TrainerCourse> trainers,Scanner sc){
        Command cmd = new Command();
        
        for( int i=0 ; i < trainers.size(); i++){
            System.out.println(i+1 + "." + trainers.get(i).getF_name() +
                                   " " + trainers.get(i).getL_name());
        }
        
        String y = cmd.getStringAttribute(sc, "Choose a number from the above trainers");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > trainers.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any student."
                                         + "Please,choose a number from the above students");
        }

        return(trainers.get(Integer.parseInt(y)-1));
    }
    
    public List<TrainerCourse> TrainersWithouCourse(){
        List<TrainerCourse> trainersWithoutCourse=new ArrayList<>();
        
        try {
            statement=con.createStatement();
            rs=statement.executeQuery("SELECT id,f_name,l_name FROM trainers WHERE course_id IS NULL" );
            while(rs.next()){
                trainersWithoutCourse.add(new TrainerCourse(rs.getInt(1),rs.getString(2),rs.getString(3),0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return(trainersWithoutCourse);
    }
 
    @Override
    public int insertStudent(Student student){
        int result=0;
        //INSERT INTO `students` (f_name,l_name,date_of_birth) VALUES..
        StringBuilder sb=new StringBuilder();
        
        sb.append("INSERT INTO ");
        sb.append("`");sb.append("students"); sb.append("`");
        sb.append(" (f_name,l_name,date_of_birth) ");
        sb.append("VALUES (");
        sb.append("\""); sb.append(student.getFirst_name()); sb.append("\",");
        sb.append("\""); sb.append(student.getLast_name()); sb.append("\",");
        sb.append("\""); sb.append(student.getDob()); sb.append("\"");
        sb.append(")");
        
        //THINK OF THE FEES
        
        System.out.println(sb.toString());
        
        try {
            statement=con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        return(result);
    }
    
    @Override
    public int insertCourse(Course course){
        int result=0;
        //INSERT INTO `courses` (title,stream,type,start_date,end_date) VALUES ..
        StringBuilder sb=new StringBuilder();
        
        sb.append("INSERT INTO ");
        sb.append("`");sb.append("courses"); sb.append("`");
        sb.append(" (title,stream,type,start_date,end_date) ");
        sb.append("VALUES (");
        sb.append("\""); sb.append(course.getTitle()); sb.append("\",");
        sb.append("\""); sb.append(course.getStream()); sb.append("\",");
        sb.append("\""); sb.append(course.getType()); sb.append("\",");
        sb.append("\""); sb.append(course.getStart_date()); sb.append("\",");
        sb.append("\""); sb.append(course.getEnd_date()); sb.append("\"");
        sb.append(")");
        
        System.out.println(sb.toString());
        
        try {
            statement = con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (result);
    }
    
    @Override
    public int insertTrainer(Trainer trainer){
        int result=0;
        //INSERT INTO `trainers` (f_name,l_name) VALUES ..--course_id--NULL
        StringBuilder sb=new StringBuilder();
        
        sb.append("INSERT INTO ");
        sb.append("`");sb.append("trainers"); sb.append("`");
        sb.append(" (f_name,l_name) ");
        sb.append("VALUES (");
        sb.append("\""); sb.append(trainer.getFirst_name()); sb.append("\",");
        sb.append("\""); sb.append(trainer.getLast_name()); sb.append("\"");
        sb.append(")");
        System.out.println(sb.toString());
        
        try {
            statement=con.createStatement();
            result=statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return(result);
    }
    
    @Override
    public int insertAssignment(Assignment assignment){
        int result=0;
        //INSERT INTO `assignments` (title,description,subDate) VALUES ..courseId--NULL
        StringBuilder sb=new StringBuilder();
        
        sb.append("INSERT INTO ");
        sb.append("`");sb.append("assignments"); sb.append("`");
        sb.append(" (title,description,subDate) ");
        sb.append("VALUES (");
        sb.append("\""); sb.append(assignment.getTitle()); sb.append("\",");
        sb.append("\""); sb.append(assignment.getDescription()); sb.append("\",");
        sb.append("\""); sb.append(assignment.getSubDate()); sb.append("\"");
        sb.append(")");
        
        System.out.println(sb.toString());
        
        try {
            statement=con.createStatement();
            result=statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return (result);
    }
    
    @Override
    public int insertTrainersToCourse(Scanner sc){
        List<TrainerCourse> trainersWithoutCourse=TrainersWithouCourse();
        if (trainersWithoutCourse.isEmpty()){
            System.out.println("All Trainers are associated to a course.");
            return 0;
        }
        else {
            //CHOOSE COURSE
            //CHOOSE TRAINER WITHOUT COURSE
            //UPDATE trainers SET course_id=|courseId| WHERE id=|trainer| IF trainers.courseId.isNULL"
            int result=0;
            int courseId=chooseCourseId(sc);
            TrainerCourse trainerToCourse=chooseTrainer(trainersWithoutCourse,sc);
            StringBuilder sb=new StringBuilder();
            
            sb.append("UPDATE ");
            sb.append("`");sb.append("trainers"); sb.append("`");
            sb.append(" SET");
            sb.append(" course_id=");
            sb.append("\""); sb.append(courseId); sb.append("\"");
            sb.append(" WHERE id="); sb.append(trainerToCourse.getTrainer_id());
            sb.append("");

            System.out.println(sb.toString());
                
            try {
                statement=con.createStatement();
                result=statement.executeUpdate(sb.toString());
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            return(result);
        }
    }
    
    @Override
    public int insertStudentsToCourse(Scanner sc){
    int result=0;
    
    //List of all the students
    List<Integer> AllstudentsIds= getListAllStudents();
    
    //Course to Add Students
    int courseId=chooseCourseId(sc);
    
    //Students that enroll in that course
    List<Integer> studentsOfCourseIds = getListStudentsPerCourse(courseId);
    
    //List of Students that do not enroll in that course filled in the above for loop
    List<Integer> studentsWithoutCourseCourseId=new ArrayList<>();
    
    int x;
    for (int i=0;i<AllstudentsIds.size();i++){
        x=0;
        for (int j=0; j< studentsOfCourseIds.size(); j++){
            if (AllstudentsIds.get(i) == studentsOfCourseIds.get(j)){
                x=1;
                break;
            }
        }
        if (x==0){
            studentsWithoutCourseCourseId.add(AllstudentsIds.get(i));
        }
    }
    
    //SELECT QUERY FOR STUDENTS THAT DO NOT ENROLL IN THAT COURSE
    StringBuilder sb1=new StringBuilder();
    sb1.append("SELECT * FROM students WHERE id IN (");
    for(int i=0;i<studentsWithoutCourseCourseId.size()-1;i++){
        sb1.append(studentsWithoutCourseCourseId.get(i)+",");
    }
    sb1.append(studentsWithoutCourseCourseId.get(studentsWithoutCourseCourseId.size()-1)+")");
    System.out.println(sb1);
    
    int j=0;
    try {
            statement=con.createStatement();
            rs=statement.executeQuery(sb1.toString());
            while(rs.next()){
                j +=1;
                System.out.println(j + "." + rs.getString("f_name") +
                                       " " + rs.getString("l_name") +
                                       " " + rs.getDate("date_of_birth"));
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    //Choose students from the above list of the query
    Command cmd = new Command();
    List<Integer> studentsToAdd=new ArrayList<>();
    while(cmd.getStringAttribute(sc, "Press C to choose a(one more) student").equalsIgnoreCase("C")){
        String y = cmd.getStringAttribute(sc, "Choose a number from the above students");
        while (!(y.matches("[0-9]")) || Integer.parseInt(y) < 1 || Integer.parseInt(y) > studentsWithoutCourseCourseId.size()) {
            y = cmd.getStringAttribute(sc, "The number you entered does not corresponds to any student."
                                         + "Please,choose a number from the above students");
        }
    studentsToAdd.add(studentsWithoutCourseCourseId.get(Integer.parseInt(y)-1));
    }
    
    //INSERT INTO studentspercourse the students that were choosen above
    for (int k = 0; k < studentsToAdd.size(); k++){
        StringBuilder sb=new StringBuilder();

        sb.append("INSERT INTO ");
        sb.append("`");sb.append("studentspercourse"); sb.append("`");
        sb.append(" (student_id,course_id) ");
        sb.append("VALUES (");
        sb.append("\""); sb.append(studentsToAdd.get(k)); sb.append("\",");
        sb.append("\""); sb.append(courseId); sb.append("\"");
        sb.append(")");

        System.out.println(sb.toString());

        try {
            statement=con.createStatement();
            result = statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return(result);
    }

}
