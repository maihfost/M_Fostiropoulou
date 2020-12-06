package dbutils;

import cmdutils.Command;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import models.Customer;
import models.Product;
import models.ProductDTO;
import java.util.ArrayList;
import java.util.List;


public class Database {
    public String server;
    public String username;
    public String password;
    public String database;
    
    
    Connection con;
    Statement statement;
    PreparedStatement prStatement;
    ResultSet rs;
    
    public Database(){
        
        
        database="eshop1";
        server="jdbc:mysql://172.17.0.2:3306/" + database + "?useSSL=false&serverTimeZone=Europe/Athens";
        username="root";
        password="lala1234";
        
        try {
            con=DriverManager.getConnection(server, username, password);
            System.out.println("Connected");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Connection is not established");
        }
    }
    
    
    //insert into customers
    
    public int insertCustomer(Customer c,String tableName){
        int result=0;
        //INSERT INTO `customers` (first_name,last_name,tel,email) VALUES ("Tom","Hanks","25861285","tHanks@hotmil.com");
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("`"); sb.append (tableName); sb.append("`");
        sb.append("(first_name,last_name,tel,email)");
        sb.append(" VALUES (");
        sb.append("\""); sb.append(c.getFirstName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(c.getLastName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(c.getTel()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(c.getEmail()); sb.append("\"");
        sb.append(")");
        
        try {
            statement = con.createStatement();
            result=statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return(result);
    }

    public int insertProduct(Product p,String tableName){
        int result=0;
        //INSERT INTO `products` (name,price,quantity) VALUES (Natura NightCream,30.9,2);
        StringBuilder sb=new StringBuilder();
        sb.append("INSERT INTO ");
        sb.append("`"); sb.append (tableName); sb.append("`");
        sb.append(" (name,price,quantity)");
        sb.append(" VALUES (");
        sb.append("\""); sb.append(p.getName()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(p.getPrice()); sb.append("\""); sb.append(",");
        sb.append("\""); sb.append(p.getQuantity()); sb.append("\"");
        sb.append(")");
        System.out.println(sb.toString());
        try {
            statement = con.createStatement();
            result=statement.executeUpdate(sb.toString());
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return(result);
    }
//    
//    public int insertOrder(Scanner sc) {
//        int result = 0;
//        
//        /*  
//            Step    1 - Select customer 
//                    1.1 SELECT * FROM customers
//                    1.2 PRINT customers
//                    1.3 From cmd choose customer
//            Step    2 - Select products
//                    2.1 SELECT * FROM products
//                    2.2 PRINT products
//                    2.3 From cmd choose product
//            Step    3 - Sum products
//            Step    4 - insertOrder()
//            Step    5 - insertProducts()
//        */
//        int customerId = selectCustomer(sc);
//        List<ProductDTO> productIdsQuantities=selectProducts(sc);
//        System.out.println(productIdsQuantities);
//        
//        //sum product prices(List<ProductDTO>)
//        double total_price=sumProductsPrice(productIdsQuantities);
//        
//        addOrder(customerId,total_price,"orders2");
//        
//        for (ProductDTO product: productIdsQuantities){
//        insertOrderDetails(product);
//        }
//        
//        return(result);
//    }
//    
//    public void insertOrderDetails(ProductDTO productDTO){
//    //Homework
//    
//    //Step1.select id of last order
//    //for loop in product_list of order2        
//    //INSERT INTO (order2_id,product_id,price,quantity)
//    
//    
//      int order2_id= selectOrder2_id();
//      addOrderDetails(order2_id,productDTO);
//        
//        
//     }
//       
//    public int addOrder(int customerId,double total_price,String tableName){
//        int result=0;
//        StringBuilder sb=new StringBuilder();
//        sb.append("INSERT INTO ");
//        sb.append("`"); sb.append (tableName); sb.append("`");
//        sb.append("(Column1,costumers_id,total_price)");
//        sb.append(" VALUES (");
//        sb.append("\""); sb.append(LocalDate.now()); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(customerId); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(total_price); sb.append("\"");
//        sb.append(")");
//        System.out.println(sb.toString());
//        try {
//            statement = con.createStatement();
//            result=statement.executeUpdate(sb.toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//            
//            }
//        return (result);
//    }
//    
//    public int addOrderDetails(int order2_id,ProductDTO productDTO){
//        int result=0;
//        StringBuilder sb=new StringBuilder();
//        sb.append("INSERT INTO ");
//        sb.append("`"); sb.append ("orders2_details"); sb.append("`");
//        sb.append("(orders2_id,products_id,price,quantity)");
//        sb.append(" VALUES (");
//        sb.append("\""); sb.append(order2_id); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(productDTO.getProductId()); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(productDTO.getPrice()); sb.append("\""); sb.append(",");
//        sb.append("\""); sb.append(productDTO.getQuantity()); sb.append("\"");
//        sb.append(")");
//        System.out.println(sb.toString());
//        try {
//            statement = con.createStatement();
//            result=statement.executeUpdate(sb.toString());
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//            
//            }
//        return (result);
//    }
//   
//    public int selectCustomer(Scanner sc) {
//        int customerId = -1;
//        Command cmd = new Command();
//        
//        ResultSet rs;
//        try {
//            statement = con.createStatement();
//            rs = statement.executeQuery("SELECT * FROM customers");
//            while(rs.next()) {
//                System.out.println(rs.getString("id") + ". " +
//                                   rs.getString("first_name") + " " +
//                                   rs.getString("last_name"));
//            }
//            // we should check that the returned Id is valid
//            customerId = cmd.getIntAttribute(sc, "Please select the customer");
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return(customerId);
//    }
//    
//    public List<ProductDTO> selectProducts(Scanner sc) {
//        
//        List<ProductDTO> productIdsQuantities = new ArrayList<>();
//        
//        Command cmd = new Command();
//        
//        
//        try {
//            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs = statement.executeQuery("SELECT * FROM products");
//            System.out.println("Our products: ");
//            while(rs.next()) {
//                System.out.println(rs.getString("id") + ". " +
//                                   rs.getString("name"));
//            }
//            
//            
//            while (cmd.getIntAttribute(sc, " Would you like to buy product?If yes, press 0") == 0){
//                
//                int prId=cmd.getIntAttribute(sc, "Please select the product number");
//                int quant=cmd.getIntAttribute(sc, "Please type the quantity of previous product with id " +prId);
//                rs.absolute(prId);//cursor shows at the row number prId(which here is the same with Id ,but in general it's not a right think to do cause a row may have been deleted
//                productIdsQuantities.add(new ProductDTO(prId,quant,rs.getDouble("price")));   
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return(productIdsQuantities);
//    }
//    
//    public double sumProductsPrice(List<ProductDTO> products){
//        double result=0;
//        for (ProductDTO product : products){
//            result += product.getPrice()*product.getQuantity();
//        }
//        return(result);
//    }
//    
//    public int selectOrder2_id(){
//        int orderId=0;
//        try {
//            statement=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
//            rs=statement.executeQuery("SELECT id FROM orders2 ORDER BY id DESC");
//            while (rs.next()){
//                if (rs.isFirst()){
//                    orderId=rs.getInt("id");
//                }
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return(orderId);
//    }
}

