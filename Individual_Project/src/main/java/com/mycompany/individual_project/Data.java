package com.mycompany.individual_project;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Data {
    static DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy.MM.dd");
    
    public static ArrayList<Course> courseArr(){
        // Builds Course ArrayList
        ArrayList<Course> courses=new ArrayList<Course>();
        
        Course course1=new Course("Piano","Jazz","Full Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter));
        Course course2=new Course("Piano","Jazz","Part Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter));
        Course course3=new Course("Piano","Classic","Full Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter));
        Course course4=new Course("Piano","Classic","Part Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter));
        Course course5=new Course("Guitar","Jazz","Full Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter));
        Course course6=new Course("Guitar","Classic","Full Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.09.15",formatter));
        Course course7=new Course("Guitar","Classic","Part Time",LocalDate.parse("2020.09.15",formatter),LocalDate.parse("2021.02.15",formatter));
        
        courses.add(0,course1);
        courses.add(1,course2);
        courses.add(2,course3);
        courses.add(3,course4);
        courses.add(4,course5);
        courses.add(5,course6);
        courses.add(6,course7);
        
        
        return courses;
    }

        
    public ArrayList<Student> students(){
        ArrayList<Student> students= new ArrayList<Student>();
        Student student1=new Student("Nicolaos","Giannopoulos",LocalDate.parse("2004.09.15",formatter),1000);
        Student student2=new Student("Ioannis","Makris",LocalDate.parse("1997.11.02",formatter),1000);
        Student student3=new Student("Stamatia","Mixalopoulou",LocalDate.parse("1995.01.15",formatter),1000);
        Student student4=new Student("Konstantina","Evaggelatou",LocalDate.parse("28.08.1999",formatter),1000);
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
    
    //Piano Jazz Fulltime
    public ArrayList<Student> studentsPianoJF(ArrayList<Student> students){ 
        ArrayList<Student> studentsPianoJF=new ArrayList<Student>();
        studentsPianoJF.add(0,students.get(4));
        studentsPianoJF.add(0,students.get(9));
        studentsPianoJF.add(0,students.get(2));
        return studentsPianoJF;
    }
    //Piano Jazz Parttime
    public ArrayList<Student> studentsPianoJP(ArrayList<Student> students){
        ArrayList<Student> studentsPianoJP=new ArrayList<Student>();
        studentsPianoJP.add(0,students.get(3));
        studentsPianoJP.add(0,students.get(0));
        return studentsPianoJP;
    }
    //Piano Classic Fulltime
    public ArrayList<Student> studentsPianoCF(ArrayList<Student> students){
        ArrayList<Student> studentsPianoCF=new ArrayList<Student>();
        studentsPianoCF.add(0,students.get(7));
        studentsPianoCF.add(0,students.get(1));
        return studentsPianoCF;
    }
    //Piano Classic Parttime
    public ArrayList<Student> studentsPianoCP(ArrayList<Student> students){
        ArrayList<Student> studentsPianoCP=new ArrayList<Student>();
        studentsPianoCP.add(0,students.get(0));
        return studentsPianoCP;
    }
    
    // Guitar Jazz Fulltime
    public ArrayList<Student> studentsGuitarJF(ArrayList<Student> students){
        ArrayList<Student> studentsGuitarJF=new ArrayList<Student>();
        studentsGuitarJF.add(0,students.get(0));
        return studentsGuitarJF;
    }
    
    // Guitar Classic Fulltime
    public ArrayList<Student> studentsGuitarCF(ArrayList<Student> students){
        ArrayList<Student> studentsGuitarCF=new ArrayList<Student>();
        studentsGuitarCF.add(0,students.get(0));
        return studentsGuitarCF;
    }
    
    // Guitar Classic Parttime
    public ArrayList<Student> studentsGuitarCP(ArrayList<Student> students){
        ArrayList<Student> studentsGuitarCP=new ArrayList<Student>();
        studentsGuitarCP.add(0,students.get(0));
        return studentsGuitarCP;
    }
    
    //Trainers
    
    //Assignments
}
