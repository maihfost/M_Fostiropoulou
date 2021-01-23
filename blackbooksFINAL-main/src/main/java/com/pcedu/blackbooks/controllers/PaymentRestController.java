package com.pcedu.blackbooks.controllers;

import com.pcedu.blackbooks.entities.Book;
import com.pcedu.blackbooks.entities.Payment;
import com.pcedu.blackbooks.entities.ShoppingCartDetail;
import com.pcedu.blackbooks.entities.dto.PaymentDTO;
import com.pcedu.blackbooks.services.interfaces.IBookService;
import com.pcedu.blackbooks.services.interfaces.IPaymentService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartDetailService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/payment"})
public class PaymentRestController {

    @Autowired
    IPaymentService paymentService;

    @Autowired
    IShoppingCartService shoppingCartService;
    
    @Autowired
    IShoppingCartDetailService cartDetailService;
    
    @Autowired
    IBookService bookService;

    @CrossOrigin
    @GetMapping("/id/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public PaymentDTO showPayment(@PathVariable int id) {
        return(paymentService.findByIdDTO(id));
    }
    
    @CrossOrigin
    @GetMapping("/ids/{ids}")
    @PreAuthorize("hasAuthority('admin')")
    public List<PaymentDTO> showListPayment(@PathVariable List<Integer> ids) {
        List<PaymentDTO> payments = new ArrayList<>();
        for (Integer id : ids) payments.add(paymentService.findByIdDTO(id));
        return (payments);
    }

    @CrossOrigin
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<PaymentDTO> showPayments() {
        return (paymentService.findAll());
    }
    
    @CrossOrigin
    @GetMapping("/all/date/{date}")
    @PreAuthorize("hasAuthority('admin')")
    public List<PaymentDTO> showPaymentsByDate(@PathVariable Date date){
        return(paymentService.findAllByDate(date)); 
    }
    
    @CrossOrigin
    @GetMapping("/all/cart/{cartId}")
    @PreAuthorize("hasAuthority('admin')")
    public List<PaymentDTO> showPaymentsByCart(@PathVariable int cartId){
        return(paymentService.findAllByCart(cartId));
    }
    
    @CrossOrigin
    @PostMapping("/new/{cartId}")
    @PreAuthorize("hasAuthority('user')")
    public ResponseEntity createNewPayment(@PathVariable int cartId){
        if(!shoppingCartService.findById(cartId).getIsPaid()){
            Payment payment = new Payment();
            payment.setDateTime(new Date());
            payment.setShoppingCartId(shoppingCartService.findById(cartId));
            payment.getShoppingCartId().setIsPaid(Boolean.TRUE);
            shoppingCartService.update(payment.getShoppingCartId());
            paymentService.save(payment);
            //getting books that just got paid!
            List<ShoppingCartDetail> details = cartDetailService.findAllByShoppingCart(cartId);
            List<Book> books = new ArrayList<>();
            for (ShoppingCartDetail detail : details) {
                books.add(detail.getBookId());
            }
            return (new ResponseEntity(books, HttpStatus.CREATED));
        }else return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }    
    
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('admin')")
    public ResponseEntity deletePayment(@PathVariable int id){
        Payment tempPayment = paymentService.findById(id);
        if(tempPayment != null){
            paymentService.delete(tempPayment);
            return (new ResponseEntity(HttpStatus.ACCEPTED));
        }
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
}
