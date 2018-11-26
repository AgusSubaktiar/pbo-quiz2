/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Toshiba
 */
public class Item {
    private final String name;
    private final float price;
    private int qty;
    
    public Item(String name, float price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() {
        return this.name;
    }
    public float getPrice() {
        return this.price * this.qty;
    }
    
    public void setQty(int qty) {
        this.qty = qty;
    }
    public int getQty() {
        return this.qty;
    }
}
