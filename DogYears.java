/* Write a program that will transform dog years to human years assuming that:
• 0 years is an impossible number
• The first two years of a dog’s life are equivalent of a humans in years
• Every further dog year corresponds to five years in the life of a human being
• A dog can’t be over 30 years old (in dog years)
*/

//package dogyears;

import java.util.Scanner;

public class DogYears {
        
    public static void main(String[] args) {
        int dogYears;
        int humanYears=0;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("How old is your dog?");
        dogYears= sc.nextInt();
        
        while (dogYears <= 0){
            System.out.println("It's an impossible number.Enter you dog's age: ");
            dogYears=sc.nextInt();
        }
        
        if (dogYears >= 30){
            System.out.println("It's a miracle!!");
            humanYears=((dogYears-2)*5)+2;
        }
        else {
            if (dogYears <= 2){
                humanYears = dogYears;
            }
            else 
                humanYears=((dogYears-2)*5)+2;
        }
        
        System.out.println("Your dog lives " + humanYears + " human years");

    }
}
