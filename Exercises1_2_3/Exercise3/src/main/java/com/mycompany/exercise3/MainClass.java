package com.mycompany.exercise3;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainClass {
    
    public static LocalDate EnterDate(Scanner sc){
        System.out.println("Date type example : 2020.05.03(YEAR.MONTH.DAY)");
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate ld = LocalDate.parse(sc.next(), formatter);
        return ld;
    }
    
    
    public static void main(String[] args) {
        BootCamp [] bootcamps=new BootCamp[3];
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome! You have to create 3 Bootcamp Programs"
                + "(Name/StartingDate/EndingDate). Let's Start!");
        
        for (int i=0;i<3;i++){
            System.out.println("Enter details for the " + (i+1)+ "st program");
            System.out.println("Name: ");
            String name=sc.next();
            System.out.println("Starting Date: ");
            LocalDate sd=MainClass.EnterDate(sc);
            System.out.println("Ending Date: ");
            LocalDate ed=MainClass.EnterDate(sc);
            bootcamps[i] =new BootCamp(name,sd,ed);
        }
        
        System.out.println("Enter a date, to check if there's an existing BootCamp:");
        LocalDate   searchOfDate=MainClass.EnterDate(sc);
        DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("d MMM uuuu");
        int x=0;
        for (BootCamp b:bootcamps){
            if (b.isAvailable(searchOfDate)==true){
                System.out.println("BootCamp "+ b.getName() + 
                " will be available in " + searchOfDate.format(formatter1) + ". It starts " +
                b.getStartingDate().format(formatter1) + " and ends " + b.getEndingDate().format(formatter1) + ".");            
            }
            else
                x++;
        }
        if (x==3){
            System.out.println("Sorry, no bootcamp available in " + searchOfDate.format(formatter1) + ".");
        }   
    }
}
