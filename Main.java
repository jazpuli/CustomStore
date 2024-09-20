import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) {
        start();
    }
    
    public static void start(){
        Admin admin = Serialization.download();
        if (admin == null) {
            admin = new Admin();
        }
        
        System.out.println("** Welcome to fksdfk! **\n1- login\n2- register");
        String input = Utility.getUserInput();
        if(input.equals("1")){
            System.out.println("Enter username: ");
            String username = Utility.getUserInput();
            System.out.println("Enter password: ");
            String password = Utility.getUserInput();
            if (isAdmin(username, password)) {
               while(true) {
                   admin.menu();
                   Serialization.save(admin);
               }
            } else {
                Customer loggedInCustomer = login(admin.getCustomers(), username, password);
                if (loggedInCustomer == null) {
                    System.out.println("Customer was not found in the system");
                } else {
                    while(true){
                        loggedInCustomer.menu(admin.getInventory().getProducts());
                        Serialization.save(admin);
                    }
                }
            }
        } else if(input.equals("2")) {
            Customer loggedInCustomer = register(admin.getCustomers());
            if (loggedInCustomer == null) {
                System.out.println("Customer was not found in the system");
            } else {
                Serialization.save(admin);
                loggedInCustomer.menu(admin.getInventory().getProducts());
            }
        } else {
            System.out.println("Invalid input");
        }
    }
    
    public static Customer register(ArrayList<Customer> customers){
        System.out.println("Enter username");
        String username = Utility.getUserInput();
        System.out.println("Enter password");
        String password = Utility.getUserInput();
        for(int i = 0; i < customers.size(); i++){
            if (username.equals(customers.get(i).getUsername())){
                System.out.println("Username already exists");
                return null;
            }
        }
        Customer customer = new Customer(username, password);
        customers.add(customer);
        return customer;
    }
    
    public static boolean isAdmin(String username, String password) {
        if(username.equals("admin") && password.equals("12345")) {
            return true;
        }
        return false;
    }
    
    public static Customer login(ArrayList<Customer> customers, String username, String password) {
        for (Customer customer : customers) {
            if (username.equals(customer.getUsername()) && password.equals(customer.getPassword())) {
                return customer;
            }
        }
        return null;
            // for(int i = 0; i < customers.size(); i++){
            //     if (username.equals(customers.get(i).getUsername()) && password.equals(customers.get(i).getPassword())){
            //         //do something lol 
            //         return i;
            //     }
            // }
        // }
        //compare admin user and pass return -5
        //if not admin access ArrayList customers
        //for every customer list of customers compare to input
        //return index of user
        //System.out.println("Login in User class");
    }
}
    
    

