package cmdutils;

import Interfaces.ICustomerCmdUtils;
import java.util.Scanner;



public class Customer implements ICustomerCmdUtils {
    String f_name;
    String l_name;
    String tel;
    String email;

    public Customer(String f_name, String l_name, String tel, String email) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.tel = tel;
        this.email = email;
    }
    

    @Override
    public models.Customer askData() {
        Command cmd=new Command();
        models.Customer customer=new models.Customer();
        
        //first_name,last_name,tel_mail
        customer.setFirstName(cmd.getAttribute(f_name));
        customer.setLastName(cmd.getAttribute(l_name));
        customer.setTel(cmd.getAttribute(tel));
        customer.setEmail(cmd.getAttribute(email));
        
        return(customer);
    }

    
}
