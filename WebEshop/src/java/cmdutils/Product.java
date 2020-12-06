package cmdutils;

import Interfaces.IProductCmdUtils;
import java.util.Scanner;


public class Product implements IProductCmdUtils{
    Scanner sc;
    
    public Product(Scanner sc){
        this.sc=sc;
    }
    
    public models.Product askData(){
        models.Product product=new models.Product();
        Command cmd= new Command();
        
//        product.setName(cmd.getAttribute(sc,"Type product's name")  );
//        product.setPrice(cmd.getDoubleAttribute(sc,"Type product's price"));
//        product.setQuantity(cmd.getIntAttribute(sc,"Type product's quantity"));
        
        return(product);
    }

    

}
