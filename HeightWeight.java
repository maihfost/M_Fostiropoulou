/*Write a simple program where:
• Height is a variable named ht
• Weight is a variable wg
• BMI is calculated based on the formula:
BMI = wg / (ht * ht)
• The BMI is then evaluated as:
Underweight = <18.5
Normal weight = 18.5–24.9
Overweight = 25–29.9
Obesity = BMI of 30 or greater
*/

//package heightweight;

import java.util.Scanner;

public class HeightWeight {

    static float bmi(float x,float y){
        return y/(x*x);
    }
   

    
    public static void main(String[] args) {
        float ht;
        float wg;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("This code will calculate your BMI. Enter your height and weight.");
        
        System.out.println("Height: ");
        ht=sc.nextFloat();
        System.out.println("Weight: ");
        wg=sc.nextFloat();
        
        System.out.println("Your BMI is: " + bmi(ht,wg) );
        
        if (bmi(ht,wg)>=30){
            System.out.println("Obesity!!");
        }
        
        else if (bmi(ht,wg)>=25){
            System.out.println("Overweight!!");
        }
        
        else if (bmi(ht,wg)>=18.5){
            System.out.println("Normal Weight");
        }
        else
            
            System.out.println("Underweight!!");
    }
    
}
