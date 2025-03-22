/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hd
 */
public class CART {
//    your code here

    private List<Item> items;

    public CART() {
        items = new ArrayList<>();
    }

    public CART(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItemByID(String id) {
        for (Item i : items) {
            if (i.getProduct().getProductID().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public int getQuantityByID(String id) {
        Item item = getItemByID(id);
        if (item != null) {
            return item.getQuantity();
        }
        return 0;
    }

    // add to cart
    public void addItem(Item item) {
        for (Item i : items) {
            if (i.getProduct().getProductID().equals(item.getProduct().getProductID())) {
                i.setQuantity(i.getQuantity() + item.getQuantity());
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(String id) {
        Item item = getItemByID(id);
        if (item != null) {
            items.remove(item);
        } 
    }

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += i.getQuantity() * i.getProduct().getPrice();
        }
        return t;
    }
}
