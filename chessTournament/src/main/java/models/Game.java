package models;
import Interfaces.IGame;

public class Game extends Naming implements IGame{
    private Player[] players;
    
    public Game(){
        System.out.println("Game 1");
    }
    
    public Game(String name){
        this.setName(name);
        System.out.println(this.getName());
    }
    
    public Game(String name,Player[] players){
        this.setName(name);
        this.start(players);
    }
    
    public void start(Player[] players){
        System.out.println("\n" + this.getName()+ "\n");
        System.out.println("Player "+ players[0]+" plays against Player "+ players[1] + "\n");
        this.players=players;
        this.playersMove(players, new Clock(600));
    }

    public void playersMove(Player[] players, Clock c) {
        // Player X plays move m against Player Y
        // 15" * 4 = 1' * 10 = 10' == 600"
        // 600" = 40 cycles, 20 cycles
        System.out.println("Game Starts!" + c.timeLeft(c.timer) + "\n");
        for (int i = 0; i < 20; i++) {
            System.out.println("Player " + players[0] + " plays move " +
                        players[0].moves(this) + " against Player " + players[1] +
                        "\n" + "Player " + players[1] + " plays move " +
                        players[1].moves(this) + " against Player " + players[0]);
            c.timer -= 30;
            System.out.println(c.timeLeft(c.timer));
        }
    }
}
