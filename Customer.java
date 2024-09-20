import java.util.*;
import java.io.*;

public class Customer extends User implements Serializable{
    private double balance; 
    private Cart cart;
    
    public Customer(){
        super();
        cart = new Cart();
        balance = 100.00;
    }
    public Customer(String username, String password) {
        super(username, password);
        cart = new Cart();
        balance = 100.00;
    }
    
    public void menu(ArrayList<Product> products) {
        System.out.println("1- Shop the store\n2- View and checkout shopping cart\n3- View balance\n4- Add balance\n5- Logout");
        String input = Utility.getUserInput();
        switch(input) {
            case "1":
                shopStore(products);
                break;
            case "2":
                viewCheckout();
                break;
            case "3":
                viewBalance();
                break;
            case "4":
                addBalance();
                break;
            case "5":
                System.exit(0);
            default:
                System.out.println("Not a valid option");
        }
            }
            
    public void shopStore(ArrayList<Product> products) {
        System.out.println("******** Shop Store ********\n");
        if(products.size() == 0){
            System.out.println("No products to shop");
            return;
        }
        for(Product product : products){
            System.out.println("Name: " + product.getName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
        }
        System.out.println("Enter the product you want to add to your cart: ");
        String cartProduct = Utility.getUserInput();
        for(int i = 0; i < products.size(); i++){
            if (cartProduct.equals(products.get(i).getName())){
                cart.addProduct(products.get(i));
                return;
            }
        }
        System.out.println("Item does not exist");
    }
    
    public void viewCheckout() {
         for(Product product : cart.getProducts()){
            System.out.println("Name: " + product.getName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
        }
        cart.checkout(balance);
    }
    
    public void viewBalance(){
        System.out.println(balance);
    }
    
    public void addBalance(){
        if (Game.play()){
            balance += 100;
            System.out.println("Balance has increased by 100");
        }
    }
}
