/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cmdutils.Command;
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
@WebServlet(name = "Costumer", urlPatterns = {"/Costumer", "/cust"})
public class Costumer extends HttpServlet {


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
            out.println("<h4>Insert Costumer Personal Details</h4>");
            out.println("<div>\n" +
                "            <form name=\"customer\" method=\"POST\" action=\"/WebEshop/cust\">\n" +
                "                <label>Name<input type=\"text\" name=\"firstName\" value=\"\" /><label/><br>\n" +
                "                <label>Last Name<input type=\"text\" name=\"lastName\" value=\"\" /><label/><br>\n" +
                "                <label>Telephone<input type=\"text\" name=\"tel\" value=\"\" /><label/><br>\n" +
                "                <label>Email<input type=\"email\" name=\"email\" value=\"\" /><label/><br>\n" +
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
            String fn=request.getParameter("firstname");
            String ln=request.getParameter("lastname");
            String tel=request.getParameter("tel");
            String email=request.getParameter("email");
            models.Customer customer=new models.Customer(fn,ln,tel,email);
            out.println(database.insertCustomer(customer, "customers"));
            out.println("</body>");
            out.println("</html>");
        }
    }

}
