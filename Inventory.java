import java.util.*;
import java.io.*;

public class Inventory implements Serializable{
    protected ArrayList<Product> products;
    // items.size() says how many items
    public Inventory(){
        products = new ArrayList<>();
    }
    
    public void setProducts(ArrayList<Product> products){
        this.products = products;
    }
    
    public ArrayList<Product> getProducts(){
        return products;
    }
    
    public void addProduct(){
        System.out.println("Enter product name");
        String productName = Utility.getUserInput();
        for(int i = 0; i < products.size(); i++){
            if (productName.equals(products.get(i).getName())){
                System.out.println("Cannot add same product " + productName);
                return;
            }
        }
        System.out.println("Enter price");
        double price = Utility.getUserDouble();
        System.out.println("Enter quantity");
        int quantity = Utility.getUserInt();
        products.add(new Product(productName, price, quantity));
        System.out.println("Product successfully added!");
    }
    
     public void restockProduct(){
        System.out.println("Enter product name");
        String productName = Utility.getUserInput();
        for(int i = 0; i < products.size(); i++){
            if (productName.equals(products.get(i).getName())){
                System.out.println("Enter quantity to add: ");
                int addQuantity = Utility.getUserInt();
                products.get(i).setQuantity(products.get(i).getQuantity()+addQuantity);
                System.out.println("Quantity updated successfully");
                return;
            }
        }
        System.out.println("Product doesn't exist");
    }
    
    public void removeProduct(){
        System.out.println("Enter product name");
        String productName = Utility.getUserInput();
        for (int i = 0; i < products.size(); i++){
            if (productName.equals(products.get(i).getName())){
                products.remove(i);
                System.out.println("Product successfully removed!");
                return;
            }
        }
        System.out.println("Product doesn't exist: " + productName);
    }
}