package models;
import java.util.List;
import java.util.ArrayList;
import Interfaces.ITournament;

public class Tournament extends Naming implements ITournament{
    private Game [] games;   //{new Game("Game1"),new Game("Game2"),new Game("Game3")};
    private List<Player> players=new ArrayList<Player>(); //POlymorphism 
    
    public Tournament(){
        System.out.println("Welcome to the Ultimate Chess Tournament 2020");
    }

    public Tournament(String name){
        this.setName(name);
        this.startTournament();
    }
    
    public void introducePlayers(List<Player> players){
        System.out.print(this.getName() + "introduces: ");
        players.add(new Player("Paspa"));
        
        System.out.print(this.getName() + "introduces: ");
        players.add(new Player("Gasparov"));
        
        System.out.print(this.getName() + "introduces: ");
        players.add(new Player("Karpov"));
        
        System.out.print(this.getName() + "introduces: ");
        players.add(new Player("Medved"));
    }
    
    public void startTournament(){
        System.out.println("Welcome to the "+ this.getName() + "\n");
        introducePlayers(players);
        games= new Game [] {new Game("Game1",new Player[] {players.get(0),players.get(1)}),
                            new Game("Game2",new Player[] {players.get(0),players.get(2)}),
                            new Game("Game3",new Player[] {players.get(0),players.get(3)})};
    }
    
    
}
