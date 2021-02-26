/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.util.List;
import java.util.Scanner;
import models.Assignment;
import models.Course;
import models.Student;
import models.Trainer;
import models.TrainerCourse;

/**
 *
 * @author maih_sofi
 */
public interface IDatabase {
 
    //Select*from students
    public List<Integer> showListStudents();
    
    //Select*from courses
    public List<Integer> showListCourses();
    
    //Select f_name,l_name FROM trainers
    public List<TrainerCourse> showListTrainers();
    
    //Select title,description,subDate FROM assignments
    public void showListAssignments();
    
    //Select students per course
    public List<Integer> showListStudentsPerCourse(Scanner sc);
    
    //Select trainers per course
    public void showListTrainersPerCourse(Scanner sc);
    
    //Select assignments per course
    public void showListAssignmentsPerCourse(Scanner sc);
    
    //Select assignments per course per stoudent
    public void showListAssignmentsPerCoursePerStudent(Scanner sc);
    
    //Select courses per student
    public List<Integer> showListCoursesPerStudent(Scanner sc);
    
    //Select students with more than one courses
    public void showListStudentsWithMoreThanOneCourses();
    
    //INSERTS!!!
    
    //Insert into Students
    public int insertStudent(Student student);
    
    //Insert into Courses
    public int insertCourse(Course course);
    
    //Insert into Trainers
    public int insertTrainer(Trainer trainer);
    
    //Insert into Assignments
    public int insertAssignment(Assignment assignement);

    //Insert into students per course 
    public int insertStudentsToCourse(Scanner sc);
    
    //Insert into trainers per Course(course_id)
    public int insertTrainersToCourse(Scanner sc);
    
   //Insert into assignments per Student per Course(course_id)
    
}

