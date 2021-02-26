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
public enum Fabric {
    WOOL(12f), COTTON(15f), POLYESTER(20f), RAYON(25f), LINEN(30f), CASHMERE(35f), SILK(40f);
    
    private final float unitPrice;
    
    Fabric (float unitPrice){
        this.unitPrice=unitPrice;
    }
    
    
    
    //Fabric (float unitPrice,String country){
        //this.unitPrice=unitPrice;
    //}

    public float getUnitPrice() {
        return unitPrice;
    }

}
