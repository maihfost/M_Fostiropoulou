/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pcedu.blackbooks.security.payload.request;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author maihf
 */
public class LoginRequest {
    //@NotBlank
    private String username;
    //@NotBlank
    private String Password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return Password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    
    
    
    
}
