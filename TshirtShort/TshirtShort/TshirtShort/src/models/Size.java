/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author maihf
 */
public enum Size {
    XS(1.0f),S(2.0f),M(3.0f),L(4.0f),XL(5.0f),XXL(6.0f),XXXL(7.0f);
    
    private final float unitPrice;
    
    Size (float unitPrice){
        this.unitPrice=unitPrice;
    }
    
    public float getUnitPrice() {
        return unitPrice;
    }
}
