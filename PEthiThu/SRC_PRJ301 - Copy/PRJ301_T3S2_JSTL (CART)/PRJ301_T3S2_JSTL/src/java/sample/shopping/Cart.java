/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.shopping;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Cart {
    private Map<String, Comestics> cart;

    public Cart(Map<String, Comestics> cart) {
        this.cart = cart;
    }
    public Cart() {
    }

    public Map<String, Comestics> getCart() {
        return cart;
    }

    public void setCart(Map<String, Comestics> cart) {
        this.cart = cart;
    }

    public boolean add(Comestics comestics) {
        boolean check = false;
        try {
            if (this.cart == null){
                this.cart = new HashMap<>();
            }
            if (this.cart.containsKey(comestics.getId())){
                int currentQuantity = this.cart.get(comestics.getId()).getQuantity();
                comestics.setQuantity(currentQuantity+ comestics.getQuantity());
            }
            this.cart.put(comestics.getId(), comestics);
            check = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return check;
    }

    public boolean remove(String id) {
       boolean check = false;
       try{
           if(this.cart!=null){
               if(this.cart.containsKey(id)){
                   this.cart.remove(id);
                   check=true;
               }
           }
       }catch(Exception e){
           
       }
       return check;
    }
    public boolean edit(String id, int quantity) {
        boolean check = false;
        try {
           this.cart.get(id).setQuantity(quantity);
           check=true;
        } catch (Exception e) {
        }
        
        return check;
    }
    
}
