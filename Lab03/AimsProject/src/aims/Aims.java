// Using class, need package its to folder, each class to a folder, import file with src path from start to end
package aims;                               // Encapsulate to aims class 
import aims.cart.Cart;                      // Import Cart Class
import aims.dvds.DigitalVideoDisc;          // Import DVD Class 

// Create public class Aims 
public class Aims {
    // Public function with void ignore no need return statement, auto return with string array "String[]" as args 
    // main is fixed name of function/method, String[]: str arr with args is name of it
    public static void main(String[] args) {
        // Create a new object anOrder of Cart class
        Cart anOrder = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);
    
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);
    
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Roger Allers", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);
    
        // Print total cost of the items in the cart 
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    
    }
}
