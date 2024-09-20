import java.util.*;
import java.io.*;

public class Product implements Serializable {
    private double price;
    private int quantity;
    private String name;
    
    //constructor
    public Product() {
        this.name = "";
        this.quantity = 0;
        this.price = 0.00;
    }
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    
    public int getQuantity(){
        return quantity;
    }
    
    public double getPrice(){
        return price;
    }
}