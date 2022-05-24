package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;
import hust.soict.dsai.aims.media.*;

public class Aims {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	public static void main(String[] args) {
		private static Scanner scan = new Scanner(System.in);

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		
		public static void showMenu() {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2 && choice != 3) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//View store
			if (choice == 1) {
				storeMenu();
			}
			
			//Update store
			else if (choice == 2) {
				updateStoreMenu();
			} 
			
			//See current cart
			else if (choice == 3) {
				cartMenu();
			} 
			
			//Exit
			else if (choice == 0) {
				System.exit(0);
			}
		}

		public static void storeMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a DVD's details");
			System.out.println("2. Add a DVD to cart");
			System.out.println("3. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//Exit
			if (choice == 0) {
				showMenu();
			} 
			
			//See a DVD's details
			else if (choice == 1) {
				System.out.println("Please enter the title of the media you want to see details of: ");
				String title = scan.nextLine();
				Media medium = store.searchMedia(title);
				//Invalid name
				while (medium == null) {
					System.out.println("Please enter a valid product name.");
					title = scan.nextLine();
					medium = store.searchMedia(title);
				}
			}
			
			//Add a media to cart
			else if (choice == 2) {
				System.out.println("Please enter the title of the media you want to add to cart: ");
				String title = scan.nextLine();
				Media medium = store.searchMedia(title);
				
				//Invalid name
				while (medium == null) {
					System.out.println("Please enter a valid product name.");
					title = scan.nextLine();
					medium = store.searchMedia(title);
				}
				
				cart.addMeia(medium);
				System.out.println("Total number of media in cart: " + cart.getSize());	//DVDs?
				System.out.println("Enter any key to continue");
				scan.nextLine();
				storeMenu();
			}
			
			//See current cart
			else if (choice == 3) {
				cartMenu();
			}
		}

		public static void updateStoreMenu() {			
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add media to the store");
			System.out.println("2. Remove media from the store");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//Exit
			if (choice == 0) {
				showMenu();
			}
			
			//Add media
			else if (choice == 1) {
				addToStoreMenu();
			}
			
			//Remove media
			else if (choice == 2) {
				removeFromStoreMenu();
			}
		}	
		
		public static void cartMenu() {
			cart.print();
			
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Place order");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//Exit
			if (choice == 0) {
				showMenu();
			}
			
			//Filter media
			else if (choice == 1) {
				filterCartMenu();
			}
			
			//Sort media
			else if (choice == 2) {
				sortCartMenu();
			}
			
			//Remove media from cart
			else if (choice == 3) {
				System.out.println("Please enter the title of the media you want to remove: ");
				String title = scan.nextLine();
				Media medium = store.searchMedia(title);
				//Invalid name
				while (medium == null) {
					System.out.println("Please enter a valid product name.");
					title = scan.nextLine();
					medium = cart.searchMedia(title);
				}
				cart.removeMedia(medium);
				System.out.println("Media removed. Enter any key to continue");
				scan.nextLine();
				cartMenu();
			}

			//Place order
			else if (choice == 4) {
				if (cart.getSize() == 0) {
					System.out.println("You cannot place an empty order\n");
					cartMenu();
				} else {
					cart = new Cart();
					System.out.println("Your order has been placed\n");
					showMenu();
				}
			}
		}
		public static void filterCartMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter by ID");
			System.out.println("2. Filter by title");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//Exit
			if (choice == 0) {
				cartMenu();
			}
			
			//ID
			else if (choice == 1) {
				System.out.println("Please enter ID number");
				choice = scan.nextInt();
				scan.nextLine();
				cart.filterMedia(choice);
				System.out.println("Enter any key to continue");
				scan.nextLine();
				cartMenu();
			}
			
			else if (choice == 2) {
				System.out.println("Please enter keyword");
				String keyword = scan.nextLine();
				cart.filterMedia(keyword);
				System.out.println("Enter any key to continue");
				scan.nextLine();
				cartMenu();
			}
		}
		
		
		public static void sortCartMenu() {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Sort by title");
			System.out.println("2. Sort by cost");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");
			
			int choice = scan.nextInt();
			scan.nextLine();
			
			//Invalid input
			while (choice != 0 && choice != 1 && choice != 2) {
				System.out.println("Please choose a valid number.");
				choice = scan.nextInt();
				scan.nextLine();
			}
			
			//Exit
			if (choice == 0) {
				cartMenu();
			}
			
			//By title
			else if (choice == 1) {
				cart.sortByTitle();
				System.out.println("Your cart has been sorted by title\n");
				cart.print();
				System.out.println("Enter any key to continue");
				scan.nextLine();
				cartMenu();
			}
			
			//By cost
			else if (choice == 1) {
				cart.sortByCost();
				System.out.println("Your cart has been sorted by cost\n");
				cart.print();
				System.out.println("Enter any key to continue");
				scan.nextLine();
				cartMenu();
			}
		}
		
		
		public static void seeMediaMenu(Media medium) {
			if (medium instanceof Disc) {
				System.out.println("\t" + medium.getDetails());
				System.out.println("\tDate added: " + medium.getDateAdded());
				System.out.println("Options: ");
				System.out.println("--------------------------------");
				System.out.println("1. Add this product to cart");
				System.out.println("2. Play this media");
				System.out.println("0. Exit");
				System.out.println("--------------------------------");
				System.out.println("Please choose a number: 0-1-2");
				int choice = scan.nextInt();
				scan.nextLine();
				while (choice != 0 && choice != 1 && choice != 2) {
					System.out.println("Please enter a valid number.");
					choice = scan.nextInt();
					scan.nextLine();
				}
				if (choice == 1) {
					System.out.println("Enter any key to continue");
					scan.nextLine();
					storeMenu();
				} else if (choice == 2) {
					System.out.println("\t" + medium.getDetails());
					System.out.println("\tDate added: " + medium.getDateAdded());
					System.out.println();
					System.out.println();
					System.out.println("Options: ");
					System.out.println("--------------------------------");
					System.out.println("1. Add this product to cart");
					System.out.println("0. Exit");
					System.out.println("--------------------------------");
					System.out.println("Please choose a number: 0-1");
					choice = scan.nextInt();
					scan.nextLine();
					while (choice != 0 && choice != 1) {
						System.out.println("Please enter a valid number.");
						choice = scan.nextInt();
						scan.nextLine();
					}
					if (choice == 1) {
						cart.addMedia(med);
						System.out.println("Enter any key to continue");
						scan.nextLine();
						storeMenu();
					} else if (choice == 0) {
						storeMenu();
					}
				} else if (choice == 0) {
					storeMenu();
				} 
			}
		}
		
		
		public static void addToStoreMenu() {
			System.out.println("Please enter the information of the new DVD");
			System.out.println("Title: ");
			String title = scan.nextLine();
			System.out.println("Category: ");
			String category = scan.nextLine();
			System.out.println("Director: ");
			String director = scan.nextLine();
			System.out.println("Length: ");
			int length = scan.nextInt();
			scan.nextLine();
			System.out.println("Price: ");
			float price = Float.parseFloat(scan.nextLine());
			System.out.println("DVD added. Enter any key to continue");
			scan.nextLine();
			updateStoreMenu();
		}
		
		
		public static void removeFromStoreMenu() {
			store.print();
			
			System.out.println("Please enter the title of the media you want to remove: ");
			String title = scan.nextLine();
			Media medium = store.searchMedia(title);
			//Invalid name
			while (medium == null) {
				System.out.println("Please enter a valid product name.");
				title = scan.nextLine();
				medium = store.searchMedia(title);
			}
			store.removeMedia(medium);
			System.out.println("Enter any key to continue");
			scan.nextLine();
			updateStoreMenu();
		}
		
}
	
