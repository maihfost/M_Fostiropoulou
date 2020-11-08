package com.mycompany.exercise2;

import java.util.ArrayList;
import java.lang.Character;

public class Person {
    private String name;
    byte age;
    ArrayList<Pet> pets;
    
    Person(String name, byte age, ArrayList<Pet> pets){
        this.name=name;
        this.age=age;
        this.pets=pets;
    }
    
    Person(String name, byte age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return  name + " is " + age + " years old and his pets: " + pets ;
    }
    
    public static boolean isName(String validName){
        boolean isValidName=true;
        boolean isDigitInName=false;
        for(char i: validName.toCharArray()){
            isDigitInName=Character.isDigit(i);
            if (isDigitInName==true){
            isValidName=false;
            break;
            }
            else{ 
                isValidName=true;
            }
        }
        return isValidName;
    }

}
