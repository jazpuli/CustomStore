import java.io.*;
import java.util.*;

public class Serialization {
    public static void save(Object obj) {
        try{
            FileOutputStream file = new FileOutputStream("objects.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(obj);

            out.close();
            file.close();

        } catch(IOException ex) {
            System.out.println("Exception has been caught");
        }
    }
    
    public static Admin download() {
        try{
            FileInputStream file = new FileInputStream("objects.ser");
            ObjectInputStream in = new ObjectInputStream(file);

            Admin admin = (Admin) in.readObject();

            in.close();
            file.close();

            System.out.println("Download is complete!\n");
            return admin;
        } catch(IOException ex) {
            System.out.println(ex.getMessage());
        } catch(ClassNotFoundException ex){
            System.out.println("Class not found exception has been caught");
        } 
        return null;
    }
}