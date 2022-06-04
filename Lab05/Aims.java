package hust.soict.globalict.aims;

import java.util.Scanner;

import hust.soict.globalict.aims.cart.*;
import hust.soict.globalict.aims.disc.*;
import hust.soict.globalict.aims.store.*;
public class Aims {
    public static void showMenu() {
		System.out.println("[Main Menu] AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	public static void storeMenu() {
		System.out.println("[Store] Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a DVD’s details");
		System.out.println("2. Add a DVD to cart");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	public static void cartMenu() {
		System.out.println("[Cart] Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void main(String[] args) {
        //create a new cart
        Cart anOrder = new Cart();
		Store anItem = new Store();
        //add DVD to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 19.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Harry Potter");
        DigitalVideoDisc dvd5= new DigitalVideoDisc("Harry Potter and the Deathly Hallows II", "Fantasy", "David Yates", 175 , 26.5f);
        DigitalVideoDisc dvd6= new DigitalVideoDisc("Harry Potter and the Order of Phoenix", "Fantasy", 
				"David Yates", 147 , 24.5f);
		DigitalVideoDisc dvd7= new DigitalVideoDisc("Avatar", "Science Fiction", 20.6f);

        anItem.addDVD(dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7);
        //show the cart

DigitalVideoDisc tmpDvd;
DigitalVideoDisc[] dvd = new DigitalVideoDisc[100];
int count = 0;
try (Scanner keyboard = new Scanner(System.in)) {
    int choice;
    int show;

    do {
        System.out.println("--------------------------------------------------------");
        // ------------------------------
        showMenu();
        // ------------------------------
        System.out.print(">>>> Your choice: ");
        show = keyboard.nextInt();
        switch(show) {
            case 0: 
                break;
            // ======================================
            case 1:
                int storeChoice;
                do {
                    System.out.println("--------------------------------------------------------");
                    anItem.viewStore();
                    // ------------------------------
                    storeMenu();
                    // ------------------------------
                    System.out.print(">>>> Your choice: ");
                    storeChoice = keyboard.nextInt();
                    switch(storeChoice) {
                    case 0:
                        break;
                    // ======================================
                    case 1:
                        System.out.print("==== Enter DVD's ID to see details: ");
                        int id = keyboard.nextInt();
                        tmpDvd = anItem.searchByID(id);

                        if (tmpDvd!=null) {
                            System.out.println(tmpDvd.getDetail());
                            System.out.println("[??] Do you want to add the DVD to the cart?");
                            System.out.println("1. Yes");
                            System.out.println("2. No");
                            System.out.print(">> Your choice: ");
                            choice = keyboard.nextInt();
                            if(choice ==1) {
                                dvd[count]= new DigitalVideoDisc(tmpDvd.getTitle(), tmpDvd.getCategory(),tmpDvd.getDirector(),
                                        tmpDvd.getLength(), tmpDvd.getCost(), tmpDvd.getId());
                                anOrder.addDigitalVideoDisc(dvd[count]);
                                count++;
                            }
                            else if(choice ==2) System.out.println();
                            
                            else System.out.println("----<!> Wrong statement!");
                        }
                        else System.out.println("----<!> No match DVD with ID: ["+ id +"]  is found");
                        break;
                    // ======================================
                    case 2:
                        System.out.print("==== Enter DVD's ID you want to add to the cart: ");
                        id = keyboard.nextInt();
                        tmpDvd = anItem.searchByID(id);
                        
                        if(tmpDvd!=null) {
                            dvd[count]= new DigitalVideoDisc(tmpDvd.getTitle(), tmpDvd.getCategory(),tmpDvd.getDirector(),
                                    tmpDvd.getLength(), tmpDvd.getCost(), tmpDvd.getId());
                            anOrder.addDigitalVideoDisc(dvd[count]);
                            count++;
                        }
                        else System.out.println("----<!> No match DVD with ID: [" + id + "] is found");
                        break;
                    // ======================================
                    case 3:
                        int cartChoice;
                        do {
                            System.out.println("--------------------------------------------------------");
                            anOrder.orderedBill();
                            // ------------------------------
                            cartMenu();
                            // ------------------------------
                            System.out.print(">>>> Your choice: ");
                            cartChoice = keyboard.nextInt();

                            switch(cartChoice) {
                            case 0:
                                break;
                            // ======================================
                            case 1:
                                System.out.println("FILTER MEDIA IN CART: ----");
                                System.out.println("1. By ID");
                                System.out.println("2. By Title");
                                System.out.print(">>>> Your choice: ");
                                choice = keyboard.nextInt();
                                if(choice ==1) {
                                    System.out.print("==== Enter DVD's ID: ");
                                    id = keyboard.nextInt();
                                    anOrder.searchByID(id);
                                }
                                else if(choice ==2) {
                                    anOrder.searchByTitle();
                                }
                                else System.out.println("----<!> Wrong statement!");
                                break;
                            // ======================================
                            case 2:
                                System.out.println("_SORT_ MEDIA IN CART: ----");
                                System.out.println("1. By Title");
                                System.out.println("2. By Cost");
                                System.out.print(">>>> Your choice: ");
                                choice = keyboard.nextInt();
                                if(choice ==1) {
                                    anOrder.sortByTitle(dvd);
                                }
                                else if(choice ==2) {
                                    anOrder.sortByCost(dvd);
                                }
                                else System.out.println("----<!> Wrong statement!");
                                break;
                            // ======================================
                            case 3:
                                System.out.print("==== Enter DVD's ID to remove from cart: ");
                                id = keyboard.nextInt();
                                anOrder.removeByID(id);
                                break;
                            // ======================================
                            case 4:
                                anOrder.emptyCart();
                                System.out.println("---- An order is created");
                                break;
                            // ======================================
                            default:
                                System.out.println("----<!> Wrong statement! Please choose again.\n");
                                break;
                            }
                        }while(cartChoice!=0);
                        break;
                    // ======================================
                    default:
                        System.out.println("----<!> Wrong statement! Please choose again.\n");
                        break;
                    }
                }while(storeChoice!=0);
                break;
            // ======================================
            case 2:
                System.out.println("--------------------------------------------------------");
                // ------------------------------
                anItem.viewStore();
                // ------------------------------
                System.out.println("UPDATE STORE: ----");
                System.out.println("1. Add DVD");
                System.out.println("2. Remove DVD");
                System.out.print(">>>> Your choice: ");
                choice = keyboard.nextInt();
                
                if(choice ==1) {
                    keyboard.nextLine();
                    System.out.print("===Enter Title: ");
                    String title =keyboard.nextLine();
                    System.out.print("===Enter Category: ");
                    String category=keyboard.nextLine();
                    System.out.print("===Enter Director: ");
                    String director=keyboard.nextLine();
                    System.out.print("===Enter Length: ");
                    int length=keyboard.nextInt();
                    System.out.print("===Enter Cost: ");
                    float cost=keyboard.nextFloat();
                    anItem.addDVD(new DigitalVideoDisc(title, category, director, length, (float)cost));
                }
                else if(choice == 2) {
                    System.out.print("==== Enter DVD's ID to remove from store: ");
                    int id = keyboard.nextInt();
                    tmpDvd = anItem.searchByID(id);
                    anItem.removeDVD(tmpDvd);
                    //remove dvd which has been removed from store from cart
                    int mark = anOrder.checkId(id);
                    while(mark > 0) {
                        anOrder.removeByID(id);
                        mark--;
                    }
                }
                else System.out.println("----<!> Wrong statement!");
                break;
            // ======================================
            case 3:
                int cartChoice;
                do {
                    System.out.println("--------------------------------------------------------");
                    anOrder.orderedBill();
                    // ------------------------------
                    cartMenu();
                    // ------------------------------
                    System.out.print(">>>> Your choice: ");
                    cartChoice = keyboard.nextInt();
                    switch(cartChoice) {
                    case 0:
                        break;
                    // ======================================
                    case 1:
                        System.out.println("_FILTER_ MEDIA IN CART: ----");
                        System.out.println("1. By ID");
                        System.out.println("2. By Title");
                        System.out.print(">>>>Your choice: ");
                        choice = keyboard.nextInt();
                        if(choice ==1) {
                            System.out.print("==== Enter DVD's ID: ");
                            int id = keyboard.nextInt();
                            anOrder.searchByID(id);
                        }
                        else if(choice ==2) {
                            anOrder.searchByTitle();
                        }
                        else System.out.println("----<!> Wrong statement!");
                        break;
                    // ======================================
                    case 2:
                        System.out.println("_SORT_ MEDIA IN CART: ----");
                        System.out.println("1. By Title");
                        System.out.println("2. By Cost");
                        System.out.print(">>>> Your choice: ");
                        choice = keyboard.nextInt();
                        if(choice == 1) {
                            anOrder.sortByTitle(dvd);
                        }
                        else if(choice == 2) {
                            anOrder.sortByCost(dvd);
                        }
                        else System.out.println("----<!> Wrong statement!");
                        break;
                    // ======================================
                    case 3:
                        System.out.print("==== Enter DVD's ID to remove from cart: ");
                        int id = keyboard.nextInt();
                        anOrder.removeByID(id);
                        break;
                    // ======================================
                    case 4:
                        anOrder.emptyCart();
                        System.out.println("---- An order has been created");
                        break;
                    // ======================================
                    default:
                        System.out.println("----<!> Wrong statement! Please choose again.\n");
                        break;
                    }
                }while(cartChoice!=0);
                break;
            // ======================================
            default:
                System.out.println("----<!> Wrong statement! Please choose again.\n");
                break;
        }

    }while(show!=0);
}

}
}
/*
		// anOrder.addDigitalVideoDisc(dvd1, dvd2);
		DigitalVideoDisc[] allDVDList = {dvd1, dvd2, dvd3, dvd4, dvd5, dvd6, dvd7};
        DigitalVideoDisc[] tempDVDList = {dvd1, dvd2, dvd3, dvd4, dvd6};  

        anOrder.addDigitalVideoDisc(tempDVDList);
		//sortByCost
		anOrder.sortByCost(tempDVDList);
		//sortByTitle
		anOrder.sortByTitle(tempDVDList);
        System.out.println("\n---- Print Bill: ");
        anOrder.orderedBill();
        // Search by Id
		anOrder.searchByID(5);
		anOrder.searchByID(1);
		System.out.println("\n");
        //remove DVD from the cart
        anOrder.removeDigitalVideoDisc(dvd4);
        anOrder.removeDigitalVideoDisc(dvd5);
		anOrder.removeDigitalVideoDisc(dvd6);
		anOrder.removeDigitalVideoDisc(dvd6);		
		System.out.println("\n---- Print Bill: ");
        anOrder.orderedBill();
        //print total cost
        System.out.print("Total Cost is: " + anOrder.totalCost() + " $");
*/