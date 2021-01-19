package com.pcedu.blackbooks.controllers;

import com.pcedu.blackbooks.entities.ShoppingCart;
import com.pcedu.blackbooks.entities.ShoppingCartDetail;
import com.pcedu.blackbooks.entities.User;
import com.pcedu.blackbooks.log.LoggedUser;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartDetailService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartService;
import com.pcedu.blackbooks.services.interfaces.IUserService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/account"})
public class AccountRestController {

    @Autowired
    IUserService userService;
    
    @Autowired
    IShoppingCartDetailService detailService;
    
    @Autowired
    IShoppingCartService cartService;

    @Transactional
    @CrossOrigin
    @PutMapping("/login/{userName}")
    public ResponseEntity loggedInUser(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        if(user.getUserName() != null){
            LoggedUser.logIn(userName);
            user.setActive(Boolean.TRUE);
            userService.update(user);
            return(new ResponseEntity(userName, HttpStatus.OK));
        }
        return(new ResponseEntity( HttpStatus.BAD_REQUEST));    
    }
    
    //problem
    @Transactional
    @CrossOrigin
    @PutMapping("/logout")
    public ResponseEntity loggedOutUser(){
        User user = userService.findByUserName(LoggedUser.get());
        user.setActive(Boolean.FALSE);
        userService.update(user);
        LoggedUser.logOut();
        
        
        
//        LoggedUser.logIn(null);
        //shoppingCartDetails with no total_price after logOut must be deleted!
        List<ShoppingCart> carts = cartService.findAllByUserDesc(userService.findByUserName(LoggedUser.get()).getId());
       
        //i need date to be null to check. Must set date on submit
        if(carts.get(0).getTotalPrice().compareTo(BigDecimal.ZERO) == 0){
             // find details with cartId carts.get(0)
            detailService.findAllByShoppingCart(carts.get(0).getId());
            cartService.delete(carts.get(0));
        }
        
        for (ShoppingCartDetail detail : detailService.findAllShoppingCart()) {
            if(detail.getShoppingCartId().getId() == 0)  detailService.delete(detail);
        }
        return(new ResponseEntity(HttpStatus.OK));
    }
}
