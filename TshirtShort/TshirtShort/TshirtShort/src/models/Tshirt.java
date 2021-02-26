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
public class Tshirt {
    private String name;
    //enum {RED,YELLOW}; STHN 11 EPITREPETAI
    //Color size Fabric
    private Color color;
    private Size size;
    private Fabric fabric;

    public Tshirt() {
    }

    public Tshirt(String name, Color color, Size size, Fabric fabric) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.fabric = fabric;
    }

    public Fabric getFabric() {
        return fabric;
    }

    public void setFabric(Fabric fabric) {
        this.fabric = fabric;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tshirt{name=").append(name);
        sb.append(", color=").append(color);
        sb.append(", size=").append(size);
        sb.append(", fabric=").append(fabric);
        sb.append('}');
        return sb.toString();
    }
    
    
}
