package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		//Create the store
		Store myStore = new Store();

		//Create DVDs
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

		//Try adding DVDs
//		myStore.addMedia(dvd2, 5);
		myStore.addMedia(dvd2);
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd3);
		myStore.addMedia(dvd1);
		myStore.addMedia(dvd1);
		myStore.print();

		//Try removing DVDs
//		myStore.removeMedia(dvd1, 2);
		myStore.removeMedia(dvd3);
		myStore.removeMedia(dvd1);
		myStore.print();
	}
}   