

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Max_value {
    
    
    static void max(ArrayList<Integer> list) {
        int maxv=list.get(0);
    
        for (int i=1 ;i < list.size(); i++) {
            if (list.get(i)>maxv){
                maxv=list.get(i);
            }
        }
        System.out.println("The max value is : " + maxv);
    }
    
    public static void main(String[] args) {
        
        int max=0;
        Scanner sc= new Scanner(System.in);
        ArrayList<Integer> list= new ArrayList<Integer>();
        
        System.out.println("Enter 5 positive numbers that you want to compare, in order to find the max value: ");
        
        for (int i=0;i<5;i++){
            list.add(i,sc.nextInt());
            if (list.get(i)<0){
                System.out.println("Give a positive number");
                list.add(i,sc.nextInt());
            }
        }
        
        long t1=System.nanoTime();
        max(list);
        long t2=System.nanoTime();
        
        Collections.sort(list);
        System.out.println("The max value is : " + list.get(list.size()-1));
        long t3=System.nanoTime();
        
        long timeFor=t2-t1;
        long timeSort=t3-t2;
        System.out.println("Execute time for Forloop : " + timeFor);
        System.out.println("Execute time for Sort : " + timeSort);
    }
    
}
