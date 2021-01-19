package com.pcedu.blackbooks.controllers;

import com.pcedu.blackbooks.entities.User;
import com.pcedu.blackbooks.entities.dto.UserDTO;
import com.pcedu.blackbooks.services.UserDetailsImpl;
import com.pcedu.blackbooks.services.interfaces.IReviewService;
import com.pcedu.blackbooks.services.interfaces.IRoleService;
import com.pcedu.blackbooks.services.interfaces.IShoppingCartService;
import com.pcedu.blackbooks.services.interfaces.IUserService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {"/api/user"})
public class UserRestController {

    @Autowired
    IUserService userService;
    
    @Autowired
    IRoleService roleService;
    
    @Autowired
    IReviewService reviewService;
    
    @Autowired
    IShoppingCartService shoppingCartService;
    
    @CrossOrigin
    @GetMapping("/id/{ids}")
    @PreAuthorize("hasAuthority('admin')")
    public List<UserDTO> showUser(@PathVariable List<Integer> ids) {
        List<UserDTO> users = new ArrayList<>();
        for (Integer id : ids) users.add(userService.findByIdDTO(id));
        return (users);
    }

    @CrossOrigin
    @GetMapping("/names/{firstName}/{lastName}")
    @PreAuthorize("hasAuthority('admin')")
    public List<UserDTO> showUserByNames(@PathVariable String firstName, @PathVariable String lastName) {
        return (userService.findByFirstLastNames(firstName, lastName));
    }
    
    @CrossOrigin
    @GetMapping("/username/{userName}")//auth?
    public UserDTO showUserByUserName(@PathVariable String userName) {
        return (userService.findByUserNameDTO(userName));
    }
    
    @CrossOrigin
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('admin')")
    public List<UserDTO> showUsers() {
        return (userService.findAll());
    }
    
    @CrossOrigin
    @GetMapping("/active")//auth
    public UserDTO showUserByShoppingCart(){
        return(userService.findActiveUser());
    }
    
    @CrossOrigin
    @GetMapping("/all/role/{roleId}")
    @PreAuthorize("hasAuthority('admin')")
    public List<UserDTO> showUsersByRole(@PathVariable int roleId){
        return(userService.findAllByRole(roleService.findById(roleId)));
        
    }
    
    @CrossOrigin
    @GetMapping("/review/{reviewId}")
    public UserDTO showUserByReview(@PathVariable int reviewId){
        return(userService.findAllByReview(reviewService.findById(reviewId)));
    }
    
    @CrossOrigin
    @GetMapping("/cart/{cartId}")
    @PreAuthorize("hasAuthority('admin')")
    public UserDTO showUserByShoppingCart(@PathVariable int cartId){
        return(userService.findByOrder(shoppingCartService.findById(cartId)));
    }
    
    @CrossOrigin
    @PostMapping("/register")//auto mallon de tha to kratisoume?
    public ResponseEntity createNewUser(@RequestBody User user){
        try{    
            userService.save(user);
            return (new ResponseEntity(user, HttpStatus.CREATED));
        }catch(Exception e) {
            return (new ResponseEntity(HttpStatus.NOT_ACCEPTABLE));
        }
    }
    
    @Transactional 
    @CrossOrigin
    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('user')")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User user){
        //User tempUser = updateCheck(user, userService.findById(id));
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User tempUser = userService.findByUserName(userDetails.getUsername());
        userService.update(tempUser);
        return (new ResponseEntity(HttpStatus.ACCEPTED));
        //return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('user')")
    public ResponseEntity deleteUser(@PathVariable int id){
        User tempUser = userService.findById(id);
        if(tempUser != null){
            userService.delete(tempUser);
            return (new ResponseEntity(HttpStatus.ACCEPTED));
        }
        return (new ResponseEntity(HttpStatus.BAD_REQUEST));
    }
    
    private User updateCheck(User user, User tempUser){
        if(user.getActive() != null) tempUser.setActive(user.getActive());
        if(user.getEmail() != null) tempUser.setEmail(user.getEmail());
        if(user.getUserName() != null) tempUser.setUserName(user.getUserName());
        if(user.getPassword() != null) tempUser.setPassword(user.getPassword());
        if(user.getFirstName() != null) tempUser.setFirstName(user.getFirstName());
        if(user.getLastName() != null) tempUser.setLastName(user.getLastName());
        if(user.getDateofbirth() != null) tempUser.setDateofbirth(user.getDateofbirth());
        if(user.getCountry() != null) tempUser.setCountry(user.getCountry());
        if(user.getTelephone() != null) tempUser.setTelephone(user.getTelephone());
        if(user.getTotalPaymentAmount() != null) tempUser.setTotalPaymentAmount(user.getTotalPaymentAmount());
        if(user.getDigitWallet() != null) tempUser.setDigitWallet(user.getDigitWallet());
        return(tempUser);
    }

}
