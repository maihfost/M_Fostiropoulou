package cmdUtils;

import java.util.Scanner;


public class Trainer {
    private Scanner sc;

    public Trainer(Scanner sc) {
        this.sc = sc;
    }
    
    public models.Trainer askData(){
        models.Trainer trainer=new models.Trainer();
        Command cmd=new Command();
        
        trainer.setFirst_name(cmd.getStringAttribute(sc, "First Name :"));
        trainer.setLast_name(cmd.getStringAttribute(sc, "Last Name :"));
        
        return(trainer);
    }
    
}
