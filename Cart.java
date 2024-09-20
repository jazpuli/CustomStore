import java.util.*;
import java.io.*;

public class Cart extends Inventory implements Serializable{
    public double total(){
        double sum = 0.0;
        for(int i = 0; i < products.size(); i++){
            sum += products.get(i).getPrice(); 
        }
        System.out.println("Your cart total: " + sum);
        return sum;
    }
    
    public void addProduct(Product product){
        products.add(product);
        System.out.println("Product successfully added!");
        
    }
    
    public double checkout(double balance){
        double cartTotal = total();
        System.out.println("Checkout?: yes no");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if(response.equals("yes")){
            if(cartTotal > balance){
                System.out.println("Not enough funds. Cannot complete purchase.");
                return -2.4;
            }
            System.out.println("Thank you for shopping");
            balance = balance - cartTotal;
            System.out.println("New balance: " + balance);
            return balance;
        } else if(response.equals("no")){
            return -2.4;
        } else {
            System.out.println("Invalid response.");
            return -2.4;
        }
    }
}