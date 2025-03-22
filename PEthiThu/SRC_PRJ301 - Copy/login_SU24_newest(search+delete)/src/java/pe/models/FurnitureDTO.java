/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.models;

public class FurnitureDTO {
    private String id;
    private String name, description;
    private float price;
    private String dimensions;
    private String material;
    private boolean status;

    public FurnitureDTO() {
    }

    public FurnitureDTO(String id, String name, String description, float price, String dimesions, String material, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.dimensions = dimesions;
        this.material = material;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimesions) {
        this.dimensions = dimesions;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
