package com.mycompany.exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static boolean isPet(){
        Scanner scPet=new Scanner(System.in);
        boolean anyPet=false;
        boolean isAnswer=false;
        String answer="";
        
        while (isAnswer==false){
            if (answer.equals("Y")) {
                anyPet=true;
                isAnswer=true;
            }
            else if (answer.equals("N")){
                anyPet=false;
                isAnswer=true;
            }
            else{
                System.out.println("Any pets?(Y/N)");
                answer=scPet.next();
                isAnswer=false;
            }
        }
        return anyPet;
    }
    
    public static void main(String[] args) {
        System.out.println("Welcome! Please enter your family's members(at least 3)");
        ArrayList<Person> personsOfFamily=new ArrayList<Person> ();
        Scanner sc=new Scanner(System.in);
        int x=0; // counts family's members
        String key1="";
        
        while (!key1.equals("S")){
            x++;    
            System.out.println("Enter person's name : ");
            String personName=sc.next();
            while (Person.isName(personName)==false){
                System.out.println("This does not seem to be a name.Please enter a valid name : ");
                personName=sc.next();
            }
            System.out.println("Enter person's age : ");
            Byte personAge=sc.nextByte();
            if (MainClass.isPet() == false) {
                personsOfFamily.add(new Person(personName,personAge));
            }
            else{
                ArrayList<Pet> pets=new ArrayList<Pet> ();
                String key = "";
                while (!key.equals("S")) {
                    System.out.println("Type of Pet (dog, cat, turtle, rabbit,"
                            + " hamster, mouse, snake, spider, elephant, tiger,"
                            + " liger, bird, fish, monkey, chameleon): ");
                    String typePet=sc.next();
                    if (Pet.petTypeExists(typePet)==false){
                        System.out.println("Press C, if not then press S.");
                        key=sc.next();
                    }
                    else{
                    System.out.println("Nickname of Pet:");
                    String petNickname=sc.next();
                    pets.add(new Pet(petNickname,typePet));
                    System.out.println("More Pets? Press C, if not then press S.");
                    key=sc.next();
                    }
                }
                if (!pets.isEmpty()){
                    personsOfFamily.add(new Person(personName,personAge,pets));
                }
                else{
                    personsOfFamily.add(new Person(personName,personAge));
                }
            }
            if (personsOfFamily.size()<3){
                System.out.println("You have entered only " + x + " family member(s). Please enter " + (3-x) + " more.");
                key1="";
            }
            else {
                System.out.println("More Family members? Press C, if not then press S.");
                key1 = sc.next();
            }
        }    
       
        System.out.println("Your Family member's are:" ); 
        for (Person person:personsOfFamily){
                System.out.println(person.toString());
        }
    }
}
