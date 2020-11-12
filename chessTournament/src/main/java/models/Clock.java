package models;
import Interfaces.IClock;

public class Clock extends Naming implements IClock{
    int timer;
    
    public Clock(int timer){
        this.timer=timer;
    }
    //Clock says that you have x min left before game ends
    public String timeLeft(float timer){
        if (timer==0.0f){
        return "End of the Game!";
        }
        else{
        String result;
        float min=timer/60;
        result = "Game ends in " + String.valueOf(min) + " minutes ";
        return result;
        }
    }
}
