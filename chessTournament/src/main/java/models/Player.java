package models;

import Interfaces.IPlayer;

public class Player extends Naming implements IPlayer{
    private int counter=0;
        
    public Player(String name){
         this.setName(name);
         System.out.println(this.getName());
    }
    
    public Player(String name,Game game){
         this.setName(name);
         System.out.println(this.getName());
    }
    
    /*
    In this method we need to figure out which move the player does
    */
    public String moves(Game game){
        counter+=1;
        String result;
        //result=Integer.toString(counter);
        if (counter>20){
            counter=1;
        }
        result=String.valueOf(counter);
        //result= counter + "";
        return (result);
    }
    
}
