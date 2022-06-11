package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Create a new cart
		Cart cart = new Cart();
		
		//Create new dvd objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		cart.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		cart.addMedia(dvd3);
		cart.addMedia(dvd3);
		cart.removeMedia(dvd3);
		cart.removeMedia(dvd3);
		
		
		Track track1 = new Track("Bruh1", 13);
		Track track2 = new Track("Bruh2", 21);
		CompactDisc cd1 = new CompactDisc("Allstars", "Yes", "Smash Mouth", "Dunno", 69.420f);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		cd1.addTrack(track1);
		cd1.removeTrack(track2);
		cd1.removeTrack(track2);
		cd1.addTrack(track2);
		cd1.addTrack(track1);
		cart.addMedia(cd1);
		
		Book book1 = new Book("Sherlock Holmes", "Detective", 420, 5f);
		book1.addAuthor("Conan Doyle");
		book1.addAuthor("JK Rolling");
		book1.addAuthor("jk rOLLING");
		book1.removeAuthor("jk rOLLING");
		book1.removeAuthor("jk rOLLING");
		cart.addMedia(book1);
		
		//Test sort methods
		cart.sortByTitle();
		
		//Test the print method
		cart.print();
		
		//TODO: Test the search method here
//		cart.addMedia(dvd2);
//		cart.filterMedia(1);
//		cart.removeMedia(dvd3);
//		cart.filterMedia(2);
//		cart.addMedia(dvd3);
//		cart.filterMedia("lion");
//		cart.filterMedia("Alad");
	}

}
      