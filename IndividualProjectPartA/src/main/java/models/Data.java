package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;



public class Data {
    static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy.MM.dd");
    static DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy.MM.dd-HH:mm:ss");
    
    //Students synthetic Data
    public ArrayList<Student> studentsArr(){
        ArrayList<Student> students= new ArrayList<Student>();
        Student student1=new Student("Nicolaos","Giannopoulos",LocalDate.parse("2004.09.15",formatter),1000);
        Student student2=new Student("Ioannis","Makris",LocalDate.parse("1997.11.02",formatter),1000);
        Student student3=new Student("Stamatia","Mixalopoulou",LocalDate.parse("1995.01.15",formatter),1000);
        Student student4=new Student("Konstantina","Evaggelatou",LocalDate.parse("1999.08.28",formatter),1000);
        Student student5=new Student("Natalia","Gkeka",LocalDate.parse("2002.07.07",formatter),1000);
        Student student6=new Student("Pigmalion","Kallimanis",LocalDate.parse("2001.09.26",formatter),1000);
        Student student7=new Student("Petros","Kalafas",LocalDate.parse("1997.02.03",formatter),1000);
        Student student8=new Student("Athanasia","Fotou",LocalDate.parse("1992.05.04",formatter),1000);
        Student student9=new Student("Niki","Augerinou",LocalDate.parse("2005.12.30",formatter),1000);
        Student student10=new Student("Xristos","Zaralikos",LocalDate.parse("1995.05.01",formatter),1000);
        students.add(0,student1);
        students.add(1,student2);
        students.add(2,student3);
        students.add(3,student4);
        students.add(4,student5);
        students.add(5,student6);
        students.add(6,student7);
        students.add(7,student8);
        students.add(8,student9);
        students.add(9,student10);
        return students;
    }
    //Trainers synthetic Data
    public ArrayList<Trainer> trainersArr(){
        ArrayList<Trainer> trainers= new ArrayList<Trainer>();
        Trainer trainer1=new Trainer("Iasonas","Kipourgos","Jazz/Classic Piano");
        Trainer trainer2=new Trainer("Vasiliki","Koulouri","Jazz Piano");
        Trainer trainer3=new Trainer("Smaragda","Alikaki","Classic Guitar");
        Trainer trainer4=new Trainer("Kiriaki","Tsagkalou","Classic Piano");
        Trainer trainer5=new Trainer("Despoina","Makri","Classic/Jazz Guitar");
        Trainer trainer6=new Trainer("Orestis","Tsekouras","Classic/Jazz Guitar");
        Trainer trainer7=new Trainer("Antonis","Ntaxli","Classic Guitar");

        trainers.add(0,trainer1);
        trainers.add(1,trainer2);
        trainers.add(2,trainer3);
        trainers.add(3,trainer4);
        trainers.add(4,trainer5);
        trainers.add(5,trainer6);
        trainers.add(6,trainer7);
        return trainers;
    }
    //Assignments synthetic Data
    public ArrayList<Assignment> assignmentsArr(){
        ArrayList<Assignment> assignments=new ArrayList<Assignment>();
        Assignment assignment1=new Assignment("Autumn Leaves",
                "Student will have to perform Autumn Leaves as Jazz Standard",
                LocalDateTime.parse("2020.01.30-10:00:00",formatter1));
        Assignment assignment2=new Assignment("Jazz Piano Scales",
                "Student will have to perform all Jazz scales in order "
                + "to be examines in jazz technical and theoritical knowledge",
                LocalDateTime.parse("2020.02.15-11:00:00",formatter1));
        Assignment assignment3=new Assignment("Cherny op.17",
                "Student will have to perform Cherny op.17 in order "
                + "to be examined on piano technic", 
                LocalDateTime.parse("2020.01.20-12:00:00",formatter1));
        Assignment assignment4=new Assignment("Toccata 914 BWV J.S.Bach",
                "Student will have to perform  Toccata 914 BWV  in order "
                + "to be examined in Baroque style", 
                LocalDateTime.parse("2020.01.05-13:00:00",formatter1));
        Assignment assignment5=new Assignment("Take The A Train",
                "Student will have to perform Take The A Train as Jazz Standard",
                LocalDateTime.parse("2020.01.14-14:00:00",formatter1));
        Assignment assignment6=new Assignment("Jazz Guitar Scales",
                "Student will have to perform all Jazz scales in order "
                + "to be examines in jazz technical and theoritical knowledge",
                LocalDateTime.parse("2020.01.25-15:00:00",formatter1));
        Assignment assignment7=new Assignment("Browen Etudes",
                "Student will have to perform Browen Etudes in order "
                + "to be examined on guitar technic", 
                LocalDateTime.parse("2020.01.15-16:00:00",formatter1));
        Assignment assignment8=new Assignment("BWV 917 J.S.Bach",
                "Student will have to perform  Toccata 914 BMW 017  in order "
                + "to be examined in Baroque style", 
                LocalDateTime.parse("2020.01.14-17:00:00",formatter1));
        assignments.add(0,assignment1);
        assignments.add(1,assignment2);
        assignments.add(2,assignment3);
        assignments.add(3,assignment4);
        assignments.add(4,assignment5);
        assignments.add(5,assignment6);
        assignments.add(6,assignment7);
        assignments.add(7,assignment8);
        return assignments;
    }
    
    //STUDENTS PER COURSE
    //Piano Jazz Fulltime
    public ArrayList<Student> studentsPianoJF(){ 
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsPianoJF=new ArrayList<Student>();
        studentsPianoJF.add(0,students.get(4));
        studentsPianoJF.add(1,students.get(9));
        return studentsPianoJF;
    }
    //Piano Jazz Parttime
    public ArrayList<Student> studentsPianoJP(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsPianoJP=new ArrayList<Student>();
        studentsPianoJP.add(0,students.get(3));
        studentsPianoJP.add(1,students.get(6));
        studentsPianoJP.add(2,students.get(0));
        return studentsPianoJP;
    }
    //Piano Classic Fulltime
    public ArrayList<Student> studentsPianoCF(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsPianoCF=new ArrayList<Student>();
        studentsPianoCF.add(0,students.get(2));
        studentsPianoCF.add(1,students.get(7));
        return studentsPianoCF;
    }
    //Piano Classic Parttime
    public ArrayList<Student> studentsPianoCP(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsPianoCP=new ArrayList<Student>();
        studentsPianoCP.add(0,students.get(1));
        studentsPianoCP.add(1,students.get(5));
        return studentsPianoCP;
    }
    // Guitar Jazz Fulltime
    public ArrayList<Student> studentsGuitarJF(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsGuitarJF=new ArrayList<Student>();
        studentsGuitarJF.add(0,students.get(3));
        studentsGuitarJF.add(1,students.get(6));
        return studentsGuitarJF;
    }
    // Guitar Classic Fulltime
    public ArrayList<Student> studentsGuitarCF(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsGuitarCF=new ArrayList<Student>();
        studentsGuitarCF.add(0,students.get(0));
        studentsGuitarCF.add(1,students.get(8));
        return studentsGuitarCF;
    }
    // Guitar Classic Parttime
    public ArrayList<Student> studentsGuitarCP(){
        ArrayList<Student> students=this.studentsArr();
        ArrayList<Student> studentsGuitarCP=new ArrayList<Student>();
        studentsGuitarCP.add(0,students.get(1));
        studentsGuitarCP.add(1,students.get(5));
        studentsGuitarCP.add(2,students.get(7));
        return studentsGuitarCP;
    }
    
    //TRAINERS PER COURSE
    //Piano Jazz Fulltime
    public ArrayList<Trainer> trainersPianoJF(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersPianoJF=new ArrayList<Trainer>();
        trainersPianoJF.add(0,trainers.get(1));
        trainersPianoJF.add(1,trainers.get(2));
        return trainersPianoJF;
    }
    //Piano Jazz Parttime
    public ArrayList<Trainer> trainersPianoJP(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersPianoJP=new ArrayList<Trainer>();
        trainersPianoJP.add(0,trainers.get(1));
        trainersPianoJP.add(1,trainers.get(2));
        return trainersPianoJP;
    }
    //Piano Classic Parttime
    public ArrayList<Trainer> trainersPianoCP(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersPianoCP=new ArrayList<Trainer>();
        trainersPianoCP.add(0,trainers.get(1));
        trainersPianoCP.add(1,trainers.get(4));
        return trainersPianoCP;
    }
    //Piano Classic Fulltime
    public ArrayList<Trainer> trainersPianoFP(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersPianoFP=new ArrayList<Trainer>();
        trainersPianoFP.add(0,trainers.get(1));
        trainersPianoFP.add(1,trainers.get(4));
        return trainersPianoFP;
    }
    // Guitar Jazz Fulltime
    public ArrayList<Trainer> trainersGuitarJF(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersGuitarJF=new ArrayList<Trainer>();
        trainersGuitarJF.add(0,trainers.get(5));
        trainersGuitarJF.add(1,trainers.get(6));
        return trainersGuitarJF;
    }
    // Guitar Classic Fulltime
    public ArrayList<Trainer> trainersGuitarCF(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersGuitarCF=new ArrayList<Trainer>();
        trainersGuitarCF.add(0,trainers.get(3));
        trainersGuitarCF.add(2,trainers.get(7));
        return trainersGuitarCF;
    }
    // Guitar Classic Parttime
    public ArrayList<Trainer> trainersGuitarCP(){
        ArrayList<Trainer> trainers=this.trainersArr();
        ArrayList<Trainer> trainersGuitarCP=new ArrayList<Trainer>();
        trainersGuitarCP.add(0,trainers.get(3));
        trainersGuitarCP.add(0,trainers.get(6));
        trainersGuitarCP.add(2,trainers.get(7));
        return trainersGuitarCP;
    } 
    
    //ASSIGNMENTS PER COURSE
    //Piano Jazz Fulltime and Parttime
    public ArrayList<Assignment> assignmentsPianoJFP(){
        ArrayList<Assignment> assignments = this.assignmentsArr();
        ArrayList<Assignment> assignmentsPianoJFP=new ArrayList<Assignment>();
        assignmentsPianoJFP.add(0,assignments.get(0));
        assignmentsPianoJFP.add(1,assignments.get(1));
        return assignmentsPianoJFP;
    }
    //Piano Classic Fulltime and Parttime
    public ArrayList<Assignment> assignmentsPianoCFP(){
        ArrayList<Assignment> assignments = this.assignmentsArr();
        ArrayList<Assignment> assignmentsPianoCFP=new ArrayList<Assignment>();
        assignmentsPianoCFP.add(0,assignments.get(2));
        assignmentsPianoCFP.add(1,assignments.get(3));
        return assignmentsPianoCFP;
    }
    //GUitar Jazz Fulltime
    public ArrayList<Assignment> assignmentsGuitarJF(){
        ArrayList<Assignment> assignments = this.assignmentsArr();
        ArrayList<Assignment> assignmentsGuitarJF=new ArrayList<Assignment>();
        assignmentsGuitarJF.add(0,assignments.get(4));
        assignmentsGuitarJF.add(1,assignments.get(5));
        return assignmentsGuitarJF;
    }
    //GUitar Classic Fulltime and Parttime
    public ArrayList<Assignment> assignmentsGuitarCFP(){
        ArrayList<Assignment> assignments = this.assignmentsArr();
        ArrayList<Assignment> assignmentsGuitarCFP=new ArrayList<Assignment>();
        assignmentsGuitarCFP.add(0,assignments.get(6));
        assignmentsGuitarCFP.add(1,assignments.get(7));
        return assignmentsGuitarCFP;
    }
    
    //Courses Synthetic Data
    public ArrayList<Course> coursesArr(){
        // Builds Course ArrayList
        ArrayList<Course> courses=new ArrayList<Course>();
        Course course1=new Course("Piano","Jazz","Full Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter),
                this.trainersPianoJF(),this.assignmentsPianoJFP(),this.studentsPianoJF());
        Course course2=new Course("Piano","Jazz","Part Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter),
                this.trainersPianoJF(), this.assignmentsPianoJFP(),this.studentsPianoJP());
        Course course3=new Course("Piano","Classic","Full Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter),
                this.trainersPianoJF(),assignmentsPianoCFP(),this.studentsPianoCF());
        Course course4=new Course("Piano","Classic","Part Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter),
                this.trainersPianoJF(),assignmentsPianoCFP(),this.studentsPianoCP());
        Course course5=new Course("Guitar","Jazz","Full Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter),
                this.trainersPianoJF(),assignmentsGuitarJF(),this.studentsGuitarJF());
        Course course6=new Course("Guitar","Classic","Full Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter),
                this.trainersPianoJF(),assignmentsGuitarCFP(),this.studentsGuitarCF());
        Course course7=new Course("Guitar","Classic","Part Time",
                LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter),
                this.trainersPianoJF(),assignmentsGuitarCFP(),this.studentsGuitarCP());
        
        courses.add(0,course1);
        courses.add(1,course2);
        courses.add(2,course3);
        courses.add(3,course4);
        courses.add(4,course5);
        courses.add(5,course6);
        courses.add(6,course7);
        return courses;
    }
 
}

