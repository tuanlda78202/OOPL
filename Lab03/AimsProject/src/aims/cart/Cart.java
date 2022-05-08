package aims.cart;
import aims.dvds.DigitalVideoDisc;

public class Cart { 
	// Create constant int MNO with `final`
	public static final int MAX_NUMBERS_ORDERED = 20;
	// Create new object arr itemsOrdered[] of DVD class, [] = 20
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	// Method addDVD
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered ++;
			System.out.println("The disc " + disc.getTitle() + " has been added to the cart");
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
	}
/*
	// Add a list of DVDs to the current cart
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("The disc " + dvdList[i].getTitle() + " has been added to the cart");
			}
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
	}
*/
	// Pass an arbitrary number of arguments for dvd
	public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
		if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("The disc " + dvdList[i].getTitle() + " has been added to the cart");
			}
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
	}

	// Overloading by differing the number of parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			System.out.println("The disc " + dvd1.getTitle() + " has been added to the cart");
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("The disc " + dvd2.getTitle() + " has been added to the cart");
		}
		if (qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full");
		}
	}

	// Method removeDVD
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].equalTitle(disc)) {
				found = true;
				qtyOrdered --;
				System.out.println("The disc " + disc.getTitle() + " has been removed from the cart");
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered] = null;
				break;
			}
		}
		if (found == false) {
			System.out.println("The disc " + disc.getTitle() + " is not in the cart");
		}
	}
	
	// Method sum of Cost
	public float totalCost() {
		float cost = 0.0f;
		for (int i = 0; i < qtyOrdered; i++) {
			cost += itemsOrdered[i].getCost();
		}
		return cost;
	}
}