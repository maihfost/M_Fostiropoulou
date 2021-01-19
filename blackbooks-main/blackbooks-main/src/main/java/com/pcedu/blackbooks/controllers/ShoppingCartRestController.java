package com.pcedu.blackbooks.controllers;

import com.pcedu.blackbooks.entities.ShoppingCart;
import com.pcedu.blackbooks.entities.ShoppingCartDetail;
import com.pcedu.blackbooks.entities.dto.ShoppingCartDTO;
import com.pcedu.blackbooks.log.LoggedUser;
import com.pcedu.blackbooks.services.UserDetailsImpl;
import com.pcedu.blackbooks.services.interfaces.IBookService;
import com.pcedu.blackbooks.services.interfaces.IPaymentService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartDetailService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartService;
import com.pcedu.blackbooks.services.interfaces.IUserService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/cart"})
public class ShoppingCartRestController {

    @Autowired
    IShoppingCartService cartService;
    
    @Autowired
    IShoppingCartDetailService detailService;
    
    @Autowired
    IPaymentService paymentService;
    
    @Autowired
    IBookService bookService;
    
    @Autowired 
    IUserService userService;
    
    //UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    //int userIdd = userDetails.getId();
    
    private static boolean exist;

    @CrossOrigin
    @GetMapping("/id/{ids}")
    public List<ShoppingCartDTO> showShoppingCart(@PathVariable List<Integer> ids) {
        List<ShoppingCartDTO> carts = new ArrayList<>();
        for (Integer id : ids) carts.add(cartService.findByIdDTO(id));
        return (carts);
    }
    
    @CrossOrigin
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('user')")
    public List<ShoppingCartDTO> showShoppingCarts() {
        return (cartService.findAll());
    }
    
    @CrossOrigin
    @GetMapping("/all/user/{userId}")
    @PreAuthorize("hasAuthority('admin')")
    public List<ShoppingCartDTO> showShoppingCartsByUser(@PathVariable int userId) {
        return (cartService.findAllByUser(userId));
    }
    
    @CrossOrigin
    @GetMapping("/cartdetail/{cartDetailId}")//auth?
    public ShoppingCartDTO showShoppingCartByShoppingCartDetail(@PathVariable int cartDetailId){
        return(cartService.findByShoppingCartDetail(detailService.findById(cartDetailId)));
    }
    
    @CrossOrigin
    @GetMapping("/payment/{paymentId}")
    @PreAuthorize("hasAuthority('user')")
    public ShoppingCartDTO showShoppingCartByPayment(@PathVariable int paymentId){
        return(cartService.findByPayment(paymentService.findById(paymentId)));
    }
    
    @Transactional
    @CrossOrigin
    @PostMapping("/addtocart/{bookId}/{quantity}")
    public ResponseEntity addItemToCart(@PathVariable int bookId, @PathVariable int quantity){
        if(!exist){ 
            ShoppingCart cart = new ShoppingCart();
            cart.setDateTime(new Date());
            cart.setUserId(userService.findByUserName(LoggedUser.get()));
            cartService.save(cart);
            exist = true;
        }
        List<ShoppingCart> carts = cartService.findAllByUserDesc(userService.findByUserName(LoggedUser.get()).getId());
        ShoppingCartDetail detail = new ShoppingCartDetail();
        detail.setBookId(bookService.findById(bookId));
        detail.setQuantity(quantity);
        detail.setPrice(bookService.findById(bookId).getRegularPrice());
        detail.setShoppingCartId(carts.get(0));
        detailService.save(detail);
        return(new ResponseEntity(carts.get(0), HttpStatus.ACCEPTED));
    }
    
    @CrossOrigin
    @DeleteMapping("/deletefromcart/{cartDetailId}")
    public ResponseEntity deleteItemFromCart (@PathVariable int cartDetailId){
        ShoppingCartDetail detail = detailService.findById(cartDetailId);
        if(detail != null){
            detailService.delete(detail);
            return (new ResponseEntity(HttpStatus.ACCEPTED));
        }
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    @Transactional
    @CrossOrigin
    @PutMapping("/updatecart/{cartDetailId}/{quantity}")
    public ResponseEntity updateItemFromCart(@PathVariable int cartDetailId, @PathVariable int quantity){
        ShoppingCartDetail detail = detailService.findById(cartDetailId);
        if(quantity == 0) {
            if(detail != null){
                detailService.delete(detail);
                return (new ResponseEntity(HttpStatus.ACCEPTED));
            }
        }
        detail.setQuantity(quantity);
        if(detailService.update(detail)) return (new ResponseEntity(HttpStatus.ACCEPTED));
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));    
    }
        
    @Transactional
    @CrossOrigin
    @PostMapping("/submitorder/{cartId}")//auth user?
    @PreAuthorize("hasAuthority('user')")
    public ResponseEntity submitOrder(@PathVariable int cartId){
        if(LoggedUser.get() != null){
            ShoppingCart cart = cartService.findById(cartId);
            cart.setDateTime(new Date());
            cart.setIsPaid(Boolean.FALSE);
            cartService.update(cart);
            exist = false;
            return(new ResponseEntity(cart, HttpStatus.ACCEPTED));
        }else return(new ResponseEntity(HttpStatus.NOT_FOUND));
    }
  
    @CrossOrigin
    @DeleteMapping("/delete/{cartId}")//auth?
    public ResponseEntity deleteOrder (@PathVariable int cartId){
        ShoppingCart tempCart = cartService.findById(cartId);
        if(tempCart != null){
            cartService.delete(tempCart);
            return (new ResponseEntity(HttpStatus.ACCEPTED));
        }
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
}