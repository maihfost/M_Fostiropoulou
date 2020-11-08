//package exercise1;
//This is a program that asks the user to input a number between 1 and 10.
import java.util.Scanner;

public class Exercise1 {
    static String str="Please enter a number between 1 and 10 : ";
    
    public static void EnterNumber(){
        Scanner sc = new Scanner(System.in);
        float floatNumber=Exercise1.checkEntry(sc);
        while (!Exercise1.isValid(floatNumber)){
            System.out.println("This number is not between 1 and 10!"+ str);
            floatNumber=Exercise1.checkEntry(sc);
        }
        System.out.println("You typed a correct number " + floatNumber +  ". Thank you! Goodbye!");
    }
    
    public static boolean isValid(float number){
        return (number >=1 && number <= 10) ? true: false;
    }
    
    public static boolean isNumber(String s){
        int x=0;
        for (int i=0;i< s.length();i++){
            if (s.charAt(i)!='0' && s.charAt(i)!= '1' && s.charAt(i)!= '2'
               && s.charAt(i)!= '3' && s.charAt(i)!= '4' && s.charAt(i)!= '5' 
               && s.charAt(i)!= '6' && s.charAt(i)!= '7' && s.charAt(i)!='8' 
               && s.charAt(i)!= '9' && s.charAt(i)!='.') {
                x=1;
            }
        }
        if (x==1){
            return false;
        }
        else {
            return true;
        }    
    }
    
    public static float checkEntry(Scanner sc){
        String number=sc.next();
        while (Exercise1.isNumber(number)==false){
            System.out.println("This isn's a number!"+ str);
            number=sc.next();
        }
        return Float.parseFloat(number);
    }    

    public static void main(String[] args) {  
        System.out.println("Welcome! "+ str);
        Exercise1.EnterNumber();
    }
}        




