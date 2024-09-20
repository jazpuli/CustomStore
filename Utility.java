import java.util.*;

public class Utility {
    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public static double getUserDouble() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
    
    public static int getUserInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}