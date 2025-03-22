/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.spring23.shopping;

/**
 *
 * @author hd
 */
public class Product {
//    your code here
    
    private String productID;
    private String productName;
    private String description;
    private float price;
    private int status;
    
    public Product() {
    }

    public Product(String productID, String productName, String description, float price, int status) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.status = status;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

  
}

