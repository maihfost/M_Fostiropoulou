/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dbutils.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author maih_sofi
 */
@WebServlet(name = "Product", urlPatterns = {"/Product", "/prod"})
public class Product extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Insert Costumer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>Insert Product Details</h4>");
            out.println("<div>\n" +
                "            <form name=\"product\" method=\"POST\" action=\"/WebEshop/prod\">\n" +
                "                <label>Product name<input type=\"text\" name=\"name\" value=\"\" /><label/><br>\n" +
                "                <label>Price<input type=\"text\" name=\"price\" value=\"\" /><label/><br>\n" +
                "                <label>Quantity<input type=\"text\" name=\"quantity\" value=\"\" /><label/><br>\n" +
                "                <input type=\"submit\" value=\"submit\" name=\"submit\" />\n" +
                "            </form>\n" +
                "        </div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Costumer</title>");            
            out.println("</head>");
            out.println("<body>");
            Database database=new Database();
            String name=request.getParameter("name");
            double price=Double.parseDouble(request.getParameter("price"));
            int quantity=Integer.parseInt(request.getParameter("quantity"));
            models.Product product=new models.Product(name,price,quantity);
            out.println(database.insertProduct(product,"products"));
            out.println("</body>");
            out.println("</html>");
        }
    }

}
