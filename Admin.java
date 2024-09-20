import java.util.*;
import java.io.*;

public class Admin extends User implements Serializable{
    protected ArrayList<Customer> customers;
    protected Inventory inventory;
    
    public Admin() {
        super();
        customers = new ArrayList<>();
        inventory = new Inventory();
    }
    
    public Admin(String username, String password) {
        super(username, password);
        customers = new ArrayList<>();
        inventory = new Inventory();
    }
    
    public void menu() {
        System.out.println("1- Create a customer account\n2- Remove a customer account");
        System.out.println("3- View inventory\n4- Add a product\n5- Remove a product\n6- Restock a product\n7- Logout");
        String input = Utility.getUserInput();
        switch(input) {
            case "1":
                addCustomer();
                break;
            case "2":
                removeCustomer();
                break;
            case "3":
                viewInventory();
                break;
            case "4":
                inventory.addProduct();
                break;
            case "5":
                inventory.removeProduct();
                break;
            case "6":
                inventory.restockProduct();
                break;
            case "7":
                System.exit(0);
            default:
                System.out.println("Not a valid option");
        }
    }
    
    public ArrayList<Customer> getCustomers() {
        return customers;
    }
    public void viewInventory() {
        System.out.println("******** View inventory ********\n");
        for(Product product : inventory.getProducts()){
            System.out.println("Name: " + product.getName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
        }
    }
    
    public void addCustomer(){
        System.out.println("Enter username");
        String username = Utility.getUserInput();
        System.out.println("Enter password");
        String password = Utility.getUserInput();
        for(int i = 0; i < customers.size(); i++){
            if (username.equals(customers.get(i).getUsername())){
                System.out.println("Username already exists");
                return;
            }
        }
        customers.add(new Customer(username, password));
         System.out.println("Customer was created successfully");
    }
    
    public void removeCustomer() {
        System.out.println("Enter username");
        String username = Utility.getUserInput();
        for (int i = 0; i < customers.size(); i++){
            if (username.equals(customers.get(i).getUsername())){
                customers.remove(i);
                System.out.println("Customer successfully removed!");
                return;
            }
        }
        System.out.println("Customer doesn't exist: " + username);
    }
        
    public Inventory getInventory() {
        return inventory;
    }
}